package ge.mziuri.test.servlet;

import ge.mziuri.test.model.Test;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateOneAnsTestServlet extends HttpServlet {
    
   
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String question = request.getParameter("question");
        String ans1 = request.getParameter("Ans1");
        String ans2 = request.getParameter("Ans2");
        String ans3 = request.getParameter("Ans3");
        String ans4 = request.getParameter("Ans4");
        String ans5 = request.getParameter("Ans5");
        String ans6 = request.getParameter("Ans6");
        String correctanswer = request.getParameter("CorrectAns");
        Test test=new Test();
       
        
        
        
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}



