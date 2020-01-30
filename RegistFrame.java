package cn.itcast.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.pojo.User;
import cn.itcast.util.UiUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegistFrame extends JFrame {

	private JPanel contentPane;
	private JTextField jtfUsername;
	private JPasswordField jpfPassword;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistFrame frame = new RegistFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public RegistFrame() {
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
		
		JButton button = new JButton("\u53D6\u6D88");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame lf = new LoginFrame();
				lf.setVisible(true);
				dispose();
			}
		});
		button.setBounds(75, 161, 75, 23);
		contentPane.add(button);
		
		JButton button_2 = new JButton("\u6CE8\u518C");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * ����
				 * A����ȡ�û���������
				 * B����������ʽ������У��
				 * C����װ���û�����
				 * D�������û������Ĺ��ܽ���ע��
				 * E���ص���¼����
				 */
				//A
				String username = jtfUsername.getText().trim();
				String password = jpfPassword.getText().trim();
				
				//B
				//�������
				//�û�������
				String usernameRegex = "[a-zA-Z]{3,10}";	//��ĸ�����ִ�Сд
				//�������
				String passwordRegex = "\\w{6,12}";		//6-12λ�����ַ�
				
				//У��
				if(!username.matches(usernameRegex)) {
					JOptionPane.showMessageDialog(rootPane, "�û�������������(3-10��Ӣ����ĸ���)");
					jtfUsername.setText("");
					jtfUsername.requestFocus();
					return;
				}
				if(!password.matches(passwordRegex)) {
					JOptionPane.showMessageDialog(rootPane, "���벻��������(6-12�����ⵥ���ַ�)");
					jpfPassword.setText("");
					jpfPassword.requestFocus();
					return;
				}
				
				//��װ���û�����
				User user =  new User();
				user.setUsername(username);
				user.setPassword(password);
				
				//�����û������Ĺ��ܽ���ע��
				UserDao ud = new UserDaoImpl();
				ud.regist(user);
				
				//������ʾ
				JOptionPane.showMessageDialog(rootPane, "�û�ע��ɹ����ص���¼����");
				
				goLogin();
				
			}

			private void goLogin() {
				// TODO Auto-generated method stub
				LoginFrame lf = new LoginFrame();
				lf.setVisible(true);
				dispose();
			}
		});
		button_2.setBounds(232, 161, 75, 23);
		contentPane.add(button_2);
		
		jpfPassword = new JPasswordField();
		jpfPassword.setBounds(127, 100, 148, 21);
		contentPane.add(jpfPassword);
		
		init();
	}
	
	private void init() {
		this.setTitle("\u6CE8\u518C\u754C\u9762");
		this.setResizable(false);	//	�û����ܵ�����С
		UiUtil.setFrameCenter(this);
		UiUtil.setFrameImage(this,"user.png");
	}
}
