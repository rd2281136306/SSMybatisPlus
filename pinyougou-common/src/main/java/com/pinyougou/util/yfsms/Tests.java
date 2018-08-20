package com.pinyougou.util.yfsms;

//Marshaller  
public class Tests {  
    public static void main(String[] args) {  
    	boolean isSend = CloudFengSms.sendSms("试试看", "15002111101");
    	System.out.println(isSend); 
    }
} 