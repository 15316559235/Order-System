import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class ShopCar {
	private JFrame frm = new JFrame();
	private JButton button=new JButton();
	private JLabel foodname_jl[]=new JLabel[10];
	private JLabel foodnumber_jl[]=new JLabel[10];
	private JPanel jp=new JPanel();
	private JPanel jp1=new JPanel();
	private JPanel jp2=new JPanel();
	private JLabel address_jl,name_jl,tel_jl;
	private JLabel totalprice1=new JLabel("总价"),totalprice2=new JLabel();
	private JPanel alljp=new JPanel();
	private int i;
	public ShopCar() {
		i=0;
		initLister();
		frm.setTitle("订单查询");
		frm.setLayout(new BorderLayout());
		JScrollPane scrollpane=new JScrollPane();
			
		address_jl=new JLabel(TCP.address);
		name_jl=new JLabel(TCP.name);
		tel_jl=new JLabel(TCP.tel);
		totalprice2.setText(TCP.totalprice);
		jp1.add(address_jl);
		jp1.add(name_jl);
		jp1.add(tel_jl);
		jp2.add(totalprice1);
		jp2.add(totalprice2);
		jp1.setLayout(new GridLayout(0,1));
		jp.setLayout(new GridLayout(0,2));
		alljp.add(jp1);
		alljp.add(jp);
		alljp.add(jp2);
		alljp.setLayout(new GridLayout(0,1));

		while(TCP.foodname[i]!=null){
			foodname_jl[i]=new JLabel();
			foodname_jl[i].setText(TCP.foodname[i]);
			foodnumber_jl[i]=new JLabel();
			foodnumber_jl[i].setText(TCP.foodnumber[i]);
			jp.add(foodname_jl[i]);
			jp.add(foodnumber_jl[i]);
			i++;
		}
		if(i!=0){
			scrollpane.setViewportView(alljp);
		}
		
		scrollpane.setBounds(100,50,200,100);
		frm.getContentPane().add(scrollpane,BorderLayout.CENTER);
		
		button.setText("返回");
		button.setBounds(170,5,120,30);
		frm.getContentPane().add(button,BorderLayout.SOUTH);
		frm.add(scrollpane);
	
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


