/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymmanagementsystem;


public class coachData {

   
    private String coachId;
    private String name;
    private String address;
    private String gender;
    private Integer phoneNum;
    private String status;

    public coachData(String coachId, String name, String address, String gender, Integer phoneNum, String status) {
       
        this.coachId = coachId;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.status = status;
    }

    

    public String getCoachId() {
        return coachId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public String getStatus() {
        return status;
    }

}
