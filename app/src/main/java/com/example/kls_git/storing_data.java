package com.example.kls_git;

public class storing_data {
    String name,usn,email,phone_no,password;

    public storing_data() {
    }

    public storing_data(String name, String usn, String email, String phone_no, String password) {
        this.name = name;
        this.usn = usn;
        this.email = email;
        this.phone_no = phone_no;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
