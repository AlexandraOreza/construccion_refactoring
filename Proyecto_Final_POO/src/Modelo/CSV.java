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

    public String[] readFile(String fileName) {
        String row;
        String[] data = null;
        try {

            BufferedReader csvReader = new BufferedReader(new FileReader(path+fileName + ".csv"));
            while ((row = csvReader.readLine()) != null) {
                data = row.split(",");
            }

            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public void addEmpleado(Administrador admin) {
//        Encriptador en = new Encriptador();
//        en.encriptar(password);
        String empleadosPath = path+"Administradores.csv";
        File empleadosFile = new File(empleadosPath);

        try {
            FileWriter writer = new FileWriter(empleadosPath, true);
            if (!empleadosFile.exists()) {
                writer.write("""
                             Nombre,ApellidoP,ApellidoM,NombreUsuario,Contrase\u00f1a,Sueldo,Id,\r
                             """);
            }
//            writer.append(user + "," + en.getEncryptedpassword() + "\r\n");
            writer.append(admin.getNombre()+","+admin.getApellidoPaterno()+","+admin.getApellidoMaterno()
                    +","+admin.getUsuario()+","+admin.getContrasenia()+","+admin.getSueldo()+","
                    +admin.getIdAdministrador()+"\r\n");
            writer.close();
            System.out.println("File created succesfully.");
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
