package GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class sign_in extends JFrame {
	private static final long serialVersionUID = 4270398606681240886L;
	private JButton jb1,jb2;
	private JLabel jl1,jl2,jl3;
	private JTextField jt;
	private JPasswordField jps1,jps2;
	private JPanel jp1,jp2,jp3,jp4;
	public sign_in() {
		initPart();
		initLister();
		InitStyle();
		initDaa();
		}

	private void initPart() {
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jt =new JTextField(10);
		jps1=new JPasswordField(10);
		jps2=new JPasswordField(10);
		jl1=new JLabel("账号");
		jl2=new JLabel("密码");
		jl3=new JLabel("重复密码");
		jb1=new JButton("注册");
		jb2=new JButton("退出");
	}

	private void InitStyle() {
		this.setLayout(new GridLayout(4,1));
		this.jp1.setLayout(new FlowLayout(2));
		this.jp2.setLayout(new FlowLayout(2));
		this.jp3.setLayout(new FlowLayout(2));
		this.jp4.setLayout(new FlowLayout());
	}

	private void initDaa() {
		jp1.add(jl1);
		jp1.add(jt);
		jp2.add(jl2);
		jp2.add(jps1);
		jp3.add(jl3);
		jp3.add(jps2);
		jp4.add(jb1);
		jp4.add(jb2);
		add(jp1);
		add(jp2);
		add(jp3);
		add(jp4);
		setVisible(true);
		pack();
		setLocation(800,400);
		setResizable(false);
		setDefaultCloseOperation(3);
	}

	private void initLister() {
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(String.valueOf(jps1.getPassword()).equals(String.valueOf(jps2.getPassword())))
					JOptionPane.showConfirmDialog(null,"注册成功","提示",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showConfirmDialog(null,"两次输入密码不相同", "提示",JOptionPane.CLOSED_OPTION,JOptionPane.ERROR_MESSAGE);
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