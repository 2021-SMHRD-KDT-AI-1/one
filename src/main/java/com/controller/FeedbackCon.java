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
import javax.servlet.http.HttpSession;

@WebServlet("/FeedbackCon")
public class FeedbackCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String feedback = request.getParameter("review_content");
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		System.out.println("사용자가 보내는 review : "+ feedback);
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
			
			String sql = "update artc set FEEDBACK=? where name=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,feedback);
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
		//응답하는 페이지를 만들어주는 기능
		PrintWriter out = response.getWriter();
		//응답하는 페이지에 코드를 입력할 수 있는 기능
		out.print("success");
		
		//response.sendRedirect("Result&Review.html");
	}
		
}


