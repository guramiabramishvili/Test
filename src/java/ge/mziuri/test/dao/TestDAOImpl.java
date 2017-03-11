
package ge.mziuri.test.dao;

import ge.mziuri.test.metainfo.DatabaseMetaInfo;
import ge.mziuri.test.model.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TestDAOImpl  implements TestDAO{
    
    
    
    
   private Connection con;

    private PreparedStatement pstmt;

    public TestDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DatabaseMetaInfo.databaseURL, DatabaseMetaInfo.username, DatabaseMetaInfo.passsword);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
 /*
   @Override
    public void addTest(Test test) {
         try {
            pstmt = con.prepareStatement("INSERT INTO test (question,ans1,ans2,ans3,ans4,correctanswer,contest_id) VALUES (?,?,?,?,?,?,?)");
            
            
           
            pstmt.setString(1, test.getQuestion());
            pstmt.setString(2, test.getAns1());
            pstmt.setString(3, test.getAns2());
            pstmt.setString(4, test.getAns3());
            pstmt.setString(5, test.getAns4());
            pstmt.setString(6, test.getCorrectanswer());
            pstmt.setInt(7, test.getContest_id());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
             */
         }
    