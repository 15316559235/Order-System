package ShopCar;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ShopCar {
	public static void main(String[] args) {
		JFrame frm = new JFrame();
		frm.setTitle("������ѯ");
		BorderLayout borderlayout=new BorderLayout();
		frm.setLayout(borderlayout);
		
		//1.��ǩ�����ʹ��
		JLabel label = new JLabel("���Ķ�����:");
		label.setBounds(5,5,160,80);
		label.setFont(new Font("",Font.BOLD,22));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		String[] likes={};
		JList list=new JList(likes);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setFixedCellHeight(20);
		list.setVisibleRowCount(5);
		JScrollPane scrollpane=new JScrollPane();
		scrollpane.setViewportView(list);
		scrollpane.setBounds(100,50,200,100);
		frm.getContentPane().add(scrollpane,BorderLayout.CENTER);
		

		//2.��ť�����ʹ��
		JButton button=new JButton();
		button.setText("����");
		button.setBounds(170,5,120,30);
		frm.getContentPane().add(button,BorderLayout.SOUTH);
	
		frm.setBounds(400, 200, 450, 320);
		frm.setVisible(true);
	}
	}


