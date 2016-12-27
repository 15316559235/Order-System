import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class restaurant_manage{
    private JLabel label[]=new JLabel[100];
    private JFileChooser chooser[]=new JFileChooser[100];
    private JButton food_jb[]=new JButton[100],shop_jb[]=new JButton[100];
    private JLabel restaurant_name,restaurant_location,restaurant_boss,restaurant_tel,food_manage;
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
    private JPanel jp=new JPanel();
    private JScrollPane js=new JScrollPane(jp);
    public static String name,location,boss,tel;
    private String iconurl[]=new String[100];
	public static int number=0;
	public static String[] name2=new String[100];
	public static String[] price2=new String[100];
    
    public void info(){
    	try{
    		Database.strTemp="SELECT * FROM restaurantinfo WHERE Username= '"+login.Username+"'";
			Database.rs=Database.stmt.executeQuery(Database.strTemp);
			while(Database.rs.next()){
				name=Database.rs.getString("RestaurantName");
				location=Database.rs.getString("RestaurantAddress");
				boss=Database.rs.getString("RestaurantBoss");
				tel=Database.rs.getString("RestaurantTel");
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
    	restaurant_name=new JLabel(name);
    	restaurant_location=new JLabel(location);
    	restaurant_boss=new JLabel(boss);
    	restaurant_tel=new JLabel(tel);
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
    	jp1.add(restaurant_name,BorderLayout.CENTER);
    	jp2.add(jl2,BorderLayout.WEST);
    	jp2.add(restaurant_location,BorderLayout.CENTER);
    	jp3.add(jl3,BorderLayout.WEST);
    	jp3.add(restaurant_boss,BorderLayout.CENTER);
    	jp4.add(jl4,BorderLayout.WEST);
    	jp4.add(restaurant_tel,BorderLayout.CENTER);
    	jp5.add(food_manage);
    	jp.add(jp1);
    	jp.add(jp2);
    	jp.add(jp3);
    	jp.add(jp4);
    	jp.add(jp5);
		jp.setLayout(new GridLayout(0,1));
		jp.setSize(400,500);
    }
    
    public void chooseimage(int i){
    	chooser[i]=new JFileChooser();
        food_jb[i] = new JButton("添加菜品");
        shop_jb[i] = new JButton("订单管理");
        food_jp[i]=new JPanel();
        food_jp[i].add(food_jb[i]);
        food_jp[i].add(shop_jb[i]);
		food_jp[i].setLayout(new FlowLayout());
		jp.add(food_jp[i]);
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
    
    private void data(){
    	try{
    		Database.strTemp="SELECT * FROM "+name+"";
			Database.rs=Database.stmt.executeQuery(Database.strTemp);
			String name1,price1,iconurl1;
			while(Database.rs.next()){
				name1=Database.rs.getString("FoodName");
				price1=Database.rs.getString("FoodPrice");
				iconurl1=Database.rs.getString("FoodIcon");
				name2[number]=name1;
				price2[number]=price1;
				icon[number]=new ImageIcon(iconurl1); 
				add_jp[number]=new JPanel();
				add_icon[number]=new JLabel();
				add_name[number]=new JLabel(name1);
				add_price[number]=new JLabel(price1);
				add_icon[number].setIcon(icon[number]);
				add_jp[number].setLayout(new GridLayout(0,3));
				add_jp[number].add(add_icon[number]);
				add_jp[number].add(add_name[number]);
				add_jp[number].add(add_price[number]);
				icon[number].setImage(icon[number].getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
				add_icon[number].setSize(200, 200);
				add_icon[number].setIcon(icon[number]);            
				add_icon[number].setHorizontalAlignment(SwingConstants.CENTER);
				jp.add(add_jp[number]);
				number++;
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
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
		shop_jb[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShopCar();
        		}
		});
	}
	private void foodlistener(final int i){
		image_jb[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label[i]=new JLabel();
		        food_jf[i].add(label[i]);
				int result = chooser[i].showOpenDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    iconurl[i] = chooser[i].getSelectedFile().getPath();
                    icon[i]=new ImageIcon(iconurl[i]); 
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
				String name1=name_jt[i].getText(),price1=price_jt[i].getText();
				Database.strTemp="INSERT INTO "+name+"(FoodName,FoodPrice,FoodIcon)VALUES ('"+name1+"','"+price1+"','"+iconurl[i]+"')";
				try{
					Database.stmt.executeUpdate(Database.strTemp);
				}catch(SQLException e1){
					e1.printStackTrace();
				}
				add_icon[i].setIcon(icon[i]);
				add_jp[i].setLayout(new GridLayout(0,3));
				add_jp[i].add(add_icon[i]);
				add_jp[i].add(add_name[i]);
				add_jp[i].add(add_price[i]);
				food_jf[i].dispose();
				jp.remove(food_jp[i]);
				jp.add(add_jp[i]);
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
	
	public restaurant_manage(){
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(3);
		jf.setBounds(500,100,800,800);
		jf.add(js);
		info();
		data();
		start();
		new info_client();
	}
}