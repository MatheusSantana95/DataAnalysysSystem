package com.matheussantana.dataanalysissystem.model;

public class Item {

    private static int counter=1;
    private int codItem;
    private Long itemId;
    private Long itemQuantity;
    private Double itemPrice;
    private String salesmanName;
    private int saleId;
    private String filePath;

    public Item(Long itemId, Long itemQuantity, Double itemPrice, String salesmanName, int saleId, String filePath) {
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.salesmanName = salesmanName;
        this.saleId = saleId;
        this.codItem = counter;
        this.filePath = filePath;
        counter++;
    }

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Long itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getSale() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
