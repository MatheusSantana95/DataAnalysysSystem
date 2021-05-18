package com.matheussantana.dataanalysissystem.controller;

import com.matheussantana.dataanalysissystem.model.*;
import com.matheussantana.dataanalysissystem.service.FileService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceController {

    private List<Salesman> salesmanlist = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();
    private List<Sale> saleList = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();
    private List<File> filesList = new ArrayList<>();
    private FileService fileService = new FileService();



    public void addSalesman(Salesman salesman) {
        salesmanlist.add(salesman);
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void addSale(Sale sale) {
        String[] items = sale.getItem().split(",");
        String[] items1 = items[0].split("-|\\[");
        String[] items2 = items[1].split("-|\\[|\\]");
        String[] items3 = items[2].split("-|\\[|\\]");
        Long itemId1 = Long.parseLong(items1[1]);
        Long itemId2 = Long.parseLong(items2[0]);
        Long itemId3 = Long.parseLong(items3[0]);
        Long itemQuantity1 = Long.parseLong(items1[2]);
        Long itemQuantity2 = Long.parseLong(items2[1]);
        Long itemQuantity3 = Long.parseLong(items3[1]);
        Double itemPrice1 = Double.parseDouble(items1[3]);
        Double itemPrice2 = Double.parseDouble(items2[2]);
        Double itemPrice3 = Double.parseDouble(items3[2]);
        addItems(new Item(itemId1, itemQuantity1, itemPrice1, sale.getSalesmanName(), sale.getSaleId(), sale.getFilePath()));
        addItems(new Item(itemId2, itemQuantity2, itemPrice2, sale.getSalesmanName(), sale.getSaleId(), sale.getFilePath()));
        addItems(new Item(itemId3, itemQuantity3, itemPrice3, sale.getSalesmanName(), sale.getSaleId(), sale.getFilePath()));
        addSaleToList(sale);
    }

    public void addItems(Item item){
        Optional<Item> optionalItem = itemList.stream().
                filter(item1 -> item.getCodItem()==item1.getCodItem()).findAny();
        boolean optionalItemIsPresent = optionalItem.isPresent();
        if (!optionalItemIsPresent)
            itemList.add(item);
    }

    public void addSaleToList(Sale sale){
        Optional<Sale> optionalSale = saleList.stream().
                filter(sale1 -> sale.getSaleId()==sale1.getSaleId()).findAny();
        boolean optionalSaleIsPresent = optionalSale.isPresent();
        if (!optionalSaleIsPresent)
            saleList.add(sale);
    }

    public void setFiles(File[] files) {
        for (File file : files ){
            filesList.add(file);
        }
    }

    public void setAmountOfClientsByFile() {
        for (File file : filesList) {
            for (Customer customer : customerList) {
                Long amountOfClients = customerList.stream().
                        filter(customer1 -> customer.getFilePath().equals(file.toString())).count();
                if (customer.getFilePath().equals(file.toString()))
                    fileService.addAmountOfClients(new AmountOfClients(customer.getCustomerName(), amountOfClients, customer.getFilePath()));
            }
        }
    }

    public void setAmountOfSalesmanByFile() {
        for (File file : filesList){
            for (Salesman salesman : salesmanlist){
                Long amountOfSalesman = salesmanlist.stream().
                filter(salesman1 -> salesman.getFilePath().equals(file.toString())).count();
                if (salesman.getFilePath().equals(file.toString()))
                    fileService.addAmountOfSalesman(new AmountOfSalesman(salesman.getSalesmanName(), amountOfSalesman, salesman.getFilePath()));
            }
        }
    }

    public void sumItems () {
        for (Sale sale : saleList) {
            Double itemsPriceBySaleId = itemList.stream().
                    filter(item -> item.getSaleId() == sale.getSaleId()).
                    mapToDouble(Item::getItemPrice).sum();
            fileService.addItemsSum(new ItemsSum(sale.getSaleId(), sale.getSalesmanName(), itemsPriceBySaleId));
        }
    }

    public List<AmountOfClients> getSummarizeDataClients(){
        return fileService.getAmountOfClientsList();
    }

    public Long getAmountOfClientsQuantity(){
        return fileService.getAmountOfClientsList().stream().count();
    }

    public List<AmountOfSalesman> getSummarizeDataSalesman(){
        return fileService.getAmountofSalesmanList();
    }

    public Long getAmountOfSalesmanQuantity(){
        return fileService.getAmountofSalesmanList().stream().count();
    }

    public List<ItemsSum> getMostExpensiveSale(){
        return fileService.getMostExpensiveSale();
    }

    public List<ItemsSum> getWorstSalesmanEver(){
        return fileService.getWorstSalesmanEver();
    }
}


