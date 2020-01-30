package cn.itcast.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.itcast.util.UiUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class FrameDemo extends JFrame {

	private JPanel contentPane;
	private JTextField firstNumber;
	private JTextField secondNumber;
	private JTextField resultNumber;

	/**
	 * Launch the application.
	 */
	
	/*public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(MyLookAndFeel.JTATTOO_ALUMINUM);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDemo frame = new FrameDemo();
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
	public FrameDemo(String name) {
		setTitle("\u6A21\u62DF\u56DB\u5219\u8FD0\u7B97");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u7B2C\u4E00\u4E2A\u64CD\u4F5C\u6570");
		label.setBounds(21, 27, 92, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u7B2C\u4E8C\u4E2A\u64CD\u4F5C\u6570");
		label_1.setBounds(139, 27, 92, 15);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u7ED3\u679C");
		label_2.setBounds(276, 27, 72, 15);
		contentPane.add(label_2);

		firstNumber = new JTextField();
		firstNumber.setBounds(21, 52, 72, 21);
		contentPane.add(firstNumber);
		firstNumber.setColumns(10);

		secondNumber = new JTextField();
		secondNumber.setColumns(10);
		secondNumber.setBounds(139, 52, 72, 21);
		contentPane.add(secondNumber);

		resultNumber = new JTextField();
		resultNumber.setColumns(10);
		resultNumber.setBounds(256, 52, 92, 21);
		contentPane.add(resultNumber);

		JLabel label_3 = new JLabel("=");
		label_3.setBounds(230, 53, 16, 20);
		contentPane.add(label_3);

		JComboBox selectOperator = new JComboBox();
		selectOperator.setModel(new DefaultComboBoxModel(new String[] { "+", "-", "*", "/" }));
		selectOperator.setBounds(97, 52, 32, 21);
		contentPane.add(selectOperator);

		JButton button = new JButton("\u8BA1\u7B97");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ��ȡ��һ��������
				String firstNumberString = firstNumber.getText().trim();
				// ��ȡ�����
				String selectOperator1 = selectOperator.getSelectedItem().toString();
				// ��ȡ�ڶ���������
				String secondNumberString = secondNumber.getText().trim();
				
				
				//����У�飬�����������ַ���
				String regex = "\\d+";
				 
				//�����һ����
				if(!firstNumberString.matches(regex)) {
					 JOptionPane.showMessageDialog(rootPane, "��һ��������������Ҫ��");;
					 firstNumber.setText("");
					 firstNumber.requestFocus();
					 return;
				 }
				//����ڶ�����
				if(!secondNumberString.matches(regex)) {
					 JOptionPane.showMessageDialog(rootPane, "�ڶ���������������Ҫ��");;
					 secondNumber.setText("");
					 secondNumber.requestFocus();
					 return;
				 }
				
				

				// ���ַ���ת��Ϊ������
				double firstNumber = Integer.parseInt(firstNumberString);
				double secondNumber = Integer.parseInt(secondNumberString);

				// ����������ܽ��
				double resultNumber1 = 0;

				switch (selectOperator1) {
				case "+":
					resultNumber1 = firstNumber + secondNumber;
					break;
				case "-":
					resultNumber1 = firstNumber - secondNumber;
					break;
				case "*":
					resultNumber1 = firstNumber * secondNumber;
					break;
				case "/":
					resultNumber1 = firstNumber / secondNumber;
					break;
				}
				//�ѽ�����Ƹ������
				resultNumber.setText(String.format("%.2f", resultNumber1));
				
			}
		});
		button.setBounds(230, 110, 93, 23);
		contentPane.add(button);
		/*//����ͼ��
		UiUtil.setFrameImage(this,"jjcc.png");
		//����
		UiUtil.setFrameCenter(this);*/
		init(name);
	}

	private void init(String name) {
		// TODO Auto-generated method stub
		this.setTitle("��ӭ"+name+"ʹ��");
		//����ͼ��
		UiUtil.setFrameImage(this,"jjcc.png");
		//����
		UiUtil.setFrameCenter(this);
	}
}
