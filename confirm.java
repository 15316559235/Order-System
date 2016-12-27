package cn.com.customer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.io.*;

public class confirm extends JFrame {
	JFrame frm5=new JFrame();
	public confirm() throws IOException{
		frm5.setTitle("订单确认");
		frm5.setLayout(null);
		frm5.setUndecorated(false);//去掉窗体修饰,包括最大化按钮 
		frm5.setResizable(false); //禁止改变窗体大

		//背景
		String path = "background.jpg";  
		ImageIcon background = new ImageIcon(path); 
		JLabel labelp = new JLabel(background);  
		labelp.setBounds(0, 0, background.getIconWidth(), background.getIconHeight()); 
		JPanel imagePanel = (JPanel)frm5.getContentPane();  
		imagePanel.setOpaque(false);  
		frm5.getLayeredPane().add(labelp, new Integer(Integer.MIN_VALUE)); 
	
		//back键
		class enter implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				new information();
				frm5.dispose();
			}
		} 
		String path1= "back.jpg";  
		ImageIcon back = new ImageIcon(path1); 
		JButton button1 = new JButton(back);  
		button1.setBounds(0, 0, 70, 70); 
		frm5.getContentPane().add(button1);
		button1.addActionListener(new enter());
    
		JLabel label1 = new JLabel("订单确认");
		label1.setBounds(70,0,330,70);
		label1.setFont(new Font("",Font.CENTER_BASELINE,22));
		label1.setForeground(Color.white); 
		label1.setBackground(Color.orange);
		label1.setOpaque(true);
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setHorizontalTextPosition(JLabel.CENTER);  
		frm5.getContentPane().add(label1);
		
		JTextArea info = new JTextArea("");
		info.setBounds(30, 100, 330, 370);
		info.setFont(new Font("",Font.CENTER_BASELINE,22));
		info.setForeground(Color.white); 
		info.setBackground(Color.orange);
		info.setEditable(false);	
		//
		info.setText("姓名："+information.name+"\r\n"+"电话："+information.phone+"\r\n"+"住址："+information.address
				+"\r\n"+"订单总价："+dishes.totalPrice);
		//
		frm5.getContentPane().add(info);
	

		//按键
		class choose implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				new TCP_Client_Send();
				new success();
				frm5.dispose();
			}
		}
		    
		final JButton button2=new JButton();
		button2.setText("确认订单");
		button2.setBounds(280,550,120,60);
		button2.setHorizontalAlignment(JButton.CENTER);
		frm5.getContentPane().add(button2);
		button2.addActionListener(new choose());

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    	int scrWidth = (int)screensize.getWidth();
    	int scrHeight = (int)screensize.getHeight();
		frm5.setBounds(scrWidth/2, 10, 400, scrHeight-100);
		frm5.setVisible(true);
		frm5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
    
	public static void main(String[] args){
    	try{
    		new confirm();
    	}catch(IOException err){}
    }
}