/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Fulfillment;
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
public class FulfillmentDAO extends DBContext<Fulfillment>{

    @Override
    public ArrayList<Fulfillment> list() {
        ArrayList<Fulfillment> list = new ArrayList<>();
        try {
            String sql = "select \n"
                    + "s2.id, s2.setting_title,s2.status,s2.description\n"
                    + "from setting_HE153274 s1 left join setting_HE153274 s2 on s1.id = s2.type\n"
                    + "where s1.setting_title = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "Fulfillment");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Fulfillment f = new Fulfillment();
                f.setId(rs.getInt("id"));
                f.setName(rs.getString("setting_title"));
                f.setStatus(rs.getBoolean("status"));
                f.setDescription(rs.getString("description"));
                
                list.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Fulfillment get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Fulfillment model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Fulfillment model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Fulfillment model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
