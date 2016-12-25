import java.io.*;
import java.net.*;

public class TCP {
	public static String[] foodname=new String[100];
	public static String[] foodnumber=new String[100];
	private boolean flag;
	private int i;
	public TCP() throws IOException{
		while(true){
		flag=true;
		i=0;
		ServerSocket server=null;
		try{
			server=new ServerSocket(4444);
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
		BufferedReader is=new BufferedReader(new InputStreamReader(client.getInputStream()));
		while(flag){
			if(is.readLine()==null){
				flag=false;
				break;
			}
			else{
				foodname[i]=is.readLine();
				foodnumber[i]=is.readLine();
				i++;
			}
		}
		is.close();
		client.close();
		server.close();
		}
	}
}
