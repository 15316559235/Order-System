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


public class information extends JFrame {
	JFrame frm4=new JFrame();
	public static String address;
	public static String name;
	public static String phone;
	public information(){
		frm4.setTitle("填写信息");
		frm4.setLayout(null);
		frm4.setUndecorated(false);//去掉窗体修饰,包括最大化按钮 
		frm4.setResizable(false); //禁止改变窗体大
	
		//背景
		String path = "background.jpg";  
		ImageIcon background = new ImageIcon(path); 
		JLabel labelp = new JLabel(background);  
		labelp.setBounds(0, 0, background.getIconWidth(), background.getIconHeight()); 
		JPanel imagePanel = (JPanel)frm4.getContentPane();  
		imagePanel.setOpaque(false);  
		frm4.getLayeredPane().add(labelp, new Integer(Integer.MIN_VALUE)); 
	
		//back键
		class enter implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try{
		    		new dishes();
		    	}catch(IOException err){}
				frm4.dispose();
			}
		} 
		String path1= "back.jpg";  
		ImageIcon back = new ImageIcon(path1); 
		JButton button1 = new JButton(back);  
		button1.setBounds(0, 0, 70, 70); 
		frm4.getContentPane().add(button1);
		button1.addActionListener(new enter());
    
		JLabel label1 = new JLabel("填写信息");
		label1.setBounds(70,0,330,70);
		label1.setFont(new Font("",Font.CENTER_BASELINE,22));
		label1.setForeground(Color.white); 
		label1.setBackground(Color.orange);
		label1.setOpaque(true);
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setHorizontalTextPosition(JLabel.CENTER);  
		frm4.getContentPane().add(label1);
	
		final JTextField text1=new JTextField();
		text1.setText("请输入姓名");
		text1.setHorizontalAlignment(JTextField.LEFT);
		text1.setBounds(120,120,160,50);
		frm4.getContentPane().add(text1);
		final JTextField text2=new JTextField();
		text2.setText("请输入联系方式");
		text2.setHorizontalAlignment(JTextField.LEFT);
		text2.setBounds(120,190,160,50);
		frm4.getContentPane().add(text2);
		final JTextField text3=new JTextField();
		text3.setText("请输入地址");
		text3.setHorizontalAlignment(JTextField.LEFT);
		text3.setBounds(120,260,160,50);
		frm4.getContentPane().add(text3);
		final JTextField text4=new JTextField();
		text4.setText("备注");
		text4.setHorizontalAlignment(JTextField.LEFT);
		text4.setBounds(120,330,160,50);
		frm4.getContentPane().add(text4);

		//按键
		class choose implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		    	address=text3.getText();
		    	name=text1.getText();
		    	phone=text2.getText();
		    	try{new confirm();}catch(Exception err){}
		    	frm4.dispose();
			}
		}
		    
		final JButton button2=new JButton();
		button2.setText("填写完成");
		button2.setBounds(280,500,120,60);
		button2.setHorizontalAlignment(JButton.CENTER);
		frm4.getContentPane().add(button2);
		button2.addActionListener(new choose());

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    	int scrWidth = (int)screensize.getWidth();
    	int scrHeight = (int)screensize.getHeight();
		frm4.setBounds(scrWidth/2, 10, 400, scrHeight-100);
		frm4.setVisible(true);
		frm4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
    
	public static void main(String[] args){
    	new information();
    }
}