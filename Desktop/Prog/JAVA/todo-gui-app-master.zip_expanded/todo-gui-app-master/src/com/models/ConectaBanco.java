package com.models;

import java.sql.*;

public class ConectaBanco {
	private String usuario = "root";
	private String senha = "root";
	private String host = "localhost";
	private String porta  = "3306";
	private String bd = "todolist_a3";
	
	public Connection conectar() {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + bd, usuario, senha);
			return c;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}