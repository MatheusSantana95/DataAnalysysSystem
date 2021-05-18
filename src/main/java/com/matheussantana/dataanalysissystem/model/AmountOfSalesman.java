package com.matheussantana.dataanalysissystem.model;

public class AmountOfSalesman {

    private String salesmanName;
    private Long salesmanQuantity;
    private String filePath;

    public AmountOfSalesman(String salesmanName, Long salesmanQuantity, String filePath) {
        this.salesmanName = salesmanName;
        this.salesmanQuantity = salesmanQuantity;
        this.filePath = filePath;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public Long getSalesmanQuantity() {
        return salesmanQuantity;
    }

    public void setSalesmanQuantity(Long salesmanQuantity) {
        this.salesmanQuantity = salesmanQuantity;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
