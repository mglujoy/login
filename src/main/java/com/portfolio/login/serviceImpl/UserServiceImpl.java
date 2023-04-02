package com.portfolio.login.serviceImpl;

import com.portfolio.login.dbutil.DBUtil;
import com.portfolio.login.service.UserService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    Connection connection;
    int flag = 0;
    
    public UserServiceImpl() throws SQLException {
        connection = DBUtil.getConnection(); 
    }
    
    @Override
    public int loginValidation(String username, String password) {
        
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = '" + username + "' ");
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()){
                if(rs.getString(6).equals(username) && rs.getString(7).equals(password)) {
                    flag = 1;
                } else {
                    System.out.println("Invalid username/password");}
                    flag = 0;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return flag;
    }
    
    
    
}
