
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
    public List<Contest> getAllContest() {
        List<Contest> contests = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM contest");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date date = rs.getDate("opendate");
                Time time = rs.getTime("opentime");
                int duration=rs.getInt("duration");
                
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
    
    }
    

