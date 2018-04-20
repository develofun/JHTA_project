package dbcp.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbcpBean {
	static DataSource ds;
	static{
		try{
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne){
			System.out.println(ne.getMessage());
		}
	}
	public static Connection getConn(){
		try{
			Connection conn = ds.getConnection();
			return conn;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public static void close(Statement stmt,Connection con){
		try{
			if(stmt!=null)stmt.close();
			if(con!=null)con.close();
		}catch(SQLException se){
			System.out.println(se.getMessage());
		}
	}
	public static void close(ResultSet rs,Statement stmt,Connection con){
		try{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(con!=null)con.close();
		}catch(SQLException se){
			System.out.println(se.getMessage());
		}
	}
}







