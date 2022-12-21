/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class UserDAO extends DBContext<User> {

    @Override
    public ArrayList<User> list() {
        ArrayList<User> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [PRJ301_BL5_FA22].[dbo].[user_HE153274]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUserName(rs.getString("user_name"));
                u.setPassword(rs.getString("password"));
                u.setFullName(rs.getString("full_name"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                u.setAddress(rs.getString("address"));
                u.setStatus(rs.getBoolean("status"));
                u.setNote(rs.getString("note"));
                
                list.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public User getAccount(String userName, String password) {
        try {
            String sql = "select * from user_HE153274\n"
                    + "where (user_name = ? or email = ?) and password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, userName);
            stm.setString(2, userName);
            stm.setString(3, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserName(rs.getString("user_name"));
                u.setPassword(rs.getString("password"));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public User get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(User model) {
        try {
            String sql = "INSERT INTO [dbo].[user_HE153274]\n"
                    + "           ([user_name]\n"
                    + "           ,[password]\n"
                    + "           ,[full_name]\n"
                    + "           ,[email]\n"
                    + "           ,[phone]\n"
                    + "           ,[address]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getUserName());
            stm.setString(2, model.getPassword());
            stm.setString(3, model.getFullName());
            stm.setString(4, model.getEmail());
            stm.setString(5, model.getPhone());
            stm.setString(6, model.getAddress());
            stm.setBoolean(7, model.isStatus());
            
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(User model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(User model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
