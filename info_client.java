import java.io.*;
import java.net.*;
public class info_client extends Thread{
	public info_client(){
		start();
	}
	public void run(){
		while(true){
		ServerSocket server=null;
		try{
			server=new ServerSocket(4445);
		}catch(Exception e){
			System.out.println("Error:"+e);
			System.exit(-1);
		}
		Socket client=null;
		try{
			client=server.accept();
		}catch(Exception e){
			System.out.println("Ω” ‹«Î«Û ß∞‹£°");
			System.exit(-1);
		}
		try {
			PrintWriter os=new PrintWriter(client.getOutputStream());
			os.println(restaurant_manage.name);
			for(int i=0;i<restaurant_manage.number;i++){
				os.println(restaurant_manage.name2[i]);
				os.println(restaurant_manage.price2[i]);
			}
			os.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}
}

