<%@page import="ge.mziuri.test.model.Test"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="ge.mziuri.test.dao.TestDAO"%>
<%@page import="ge.mziuri.test.dao.TestDAO"%>
<%@page import="ge.mziuri.test.dao.TestDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> ღია კითხვა</title>
    </head>
    <body>
        <form action="OpenAnsTestServlet" method="get">
            <%
                TestDAO testDAO = new TestDAOImpl();

                int contestid = 0;
                int questionNumber = 0;
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("contest_id")) {
                            contestid = Integer.parseInt(cookie.getValue());
                        }
                    }
                    for (Cookie cookie1 : cookies) {
                        if (cookie1.getName().equals("TestNumber")) {
                            questionNumber = Integer.parseInt(cookie1.getValue());
                        }
                    }
                }
                List<Test> test = testDAO.getQuestionByContestId(contestid);
                String question = test.get(questionNumber).getQuestion();
                %>
                <input type="text" style="width:800px; height:100px; font-size:20px"  value="<%=question%>"   name="question" /> <br> <br> 
              <input type="text" style="width:400px; height:50px;"   /> <br> <br> 
              <input type="submit" value="გაგძელება" />
        </form>
    </body>
</html>
