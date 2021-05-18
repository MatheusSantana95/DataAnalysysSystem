package com.matheussantana.dataanalysissystem.model;

public class Customer {

    private Long cnpj;
    private String customerName;
    private String businessArea;
    private String filePath;

    public Customer(Long cnpj, String customerName, String businessArea, String filePath) {
        this.cnpj = cnpj;
        this.customerName = customerName;
        this.businessArea = businessArea;
        this.filePath = filePath;
    }


    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
