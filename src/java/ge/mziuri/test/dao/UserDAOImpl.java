
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
    public User getUser(String username,String password) {
        User user = null;
        try { 
            pstmt = con.prepareStatement("SELECT * FROM  systemuser  WHERE username = ? AND password = ? ;");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String firstname=rs.getString("firstname");
                String lastname=rs.getString("lastname");
                String email=rs.getString("email");
                boolean admin=rs.getBoolean("admin");
                System.out.println(username + " " + admin);
                user = new User();
                user.setAdmin(admin);
                user.setEmail(email);
                user.setFirstname(firstname);
                user.setId(id);
                user.setLastname(lastname);
                user.setPassword(password);
                user.setUsername(username);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

    @Override
    public User getUserbyID(int id) {
        User user = null;
        try { 
            pstmt = con.prepareStatement("SELECT * FROM  systemuser  WHERE id = ? ;");
            pstmt.setInt(1, id);
           
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String username=rs.getString("username");
                String password=rs.getString("password");
                String firstname=rs.getString("firstname");
                String lastname=rs.getString("lastname");
                String email=rs.getString("email");
                boolean admin=rs.getBoolean("admin");
               // System.out.println(username + " " + admin);
                user = new User();
                user.setAdmin(admin);
                user.setEmail(email);
                user.setFirstname(firstname);
                user.setId(id);
                user.setLastname(lastname);
                user.setPassword(password);
                user.setUsername(username);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }
    
}