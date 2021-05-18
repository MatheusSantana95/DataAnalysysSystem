package com.matheussantana.dataanalysissystem.model;

public class ItemsSum {

    private int saleId;
    private String salesmanName;
    private Double itemsPriceSum;

    public ItemsSum(int saleId, String salesmanName, Double itemsPriceSum) {
        this.saleId = saleId;
        this.salesmanName = salesmanName;
        this.itemsPriceSum = itemsPriceSum;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public Double getItemsPriceSum() {
        return itemsPriceSum;
    }

    public void setItemsPriceSum(Double itemsPriceSum) {
        this.itemsPriceSum = itemsPriceSum;
    }
}
