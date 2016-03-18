package com.wy;

import java.sql.*;
public class JDBConnection {
	private Connection conn = null;  //定义连接的对象
	private Statement st = null;	//设置Statement类的对象
	private ResultSet rs=null;
	private String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 数据库的驱动
	private String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=db_WuLiu"; // URL地址
	public  JDBConnection(){
		try {
			Class.forName(dbDriver).newInstance(); // 加载数据库驱动
			conn = DriverManager.getConnection(url, "sa", "sa"); // 加载数据库
			//System.out.println("加载成功");
		} catch (Exception ex) {
			System.out.println("数据库加载失败");
		}
	}
	public ResultSet executeQuery(String sql) {
		try {
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(sql);     					//执行对数据库的查询操作
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query Exception");				//在控制台中输入异常信息
		}
		return rs;                  //将查询的结果通过return关键字返回
	}
		public boolean executeUpdata(String sql) {
		try {
			st = conn.createStatement();	//创建声明对象连接
			st.executeUpdate(sql);          //执行添加、修改、删除操作
			return true;                     //如果执行成功则返回true
		} catch (Exception e) {
			e.printStackTrace();
	    return false;                           //如果执行成功则返回false
		}	
	}
}
