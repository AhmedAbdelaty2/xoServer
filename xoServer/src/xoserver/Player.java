/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xoserver;

/**
 *
 * @author Ahmed
 */
public class Player {

    String username;
    int points;
    String status;
    String email;

    public Player(String name,int points,String status,String email){
        this.username = name;
        this.points = points;
        this.status = status;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public int getPoints() {
        return points;
    }

    public String getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
