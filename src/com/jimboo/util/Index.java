package com.jimboo.util;

public class Index {
	
	
	/**
	 * ����Ԫ���������е��±�,�����ڷ���-1
	 * 
	 * */
	public static int indexOf(int[] array,int value){  
	    for(int i = 0;i<array.length;i++){
	    	//ѭ�����������ֵ
	        if(array[i]==value){ 
	        	//���ֵ��Ҫ�ҵ���ͬ
	        	//�ͷ���i
	            return i;  
	        }  
	    }  
	    //�����ھͷ���-1
	    return -1;  
	}
}
