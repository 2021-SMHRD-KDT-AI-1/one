package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GameCon")
public class GameCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("����������ȣ��");
		
		int pt = Integer.parseInt(request.getParameter("radioTxt"));
		int num = Integer.parseInt(request.getParameter("num"));
		String A = "Q"+num;
		System.out.println("����"+pt);
		System.out.println("����"+A);
		String name = request.getParameter("name");
		System.out.println("����ڰ� ������ �� : "+ pt);
		System.out.println("����ڰ� ������ name : "+ name);
		
		//A�� �������� �÷�
		//pt�� ?�����Դϴ�. 
		//name�� �����..�� �װ��־�� ���� �Է°����ؼ���������
		
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
//		for(int i=1; i<=10;i++) {
//			String A = "Q"+i;
//		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url ="jdbc:oracle:thin:@127.0.0.1:1521";
			String dbid ="hr";
			String dbpw ="hr";
			Connection conn = DriverManager.getConnection(url, dbid, dbpw);
			
			if(conn!=null) {
				System.out.println("���Ἲ��");
			}else {
				System.out.println("�������");
			}
			//"update ggame set Q1=? where name=?;"
			//"update web_member set pw=?,tel=?,address=? where email=?"
			
			String sql = "update ggame set " + A +"=? where name=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1,pt);
			psmt.setString(2, name);
			
			int cnt = psmt.executeUpdate();
			
			if(cnt>0) {
				//response.sendRedirect("QuestionGame.jsp");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		response.setContentType("text/html;charset=euc-kr");
		//�����ϴ� �������� ������ִ� ���
		PrintWriter out = response.getWriter();
		//�����ϴ� �������� �ڵ带 �Է��� �� �ִ� ���
		out.print("success");
	}

}
