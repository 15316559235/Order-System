package cn.com.customer;

import java.io.*;
import java.net.*;
import java.net.*;

public class TCP_Client_Receive {
	public static String shopName;
	public static String[] dishName=new String[100];
	public static String[] price=new String[100];
	int i=0;
	public TCP_Client_Receive(){
		Socket server=null;
		try{
			server=new Socket("192.168.1.32",4445);
			BufferedReader is=new BufferedReader(new InputStreamReader(server.getInputStream()));
			shopName = is.readLine();
			while(i<4){
				dishName[i]=is.readLine();
				//System.out.println("get:"+dishName[i]);
				price[i]=is.readLine();
				//System.out.println("get:"+price[i]);
				i++;
			}
			is.close();
			server.close();
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}	
}


