package GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class login extends JFrame {
	private static final long serialVersionUID = 4270398606681240886L;
	private JButton jb1,jb2;
	private JLabel jl1,jl2;
	private JTextField jt;
	private JPasswordField jps;
	private JPanel jp1,jp2,jp3;
	public login() {
		initPart();
		initLister();
		InitStyle();
		initDaa();
		}

	private void initPart() {
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jt =new JTextField(10);
		jps=new JPasswordField(10);
		jl1=new JLabel("�˺�");
		jl2=new JLabel("����");
		jb1=new JButton("��½");
		jb2=new JButton("�˳�");
	}

	private void InitStyle() {
		this.setLayout(new GridLayout(3,1));
		this.jp1.setLayout(new FlowLayout());
		this.jp2.setLayout(new FlowLayout());
		this.jp3.setLayout(new FlowLayout());

	}

	private void initDaa() {
		jp1.add(jl1);
		jp1.add(jt);
		jp2.add(jl2);
		jp2.add(jps);
		jp3.add(jb1);
		jp3.add(jb2);
		add(jp1);
		add(jp2);
		add(jp3);
		setVisible(true);
		pack();
		setLocation(800,400);
		setResizable(false);
		setDefaultCloseOperation(3);
	}

	private void initLister() {
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password="123";
				if(jt.getText().endsWith("123")&&String.valueOf(jps.getPassword()).equals(password))
					JOptionPane.showConfirmDialog(null,"��½�ɹ�","��ʾ",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showConfirmDialog(null,"�������", "��ʾ",JOptionPane.CLOSED_OPTION,JOptionPane.ERROR_MESSAGE);
			}
		});
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int s=JOptionPane.showConfirmDialog(null, "�Ƿ��˳���","��ʾ",JOptionPane.CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if (s==JOptionPane.OK_OPTION)
					System.exit(0);
			}
		});
	}
}
