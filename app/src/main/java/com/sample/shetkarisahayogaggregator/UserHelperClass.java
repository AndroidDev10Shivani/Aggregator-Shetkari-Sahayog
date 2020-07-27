package com.sample.shetkarisahayogaggregator;

public class UserHelperClass {
    String name, middleName, gender, dob, mobileNumber, address, country, state, district, city, pincode, businessType, demandingCrops, bankAccNumber, ifscCode;
    long applicationID;

    public UserHelperClass() {
    }

    public UserHelperClass(String name, String middleName, String gender, String dob, String mobileNumber, String address, String country, String state, String district, String city, String pincode, String businessType, String demandingCrops, String bankAccNumber, String ifscCode, long applicationID) {
        this.name = name;
        this.middleName = middleName;
        this.gender = gender;
        this.dob = dob;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.country = country;
        this.state = state;
        this.district = district;
        this.city = city;
        this.pincode = pincode;
        this.businessType = businessType;
        this.demandingCrops = demandingCrops;
        this.bankAccNumber = bankAccNumber;
        this.ifscCode = ifscCode;
        this.applicationID = applicationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getbusinessType() {
        return businessType;
    }

    public void setbusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getdemandingCrops() {
        return demandingCrops;
    }

    public void setdemandingCrops(String demandingCrops) {
        this.demandingCrops = demandingCrops;
    }

    public String getBankAccNumber() {
        return bankAccNumber;
    }

    public void setBankAccNumber(String bankAccNumber) {
        this.bankAccNumber = bankAccNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public long getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(long applicationID) {
        this.applicationID = applicationID;
    }
}
