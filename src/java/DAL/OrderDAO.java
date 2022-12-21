/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Carrier;
import Models.Chanel;
import Models.Customer;
import Models.Fulfillment;
import Models.Order;
import Models.Payment;
import Models.PaymentMethod;
import Models.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class OrderDAO extends DBContext<Order> {

    @Override
    public ArrayList<Order> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Order> listSearch() {
        ArrayList<Order> list = new ArrayList<>();
        try {
            String sql = "SELECT o.id as 'oid',\n"
                    + "                    IsNull(o.customer_id,-1) as 'customer_id',c.name as 'cname', c.address,c.phone,\n"
                    + "                     o.payment, s1.setting_title as 'pname',\n"
                    + "                     o.Fulfillment,s2.setting_title as 'fname',\n"
                    + "                     o.payment_method,s3.setting_title as 'pmethod',\n"
                    + "                     o.chanel_id,ch.chanel_name as 'chname',\n"
                    + "                     o.carrier_id, ca.name as'caname',\n"
                    + "                     o.time_create,o.is_cod,o.description,\n"
                    + "                     p.id as 'pid',p.product_name,p.type,p.price,od.quantity\n"
                    + "                     from order_HE153274 o\n"
                    + "                    left join order_details_HE153274 od on o.id = od.oder_id\n"
                    + "                     left join customer_HE153274 c on o.customer_id = c.id\n"
                    + "                     left join setting_HE153274 s1 on o.payment = s1.id\n"
                    + "                     left join setting_HE153274 s2 on o.Fulfillment = s2.id\n"
                    + "                     left join channel_HE153274 ch on o.carrier_id = ch.id\n"
                    + "                     left join setting_HE153274 s3 on o.payment_method = s3.id\n"
                    + "                     left join carrier_HE153274 ca on o.carrier_id = ca.id\n"
                    + "                    left join product_HE153274 p on od.product_id = p.id";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            Order current = new Order();
            current.setId(-1);
            while (rs.next()) {
                int oid = rs.getInt("oid");
                if (oid != current.getId()) {
                    current = new Order();
                    current.setId(oid);

                    Customer c = new Customer();
                    c.setId(rs.getInt("customer_id"));
                    c.setName(rs.getString("cname"));
                    c.setAddress(rs.getString("address"));
                    c.setPhone(rs.getString("phone"));
                    current.setCustomer(c);

                    Payment p = new Payment();
                    p.setId(rs.getInt("payment"));
                    p.setName(rs.getString("pname"));
                    current.setPayment(p);

                    PaymentMethod pm = new PaymentMethod();
                    pm.setId(rs.getInt("payment_method"));
                    pm.setName(rs.getString("pmethod"));
                    current.setPaymentMethod(pm);

                    Fulfillment f = new Fulfillment();
                    f.setId(rs.getInt("Fulfillment"));
                    f.setName(rs.getString("fname"));
                    current.setFulfillment(f);

                    Chanel ch = new Chanel();
                    ch.setId(rs.getInt("chanel_id"));
                    ch.setName(rs.getString("chname"));
                    current.setChanel(ch);

                    Carrier ca = new Carrier();
                    ca.setId(rs.getInt("carrier_id"));
                    ca.setName(rs.getString("caname"));
                    current.setCarrierId(ca);

                    current.setTimeCreate(rs.getDate("time_create"));
                    current.setIsCod(rs.getBoolean("is_cod"));
                    current.setDescription(rs.getString("description"));

                    Product pr = new Product();
                    pr.setId(rs.getInt("pid"));
                    pr.setName(rs.getString("product_name"));
                    pr.setType(rs.getString("type"));
                    pr.setPrice(rs.getFloat("price"));
                    pr.setQuantity(rs.getInt("quantity"));
                    current.getProducts().add(pr);

                    list.add(current);
                }
                if (oid == current.getId()) {
                    Product pr = new Product();
                    pr.setId(rs.getInt("pid"));
                    pr.setName(rs.getString("product_name"));
                    pr.setType(rs.getString("type"));
                    pr.setPrice(rs.getFloat("price"));
                    pr.setQuantity(rs.getInt("quantity"));
                    current.getProducts().add(pr);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Order get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Order model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Order model) {
        try {
            String sql = "UPDATE [dbo].[order_HE153274]\n"
                    + "   SET [payment] = ?\n"
                    + "      ,[Fulfillment] = ?\n"
                    + "      ,[description] = ?\n"
                    + " WHERE id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getPayment().getId());
            stm.setInt(2, model.getFulfillment().getId());
            stm.setString(3, model.getDescription());
            stm.setInt(4, model.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Order model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int count(int payment, int fulfillment, int cod, int chanel, String textSearch) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Order> listSearch(int payment, int fulfillment, int cod, int chanel, String textSearch) {
        ArrayList<Order> list = new ArrayList<>();
        try {
            String sql = "SELECT o.id as 'oid',\n"
                    + "IsNull(o.customer_id,-1) as 'customer_id',c.name as 'cname',\n"
                    + "o.payment, s1.setting_title as 'pname',\n"
                    + "o.Fulfillment,s2.setting_title as 'fname',\n"
                    + "o.chanel_id,ch.chanel_name as 'chname',\n"
                    + "o.carrier_id, ca.name as'caname',\n"
                    + "o.time_create,o.is_cod,o.description,\n"
                    + "p.id as 'pid',p.product_name,p.type,p.price,od.quantity\n"
                    + "from order_HE153274 o\n"
                    + "left join order_details_HE153274 od on o.id = od.oder_id\n"
                    + "left join customer_HE153274 c on o.customer_id = c.id\n"
                    + "left join setting_HE153274 s1 on o.payment = s1.id\n"
                    + "left join setting_HE153274 s2 on o.Fulfillment = s2.id\n"
                    + "left join channel_HE153274 ch on o.carrier_id = ch.id\n"
                    + "left join carrier_HE153274 ca on o.carrier_id = ca.id\n"
                    + "left join product_HE153274 p on od.product_id = p.id";
            int count = 0;
            HashMap<Integer, Object> param = new HashMap<>();
            if (payment != -1 || fulfillment != -1 || cod != -1
                    || chanel != -1 || textSearch.length() != 0) {
                sql += " where";

            }
            if (payment != -1) {
                sql += " o.payment = ?";
                count++;
                param.put(count, payment);
            }
            if (fulfillment != -1) {
                if (count > 0) {
                    sql += " and";
                }
                sql += " o.Fulfillment = ?";
                count++;
                param.put(count, fulfillment);
            }
            if (chanel != -1) {
                if (count > 0) {
                    sql += " and";
                }
                sql += " o.chanel_id = ?";
                count++;
                param.put(count, fulfillment);
            }

            if (cod != -1) {
                if (count > 0) {
                    sql += " and";
                }
                sql += " o.is_cod = ?";
                count++;
                param.put(count, cod);
            }

            if (textSearch.length() != 0) {
                if (count > 0) {
                    sql += " and";
                }
                sql += " (o.id like ? or c.name like ?)";
                textSearch = "%" + textSearch + "%";
                count++;
                param.put(count, textSearch);
                count++;
                param.put(count, textSearch);
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            for (Map.Entry<Integer, Object> entry : param.entrySet()) {
                Integer key = entry.getKey();
                Object val = entry.getValue();
                stm.setObject(key, val);
            }
            ResultSet rs = stm.executeQuery();
            Order current = new Order();
            current.setId(-1);
            while (rs.next()) {
                int oid = rs.getInt("oid");
                if (oid != current.getId()) {
                    current = new Order();
                    current.setId(oid);

                    Customer c = new Customer();
                    c.setId(rs.getInt("customer_id"));
                    c.setName(rs.getString("cname"));
                    current.setCustomer(c);

                    Payment p = new Payment();
                    p.setId(rs.getInt("payment"));
                    p.setName(rs.getString("pname"));
                    current.setPayment(p);

                    Fulfillment f = new Fulfillment();
                    f.setId(rs.getInt("Fulfillment"));
                    f.setName(rs.getString("fname"));
                    current.setFulfillment(f);

                    Chanel ch = new Chanel();
                    ch.setId(rs.getInt("chanel_id"));
                    ch.setName(rs.getString("chname"));
                    current.setChanel(ch);

                    Carrier ca = new Carrier();
                    ca.setId(rs.getInt("carrier_id"));
                    ca.setName(rs.getString("caname"));

                    current.setTimeCreate(rs.getDate("time_create"));
                    current.setIsCod(rs.getBoolean("is_cod"));
                    current.setDescription(rs.getString("description"));

                    Product pr = new Product();
                    pr.setId(rs.getInt("pid"));
                    pr.setName(rs.getString("product_name"));
                    pr.setType(rs.getString("type"));
                    pr.setPrice(rs.getFloat("price"));
                    pr.setQuantity(rs.getInt("quantity"));
                    current.getProducts().add(pr);

                    list.add(current);
                }
                if (oid == current.getId()) {
                    Product pr = new Product();
                    pr.setId(rs.getInt("pid"));
                    pr.setName(rs.getString("product_name"));
                    pr.setType(rs.getString("type"));
                    pr.setPrice(rs.getFloat("price"));
                    pr.setQuantity(rs.getInt("quantity"));
                    current.getProducts().add(pr);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void canelOrder(int oid) {
        try {
            String sql = "UPDATE [dbo].[order_HE153274]\n"
                    + "   SET \n"
                    + "      [payment] = ?,\n"
                    + "      [Fulfillment] = ?\n"
                    + " WHERE id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, 12);
            stm.setInt(2, 22);
            stm.setInt(3, oid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
