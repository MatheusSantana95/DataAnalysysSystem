package com.matheussantana.dataanalysissystem.model;

public class Salesman {

    private Long cpf;
    private String salesmanName;
    private Double salary;
    private String filePath;

    public Salesman(Long cpf, String salesmanName, Double salary, String filePath) {
        this.cpf = cpf;
        this.salesmanName = salesmanName;
        this.salary = salary;
        this.filePath = filePath;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
