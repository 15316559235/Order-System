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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.*;

public class restaurant extends JFrame {
	JFrame frm2=new JFrame();
	public restaurant()throws IOException{
		frm2.setTitle("选择店家");
		frm2.setLayout(null);
		frm2.setUndecorated(false);//去掉窗体修饰,包括最大化按钮 
		frm2.setResizable(false); //禁止改变窗体大
	
		//背景
		String path = "background.jpg";  
		ImageIcon background = new ImageIcon(path); 
		JLabel labelp = new JLabel(background);  
		labelp.setBounds(0, 0, background.getIconWidth(), background.getIconHeight()); 
		JPanel imagePanel = (JPanel)frm2.getContentPane();  
		imagePanel.setOpaque(false);  
		frm2.getLayeredPane().add(labelp, new Integer(Integer.MIN_VALUE)); 
	
		//back键
		class enter implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				new Welcome();
				frm2.dispose();
			}
		} 
		String path1= "back.jpg";  
		ImageIcon back = new ImageIcon(path1); 
		JButton button1 = new JButton(back);  
		button1.setBounds(0, 0, 70, 70); 
		frm2.getContentPane().add(button1);
		button1.addActionListener(new enter());
    
    
		JLabel label1 = new JLabel("选择店家");
		label1.setBounds(70,0,330,70);
		label1.setFont(new Font("",Font.CENTER_BASELINE,22));
		label1.setForeground(Color.white); 
		label1.setBackground(Color.orange);
		label1.setOpaque(true);
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setHorizontalTextPosition(JLabel.CENTER);  
		frm2.getContentPane().add(label1);
	

		//按键
		class choose implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		    	new dishes();
		    	frm2.dispose();
			}
		}
		    
		final JButton button2=new JButton();
		button2.setText("进入店家");
		button2.setBounds(280,570,120,60);
		button2.setHorizontalAlignment(JButton.CENTER);
		frm2.getContentPane().add(button2);
		button2.setEnabled(false);
		button2.addActionListener(new choose());
	
		//列表
		class add implements ListSelectionListener {
			public void valueChanged(ListSelectionEvent arg0) {
				button2.setEnabled(true);
			}
		}
		
		FileReader getResName;
		getResName = new FileReader(".\\ResName.txt");
		BufferedReader reader = new BufferedReader(getResName);
		final String[] restaurants={"店家1","店家2","店家3","店家4","店家5",""};
		int i;
		for(i=0;(restaurants[i]=reader.readLine()) != null;i++){
		}
		getResName.close();		
		
		JList list=new JList(restaurants);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectionBackground(Color.gray);
		list.setFixedCellHeight(100);
		list.setVisibleRowCount(5);
		list.addListSelectionListener(new add());
		JScrollPane scrollpane=new JScrollPane();
		scrollpane.setViewportView(list);
		scrollpane.setBounds(0,70,395,640);
		frm2.getContentPane().add(scrollpane);
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    	int scrWidth = (int)screensize.getWidth();
    	int scrHeight = (int)screensize.getHeight();
		frm2.setBounds(scrWidth/2, 10, 400, scrHeight-100);
		frm2.setVisible(true);
		frm2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
    
	public static void main(String[] args) throws IOException{
    	new restaurant();
    }
}

