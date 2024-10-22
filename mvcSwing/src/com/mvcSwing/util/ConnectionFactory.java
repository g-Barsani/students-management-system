package com.mvcSwing.util;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception {
		try {
			// Indica o DB mysql e aponta para o driver
			Class.forName("com.mysql.jdbc.Driver");
			// Conexão com DB
			String login = "root";
			String senha = "1234";
			String url = "jdbc:mysql://localhost:3306/mvc_swing";
			return DriverManager.getConnection(url,login,senha);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			JOptionPane.showMessageDialog(null, "DB conectado.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
