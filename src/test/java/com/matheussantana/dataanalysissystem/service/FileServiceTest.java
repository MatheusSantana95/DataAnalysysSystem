package com.matheussantana.dataanalysissystem.service;

import com.matheussantana.dataanalysissystem.model.AmountOfClients;
import com.matheussantana.dataanalysissystem.model.AmountOfSalesman;
import com.matheussantana.dataanalysissystem.model.ItemsSum;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {

    private FileService fileService = new FileService();

    @Test
    public void shouldAddAmountOfClients() {
        AmountOfClients amountOfClients1 = new AmountOfClients("Pedro", 2L, "homwpath/h");
        AmountOfClients amountOfClients2 = new AmountOfClients("Samuel", 3L, "homwpath/h");
        fileService.addAmountOfClients(amountOfClients1);
        fileService.addAmountOfClients(amountOfClients2);
        assertTrue(fileService.getAmountOfClientsList().contains(amountOfClients1));
        assertTrue(fileService.getAmountOfClientsList().contains(amountOfClients2));
    }

    @Test
    public void shouldAddAmountOfSalesman() {
        AmountOfSalesman amountOfSalesman1 = new AmountOfSalesman("Carina", 2L, "Home/in/out");
        AmountOfSalesman amountOfSalesman2 = new AmountOfSalesman("Luiza", 4L, "Home/in/out");
        fileService.addAmountOfSalesman(amountOfSalesman1);
        fileService.addAmountOfSalesman(amountOfSalesman2);
        assertTrue(fileService.getAmountofSalesmanList().contains(amountOfSalesman1));
        assertTrue(fileService.getAmountofSalesmanList().contains(amountOfSalesman2));
    }

    public void shouldAddItemsSums(){
        ItemsSum itemsSum1 = new ItemsSum(1, "Carina", 25.5);
        ItemsSum itemsSum2 = new ItemsSum(2, "Luiza", 29.5);
        fileService.addItemsSum(itemsSum1);
        fileService.addItemsSum(itemsSum2);
        assertTrue(fileService.getItemsSumsList().contains(itemsSum1));
        assertTrue(fileService.getItemsSumsList().contains(itemsSum2));
    }

    @Test
    public void shouldGetMostExpensiveSale(){
        ItemsSum itemsSum1 = new ItemsSum(1, "Carina", 25.5);
        ItemsSum itemsSum2 = new ItemsSum(2, "Luiza", 89.5);
        fileService.addItemsSum(itemsSum1);
        fileService.addItemsSum(itemsSum2);
        List<ItemsSum> expensiveSaleList = fileService.getMostExpensiveSale();
        assertTrue(expensiveSaleList.contains(itemsSum2));
    }

    @Test
    public void shouldGetWorstSalesmanEver(){
        ItemsSum itemsSum1 = new ItemsSum(1, "Almir", 25.5);
        ItemsSum itemsSum2 = new ItemsSum(2, "Lorenzo", 0.5);
        fileService.addItemsSum(itemsSum1);
        fileService.addItemsSum(itemsSum2);
        List<ItemsSum> worstSalesmanEverList = fileService.getWorstSalesmanEver();
        assertTrue(worstSalesmanEverList.contains(itemsSum2));
    }
}