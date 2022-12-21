/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Payment;
import Models.PaymentMethod;
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
public class PaymentMethodDAO extends DBContext<PaymentMethod>{

    @Override
    public ArrayList<PaymentMethod> list() {
        ArrayList<PaymentMethod> list = new ArrayList<>();
        try {
            String sql = "select \n"
                    + "s2.id, s2.setting_title,s2.status,s2.description\n"
                    + "from setting_HE153274 s1 left join setting_HE153274 s2 on s1.id = s2.type\n"
                    + "where s1.setting_title = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "Payment method");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                PaymentMethod p = new PaymentMethod();
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
    public PaymentMethod get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(PaymentMethod model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(PaymentMethod model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(PaymentMethod model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
