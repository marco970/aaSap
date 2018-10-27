package zad1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	private String url;
	private String uid = "root";
	private String pwd = "usbw";
	private String driverName = "com.mysql.jdbc.Driver";
	private Connection con;
	
	
	
	public Database(String url, TravelData travelData) {
		// TODO Auto-generated constructor stub
		this.url=url;
	}

	public void create()  {
		// TODO Auto-generated method stub
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, uid, pwd);
		} catch (ClassNotFoundException exc) {
	        System.out.println("Brak klasy sterownika");
	        System.out.println(exc);
	        System.exit(1);
		} catch (SQLException exc) {
		    System.out.println("Nieudane po³¹czenie z " + url);
		    System.out.println(exc);
		    System.exit(1);
		}
		 Statement stmt;
		try {
			stmt = (Statement) con.createStatement();
			 stmt.executeUpdate("create database if not exists offers");
			 stmt.executeUpdate("use offers");
			 stmt.executeUpdate("drop table if exists sentens;");
			 String creaTab = "create table sentens (sent varchar(300));";
			 stmt.executeUpdate(creaTab);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //System.out.println(stmt.executeQuery("show tables").toString());

		 
		 //-- INSERT INTO `offers`.`sentens` (`sent`) VALUES ('ala');
		 //stmt.executeUpdate("
		 /*
		 while (rs.next())	{
			 String p = rs.getString(3);
			 System.out.println(p);
		 }
		 */
		
		
		
	}// end of create

	public void showGui() {
		// TODO Auto-generated method stub
		
	}

}

