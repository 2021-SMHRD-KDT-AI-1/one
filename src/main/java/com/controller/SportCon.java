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
import javax.websocket.Session;
import javax.servlet.http.HttpSession;

@WebServlet("/SportCon")
public class SportCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		int pt1 = Integer.parseInt(request.getParameter("exercize1"));
		int pt2 = Integer.parseInt(request.getParameter("exercize2"));
		int pt3 = Integer.parseInt(request.getParameter("exercize3"));
		int pt4 = Integer.parseInt(request.getParameter("exercize4"));
		int pt5 = Integer.parseInt(request.getParameter("exercize5"));
		
		System.out.println("사용자가 보내는 값 : "+ pt1 +","+ pt2 +","+ pt3 +","+ pt4 +","+ pt5 );
		System.out.println("사용자가 보내는 name : "+ name);
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url ="jdbc:oracle:thin:@127.0.0.1:1521";
			String dbid ="hr";
			String dbpw ="hr";
			Connection conn = DriverManager.getConnection(url, dbid, dbpw);
			
			if(conn!=null) {
				System.out.println("연결성공");
			}else {
				System.out.println("연결실패");
			}
			//"update ggame set Q1=? where name=?;"
			//"update web_member set pw=?,tel=?,address=? where email=?"
			
			String sql = "update ggame set Q1=? ,Q2=? ,Q3=? ,Q4=? ,Q5=? where name=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1,pt1);
			psmt.setInt(2,pt2);
			psmt.setInt(3,pt3);
			psmt.setInt(4,pt4);
			psmt.setInt(5,pt5);
			psmt.setString(6, name);
			
			int cnt = psmt.executeUpdate();
			
			if(cnt>0) {
				//response.sendRedirect("Result&Review.html");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		response.setContentType("text/html;charset=euc-kr");
		//응답하는 페이지를 만들어주는 기능
		PrintWriter out = response.getWriter();
		//응답하는 페이지에 코드를 입력할 수 있는 기능
		out.print("success");
	}
	

}
