package cn.itcast.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.util.UiUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField jtfUsername;
	private JPasswordField jpfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jLabel1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		jLabel1.setBounds(63, 46, 54, 15);
		contentPane.add(jLabel1);
		
		JLabel jLabel2 = new JLabel("\u5BC6\u7801\uFF1A");
		jLabel2.setBounds(63, 103, 54, 15);
		contentPane.add(jLabel2);
		
		jtfUsername = new JTextField();
		jtfUsername.setBounds(127, 43, 148, 21);
		contentPane.add(jtfUsername);
		jtfUsername.setColumns(10);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 思路：
				 * A：获取用户名和密码
				 * B：正则表达式校验用户名和密码
				 * C：创建对象调用功能，返回一个boolean值
				 * D：根据boolean值给出提示
				 */
				
				//A
				String username = jtfUsername.getText().trim();
				String password = jpfPassword.getText().trim();
				
				//B
				//定义规则
				//用户名规则
				String usernameRegex = "[a-zA-Z]{3,10}";	//字母不区分大小写
				//密码规则
				String passwordRegex = "\\w{6,12}";		//6-12位任意字符
				
				//校验
				if(!username.matches(usernameRegex)) {
					JOptionPane.showMessageDialog(rootPane, "用户名不满足条件(3-10个英文字母组成)");
					jtfUsername.setText("");
					jtfUsername.requestFocus();
					return;
				}
				if(!password.matches(passwordRegex)) {
					JOptionPane.showMessageDialog(rootPane, "密码不满足条件(6-12个任意单词字符)");
					jpfPassword.setText("");
					jpfPassword.requestFocus();
					return;
				}	
				
				//创建对象调用功能，返回一个boolean值
				UserDao ud = new UserDaoImpl();
				boolean flag = ud.login(username, password);
				
				if(flag) {
					JOptionPane.showMessageDialog(getParent(), "恭喜你登录成功！");
					FrameDemo njf = new FrameDemo(username);
					njf.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(rootPane, "用户名或密码不正确！");
					jtfUsername.setText("");
					jpfPassword.setText("");
					jtfUsername.requestFocus();
				}
				
			}
		});
		button.setBounds(42, 170, 75, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfUsername.setText("");
				jpfPassword.setText("");
				
			}
		});
		button_1.setBounds(151, 170, 75, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u6CE8\u518C");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistFrame rf = new RegistFrame();
				rf.setVisible(true);
				dispose(); //隐藏本窗体
			}
		});
		button_2.setBounds(251, 170, 75, 23);
		contentPane.add(button_2);
		
		jpfPassword = new JPasswordField();
		jpfPassword.setBounds(127, 100, 148, 21);
		contentPane.add(jpfPassword);
		
		init();
	}
	
	private void init() {
		this.setTitle("登录界面");
		this.setResizable(false);	//不可改变大小
		UiUtil.setFrameCenter(this);
		UiUtil.setFrameImage(this,"user.png");
	}
}
