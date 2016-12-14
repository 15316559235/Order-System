package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class restruant_manage{
    private JLabel label[]=new JLabel[100];
    private JFileChooser chooser[]=new JFileChooser[100];
    private JButton food_jb[]=new JButton[100];
    private JLabel restruant_name,restruant_location,restruant_boss,restruant_tel,food_manage;
    private JPanel jp1,jp2,jp3,jp4,jp5;
    private JPanel food_jp[]=new JPanel[100];
    private JLabel jl1,jl2,jl3,jl4;
    private JFrame jf=new JFrame();
    private JFrame food_jf[]=new JFrame[100];
    private JButton image_jb[]=new JButton[100],yes_jb[]=new JButton[100],no_jb[]=new JButton[100];
    private JLabel name_jl[]=new JLabel[100],price_jl[]=new JLabel[100];
    private JTextField name_jt[]=new JTextField[100],price_jt[]=new JTextField[100];
    private JPanel name_jp[]=new JPanel[100],image_jp[]=new JPanel[100],price_jp[]=new JPanel[100],button_jp[]=new JPanel[100];
    private JLabel add_icon[]=new JLabel[100],add_price[]=new JLabel[100],add_name[]=new JLabel[100];
    private ImageIcon icon[]=new ImageIcon[100];
    private JPanel add_jp[]=new JPanel[100];
	int number=0;
    
    public void info(){
    	restruant_name=new JLabel(new_restruant.name);
    	restruant_location=new JLabel(new_restruant.location);
    	restruant_boss=new JLabel(new_restruant.boss);
    	restruant_tel=new JLabel(new_restruant.tel);
    	food_manage=new JLabel("管理菜单");
    	jl1=new JLabel("店名");
    	jl2=new JLabel("地址");
    	jl3=new JLabel("负责人");
    	jl4=new JLabel("电话");
    	jp1=new JPanel();
    	jp2=new JPanel();
    	jp3=new JPanel();
    	jp4=new JPanel();
    	jp5=new JPanel();
    	jp1.add(jl1,BorderLayout.WEST);
    	jp1.add(restruant_name,BorderLayout.CENTER);
    	jp2.add(jl2,BorderLayout.WEST);
    	jp2.add(restruant_location,BorderLayout.CENTER);
    	jp3.add(jl3,BorderLayout.WEST);
    	jp3.add(restruant_boss,BorderLayout.CENTER);
    	jp4.add(jl4,BorderLayout.WEST);
    	jp4.add(restruant_tel,BorderLayout.CENTER);
    	jp5.add(food_manage);
    	jf.add(jp1);
    	jf.add(jp2);
    	jf.add(jp3);
    	jf.add(jp4);
    	jf.add(jp5);
		jf.setLayout(new GridLayout(0,1));
		jf.setSize(400,500);
    	
    }
    
    public void chooseimage(int i){
    	chooser[i]=new JFileChooser();
        food_jb[i] = new JButton("添加菜品");
        food_jp[i]=new JPanel();
        food_jp[i].add(food_jb[i]);
		food_jp[i].setLayout(new FlowLayout());
		jf.add(food_jp[i]);
		jf.setVisible(true);
		jf.setLocation(800,400);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(3);
	}
    
    public void food(int i){
		food_jf[i]=new JFrame();
		food_jf[i].setVisible(true);
		food_jf[i].setLocation(800,400);
		food_jf[i].setResizable(false);
		food_jf[i].setLayout(new GridLayout(0,1));
		food_jf[i].setDefaultCloseOperation(3);
		image_jb[i]=new JButton("添加图片");
		name_jl[i]=new JLabel("添加菜名");
		name_jt[i]=new JTextField(10);
		price_jl[i]=new JLabel("添加价格");
		price_jt[i]=new JTextField(10);
		yes_jb[i]=new JButton("确定");
		no_jb[i]=new JButton("取消");
		button_jp[i]=new JPanel();
		image_jp[i]=new JPanel();
		name_jp[i]=new JPanel();
		price_jp[i]=new JPanel();
		name_jp[i].add(name_jl[i]);
		name_jp[i].add(name_jt[i]);
		image_jp[i].add(image_jb[i]);
		price_jp[i].add(price_jl[i]);
		price_jp[i].add(price_jt[i]);
		button_jp[i].add(yes_jb[i]);
		button_jp[i].add(no_jb[i]);
		food_jf[i].add(name_jp[i]);
		food_jf[i].add(price_jp[i]);
		food_jf[i].add(image_jp[i]);
		food_jf[i].add(button_jp[i]);
		name_jp[i].setLayout(new GridLayout(0,2));
		image_jp[i].setLayout(new FlowLayout());
		price_jp[i].setLayout(new GridLayout(0,2));
		button_jp[i].setLayout(new GridLayout(0,2));
		food_jf[i].pack();
    }
    
	private void initLister(int i) {
		food_jb[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                number++;
        		if(number==100)
        			JOptionPane.showConfirmDialog(null,"只能添加100种菜品", "提示",JOptionPane.CLOSED_OPTION,JOptionPane.ERROR_MESSAGE);
        		else{
        			food(number-1);
        			foodlistener(number-1);
        		}
			}
		});
	}
	private void foodlistener(int i){
		image_jb[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label[i]=new JLabel();
		        food_jf[i].add(label[i]);
				int result = chooser[i].showOpenDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    String name = chooser[i].getSelectedFile().getPath();
                    icon[i]=new ImageIcon(name); 
                    icon[i].setImage(icon[i].getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));     
                    label[i].setSize(200, 200);
                    label[i].setIcon(icon[i]);            
                    label[i].setHorizontalAlignment(SwingConstants.CENTER);
                    food_jf[i].remove(image_jp[i]);
                }
                    }
		});
		yes_jb[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_jp[i]=new JPanel();
				add_icon[i]=new JLabel();
				add_name[i]=new JLabel(name_jt[i].getText());
				add_price[i]=new JLabel(price_jt[i].getText());
				add_icon[i].setIcon(icon[i]);
				add_jp[i].setLayout(new GridLayout(0,3));
				add_jp[i].add(add_icon[i]);
				add_jp[i].add(add_name[i]);
				add_jp[i].add(add_price[i]);
				food_jf[i].dispose();
				jf.remove(food_jp[i]);
				jf.add(add_jp[i]);
				start();
			}
		});	
		no_jb[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int s=JOptionPane.showConfirmDialog(null, "是否退出？","提示",JOptionPane.CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if (s==JOptionPane.OK_OPTION)
					food_jf[i].dispose();
			}
		});
		}
	
	public void start(){
		chooseimage(number);
		initLister(number);
	}
	
	public restruant_manage(){
		info();
		start();
	}
}
