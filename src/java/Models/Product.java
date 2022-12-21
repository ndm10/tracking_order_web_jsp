/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author dell
 */
public class Product {
    private int id;
    private String name;
    private Vendor vendor;
    private String type;
    private String description;
    private String imgLink;
    private float price;
    private int quantity;
    private boolean isShipping;
    private boolean status;

    public Product() {
    }

    public Product(int id, String name, Vendor vendor, String type, String description, String imgLink, float price, int quantity, boolean isShipping, boolean status) {
        this.id = id;
        this.name = name;
        this.vendor = vendor;
        this.type = type;
        this.description = description;
        this.imgLink = imgLink;
        this.price = price;
        this.quantity = quantity;
        this.isShipping = isShipping;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isIsShipping() {
        return isShipping;
    }

    public void setIsShipping(boolean isShipping) {
        this.isShipping = isShipping;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
