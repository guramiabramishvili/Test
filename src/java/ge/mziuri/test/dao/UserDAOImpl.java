
package ge.mziuri.test.dao;

import ge.mziuri.test.exceptions.RegistrationException;
import ge.mziuri.test.metainfo.DatabaseMetaInfo;
import ge.mziuri.test.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl implements UserDAO {
    
   private Connection con;

    private PreparedStatement pstmt;

    public UserDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DatabaseMetaInfo.databaseURL, DatabaseMetaInfo.username, DatabaseMetaInfo.passsword);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void addUser(User user) throws RegistrationException {
       try {
            pstmt = con.prepareStatement("SELECT COUNT(id) FROM systemuser WHERE username = ?");
            pstmt.setString(1, user.getUsername());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            if (count > 0) {
                throw new RegistrationException("Username already used!");
            } else {
                pstmt = con.prepareStatement("INSERT INTO systemuser (admin,firstname,username,lastname,password,email) VALUES (?,?,?,?,?,?)");
                pstmt.setBoolean(1, user.isAdmin());
                pstmt.setString(2, user.getFirstname());
                pstmt.setString(3, user.getUsername());
                pstmt.setString(4, user.getLastname());
                pstmt.setString(5, user.getPassword());
                pstmt.setString(6, user.getEmail());

                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
    }

    @Override
    public User getUser(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
