package com.laptrinhjavaweb.model;


public class User extends abstractnodel<User> {


    private Long roleId;
    private String userName;
    private String password;
    private String fullname;
    private int status;
    private Role role = new Role();


    public User() {
    }

    public User(Long roleId, String userName, String password, String fullname, int status) {
        this.roleId = roleId;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.fullname = fullname;
    }


    public Long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
