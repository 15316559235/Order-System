package cn.com.customer;

import java.awt.Button;
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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.io.*;

public class dishes extends JFrame {
	private static final String String = null;
	JFrame frm3=new JFrame();
	public dishes(){
		frm3.setTitle("选择菜品");
		frm3.setLayout(null);
		frm3.setUndecorated(false);//去掉窗体修饰,包括最大化按钮 
		frm3.setResizable(false); //禁止改变窗体大
	
	
		//背景
		String path = "background.jpg";  
		ImageIcon background = new ImageIcon(path); 
		JLabel labelp = new JLabel(background);  
		labelp.setBounds(0, 0, background.getIconWidth(), background.getIconHeight()); 
		JPanel imagePanel = (JPanel)frm3.getContentPane();  
		imagePanel.setOpaque(false);  
		frm3.getLayeredPane().add(labelp, new Integer(Integer.MIN_VALUE)); 
	
	
		//back键
		class enter implements ActionListener{
				public void actionPerformed(ActionEvent e)  {
					try{
						new restaurant();
					}catch(IOException err){}
					frm3.dispose();
				}
		} 
		String path1= "back.jpg";  
		ImageIcon back = new ImageIcon(path1); 
		JButton button1 = new JButton(back);  
		button1.setBounds(0, 0, 70, 70); 
		frm3.getContentPane().add(button1);
		button1.addActionListener(new enter());
    
    
		JLabel label1 = new JLabel("选择菜品");
		label1.setBounds(70,0,330,70);
		label1.setFont(new Font("",Font.CENTER_BASELINE,22));
		label1.setForeground(Color.white); 
		label1.setBackground(Color.orange);
		label1.setOpaque(true);
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setHorizontalTextPosition(JLabel.CENTER);  
		frm3.getContentPane().add(label1);


		JLabel label = new JLabel();
		label.setBounds(0,70,400,50);
		String text=new String("菜名                                              价格                                            数量");
		label.setText(text);
		label.setForeground(Color.white); 
		label.setBackground(Color.blue);
		label.setOpaque(true);
		label.setHorizontalAlignment(JLabel.LEFT);
		frm3.getContentPane().add(label);
	
		JLabel labelc1 = new JLabel();
		labelc1.setBounds(0,120,400,90);
		String text1=new String("番茄炒蛋                                       15                                         ");
		labelc1.setText(text1);
		labelc1.setHorizontalAlignment(JLabel.LEFT);
		frm3.getContentPane().add(labelc1);
	
		JLabel labelc2 = new JLabel();
		labelc2.setBounds(0,244,400,90);
		String text2=new String("番茄炒蛋                                       15                                         ");
		labelc2.setText(text2);
		labelc2.setHorizontalAlignment(JLabel.LEFT);
		frm3.getContentPane().add(labelc2);
	
		JLabel labelc3 = new JLabel();
		labelc3.setBounds(0,368,400,90);
		String text3=new String("番茄炒蛋                                       15                                         ");
		labelc3.setText(text3);
		labelc3.setHorizontalAlignment(JLabel.LEFT);
		frm3.getContentPane().add(labelc3);
	
		JLabel labelc4 = new JLabel();
		labelc4.setBounds(0,492,400,90);
		String text4=new String("番茄炒蛋                                       15                                         ");
		labelc4.setText(text4);
		labelc4.setHorizontalAlignment(JLabel.LEFT);
		frm3.getContentPane().add(labelc4);
	
		JLabel labelc5 = new JLabel();
		labelc5.setBounds(0,616,400,90);
		String text5=new String("番茄炒蛋                                       15                                         ");
		labelc5.setText(text5);
		labelc5.setHorizontalAlignment(JLabel.LEFT);
		frm3.getContentPane().add(labelc5);
	
		
		
		//+/-按键
		final JTextField textc1=new JTextField();
		textc1.setHorizontalAlignment(JTextField.LEFT);
		textc1.setBounds(320,150,30,30);
		textc1.setText("0");
		frm3.getContentPane().add(textc1);
		
		class plusc1 implements ActionListener{
			public void actionPerformed(ActionEvent e)  {
				textc1.setText(String.valueOf(Integer.parseInt(textc1.getText())+Integer.parseInt("1")));
			}
		}
		
		String pathc1p = "plus.jpg";  
		ImageIcon c1plus = new ImageIcon(pathc1p); 
		JButton buttonc1p = new JButton(c1plus);  
		buttonc1p.setBounds(350, 150, 30, 30);  
		frm3.getContentPane().add(buttonc1p);
		buttonc1p.addActionListener(new plusc1());
		
		
		class minusc1 implements ActionListener{
			public void actionPerformed(ActionEvent e)  {
				textc1.setText(String.valueOf(Integer.parseInt(textc1.getText())-Integer.parseInt("1")));
				if(Integer.parseInt(textc1.getText())-Integer.parseInt("1")<0)
					textc1.setText("0");
			}			
		}
		
		String pathc1m = "minus.jpg";  
		ImageIcon c1minus = new ImageIcon(pathc1m); 
		JButton buttonc1m = new JButton(c1minus);  
		buttonc1m.setBounds(290, 150, 30, 30);  
		frm3.getContentPane().add(buttonc1m);
		buttonc1m.addActionListener(new minusc1());
		
		
		
		final JTextField textc2=new JTextField();
		textc2.setHorizontalAlignment(JTextField.LEFT);
		textc2.setBounds(320,274,30,30);
		textc2.setText("0");
		frm3.getContentPane().add(textc2);
		
		class plusc2 implements ActionListener{
			public void actionPerformed(ActionEvent e)  {
				textc2.setText(String.valueOf(Integer.parseInt(textc2.getText())+Integer.parseInt("1")));
			}
		}
		
		String pathc2p = "plus.jpg";  
		ImageIcon c2plus = new ImageIcon(pathc2p); 
		JButton buttonc2p = new JButton(c2plus);  
		buttonc2p.setBounds(350, 274, 30, 30);  
		frm3.getContentPane().add(buttonc2p);
		buttonc2p.addActionListener(new plusc2());
		
		
		class minusc2 implements ActionListener{
			public void actionPerformed(ActionEvent e)  {
				textc2.setText(String.valueOf(Integer.parseInt(textc2.getText())-Integer.parseInt("1")));
				if(Integer.parseInt(textc2.getText())-Integer.parseInt("1")<0)
					textc2.setText("0");
			}			
		}
		
		String pathc2m = "minus.jpg";  
		ImageIcon c2minus = new ImageIcon(pathc2m); 
		JButton buttonc2m = new JButton(c2minus);  
		buttonc2m.setBounds(290, 274, 30, 30);  
		frm3.getContentPane().add(buttonc2m);
		buttonc2m.addActionListener(new minusc2());
		
		
		
		final JTextField textc3=new JTextField();
		textc3.setHorizontalAlignment(JTextField.LEFT);
		textc3.setBounds(320,398,30,30);
		textc3.setText("0");
		frm3.getContentPane().add(textc3);
		
		class plusc3 implements ActionListener{
			public void actionPerformed(ActionEvent e)  {
				textc3.setText(String.valueOf(Integer.parseInt(textc3.getText())+Integer.parseInt("1")));
			}
		}
		
		String pathc3p = "plus.jpg";  
		ImageIcon c3plus = new ImageIcon(pathc3p); 
		JButton buttonc3p = new JButton(c3plus);  
		buttonc3p.setBounds(350, 398, 30, 30);  
		frm3.getContentPane().add(buttonc3p);
		buttonc3p.addActionListener(new plusc3());
		
		
		class minusc3 implements ActionListener{
			public void actionPerformed(ActionEvent e)  {
				textc3.setText(String.valueOf(Integer.parseInt(textc3.getText())-Integer.parseInt("1")));
				if(Integer.parseInt(textc3.getText())-Integer.parseInt("1")<0)
					textc3.setText("0");
			}			
		}
		
		String pathc3m = "minus.jpg";  
		ImageIcon c3minus = new ImageIcon(pathc3m); 
		JButton buttonc3m = new JButton(c3minus);  
		buttonc3m.setBounds(290, 398, 30, 30);  
		frm3.getContentPane().add(buttonc3m);
		buttonc3m.addActionListener(new minusc3());
		
		
		
		final JTextField textc4=new JTextField();
		textc4.setHorizontalAlignment(JTextField.LEFT);
		textc4.setBounds(320,522,30,30);
		textc4.setText("0");
		frm3.getContentPane().add(textc4);
		
		class plusc4 implements ActionListener{
			public void actionPerformed(ActionEvent e)  {
				textc4.setText(String.valueOf(Integer.parseInt(textc4.getText())+Integer.parseInt("1")));
			}
		}
		
		String pathc4p = "plus.jpg";  
		ImageIcon c4plus = new ImageIcon(pathc4p); 
		JButton buttonc4p = new JButton(c4plus);  
		buttonc4p.setBounds(350, 522, 30, 30);  
		frm3.getContentPane().add(buttonc4p);
		buttonc4p.addActionListener(new plusc4());
		
		
		class minusc4 implements ActionListener{
			public void actionPerformed(ActionEvent e)  {
				textc4.setText(String.valueOf(Integer.parseInt(textc4.getText())-Integer.parseInt("1")));
				if(Integer.parseInt(textc4.getText())-Integer.parseInt("1")<0)
					textc4.setText("0");
			}			
		}
		
		String pathc4m = "minus.jpg";  
		ImageIcon c4minus = new ImageIcon(pathc4m); 
		JButton buttonc4m = new JButton(c4minus);  
		buttonc4m.setBounds(290, 522, 30, 30);  
		frm3.getContentPane().add(buttonc4m);
		buttonc4m.addActionListener(new minusc4());
		
		
		final JTextField textc5=new JTextField();
		textc5.setHorizontalAlignment(JTextField.LEFT);
		textc5.setBounds(320,646,30,30);
		textc5.setText("0");
		frm3.getContentPane().add(textc5);
		
		class plusc5 implements ActionListener{
			public void actionPerformed(ActionEvent e)  {
				textc5.setText(String.valueOf(Integer.parseInt(textc5.getText())+Integer.parseInt("1")));
			}
		}
		
		String pathc5p = "plus.jpg";  
		ImageIcon c5plus = new ImageIcon(pathc5p); 
		JButton buttonc5p = new JButton(c5plus);  
		buttonc5p.setBounds(350, 646, 30, 30);  
		frm3.getContentPane().add(buttonc5p);
		buttonc5p.addActionListener(new plusc5());
		
		
		class minusc5 implements ActionListener{
			public void actionPerformed(ActionEvent e)  {
				textc5.setText(String.valueOf(Integer.parseInt(textc5.getText())-Integer.parseInt("1")));
				if(Integer.parseInt(textc5.getText())-Integer.parseInt("1")<0)
					textc5.setText("0");
			}			
		}
		
		String pathc5m = "minus.jpg";  
		ImageIcon c5minus = new ImageIcon(pathc5m); 
		JButton buttonc5m = new JButton(c5minus);  
		buttonc5m.setBounds(290, 646, 30, 30);  
		frm3.getContentPane().add(buttonc5m);
		buttonc5m.addActionListener(new minusc5());
		
		
		
		

		//按键
		class choose implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				new information();
				frm3.dispose();
			}
		}
		    
		final JButton button2=new JButton();
		button2.setText("填写信息");
		button2.setBounds(280,800,120,60);//方便我看，你自己改一下!!!!
		button2.setHorizontalAlignment(JButton.CENTER);
		frm3.getContentPane().add(button2);
		button2.addActionListener(new choose());
	
		
			
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    	int scrWidth = (int)screensize.getWidth();
    	int scrHeight = (int)screensize.getHeight();
		frm3.setBounds(scrWidth/2, 10, 400, scrHeight-100);
		frm3.setVisible(true);
		frm3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
    
	public static void main(String[] args){
    	new dishes();
    }
}
