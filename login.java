import java.awt.*;
import java.sql.*;

import javax.swing.*;
import java.awt.event.*;

public class login extends JFrame {
	private static final long serialVersionUID = 4270398606681240886L;
	private JButton jb1,jb2;
	private JLabel jl1,jl2;
	private JTextField jt;
	private JPasswordField jps;
	private JPanel jp1,jp2,jp3;
	public static int flag = 0;
	public static String Username,Password;
	public login() {
		initPart();
		initLister();
		InitStyle();
		initDaa();
		}

	private void initPart() {
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jt =new JTextField(10);
		jps=new JPasswordField(10);
		jl1=new JLabel("账号");
		jl2=new JLabel("密码");
		jb1=new JButton("登陆");
		jb2=new JButton("退出");
	}

	private void InitStyle() {
		this.setLayout(new GridLayout(3,1));
		this.jp1.setLayout(new FlowLayout());
		this.jp2.setLayout(new FlowLayout());
		this.jp3.setLayout(new FlowLayout());

	}

	private void initDaa() {
		jp1.add(jl1);
		jp1.add(jt);
		jp2.add(jl2);
		jp2.add(jps);
		jp3.add(jb1);
		jp3.add(jb2);
		add(jp1);
		add(jp2);
		add(jp3);
		setVisible(true);
		pack();
		setLocation(800,400);
		setResizable(false);
		setDefaultCloseOperation(3);
	}

	private void initLister() {
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try{
					Database.con=DriverManager.getConnection("jdbc:odbc:restaurantuser");
					Database.stmt=Database.con.createStatement();
				}catch(SQLException ee){}	
				String s1=jt.getText();
				String s2=String.valueOf(jps.getPassword());
				Database.strTemp="SELECT * FROM restaurantuser WHERE Username= '"+s1+"' and Password= '"+s2+"'";
				try{
					Database.rs=Database.stmt.executeQuery(Database.strTemp);
				}catch(SQLException e1){
					e1.printStackTrace();
				}
				try{
				if(Database.rs.next()!=false){
					JOptionPane.showConfirmDialog(null,"登陆成功","提示",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
					dispose();
					Database.strTemp="SELECT * FROM restaurantuser WHERE Username= '"+s1+"'";
					Database.rs=Database.stmt.executeQuery(Database.strTemp);
					while(Database.rs.next()){
						Username=Database.rs.getString("Username");
						Password=Database.rs.getString("Password");
						flag=Database.rs.getInt("Flag");
					}
					if(flag==0)
						new add_restaurant();
					else
						new restaurant_manage();
				}
				else
					JOptionPane.showConfirmDialog(null,"用户名或密码错误", "提示",JOptionPane.CLOSED_OPTION,JOptionPane.ERROR_MESSAGE);
				}catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		});
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int s=JOptionPane.showConfirmDialog(null, "是否退出？","提示",JOptionPane.CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if (s==JOptionPane.OK_OPTION)
					System.exit(0);
			}
		});
	}
}
