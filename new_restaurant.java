import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class new_restaurant extends JFrame {
	private static final long serialVersionUID = 4270398606681240886L;
	private JPanel jp1,jp2,jp3,jp4,jp5;
	private JLabel jl1,jl2,jl3,jl4;
	private JButton jb1,jb2;
	private JTextField jt1,jt2,jt3,jt4;
	private String name,location,boss,tel;
	
	public new_restaurant(){
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();
		jl1=new JLabel("店名");
		jl2=new JLabel("地址");
		jl3=new JLabel("负责人");
		jl4=new JLabel("联系电话");
		jt1=new JTextField(11);
		jt2=new JTextField(11);
		jt3=new JTextField(11);
		jt4=new JTextField(11);
		jb1=new JButton("确定");
		jb2=new JButton("取消");
		setLayout(new GridLayout(5,1));
        this.jp1.setLayout(new FlowLayout(2));
		this.jp2.setLayout(new FlowLayout(2));
		this.jp3.setLayout(new FlowLayout(2));
		this.jp4.setLayout(new FlowLayout(2));
		this.jp5.setLayout(new FlowLayout());
		jp1.add(jl1);
		jp1.add(jt1);
		jp2.add(jl2);
		jp2.add(jt2);
		jp3.add(jl3);
		jp3.add(jt3);
		jp4.add(jl4);
		jp4.add(jt4);
		jp5.add(jb1);
		jp5.add(jb2);
		add(jp1);
		add(jp2);
		add(jp3);
		add(jp4);
		add(jp5);
		setVisible(true);
		pack();
		setLocation(800,400);
		setResizable(false);
		setDefaultCloseOperation(3);
		initLister();
		}
	
	private boolean isnumber(){
		for (int i = 0; i < jt4.getText().length(); i++){
			   if (!Character.isDigit(jt4.getText().charAt(i))){
			    return false;
			   }
			  }
		return true;
	}
	
	private void initLister() {
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isnumber()){
					name=jt1.getText();
					location=jt2.getText();
					boss=jt3.getText();
					tel=jt4.getText();
					JOptionPane.showConfirmDialog(null,"添加成功","提示",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
					dispose();
					try{				
						Database.strTemp="UPDATE restaurantuser SET Flag=1 WHERE Username='"+login.Username+"'";				
						Database.rs=Database.stmt.executeQuery(Database.strTemp);
					}catch(SQLException e1){}
					try{
						Database.strTemp="INSERT INTO restaurantinfo (Username,RestaurantName,RestaurantAddress,RestaurantBoss,RestaurantTel)VALUES ('"+login.Username+"','"+name+"','"+location+"','"+boss+"','"+tel+"')";
						Database.stmt.executeUpdate(Database.strTemp);
						}catch(SQLException e1){
							e1.printStackTrace();
						}
					try{
						Database.strTemp="CREATE TABLE "+name+"(FoodName TEXT(20) PRIMARY KEY,FoodPrice TEXT(20),FoodIcon TEXT(50))";
						Database.stmt.executeUpdate(Database.strTemp);
					}catch(SQLException e1){
						e1.printStackTrace();
					}
					new restaurant_manage();
				}
				else
					JOptionPane.showConfirmDialog(null,"联系电话只能为数字", "提示",JOptionPane.CLOSED_OPTION,JOptionPane.ERROR_MESSAGE);
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
