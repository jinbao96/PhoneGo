package com.jimboo.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@SuppressWarnings("serial")
@WebServlet("/Upload")
//@MultipartConfig
public class Upload extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
//		String g = req.getParameter("gname");
//		System.out.println("gggg:" + g);
		//获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//获取文件需要上传的路径
		String path = "F:" + File.separatorChar 
				+ "DaDao-Java" + File.separatorChar 
				+ "PhoneGo" + File.separatorChar + "WebContent" 
				+ File.separatorChar +"img" + File.separatorChar + "product";
				//req.getServletContext().getRealPath("/img");
		/***
		String path = request.getServletContext()
				.getRealPath("") + File.separatorChar + "img" + File.separatorChar + "product";
				*/
		System.out.println("路径:" + path);
		
		//如果没以下两行设置的话，上传大的 文件 会占用 很多内存，  
        //设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同  
        /** 
         * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上，  
         * 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的  
         * 然后再将其真正写到 对应目录的硬盘上 
         */  
        factory.setRepository(new File(path));  
        //设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室  
        factory.setSizeThreshold(1024*1024) ;  
          
        //高水平的API文件上传处理  
        ServletFileUpload upload = new ServletFileUpload(factory); 
        upload.setHeaderEncoding("UTF-8");
        String filename = null;
        //Goods g = new Goods();
        try {  
            //可以上传多个文件  
            List<FileItem> list = (List<FileItem>)upload.parseRequest(req);  
              
            for(FileItem item : list)  
            {  
                //获取表单的属性名字  
                String name = item.getFieldName();  
                System.out.println("表单属性name:" + name);
                //如果获取的 表单信息是普通的 文本 信息  
                if(item.isFormField())  
                {                     
                    //获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的  
                    String value = item.getString("UTF-8");
                    //value = new String(value.getBytes(), "UTF-8");
                    System.out.println("value:" + value);
                    req.setAttribute(name, value);  
                }  
                //对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些  
                else  
                {  
                    /** 
                     * 以下三步，主要获取 上传文件的名字 
                     */  
                    //获取路径名  
                    String value = item.getName() ;  
                    //索引到最后一个反斜杠  
                    int start = value.lastIndexOf("\\");  
                    //截取 上传文件的 字符串名字，加1是 去掉反斜杠，  
                    String filename1 = value.substring(start+1);  
                    String[] strings = filename1.split("[.]");
                    //System.out.println("格式:" + strings[1]);
                    for (String string : strings) {
						System.out.println("sss..." + string);
					}
                    filename = "img" + System.currentTimeMillis() + "." + strings[1];
                    System.out.println("filename:" + filename);
                    req.setAttribute("url", "img/product/" + filename);  
                      
                    //真正写到磁盘上  
                    //它抛出的异常 用exception 捕捉  
                      
                    //item.write( new File(path,filename) );//第三方提供的  
                      
                    //手动写的  
                    OutputStream out = new FileOutputStream(new File(path,filename));  
                      
                    InputStream in = item.getInputStream() ;  
                      
                    int length = 0 ;  
                    byte [] buf = new byte[1024] ;  
                      
                    System.out.println("获取上传文件的总共的容量："+item.getSize());  
  
                    // in.read(buf) 每次读到的数据存放在   buf 数组中  
                    while( (length = in.read(buf) ) != -1)  
                    {  
                        //在   buf 数组中 取出数据 写到 （输出流）磁盘上  
                        out.write(buf, 0, length);  
                          
                    }    
                    in.close();  
                    out.close();  
                    
                    
                }  
            }  
              
              
              
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace(); 
            resp.getWriter().write("异常");
        }    
        req.getRequestDispatcher("/AddGoods").forward(req, resp);
  
    }  
}

