/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymmanagementsystem;

import java.sql.Date;


public class memberData {

    
    private String memberId;
    private String name;
    private String address;
    private Integer phoneNum;
    private String vip;
    private String schedule;
    private Date startDate;
    private Date endDate;
    private String status;
    private Double price;
    private int weight;
    private int height;
    private String dietPlanType;

    public memberData(String memberId, String name, String address,
             Integer phoneNum, String vip, String schedule, Date startDate,
             Date endDate, Double price, String status ,int weight, int height) {
        
        this.memberId = memberId;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.vip = vip;
        this.schedule = schedule;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.status = status;
        this.weight = weight;
        this.height = height;
        this.dietPlanType = calculateDietPlanType(weight, height);
        
    }
    
    private String calculateDietPlanType(int weight, int height) {
        if (weight < 50 && height < 160) {
            return "Type 1";
        } else if (weight >= 50 && weight <= 70 && height >= 160 && height <= 180) {
            return "Type 2";
        } else {
            return "Type 3";
        }
    }

    
    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public String getVip() {
        return vip;
    }

    public String getSchedule() {
        return schedule;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public String getDietPlanType() {
        return dietPlanType;
    }

    public void setDietPlanType(String dietPlanType) {
        this.dietPlanType = dietPlanType;
    }
}
