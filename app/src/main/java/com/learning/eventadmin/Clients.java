package com.learning.eventadmin;

public class Clients {

    private String ClientID;
    private String ClientName;
    private String ClientCollege;
    private String ClientCollegeStudentID;
    private String ClientEmail;
    private String ClientPhoneNumber;

    public Clients() {
    }

    public Clients(String clientID, String clientName, String clientCollege, String clientCollegeStudentID, String clientEmail, String clientPhoneNumber) {
        ClientID = clientID;
        ClientName = clientName;
        ClientCollege = clientCollege;
        ClientCollegeStudentID = clientCollegeStudentID;
        ClientEmail = clientEmail;
        ClientPhoneNumber = clientPhoneNumber;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getClientCollege() {
        return ClientCollege;
    }

    public void setClientCollege(String clientCollege) {
        ClientCollege = clientCollege;
    }

    public String getClientCollegeStudentID() {
        return ClientCollegeStudentID;
    }

    public void setClientCollegeStudentID(String clientCollegeStudentID) {
        ClientCollegeStudentID = clientCollegeStudentID;
    }

    public String getClientEmail() {
        return ClientEmail;
    }

    public void setClientEmail(String clientEmail) {
        ClientEmail = clientEmail;
    }

    public String getClientPhoneNumber() {
        return ClientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        ClientPhoneNumber = clientPhoneNumber;
    }
}
