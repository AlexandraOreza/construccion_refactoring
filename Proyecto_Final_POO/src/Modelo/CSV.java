/*
 * CSV
 * 
 * Version 0.9
 *
 * 29/Jun/23
 *
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
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

    private static final String RUTA_CARPETA = "src\\backupFilesTienda\\";
    
    public List<String> obtenerDatosArchivo(String nombreArchivoLectura) {
        List lineas = new ArrayList<>();
        try {
            BufferedReader csvLector = new BufferedReader(new FileReader(RUTA_CARPETA
                    +nombreArchivoLectura));
            String linea;
            while ((linea = csvLector.readLine()) != null) {
                lineas.add(linea);
            }

            csvLector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineas;
    }

    public void agregarFilaDatos(String nombreArchivo, Object datosNuevaFila) {
        File archivoDatos = new File(RUTA_CARPETA+nombreArchivo);
        try {
            FileWriter escritor = new FileWriter(RUTA_CARPETA+nombreArchivo, true);
            if (!archivoDatos.exists()) {
                escritor.write("\r\n");
            }
            escritor.append(convertirObjetoAFilaCsv(datosNuevaFila));
            escritor.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error.");
            e.printStackTrace();
        }
    }

    public void modificarFilaDatos(String fileName, int idFila, Object datosModificados) {
        List<String> data = obtenerDatosArchivo(fileName);
        if (data != null && idFila >= 0 && idFila <= data.size()) {
            int filaModificar = idFila -1;
            data.set(filaModificar, convertirObjetoAFilaCsv(datosModificados));
            
            try {
                FileWriter csvEscritor = new FileWriter(RUTA_CARPETA+fileName, false);

                for (int i = 0; i < data.size(); i++) {
                    csvEscritor.write(data.get(i));
                    if(i< data.size()-1){
                        csvEscritor.write(System.lineSeparator());
                    }
                }

                csvEscritor.close();
                System.out.println("Datos de fila modificados exitosamente.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Fila invalida o indice invalido.");
        }
    }
    
    private String convertirObjetoAFilaCsv(Object dataObject) {
        if (dataObject instanceof Administrador) {
            Administrador admin = (Administrador) dataObject;
            return admin.getIdAdministrador() + ","
                    + admin.getNombre() + ","
                    + admin.getApellidoPaterno() + ","
                    + admin.getApellidoMaterno() + ","
                    + admin.getUsuario() + ","
                    + admin.getContrasenia() + ","
                    + admin.getSueldo() + "\r\n";
        } else {
            return null;
        }
    }

    public void eliminarFilaDatos(String nombreArchivo,int idFila) {
        List<String> data = obtenerDatosArchivo(nombreArchivo);

        if (data != null && idFila > 0 && idFila <= data.size()) {
            data.remove(idFila - 1);
            try {
                FileWriter csvEscritor = new FileWriter(RUTA_CARPETA+nombreArchivo, false);

                for (String line : data) {
                    csvEscritor.write(line);
                    csvEscritor.write(System.lineSeparator());
                }

                csvEscritor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Fila invalida o id inválido.");
        }
    }
    
    public boolean existeId(String fileName, int id) {
        List<String> data = obtenerDatosArchivo(fileName);
        
        if (data != null) {
            for (String linea : data) {
                String[] valores = linea.split(",");
                if (valores.length > 0 && Integer.parseInt(valores[0]) == id) {
                    return true;
                }
            }
        }
        return false;
    }
}
