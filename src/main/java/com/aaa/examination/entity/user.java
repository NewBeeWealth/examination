package com.aaa.examination.entity;

/**
 * className:user
 * discriptoin:
 * author:llw
 * createTime:2018-12-11 20:47
 */
public class user {

    private int adminid;
    private String adminname;
    private String adminusername;
    private String adminpwd;

    public String getAdminstate() {
        return adminstate;
    }

    public void setAdminstate(String adminstate) {
        this.adminstate = adminstate;
    }

    private String adminstate;

    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminusername() {
        return adminusername;
    }

    public void setAdminusername(String adminusername) {
        this.adminusername = adminusername;
    }

    public String getAdminpwd() {
        return adminpwd;
    }

    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd;
    }
}
