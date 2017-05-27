package ge.mziuri.test.dao;

import ge.mziuri.test.metainfo.DatabaseMetaInfo;
import ge.mziuri.test.model.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public void addResult(Result result) {
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
            } catch (SQLException ex) {
            }
        }
    }

    @Override
    public List<Result> getResultByContestId(Integer contestid) {
        List<Result> results = new ArrayList<>();
        ContestDAO contestDAO = new ContestDAOImpl();
        UserDAO userDAO = new UserDAOImpl();
        try {
            pstmt = con.prepareCall("SELECT * FROM Results WHERE contestid = ? ORDER BY point DESC");
            pstmt.setInt(1, contestid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Result result = new Result();
                int userid = rs.getInt("userid");
                int points = rs.getInt("point");
                result.setContest(contestDAO.getContestbyId(contestid));
                userDAO = new UserDAOImpl();
                result.setUser(userDAO.getUserbyID(userid));
                result.setPoint(points);
                results.add(result);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
            }
        }
        return results;
    }
}
