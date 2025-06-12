package com.shoppingapp.app.service.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {

    @Id
    @Column()
    private String userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;


    public UserEntity() {
    }
    
    public UserEntity(String userId, String username, String password, String mailaddress) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = mailaddress;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMailaddress() {
        return email;
    }
}
