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
		System.out.println("서버페이지호출");
		
		int pt = Integer.parseInt(request.getParameter("radioTxt"));
		int num = Integer.parseInt(request.getParameter("num"));
		String A = "Q"+num;
		System.out.println("점수"+pt);
		System.out.println("문제"+A);
		String name = request.getParameter("name");
		System.out.println("사용자가 보내는 값 : "+ pt);
		System.out.println("사용자가 보내는 name : "+ name);
		
		//A는 문제유형 컬럼
		//pt는 ?점수입니다. 
		//name은 사용자..넵 그게있어야 점수 입력가능해서만들었어요
		
		
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
				System.out.println("연결성공");
			}else {
				System.out.println("연결실패");
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
		//응답하는 페이지를 만들어주는 기능
		PrintWriter out = response.getWriter();
		//응답하는 페이지에 코드를 입력할 수 있는 기능
		out.print("success");
	}

}
