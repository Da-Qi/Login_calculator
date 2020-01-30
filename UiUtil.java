package cn.itcast.util;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.print.DocFlavor.URL;
import javax.swing.JFrame;

public class UiUtil {

	private UiUtil() {}
	
	/*//修改窗体图标
	public static void setFrameImage(JFrame jf) {
		//获取工具类对象
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		//根据路径获取图片
		Image i = tk.getImage("src\\cn\\itcast\\resource\\user.png");
		//给窗体设置图片
		jf.setIconImage(i);
	}*/
	
	//修改窗体图标
		public static void setFrameImage(JFrame jf,String imageName) {
			//获取工具类对象
			Toolkit tk = Toolkit.getDefaultToolkit();
			
			//根据路径获取图片
			Image i = tk.getImage("src\\cn\\itcast\\resource\\"+imageName);
			//给窗体设置图片
			jf.setIconImage(i);
		}
	
	//设置窗体居中
	public static void setFrameCenter(JFrame jf) {
		/*
		 * 思路：
		 * A:获取屏幕的宽和高
		 * B:获取窗体的宽和高
		 * C:（用屏幕的宽-窗体的宽）/2，（用屏幕的高-窗体的高）/2作为窗体的新坐标
		*/
		
		//获取工具对象
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		//获取屏幕的宽和高
		Dimension d = tk.getScreenSize();
		double screenWidth = d.getWidth();
		double screenHeigth = d.getHeight();
		
		//获取窗体的宽和高
		int frameWidth = jf.getWidth();
		int frameHeigth = jf.getHeight();
		
		//获取新的窗体宽和高
		int width = (int)(screenWidth-frameWidth)/2;
		int heigth = (int)(screenHeigth-frameHeigth)/2;
		
		//设置窗体坐标
		jf.setLocation(width, heigth);
		
	}

}
