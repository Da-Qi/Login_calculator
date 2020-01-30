package cn.itcast.util;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.print.DocFlavor.URL;
import javax.swing.JFrame;

public class UiUtil {

	private UiUtil() {}
	
	/*//�޸Ĵ���ͼ��
	public static void setFrameImage(JFrame jf) {
		//��ȡ���������
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		//����·����ȡͼƬ
		Image i = tk.getImage("src\\cn\\itcast\\resource\\user.png");
		//����������ͼƬ
		jf.setIconImage(i);
	}*/
	
	//�޸Ĵ���ͼ��
		public static void setFrameImage(JFrame jf,String imageName) {
			//��ȡ���������
			Toolkit tk = Toolkit.getDefaultToolkit();
			
			//����·����ȡͼƬ
			Image i = tk.getImage("src\\cn\\itcast\\resource\\"+imageName);
			//����������ͼƬ
			jf.setIconImage(i);
		}
	
	//���ô������
	public static void setFrameCenter(JFrame jf) {
		/*
		 * ˼·��
		 * A:��ȡ��Ļ�Ŀ�͸�
		 * B:��ȡ����Ŀ�͸�
		 * C:������Ļ�Ŀ�-����Ŀ�/2��������Ļ�ĸ�-����ĸߣ�/2��Ϊ�����������
		*/
		
		//��ȡ���߶���
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		//��ȡ��Ļ�Ŀ�͸�
		Dimension d = tk.getScreenSize();
		double screenWidth = d.getWidth();
		double screenHeigth = d.getHeight();
		
		//��ȡ����Ŀ�͸�
		int frameWidth = jf.getWidth();
		int frameHeigth = jf.getHeight();
		
		//��ȡ�µĴ����͸�
		int width = (int)(screenWidth-frameWidth)/2;
		int heigth = (int)(screenHeigth-frameHeigth)/2;
		
		//���ô�������
		jf.setLocation(width, heigth);
		
	}

}
