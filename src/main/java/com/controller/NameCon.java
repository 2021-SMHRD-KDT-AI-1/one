package com.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/NameCon")
public class NameCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		String name = request.getParameter("name");
		
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
			//insert into ggame (name) values ('?')
			//insert into ggame values ('?')
			//insert into ggame (name) values (?)
			//insert into ggame values (?)
			String sql = "insert into artc values(?,'','','','','','','','')";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, name);
			
			int cnt = psmt.executeUpdate();
			
			if(cnt>0) {
				// '/' : 해당경로 아래에 접근
				// '?' : 쿼리스트링
				HttpSession session = request.getSession();
				session.setAttribute("name", name);
				
				name = URLEncoder.encode(name,"utf-8");
				response.sendRedirect("select.html");
				
			}
			
			}catch(Exception e) {
			e.printStackTrace();
			}
	
	}

}
