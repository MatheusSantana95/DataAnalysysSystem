package com.matheussantana.dataanalysissystem.controller;

import com.matheussantana.dataanalysissystem.exceptions.FileReaderException;
import com.matheussantana.dataanalysissystem.exceptions.FileWritterException;
import com.matheussantana.dataanalysissystem.model.*;

import java.io.*;

public class FileController  {

    private ServiceController serviceController = new ServiceController();

    public boolean isDatExtension(File file) {
        String fileName = file.getName();
        int lastIndexOf = fileName.lastIndexOf(".");
        String fileExtension = fileName.substring(lastIndexOf);
        if (fileExtension.equalsIgnoreCase(".dat")) {
            return true;
        }
        return false;
    }

    public void FileController() throws IOException, FileReaderException, FileWritterException {
        String folderPath = "%HOMEPATH%/data/in";
        File path = new File(folderPath);
        File[] files = path.listFiles(File::isFile);
        serviceController.setFiles(files);

        boolean success1 = new File("%HOMEPATH%/data/out/summary.done.dat").createNewFile();
        String targetFile = "%HOMEPATH%/data/out/summary.done.dat";

        for (File file : files) {
           if (isDatExtension(file)) {
               try (BufferedReader br = new BufferedReader(new FileReader(file.toString()))) {
                   String itemDat = br.readLine();
                   while (itemDat != null) {
                       String[] fields = itemDat.split("ç");
                       int id = Integer.parseInt(fields[0]);
                       if (fields.length == 7) {
                           String[] field4 = fields[3].split(" ");
                           int id2 = Integer.parseInt(field4[1]);
                           if (id == 001 && id2 == 001) {
                               Long cpf = Long.parseLong(fields[1]);
                               String name = fields[2];
                               Double salary = Double.parseDouble(field4[0]);
                               serviceController.addSalesman(new Salesman(cpf, name, salary, file.toString()));
                               Long cpf2 = Long.parseLong(fields[4]);
                               String name2 = fields[5];
                               Double salary2 = Double.parseDouble(fields[6]);
                               serviceController.addSalesman(new Salesman(cpf2, name2, salary2, file.toString()));
                           }
                           if (id == 002 && id2 == 002) {
                               Long cnpj = Long.parseLong(fields[1]);
                               String name = fields[2];
                               String businessArea = field4[0];
                               serviceController.addCustomer(new Customer(cnpj, name, businessArea, file.toString()));
                               Long cnpj2 = Long.parseLong(fields[4]);
                               String name2 = fields[5];
                               String businessArea2 = fields[6];
                               serviceController.addCustomer(new Customer(cnpj2, name2, businessArea2, file.toString()));
                           }
                           if (id == 003 && id2 == 003) {
                               int saleId = Integer.parseInt(fields[1]);
                               String item = fields[2];
                               String salesmanName = field4[0];
                               serviceController.addSale(new Sale(saleId, item, salesmanName, file.toString()));
                               int saleId2 = Integer.parseInt(fields[4]);
                               String item2 = fields[5];
                               String salesmanName2 = fields[6];
                               serviceController.addSale(new Sale(saleId2, item2, salesmanName2, file.toString()));
                           }
                           itemDat = br.readLine();
                       } else {

                           if (id == 001) {
                               Long cpf = Long.parseLong(fields[1]);
                               String name = fields[2];
                               Double salary = Double.parseDouble(fields[3]);
                               serviceController.addSalesman(new Salesman(cpf, name, salary, file.toString()));
                           }
                           if (id == 002) {
                               Long cnpj = Long.parseLong(fields[1]);
                               String name = fields[2];
                               String businessArea = fields[3];
                               serviceController.addCustomer(new Customer(cnpj, name, businessArea, file.toString()));
                           }
                           if (id == 003) {
                               int saleId = Integer.parseInt(fields[1]);
                               String item = fields[2];
                               String salesmanName = fields[3];
                               serviceController.addSale(new Sale(saleId, item, salesmanName, file.toString()));
                           }
                           itemDat = br.readLine();
                       }
                   }
                   serviceController.setAmountOfSalesmanByFile();
                   serviceController.setAmountOfClientsByFile();
                   serviceController.sumItems();
               } catch (IOException e) {
                   throw new FileReaderException("Something wrong while trying to read the file!", e);
               }
           }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))) {
            bw.newLine();
            bw.write("------Summarize data------");
            bw.newLine();
            bw.newLine();
            bw.write("Summarize Salesman data: ");
            bw.newLine();
            for (AmountOfSalesman amountOfSalesman : serviceController.getSummarizeDataSalesman()) {
                bw.newLine();
                bw.write("Salesman name: "+amountOfSalesman.getSalesmanName()+ ", File path: "+amountOfSalesman.getFilePath());
                bw.newLine();
            }
            bw.newLine();
            bw.write("Salesman quantity: "+serviceController.getAmountOfSalesmanQuantity());
            bw.newLine();
            bw.newLine();
            bw.write("Summarize Clients data: ");
            bw.newLine();
            for (AmountOfClients amountOfClients : serviceController.getSummarizeDataClients()){
                bw.newLine();
                bw.write("Client name: "+amountOfClients.getCustomerName()+", File path: "+amountOfClients.getFilePath());
                bw.newLine();
            }
            bw.newLine();
            bw.write("Client quantity: " +serviceController.getAmountOfClientsQuantity());
            bw.newLine();
            bw.newLine();
            bw.write("Most expensive sale: SaleId = " + serviceController.getMostExpensiveSale().stream().findAny().get().getSaleId());
            bw.newLine();
            bw.write("Worst Salesman ever: "+ serviceController.getWorstSalesmanEver().stream().findAny().get().getSalesmanName());
            bw.newLine();
            System.out.println(targetFile + " created!");
        } catch (IOException e){
            throw new FileWritterException("Something wrong while trying to writte the file!", e);
        }
    }
}