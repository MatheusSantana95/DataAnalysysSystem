package com.matheussantana.dataanalysissystem.model;

public class AmountOfClients {

    private String customerName;
    private Long customerQuantity;
    private String filePath;

    public AmountOfClients(String customerName, Long customerQuantity, String filePath) {
        this.customerName = customerName;
        this.customerQuantity = customerQuantity;
        this.filePath = filePath;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCustomerQuantity() {
        return customerQuantity;
    }

    public void setCustomerQuantity(Long customerQuantity) {
        this.customerQuantity = customerQuantity;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
