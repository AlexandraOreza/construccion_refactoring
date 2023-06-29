/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.CSV;
import Modelo.MetodosProductos;
import Modelo.Productos;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexandra
 */
public class frmCatalogo extends javax.swing.JFrame {

     //Variables de instancia
    private String rutaArchivo = "Catalogo.txt";
    Productos productos;
    MetodosProductos metodosProductos;
   
    public void inicializarTablaProductos() {
        DefaultTableModel titulos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return false;
            }
        };
        titulos.addColumn("Clave Producto");
        titulos.addColumn("Nombre Producto");
        titulos.addColumn("Cantidad");
        titulos.addColumn("Descripción");
        titulos.addColumn("Precio");

        Object fila[] = new Object[titulos.getColumnCount()];
        for (int i = 0; i < metodosProductos.cantidadProductoRegistrados(); i++) {
            productos = metodosProductos.obtenerDatosProducto(i);
            fila[0] = productos.getClaveP();
            fila[1] = productos.getNombreProducto();
            fila[2] = productos.getCantidad();
            fila[3] = productos.getDescripcion();
            fila[4] = productos.getPrecio();
            titulos.addRow(fila);
        }
        tabla_consultaCatalogo.setModel(titulos);
        tabla_consultaCatalogo.setRowHeight(60);
    }
    
    
    //Métodos para leer los campos ingresados
    public int leerClaveTextField(){
        try {
            int claveP = Integer.parseInt(texto_Clave.getText().trim());
            return claveP;
        } catch (Exception exception) {
            return -666;
        }
    }
    
    public String leerNombreTextField(){
      try {
            String nombreProducto = texto_nombre.getText().trim().replace(" ", " ");
            return nombreProducto;
        } catch (Exception exception) {
            return null;
        }  
    }
    
    public int leerCantidadTextField(){
      try {
           int cantidad = Integer.parseInt(texto_cantidad.getText().trim());
            return cantidad;
        } catch (Exception exception) {
            return -666;
        }  
    }
    
    public String leerDescripcionTextField(){
      try {
            String descripcion = texto_descripcion.getText().trim().replace(" ", " ");
            return descripcion;
        } catch (Exception exception) {
            return null;
        }  
    }
    
    public double leerPrecioTextField(){
      try {
           double cantidad = Integer.parseInt(texto_precio.getText().trim());
            return cantidad;
        } catch (Exception exception) {
            return -666;
        }  
    }
    
    // Metodo para quitar el contenido de las celdas al guardar
    public void limpiarCeldas(JPanel jPanel) {
        for (int i = 0; jPanel.getComponents().length > i; i++) {
            if (jPanel.getComponents()[i] instanceof JTextField) {
                ((JTextField) jPanel.getComponents()[i]).setText("");
            } else if (jPanel.getComponents()[i] instanceof JPasswordField) {
                ((JPasswordField) jPanel.getComponents()[i]).setText("");
            }
        }
    }
    CSV csv = new CSV();
    String fileName = "Catalogo.csv";
    
    public void guardarProducto() {
        try {
            // que es -666
            //Cambiar el manejo de errores
            if (leerClaveTextField() == -666) {
                JOptionPane.showMessageDialog(null, "Ingrese una clave");
            } else if (leerNombreTextField().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese el nombre del producto");
            } else if (leerCantidadTextField()==-666) {
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad");
            } else if (leerDescripcionTextField().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese el apellido materno");
            } else if (leerPrecioTextField() == -666) {
                JOptionPane.showMessageDialog(null, "Ingrese el precio");
            } else {
                productos = new Productos(leerNombreTextField(),  leerCantidadTextField(), leerClaveTextField(),leerDescripcionTextField(), leerPrecioTextField() );
                if ((metodosProductos.compararExistenteID((int) productos.getClaveP())) != (-1)) {
                    JOptionPane.showMessageDialog(null, "Este ID ya ha sido asginado");
                } else {
                    metodosProductos.agregarDatosProducto(productos);
                    csv.agregarFilaDatos(fileName, productos);
                    //guardarContenidoTXT();
                    inicializarTablaProductos();
                    limpiarCeldas(panelRegistro);
                }

            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Error al guardar producto");
        }
    }
    
        public void modificarProducto() {
        try {
            // que es -666
            //Cambiar el manejo de errores
            if (leerClaveTextField() == -666) {
                JOptionPane.showMessageDialog(null, "Ingrese una clave");
            } else if (leerNombreTextField().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese el nombre del producto");
            } else if (leerCantidadTextField()==-666) {
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad");
            } else if (leerDescripcionTextField().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese el apellido materno");
            } else if (leerPrecioTextField() == -666) {
                JOptionPane.showMessageDialog(null, "Ingrese el precio");
            } else {
                productos = new Productos(leerNombreTextField(),  leerCantidadTextField(), leerClaveTextField(),leerDescripcionTextField(), leerPrecioTextField() );
                int claveP = metodosProductos.compararExistenteID((int) leerClaveTextField());
                if (claveP == -1) {
                    metodosProductos.agregarDatosProducto(productos);
                } else {
                    metodosProductos.modificarDatosProducto((int) claveP, productos);
                    csv.modificarFilaDatos(fileName,claveP, productos);
                }

            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Error al guardar producto");
        }
    }
    
    
    public void eliminarProducto() {
        try {
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar al administrador?", "Aviso", 0);
            if (confirmacion == 0) {
                metodosProductos.eliminarDatosProducto(productos);
                csv.eliminarFilaDatos(fileName, productos.getClaveP());
                //guardarContenidoTXT();
                inicializarTablaProductos();
                limpiarCeldas(panelRegistro);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Error al eliminar administrador");
        }
    }
    /**
     * Creates new form frmCatalogo
     */
    public frmCatalogo() {
        initComponents();
        setLocationRelativeTo(null);
        metodosProductos = new MetodosProductos();
        try {
            //verContenidoTXT();
            inicializarTablaProductos();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "El archivo de texto no existe");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_consultaCatalogo = new javax.swing.JTable();
        panelRegistro = new javax.swing.JPanel();
        label_apellidoP = new javax.swing.JLabel();
        label_sueldo = new javax.swing.JLabel();
        label_ID = new javax.swing.JLabel();
        texto_Clave = new javax.swing.JTextField();
        texto_nombre = new javax.swing.JTextField();
        texto_descripcion = new javax.swing.JTextField();
        texto_precio = new javax.swing.JTextField();
        label_nombre = new javax.swing.JLabel();
        label_titulo = new javax.swing.JLabel();
        label_nombre1 = new javax.swing.JLabel();
        texto_cantidad = new javax.swing.JTextField();
        btnRegresarAMenu = new javax.swing.JButton();
        boton_guardar = new javax.swing.JButton();
        boton_modificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boton_eliminar.setBackground(new java.awt.Color(224, 255, 255));
        boton_eliminar.setForeground(new java.awt.Color(1, 1, 1));
        boton_eliminar.setText("Eliminar");
        boton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminarActionPerformed(evt);
            }
        });

        tabla_consultaCatalogo.setBackground(new java.awt.Color(224, 255, 255));
        tabla_consultaCatalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_consultaCatalogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_consultaCatalogoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_consultaCatalogo);

        label_apellidoP.setText("Descripción");

        label_sueldo.setText("Precio");

        label_ID.setText("Clave Producto");

        texto_Clave.setBackground(new java.awt.Color(224, 255, 255));
        texto_Clave.setForeground(new java.awt.Color(1, 1, 1));
        texto_Clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_ClaveActionPerformed(evt);
            }
        });

        texto_nombre.setBackground(new java.awt.Color(224, 255, 255));
        texto_nombre.setForeground(new java.awt.Color(1, 1, 1));
        texto_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_nombreActionPerformed(evt);
            }
        });

        texto_descripcion.setBackground(new java.awt.Color(224, 255, 255));
        texto_descripcion.setForeground(new java.awt.Color(1, 1, 1));
        texto_descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_descripcionActionPerformed(evt);
            }
        });

        texto_precio.setBackground(new java.awt.Color(224, 255, 255));
        texto_precio.setForeground(new java.awt.Color(1, 1, 1));
        texto_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_precioActionPerformed(evt);
            }
        });

        label_nombre.setText("Nombre:");

        label_titulo.setFont(new java.awt.Font("Jamrul", 1, 18)); // NOI18N
        label_titulo.setText("Catalogo");

        label_nombre1.setText("Cantidad");

        texto_cantidad.setBackground(new java.awt.Color(224, 255, 255));
        texto_cantidad.setForeground(new java.awt.Color(1, 1, 1));
        texto_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_cantidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRegistroLayout = new javax.swing.GroupLayout(panelRegistro);
        panelRegistro.setLayout(panelRegistroLayout);
        panelRegistroLayout.setHorizontalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                        .addComponent(label_titulo)
                        .addGap(112, 112, 112))
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addComponent(label_nombre1)
                                .addGap(142, 142, 142)
                                .addComponent(texto_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(panelRegistroLayout.createSequentialGroup()
                                    .addComponent(label_sueldo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(texto_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRegistroLayout.createSequentialGroup()
                                    .addComponent(label_ID)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(texto_Clave, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelRegistroLayout.createSequentialGroup()
                                    .addComponent(label_nombre)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(texto_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRegistroLayout.createSequentialGroup()
                                    .addComponent(label_apellidoP)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(texto_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(206, Short.MAX_VALUE))))
        );
        panelRegistroLayout.setVerticalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_ID)
                            .addComponent(texto_Clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_nombre))
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(texto_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_nombre1)
                            .addComponent(texto_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(texto_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_apellidoP))))
                .addGap(25, 25, 25)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_sueldo)
                    .addComponent(texto_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        btnRegresarAMenu.setText("Regresar");
        btnRegresarAMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarAMenuActionPerformed(evt);
            }
        });

        boton_guardar.setBackground(new java.awt.Color(224, 255, 255));
        boton_guardar.setForeground(new java.awt.Color(1, 1, 1));
        boton_guardar.setText("Guardar");
        boton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardarActionPerformed(evt);
            }
        });

        boton_modificar.setBackground(new java.awt.Color(224, 255, 255));
        boton_modificar.setForeground(new java.awt.Color(1, 1, 1));
        boton_modificar.setText("Modificar");
        boton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_modificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnRegresarAMenu)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boton_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boton_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boton_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(boton_guardar)
                        .addGap(30, 30, 30)
                        .addComponent(boton_modificar)
                        .addGap(30, 30, 30)
                        .addComponent(boton_eliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegresarAMenu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_eliminarActionPerformed

    private void tabla_consultaCatalogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_consultaCatalogoMouseClicked
        // TODO add your handling code here:
        int mouseClick = tabla_consultaCatalogo.rowAtPoint(evt.getPoint());

        int idProducto = (int) tabla_consultaCatalogo.getValueAt(mouseClick, 0);
        String nombre = "" + tabla_consultaCatalogo.getValueAt(mouseClick, 1);
        String descripcion = "" + tabla_consultaCatalogo.getValueAt(mouseClick, 2);
        double precio = (double) tabla_consultaCatalogo.getValueAt(mouseClick, 3);

        texto_Clave.setText(String.valueOf(idProducto));
        texto_nombre.setText(nombre);
        texto_descripcion.setText(descripcion);
        texto_precio.setText(String.valueOf(precio));
    }//GEN-LAST:event_tabla_consultaCatalogoMouseClicked

    private void texto_ClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_ClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_ClaveActionPerformed

    private void btnRegresarAMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarAMenuActionPerformed
        // TODO add your handling code here:
        frmMenu menu = new frmMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarAMenuActionPerformed

    private void boton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardarActionPerformed
        // TODO add your handling code here:
        //this.guardarAdministrador();
    }//GEN-LAST:event_boton_guardarActionPerformed

    private void boton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_modificarActionPerformed
        // TODO add your handling code here:
        //this.modificarAdministrador();
    }//GEN-LAST:event_boton_modificarActionPerformed

    private void texto_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_nombreActionPerformed

    private void texto_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_cantidadActionPerformed

    private void texto_descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_descripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_descripcionActionPerformed

    private void texto_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_precioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCatalogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_eliminar;
    private javax.swing.JButton boton_guardar;
    private javax.swing.JButton boton_modificar;
    private javax.swing.JButton btnRegresarAMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_ID;
    private javax.swing.JLabel label_apellidoP;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_nombre1;
    private javax.swing.JLabel label_sueldo;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JTable tabla_consultaCatalogo;
    private javax.swing.JTextField texto_Clave;
    private javax.swing.JTextField texto_cantidad;
    private javax.swing.JTextField texto_descripcion;
    private javax.swing.JTextField texto_nombre;
    private javax.swing.JTextField texto_precio;
    // End of variables declaration//GEN-END:variables
}
