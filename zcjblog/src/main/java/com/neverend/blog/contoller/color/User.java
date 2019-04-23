package com.neverend.blog.contoller.color;


import java.util.Date;

public class User {


    private String    id;
    private String              username;
    private String              email;
    private String              sex;
    private String              city;
    private String              sign;
    private String              experience;
    private String              ip;
    private String             logins;
    private Date joinTime;

    public User() {
    }
    public User(String id, String username, String email, String sex, String city, String sign, String experience, String ip, String logins, Date joinTime) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.sex = sex;
        this.city = city;
        this.sign = sign;
        this.experience = experience;
        this.ip = ip;
        this.logins = logins;
        this.joinTime = joinTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLogins() {
        return logins;
    }

    public void setLogins(String logins) {
        this.logins = logins;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", city='" + city + '\'' +
                ", sign='" + sign + '\'' +
                ", experience='" + experience + '\'' +
                ", ip='" + ip + '\'' +
                ", logins='" + logins + '\'' +
                ", joinTime=" + joinTime +
                '}';
    }
}
