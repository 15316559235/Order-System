package cn.com.customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
public class TCP_Client_Send {
	public TCP_Client_Send(){
		Socket server=null;
		try{
			server=new Socket("192.168.1.32",4000);
		}catch(Exception e){}

		try{
			PrintWriter os=new PrintWriter(server.getOutputStream());
			os.println(information.address);
			os.flush();
			os.println(information.name);
			os.flush();
			os.println(information.phone);
			os.flush();
			os.println(dishes.totalPrice);
			os.flush();
			for(int i=0;i<5;i++){
				if(!dishes.dishNum[i].equals("0")){
					os.println(TCP_Client_Receive.dishName[i]);
					os.flush();
					os.println(dishes.dishNum[i]);
					os.flush();
				}
			}
			os.close();
			server.close();
		}catch(IOException e){}
	}
}
