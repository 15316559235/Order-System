package cn.com.customer;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Welcome extends JFrame {
	JFrame frm1 = new JFrame();
    
    public Welcome(){
    	frm1.setTitle("订餐系统");
    	frm1.setLayout(null);
    	frm1.setUndecorated(false);//去掉窗体修饰,包括最大化按钮 
    	frm1.setResizable(false); //禁止改变窗体大

    	//背景
    	String path = "background.jpg";  
    	ImageIcon background = new ImageIcon(path); 
    	JLabel label1 = new JLabel(background);  
    	label1.setBounds(0, 0, background.getIconWidth(), background.getIconHeight()); 
    	JPanel imagePanel = (JPanel)frm1.getContentPane();  
    	imagePanel.setOpaque(false);  
    	frm1.getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE)); 
    	
    	//文字图片
    	JLabel label = new JLabel("欢迎使用订餐系统");
    	label.setBounds(5,65,400,400);
    	label.setFont(new Font("",Font.CENTER_BASELINE,22));
    	label.setForeground(Color.red); 
    	label.setIcon(new ImageIcon("fork&knife.jpg"));
    	label.setHorizontalAlignment(JLabel.CENTER);
    	label.setHorizontalTextPosition(JLabel.CENTER); 
    	label.setVerticalTextPosition(JLabel.TOP); 
    	frm1.getContentPane().add(label);
	
 
    	//按键
    	//按键触发
    	class enter implements ActionListener {
    		public void actionPerformed(ActionEvent e) {
    			try{
					new restaurant();
				}catch(IOException err){}
    			frm1.dispose();
    		}
    	}
    
    	JButton button=new JButton();
    	button.setText("进入点餐");
    	button.setBounds(140,450,120,30);
    	frm1.getContentPane().add(button);
    	button.addActionListener(new enter());
    	
    	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    	int scrWidth = (int)screensize.getWidth();
    	int scrHeight = (int)screensize.getHeight();
    	frm1.setBounds(scrWidth/2, 10, 400, scrHeight-100);
    	frm1.setVisible(true);
    }

    public static void main(String[] args) { 
    	new Welcome();
    }
}