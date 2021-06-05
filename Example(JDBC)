<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<script>
      var i = 0;
      var q= ["Q1 질문~~", "Q2 질문~~", "Q3~~ " , "Q4~~"];
      
      function make_question(i){
          document.getElementById("question").innerHTML  = q[i]     
      }
   </script>
   
   <h2>게임</h2>
   
   <% 
      request.setCharacterEncoding("UTF-8");
      String name = request.getParameter("name");
   %>
   <%System.out.println(name);%>
   <%
   //for(int i=0;i<str.length;i++){
      //out.println(str[i]);%>
   <form action="GameCon">
   
   <span id="question"></span>
      <br><br>
      1<input type="radio" name="radioTxt" value="1" checked>
      <input type="radio" name="radioTxt" value="2">
      <input type="radio" name="radioTxt" value="3">
      <input type="radio" name="radioTxt" value="4">
      <input type="radio" name="radioTxt" value="5">
      <input type="radio" name="radioTxt" value="6">
      <input type="radio" name="radioTxt" value="7">
      <input type="radio" name="radioTxt" value="8">
      <input type="radio" name="radioTxt" value="9">
      <input type="radio" name="radioTxt" value="10">10
      <br>
       
   </form>
   <br>
   <button onclick="ajaxCall()">다 음</button>
   <p id="p1"></p>

   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">

      </script>

   <script type="text/javascript">
   
      function ajaxCall() {
         var pt = $('input[name="radioTxt"]:checked').val();
         
         <%System.out.println(name);%>
         $.ajax({
            type : "get",//서버페이지로 보내는 방식(get/post)
            url : "GameCon",//어떤 서버페이지로 보낼건지(action)속성과 비슷
            data : {"radioTxt" : pt, "num":i+1,"name":'<%=name%>'},//서버로 보내는 데이터 {name : data}
            dataType : "text",//응답받는 데이터타입
            //async:false,
            success : function(data) {
               //서버페이지와 연결에 성공했을 때 그 다음 처리
               
               //문제번호를 +1시키고 해당하는 문제번호로 문제를 교체
               i+=1;
               make_question(i);
            },
            error : function() {
               //서버페이지와 연결이 실패했을 때 그 다음 처리
            }
            
         });
      }
   make_question(i);
   </script>
   
   <br/>

</body>
</html>
