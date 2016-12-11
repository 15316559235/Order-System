package GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class add_restruant extends JFrame{
	private static final long serialVersionUID = 4270398606681240886L;
	private JLabel jl;
	private JButton jb;
	private JPanel jp;
	
	public add_restruant(){
		jp=new JPanel();
		jb=new JButton("添加饭店");
		jl=new JLabel("没有已添加的饭店");
		jp.setLayout(new FlowLayout());
		jp.add(jl);
		jp.add(jb);
		add(jp);
		pack();
		setVisible(true);
		setLocation(800,400);
		setResizable(false);
		setDefaultCloseOperation(3);
		initLister();
	}
	
	private void initLister() {
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new new_restruant();
			}
		});
	}
}
