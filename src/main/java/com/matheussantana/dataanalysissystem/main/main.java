package com.matheussantana.dataanalysissystem.main;

import com.matheussantana.dataanalysissystem.controller.FileController;
import com.matheussantana.dataanalysissystem.exceptions.FileReaderException;
import com.matheussantana.dataanalysissystem.exceptions.FileWritterException;
import com.matheussantana.dataanalysissystem.model.Customer;
import com.matheussantana.dataanalysissystem.model.Sale;
import com.matheussantana.dataanalysissystem.model.Salesman;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class main {

    public static void main(String[] args) throws IOException, FileWritterException, FileReaderException {
        FileController fileController = new FileController();
        fileController.FileController();
    }
}
