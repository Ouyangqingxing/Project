package com.wy;

import java.sql.*;
public class JDBConnection {
	private Connection conn = null;  //�������ӵĶ���
	private Statement st = null;	//����Statement��Ķ���
	private ResultSet rs=null;
	private String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // ���ݿ������
	private String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=db_WuLiu"; // URL��ַ
	public  JDBConnection(){
		try {
			Class.forName(dbDriver).newInstance(); // �������ݿ�����
			conn = DriverManager.getConnection(url, "sa", "sa"); // �������ݿ�
			//System.out.println("���سɹ�");
		} catch (Exception ex) {
			System.out.println("���ݿ����ʧ��");
		}
	}
	public ResultSet executeQuery(String sql) {
		try {
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(sql);     					//ִ�ж����ݿ�Ĳ�ѯ����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query Exception");				//�ڿ���̨�������쳣��Ϣ
		}
		return rs;                  //����ѯ�Ľ��ͨ��return�ؼ��ַ���
	}
		public boolean executeUpdata(String sql) {
		try {
			st = conn.createStatement();	//����������������
			st.executeUpdate(sql);          //ִ����ӡ��޸ġ�ɾ������
			return true;                     //���ִ�гɹ��򷵻�true
		} catch (Exception e) {
			e.printStackTrace();
	    return false;                           //���ִ�гɹ��򷵻�false
		}	
	}
}
