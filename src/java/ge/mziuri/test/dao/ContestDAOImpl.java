package ge.mziuri.test.dao;

import ge.mziuri.test.metainfo.DatabaseMetaInfo;
import ge.mziuri.test.model.Contest;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ContestDAOImpl implements ContestDAO {

    private Connection con;

    private PreparedStatement pstmt;

    public ContestDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DatabaseMetaInfo.databaseURL, DatabaseMetaInfo.username, DatabaseMetaInfo.passsword);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int addContest(Contest contest) {
        try {
            pstmt = con.prepareStatement("INSERT INTO contest (name,opendate,opentime,duration) VALUES (?,?,?,?) RETURNING id");
            pstmt.setString(1, contest.getName());
            pstmt.setDate(2, contest.getDate());
            pstmt.setTime(3, contest.getTime());
            pstmt.setInt(4, contest.getDuration());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

    @Override
    public List<Contest> getAllContest(boolean active) {
        List<Contest> contests = new ArrayList<>();
        try {
            String sql = "SELECT * FROM contest ";
            if (active) {
                sql += "WHERE opendate >= ? OR (opendate = ? AND opentime >= ?)";
            }
            pstmt = con.prepareStatement(sql);
            if (active) {
                java.util.Date currDate = new java.util.Date();
                Date date = new Date(currDate.getYear(), currDate.getMonth(), currDate.getDate());
                Time time = new Time(currDate.getHours(), currDate.getMinutes(), currDate.getSeconds());
                pstmt.setDate(1, date);
                pstmt.setDate(2, date);
                pstmt.setTime(3, time);
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date date = rs.getDate("opendate");
                Time time = rs.getTime("opentime");
                int duration = rs.getInt("duration");

                Contest contest = new Contest();
                contest.setDate(date);
                contest.setDuration(duration);
                contest.setId(id);
                contest.setName(name);
                contest.setTime(time);

                contests.add(contest);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return contests;
    }

    @Override
    public Contest getContestbyId(int id) {
        Contest contest = null;
        try {
            String sql = "SELECT * FROM contest Where id=? ";
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {

                String name = rs.getString("name");
                Date date = rs.getDate("opendate");
                Time time = rs.getTime("opentime");
                int duration = rs.getInt("duration");
                contest =new Contest();
                contest.setDate(date);
                contest.setDuration(duration);
                contest.setId(id);
                contest.setName(name);
                contest.setTime(time);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return contest;
    }

}
