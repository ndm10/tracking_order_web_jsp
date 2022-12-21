/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author dell
 */
public class Chanel {
    private int id;
    private String name;
    private boolean status;
    private String chanelLink;
    private String description;

    public Chanel() {
    }

    public Chanel(int id, String name, boolean status, String chanelLink, String description) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.chanelLink = chanelLink;
        this.description = description;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getChanelLink() {
        return chanelLink;
    }

    public void setChanelLink(String chanelLink) {
        this.chanelLink = chanelLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
