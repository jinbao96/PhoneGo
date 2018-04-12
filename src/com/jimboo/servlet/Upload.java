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
		//��ô����ļ���Ŀ����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//��ȡ�ļ���Ҫ�ϴ���·��
		String path = "F:" + File.separatorChar 
				+ "DaDao-Java" + File.separatorChar 
				+ "PhoneGo" + File.separatorChar + "WebContent" 
				+ File.separatorChar +"img" + File.separatorChar + "product";
				//req.getServletContext().getRealPath("/img");
		/***
		String path = request.getServletContext()
				.getRealPath("") + File.separatorChar + "img" + File.separatorChar + "product";
				*/
		System.out.println("·��:" + path);
		
		//���û�����������õĻ����ϴ���� �ļ� ��ռ�� �ܶ��ڴ棬  
        //������ʱ��ŵ� �洢�� , ����洢�ң����Ժ� ���մ洢�ļ� ��Ŀ¼��ͬ  
        /** 
         * ԭ�� �����ȴ浽 ��ʱ�洢�ң�Ȼ��������д�� ��ӦĿ¼��Ӳ���ϣ�  
         * ������˵ ���ϴ�һ���ļ�ʱ����ʵ���ϴ������ݣ���һ������ .tem ��ʽ��  
         * Ȼ���ٽ�������д�� ��ӦĿ¼��Ӳ���� 
         */  
        factory.setRepository(new File(path));  
        //���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��  
        factory.setSizeThreshold(1024*1024) ;  
          
        //��ˮƽ��API�ļ��ϴ�����  
        ServletFileUpload upload = new ServletFileUpload(factory); 
        upload.setHeaderEncoding("UTF-8");
        String filename = null;
        //Goods g = new Goods();
        try {  
            //�����ϴ�����ļ�  
            List<FileItem> list = (List<FileItem>)upload.parseRequest(req);  
              
            for(FileItem item : list)  
            {  
                //��ȡ������������  
                String name = item.getFieldName();  
                System.out.println("������name:" + name);
                //�����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ  
                if(item.isFormField())  
                {                     
                    //��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�  
                    String value = item.getString("UTF-8");
                    //value = new String(value.getBytes(), "UTF-8");
                    System.out.println("value:" + value);
                    req.setAttribute(name, value);  
                }  
                //�Դ���ķ� �򵥵��ַ������д��� ������˵�����Ƶ� ͼƬ����Ӱ��Щ  
                else  
                {  
                    /** 
                     * ������������Ҫ��ȡ �ϴ��ļ������� 
                     */  
                    //��ȡ·����  
                    String value = item.getName() ;  
                    //���������һ����б��  
                    int start = value.lastIndexOf("\\");  
                    //��ȡ �ϴ��ļ��� �ַ������֣���1�� ȥ����б�ܣ�  
                    String filename1 = value.substring(start+1);  
                    String[] strings = filename1.split("[.]");
                    //System.out.println("��ʽ:" + strings[1]);
                    for (String string : strings) {
						System.out.println("sss..." + string);
					}
                    filename = "img" + System.currentTimeMillis() + "." + strings[1];
                    System.out.println("filename:" + filename);
                    req.setAttribute("url", "img/product/" + filename);  
                      
                    //����д��������  
                    //���׳����쳣 ��exception ��׽  
                      
                    //item.write( new File(path,filename) );//�������ṩ��  
                      
                    //�ֶ�д��  
                    OutputStream out = new FileOutputStream(new File(path,filename));  
                      
                    InputStream in = item.getInputStream() ;  
                      
                    int length = 0 ;  
                    byte [] buf = new byte[1024] ;  
                      
                    System.out.println("��ȡ�ϴ��ļ����ܹ���������"+item.getSize());  
  
                    // in.read(buf) ÿ�ζ��������ݴ����   buf ������  
                    while( (length = in.read(buf) ) != -1)  
                    {  
                        //��   buf ������ ȡ������ д�� ���������������  
                        out.write(buf, 0, length);  
                          
                    }    
                    in.close();  
                    out.close();  
                    
                    
                }  
            }  
              
              
              
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace(); 
            resp.getWriter().write("�쳣");
        }    
        req.getRequestDispatcher("/AddGoods").forward(req, resp);
  
    }  
}

