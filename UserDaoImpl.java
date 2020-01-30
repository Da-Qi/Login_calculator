package cn.itcast.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import cn.itcast.dao.UserDao;
import cn.itcast.pojo.User;

public class UserDaoImpl implements UserDao {
	// 定义文件
	private static File file = new File("user.txt");

	// 类加载的时候就把文件创建
	static {
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean login(String username, String password) {
		boolean flag = false;

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] datas = line.split("="); // 用户名密码分开放，以“=”切割
				if (datas[0].equals(username) && datas[1].equals(password)) {
					flag = true;
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}

		return flag;
	}

	@Override
	public void regist(User user) {
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(file,true));
			bw.write(user.getUsername()+"="+user.getPassword());
			bw.newLine();
			bw.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}

}
