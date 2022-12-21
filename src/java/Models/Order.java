/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Order {

    private int id;
    private Customer customer;
    private ArrayList<Product> products = new ArrayList<>();
    private Payment payment;
    private Fulfillment fulfillment;
    private Chanel chanel;
    private Date timeCreate;
    private boolean isCod;
    private PaymentMethod paymentMethod;
    private float total;
    private Carrier carrierId;
    private String description;

    public Order() {
    }

    public Order(int id, Customer customer, ArrayList<Product> products, Payment payment,
            Fulfillment fulfillment, Chanel chanel, Date timeCreate, boolean isCod, PaymentMethod paymentMethod, float total, Carrier carrierId, String description) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.payment = payment;
        this.fulfillment = fulfillment;
        this.chanel = chanel;
        this.timeCreate = timeCreate;
        this.isCod = isCod;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.carrierId = carrierId;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Fulfillment getFulfillment() {
        return fulfillment;
    }

    public void setFulfillment(Fulfillment fulfillment) {
        this.fulfillment = fulfillment;
    }

    public Chanel getChanel() {
        return chanel;
    }

    public void setChanel(Chanel chanel) {
        this.chanel = chanel;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    public boolean isIsCod() {
        return isCod;
    }

    public void setIsCod(boolean isCod) {
        this.isCod = isCod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Carrier getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Carrier carrierId) {
        this.carrierId = carrierId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
