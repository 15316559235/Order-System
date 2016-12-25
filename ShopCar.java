import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class ShopCar {
	private JFrame frm = new JFrame();
	private JButton button=new JButton();
	private JLabel[] foodname=new JLabel[100];
	private JLabel[] foodnumber=new JLabel[100];
	private JPanel jp=new JPanel();
	private int i=0;
	public ShopCar() {
		initLister();
		frm.setTitle("订单查询");
		BorderLayout borderlayout=new BorderLayout();
		frm.setLayout(borderlayout);
		
		JLabel label = new JLabel("您的订单有:");
		label.setBounds(5,5,160,80);
		label.setFont(new Font("",Font.BOLD,22));
		label.setHorizontalAlignment(JLabel.CENTER);
		jp.setLayout(new GridLayout(0,2));
		
		while(TCP.foodname[i]!=null){
			foodname[i]=new JLabel(TCP.foodname[i]);
			foodnumber[i]=new JLabel(TCP.foodnumber[i]);
			jp.add(foodname[i]);
			jp.add(foodnumber[i]);
			i++;
		}
		
		String[] likes={};
		JList list=new JList(likes);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setFixedCellHeight(20);
		list.setVisibleRowCount(5);
		JScrollPane scrollpane=new JScrollPane();
		scrollpane.setViewportView(list);
		scrollpane.setBounds(100,50,200,100);
		scrollpane.add(jp);
		frm.getContentPane().add(scrollpane,BorderLayout.CENTER);
		
		button.setText("返回");
		button.setBounds(170,5,120,30);
		frm.getContentPane().add(button,BorderLayout.SOUTH);
	
		frm.setBounds(400, 200, 450, 320);
		frm.setVisible(true);
	}
	private void initLister() {
		button.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {			
				frm.dispose();
		}
	});
	}
}


