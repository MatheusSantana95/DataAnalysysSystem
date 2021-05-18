# Data Analysy System

## About this guide:
This is a guide that will explain whats is the purpose of the project and how to use this application.


## Project:
This project is a data analysys system that is able to import lots of flat files ```.dat```, read and analyse all the informations and gives a output report. 

This project will analyse data in a specific directory that can be put in a variable ```String folderPath``` that is located in the following project path: ```src/main/java/com/matheussantana/controller/FileController.java```. In this variable, you can put a input default directory. For example: ```String folderParth = "%HOMEPATH%/data/in"```.

### The files contains salesman, customer and sales data in a specific format.

1. Salesman data:
- Contains the following format: ```001çCPFçNameçSalary```.
2. Customer data:
- Contains the following format: ```002çCNPJçNameçBusiness Area```.
1. Sales data:
- Contains the following format: ```003çSaleIDç[Item ID-Item Quantity-Item Price]çSalesman name```.


### This project returns a output file that contains a report about the files that were analyzed:

- Amount of clients in the input file;
- Amount of salesman in the input file;
- ID of the most expensive sale;
- Worst salesman ever.

To be able to access the report, you need to put a default output directory in a variable ```success1```, and ```String targetFile``` that is located in the following project path: ```src/main/java/com/matheussantana/controller/FileController.java```. You can put a output directory like this: ```boolean success1 = new File("%HOMEPATH%/data/out/summary.done.dat").createNewFile(); String targetFile = "%HOMEPATH%/data/out/summary.done.dat";```.


