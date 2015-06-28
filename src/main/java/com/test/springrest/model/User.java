package com.test.springrest.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.test.springrest.shared.EncriptUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Bandula Gamage on 28/06/2015.
 */
public class User implements Serializable {
    private String userName;
    private String role;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private Date lastModified;
    private String pwdHash;   // Hashed representation of the Password

    @JsonSerialize(using=DateSerializer.class)
    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName1) {
        this.userName = userName1;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role1) {
        this.role = role1;
    }

    public void setPwdHash(String plainPwd) {
        this.pwdHash = EncriptUtils.toMD5String(plainPwd);
    }

    public String getPwdHash() {
        return pwdHash;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean authenticate(String plainPass) {
        if (this.pwdHash.equals(EncriptUtils.toMD5String(plainPass)))
            return true;
        else
            return false;
    }


}
