package com.matheussantana.dataanalysissystem.service;

import com.matheussantana.dataanalysissystem.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class FileService {

    private List<ItemsSum> itemsSumsList = new ArrayList<>();
    private List<AmountOfClients> amountOfClientsList = new ArrayList<>();
    private List<AmountOfSalesman> amountOfSalesmanList = new ArrayList<>();

    public void addAmountOfClients(AmountOfClients amountOfClients){
        Optional<AmountOfClients> optionalAmountOfClients = amountOfClientsList.stream().
                filter(amountOfClients1 -> amountOfClients.getCustomerName().equals(amountOfClients1.getCustomerName())).findAny();
        boolean amountOfClientsIsPresent = optionalAmountOfClients.isPresent();
        if (!amountOfClientsIsPresent)
            amountOfClientsList.add(amountOfClients);
    }

    public List<AmountOfClients> getAmountOfClientsList(){
        return amountOfClientsList;
    }

    public void addAmountOfSalesman(AmountOfSalesman amountOfSalesman){
        Optional<AmountOfSalesman> optionalAmountOfSalesman = amountOfSalesmanList.stream().
                filter(amountOfSalesman1 -> amountOfSalesman.getSalesmanName().equals(amountOfSalesman1.getSalesmanName())).findAny();
        boolean amountOfSalesmanIsPresent = optionalAmountOfSalesman.isPresent();
        if (!amountOfSalesmanIsPresent)
            amountOfSalesmanList.add(amountOfSalesman);
    }

    public List<AmountOfSalesman> getAmountofSalesmanList(){
        return amountOfSalesmanList;
    }

    public void addItemsSum(ItemsSum itemsSum) {
        Optional<ItemsSum> optionalItemsSum = itemsSumsList.stream().
                filter(itemsSum1 -> itemsSum.getSaleId()==itemsSum1.getSaleId()).findAny();
        boolean optionalItemSumIsPresent = optionalItemsSum.isPresent();
        if (!optionalItemSumIsPresent)
            itemsSumsList.add(itemsSum);
    }

    public List<ItemsSum> getItemsSumsList() { return itemsSumsList;}

    public List<ItemsSum> getMostExpensiveSale() {
        return itemsSumsList.stream().sorted(Comparator.comparing(ItemsSum::getItemsPriceSum,
                (s1, s2) -> {return s2.compareTo(s1);})).collect(Collectors.toList());
    }


    public List<ItemsSum> getWorstSalesmanEver () {
        return itemsSumsList.stream().sorted(Comparator.comparing(ItemsSum::getItemsPriceSum,
                (s1, s2) -> {return s2.compareTo(s1);}).reversed()).collect(Collectors.toList());
    }
}
