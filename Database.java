import java.sql.*;
public class Database {
	public static Connection con=null;
	public static Statement stmt=null;
    public static ResultSet rs=null;
    public static String strTemp="";
	public static void getdatabase(){
	try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	}catch(ClassNotFoundException e){}
	}
}
