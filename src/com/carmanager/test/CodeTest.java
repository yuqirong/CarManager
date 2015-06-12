package com.carmanager.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CodeTest {

	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql:///carmanager", "root", "mysql");
		return connection;
	}

	public void readline(Connection connection) throws IOException, SQLException {
		InputStream inputStream = new FileInputStream("D:\\code.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				inputStream));
		String str = null;
		while ((str = reader.readLine()) != null) {
			if (str.trim() != "" && str.trim().length() > 0) {
				String[] split = str.split(";");
				System.out.println(split[0]);
				System.out.println(split[1]);
				String sql = "insert into faultcodes(code,information) values (?,?)";
				PreparedStatement prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setString(1, split[0]);
				prepareStatement.setString(2, split[1]);
				prepareStatement.executeUpdate();
				System.out.println("success");
			}
		}
		reader.close();
		inputStream.close();
		connection.close();
	}
	
	public static void main(String[] args) {
		CodeTest codeTest = new CodeTest();
		try {
			codeTest.readline(codeTest.getConnection());
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
