 package ge.mziuri.test.dao;

import ge.mziuri.test.metainfo.DatabaseMetaInfo;
import ge.mziuri.test.model.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResultsDAOImpl implements ResultsDAO {
  private Connection con;

    private PreparedStatement pstmt;

    public ResultsDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DatabaseMetaInfo.databaseURL, DatabaseMetaInfo.username, DatabaseMetaInfo.passsword);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public Void addResult(Result result) {
         try {
            pstmt = con.prepareStatement("INSERT INTO results (userid,contestid,point) VALUES (?,?,?) ");
            pstmt.setInt(1, result.getUser().getId());
            pstmt.setInt(2, result.getContest().getId());
            pstmt.setInt(3, result.getPoint());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {}
        }
       return null;
    }
}
    

    
