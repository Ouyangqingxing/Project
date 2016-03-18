package com.wy;

import java.sql.ResultSet;

public class test {
	public static void main(String[] args) {
		 ResultSet rs1=null;
		 String sql="select * from tb_Customar";
		 JDBConnection op=new JDBConnection();
		 rs1=op.executeQuery(sql);
		 if(rs1!=null)
		 {
			 System.out.println("1");
		 }
		 else
		 {
			 System.out.println("2");
		 }
		 
	}

}
