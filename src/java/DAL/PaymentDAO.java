/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Payment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class PaymentDAO extends DBContext<Payment> {

    @Override
    public ArrayList<Payment> list() {
        ArrayList<Payment> list = new ArrayList<>();
        try {
            String sql = "select \n"
                    + "s2.id, s2.setting_title,s2.status,s2.description\n"
                    + "from setting_HE153274 s1 left join setting_HE153274 s2 on s1.id = s2.type\n"
                    + "where s1.setting_title = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "Payment");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Payment p = new Payment();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("setting_title"));
                p.setStatus(rs.getBoolean("status"));
                p.setDescription(rs.getString("description"));
                
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Payment get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Payment model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Payment model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Payment model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
