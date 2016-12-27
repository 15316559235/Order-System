import java.io.*;
import java.net.*;

public class TCP  extends Thread{
	public static String foodname[]=new String[100];
	public static String foodnumber[]=new String[100];
	public static String address,name,tel,totalprice;
	private int i;
	public TCP(){
		start();
	}
	public void run(){
		while(true){
		i=0;
		ServerSocket server=null;
		try{
			server=new ServerSocket(4000);
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
		BufferedReader is;
		String s;
		try {
			is = new BufferedReader(new InputStreamReader(client.getInputStream()));
			address=is.readLine();
			name=is.readLine();
			tel=is.readLine();
			totalprice=is.readLine();
			s=is.readLine();
			while(s!=null){
				foodname[i]=s;
				foodnumber[i]=is.readLine();
				s=is.readLine();
				i++;
			}
			is.close();
			client.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}
}
