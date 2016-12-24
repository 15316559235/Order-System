import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
 
public class home{
    private static JButton jb1=new JButton("µÇÂ¼");
    private static JButton jb2=new JButton("×¢²á");
    private static JPanel jp=new JPanel();
	private static JFrame frm=new JFrame("Ê×Ò³");
	private static void panel(){
	    jp.add(jb1);
	    jp.add(jb2);
	    JSplitPane splitPane=new JSplitPane();
	    splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
	    frm.getContentPane().add(splitPane);
	    imagine ip=new imagine();
		ip.setBounds(0,0,400,200);
		frm.setBounds(600,400,600,300);
		splitPane.setLeftComponent(ip);
		splitPane.setRightComponent(jp);
		splitPane.setDividerLocation(200);
	    frm.setVisible(true);
	}
	private static void initLister() {
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.dispose();
				new login();
			}
		});
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.dispose();
				new sign_in();
			}
		});
	}
    public static void main(String[] args){
    	Database.getdatabase();
    	panel();
    	initLister();
    }
}
class imagine extends JPanel{
	private static final long serialVersionUID = 4270398606681240886L;
	public void paint(Graphics g){
	    Image img = null;
		try{
			img=ImageIO.read(new File("E:/JAVA/workplace/Order-System/home.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
		g.drawImage(img, 100, 0, 400, 200, null);
	}
}
