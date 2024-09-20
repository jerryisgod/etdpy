package com.etdpy.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class CarRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 自增ID

    private int year;  // 年份
    private String brand;  // 廠牌
    private String model;  // 車型
    private String engineCapacity;  // 排量
    private String fuelType;  // 燃料
    private String color;  // 顏色
    private String style;  // 樣式
    private String engineNumber;  // 引擎號碼
    private String licensePlate;  // 車牌號碼
    private String ownerName;  // 車主名稱
    private String ownerPhone;  // 車主電話
    private String ownerLandline;  // 車主市話
    private String backupPhone;  // 備用連絡電話
    private String ownerAddress;  // 車主地址
    private String companyName;  // 公司名稱
    private String companyTaxId;  // 統一編號
    private String notes;  // 其他備註

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerLandline() {
        return ownerLandline;
    }

    public void setOwnerLandline(String ownerLandline) {
        this.ownerLandline = ownerLandline;
    }

    public String getBackupPhone() {
        return backupPhone;
    }

    public void setBackupPhone(String backupPhone) {
        this.backupPhone = backupPhone;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyTaxId() {
        return companyTaxId;
    }

    public void setCompanyTaxId(String companyTaxId) {
        this.companyTaxId = companyTaxId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "CarRecord{" +
                "id=" + id +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineCapacity='" + engineCapacity + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", color='" + color + '\'' +
                ", style='" + style + '\'' +
                ", engineNumber='" + engineNumber + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerPhone='" + ownerPhone + '\'' +
                ", ownerLandline='" + ownerLandline + '\'' +
                ", backupPhone='" + backupPhone + '\'' +
                ", ownerAddress='" + ownerAddress + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyTaxId='" + companyTaxId + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
