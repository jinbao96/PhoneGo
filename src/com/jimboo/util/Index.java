package com.jimboo.util;

public class Index {
	
	
	/**
	 * 查找元素在数组中的下标,不存在返回-1
	 * 
	 * */
	public static int indexOf(int[] array,int value){  
	    for(int i = 0;i<array.length;i++){
	    	//循环遍历数组的值
	        if(array[i]==value){ 
	        	//如果值与要找的相同
	        	//就返回i
	            return i;  
	        }  
	    }  
	    //不存在就返回-1
	    return -1;  
	}
}
