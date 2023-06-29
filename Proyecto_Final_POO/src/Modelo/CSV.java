/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Alexandra
 */
public class CSV {

    private static final String path = "src\\backupFilesTienda\\";

    private List<String> readFile(String fileName) {
        List lineas = new ArrayList<>();
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
            String linea;
            while ((linea = csvReader.readLine()) != null) {
                lineas.add(linea);
            }

            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineas;
    }

    public void addRow(String fileName, Object newRowData) {
        File empleadosFile = new File(path+fileName);
        try {
            FileWriter writer = new FileWriter(path+fileName, true);
            if (!empleadosFile.exists()) {
                writer.write("\r\n");
            }
            writer.append(convertObjectToCsvRow(newRowData));
            writer.close();
            System.out.println("File created succesfully.");
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void modifyRow(String fileName, int idRow, Object modifiedData) {
        List<String> data = readFile(path+fileName);
        if (data != null && idRow >= 0 && idRow < data.size()) {
            data.set(idRow, convertObjectToCsvRow(modifiedData));
            try {
                FileWriter csvWriter = new FileWriter(path+fileName, false);

                for (int i = 0; i < data.size(); i++) {
                    csvWriter.write(data.get(i));
                    if(i< data.size()-1){
                        csvWriter.write(System.lineSeparator());
                    }
                }

                csvWriter.close();
                System.out.println("Row modified successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid file or row index.");
        }
    }

    public void deleteRow(String fileName,int idRow) {
        List<String> data = readFile(path+fileName);

        if (data != null && idRow > 0 && idRow <= data.size()) {
            data.remove(idRow - 1);

            try {
                FileWriter csvWriter = new FileWriter(path+fileName, false);

                for (String line : data) {
                    csvWriter.write(line);
                    csvWriter.write(System.lineSeparator());
                }

                csvWriter.close();
                System.out.println("Row deleted successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid file or row ID.");
        }
    }

    private String convertObjectToCsvRow(Object dataObject) {
        if (dataObject instanceof Administrador) {
            Administrador admin = (Administrador) dataObject;
            return admin.getIdAdministrador() + ","
                    + admin.getNombre() + ","
                    + admin.getApellidoPaterno() + ","
                    + admin.getApellidoMaterno() + ","
                    + admin.getUsuario() + ","
                    + admin.getContrasenia() + ","
                    + admin.getSueldo() + "\r";
        } else {
            return null;
        }
    }
}
