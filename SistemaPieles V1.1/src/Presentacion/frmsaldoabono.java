/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vabono;
import Logica.conexion;
import Logica.fabono;
import Logica.fcliente;
import Logica.fventa;
import static Presentacion.frmreportes.idcliente;
import static Presentacion.frmreportes.txtidcliente;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Alan Itzep
 */
public class frmsaldoabono extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmcuenta
     */
    public frmsaldoabono() {
        initComponents();
        mostrar("");
        this.setTitle("Abonos");
        inhabilitar();
    }

    private String accion = "guardar";
    public static String idcliente = "";
    private Connection connection = new conexion().conectar();
    
    void ocultar_columnas() {
        tablalistadoventa.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistadoventa.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistadoventa.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tablalistadoventa.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistadoventa.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistadoventa.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        tablalistadoventa.getColumnModel().getColumn(3).setMaxWidth(0);
        tablalistadoventa.getColumnModel().getColumn(3).setMinWidth(0);
        tablalistadoventa.getColumnModel().getColumn(3).setPreferredWidth(0);
        
        tablalistadoventa.getColumnModel().getColumn(4).setMaxWidth(0);
        tablalistadoventa.getColumnModel().getColumn(4).setMinWidth(0);
        tablalistadoventa.getColumnModel().getColumn(4).setPreferredWidth(0);
        
        tablalistadoventa.getColumnModel().getColumn(5).setMaxWidth(0);
        tablalistadoventa.getColumnModel().getColumn(5).setMinWidth(0);
        tablalistadoventa.getColumnModel().getColumn(5).setPreferredWidth(0);
        
        tablalistadoventa.getColumnModel().getColumn(8).setMaxWidth(0);
        tablalistadoventa.getColumnModel().getColumn(8).setMinWidth(0);
        tablalistadoventa.getColumnModel().getColumn(8).setPreferredWidth(0);
        
        
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(0);
        
    }
    
    void inhabilitar(){
        txtidcliente.setVisible(false);
        btnfiltrar.setEnabled(false);
        
        txtidabono.setVisible(false);
        txtdescripcion.setEnabled(false);
        txttotalmedida.setEnabled(false);
        txttotalventa.setEnabled(false); 
        txtabono.setEnabled(false);
        dcfechaabono.setEnabled(false); 
        txtsaldo.setEnabled(false);
        
        btnnuevo.setEnabled(false);
        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        
        btneliminar.setEnabled(false);
        
        txtidcliente.setText("");
        txtnombrecliente.setText("");
        
        txtidabono.setText("");
        txtdescripcion.setText("");
        txttotalmedida.setText("");
        txttotalventa.setText("");
        txtabono.setText("");
        txtsaldo.setText("");
    }
    
    void habilitar(){
        txtidabono.setVisible(false);
        txtdescripcion.setEnabled(false);
        txttotalmedida.setEnabled(false);
        txttotalventa.setEnabled(false); 
        txtabono.setEnabled(false);
        dcfechaabono.setEnabled(false); 
        txtsaldo.setEnabled(false);
        
        btnnuevo.setEnabled(true);
        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        
        btneliminar.setEnabled(false);
        
        txtidabono.setText("");
        txtdescripcion.setText("");
        txtabono.setText("");
    }
    
    void habilitarabono(){
        txtidabono.setVisible(false);
        txtdescripcion.setEnabled(true);
        txttotalmedida.setEnabled(false);
        txttotalventa.setEnabled(false); 
        txtabono.setEnabled(true);
        dcfechaabono.setEnabled(true); 
        txtsaldo.setEnabled(false);
        
        btnnuevo.setEnabled(true);
        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        
        btneliminar.setEnabled(false);
        
        txtidabono.setText("");
        txtdescripcion.setText("");
        txtabono.setText("");
    }
    
    void inhabilitarabono(){
        txtidabono.setVisible(false);
        txtdescripcion.setEnabled(false);
        txttotalmedida.setEnabled(false);
        txttotalventa.setEnabled(false); 
        txtabono.setEnabled(false);
        dcfechaabono.setEnabled(false); 
        txtsaldo.setEnabled(false);
        
        btnnuevo.setEnabled(true);
        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        
        btneliminar.setEnabled(false);
        
        txtidabono.setText("");
        txtdescripcion.setText("");
        txtabono.setText("");
    }
    void mostrar(String buscar){
        try{
            
            DefaultTableModel modelo;
            fventa func = new fventa();
            modelo = func.mostrarinabono(buscar);
            
            tablalistadoventa.setModel(modelo);
            
            lbltotalregistrosinventa.setText("Total registros: "+Integer.toString(func.totalregistros));
            lbltotalventainventa.setText("Total venta : "+ Double.toString(func.totalventa));
            lbltotalmedidainventa.setText("Total Medida : " + Double.toString(func.totalmedida));
            
            txttotalmedida.setText(Double.toString(func.totalmedida));
            txttotalventa.setText(Double.toString(func.totalventa));
            
            fabono func2 = new fabono();
            modelo = func2.mostrar(buscar);
            tablalistado.setModel(modelo);
            
            lbltotalregistros.setText("No. Abonos realizados : "+Integer.toString(func2.totalregistros));
            lbltotalabonos.setText("Total abonos : "+Double.toString(func2.totalabonos));
            
            Double resultado;
            resultado = func.totalventa-func2.totalabonos;
            txtsaldo.setText(resultado.toString());
            
            ocultar_columnas();
            /**
            fcliente func3 = new fcliente();
            func3.cargarclientes();
            func3.cargaridclientes(buscar);**/
        }catch(Exception e){
            JOptionPane.showConfirmDialog(rootPane,e);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txttotalmedida = new javax.swing.JTextField();
        txttotalventa = new javax.swing.JTextField();
        txtabono = new javax.swing.JTextField();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txtsaldo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dcfechaabono = new com.toedter.calendar.JDateChooser();
        txtidabono = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        lbltotalabonos = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablalistadoventa = new javax.swing.JTable();
        txtnombrecliente = new javax.swing.JTextField();
        txtidcliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnbuscarcliente = new javax.swing.JButton();
        btnfiltrar = new javax.swing.JButton();
        lbltotalregistrosinventa = new javax.swing.JLabel();
        lbltotalmedidainventa = new javax.swing.JLabel();
        lbltotalventainventa = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(127, 140, 141));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(44, 62, 80));
        jLabel1.setText("Abono");

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de abono", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 15), new java.awt.Color(236, 240, 241))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(236, 240, 241));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Total medida");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(236, 240, 241));
        jLabel3.setText("Descripcion");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 240, 241));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Total venta");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 240, 241));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Abono");

        txttotalmedida.setText("0.00");
        txttotalmedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalmedidaActionPerformed(evt);
            }
        });

        txttotalventa.setText("0.00");
        txttotalventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalventaActionPerformed(evt);
            }
        });

        txtabono.setText("0.00");
        txtabono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtabonoActionPerformed(evt);
            }
        });
        txtabono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtabonoKeyReleased(evt);
            }
        });

        btnnuevo.setBackground(new java.awt.Color(52, 73, 94));
        btnnuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/New1.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(52, 73, 94));
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/save1.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(52, 73, 94));
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/cancel1.png"))); // NOI18N
        btncancelar.setText("Cancelar");

        txtdescripcion.setColumns(20);
        txtdescripcion.setRows(5);
        jScrollPane1.setViewportView(txtdescripcion);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 240, 241));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Fecha abono");

        txtsaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsaldoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 240, 241));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Saldo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsaldo)
                            .addComponent(txttotalmedida)
                            .addComponent(txtabono)
                            .addComponent(txttotalventa)
                            .addComponent(dcfechaabono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidabono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(btnnuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnguardar)
                        .addGap(18, 18, 18)
                        .addComponent(btncancelar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidabono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txttotalmedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttotalventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtabono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(dcfechaabono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevo)
                    .addComponent(btncancelar)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(52, 73, 94));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de abonos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 15), new java.awt.Color(236, 240, 241))); // NOI18N

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablalistado);

        btneliminar.setBackground(new java.awt.Color(52, 73, 94));
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/delete1.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnsalir.setBackground(new java.awt.Color(52, 73, 94));
        btnsalir.setForeground(new java.awt.Color(255, 255, 255));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/close1.png"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(236, 240, 241));
        lbltotalregistros.setText("jLabel7");

        lbltotalabonos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbltotalabonos.setForeground(new java.awt.Color(236, 240, 241));
        lbltotalabonos.setText("jLabel7");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btneliminar)
                .addGap(42, 42, 42)
                .addComponent(btnsalir)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbltotalabonos)
                .addGap(18, 18, 18)
                .addComponent(lbltotalregistros))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsalir)
                    .addComponent(btneliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltotalregistros)
                    .addComponent(lbltotalabonos))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(52, 73, 94));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 15), new java.awt.Color(236, 240, 241))); // NOI18N

        tablalistadoventa.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistadoventa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoventaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablalistadoventa);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 240, 241));
        jLabel8.setText("Cliente");

        btnbuscarcliente.setBackground(new java.awt.Color(255, 255, 255));
        btnbuscarcliente.setForeground(new java.awt.Color(52, 73, 94));
        btnbuscarcliente.setText("...");
        btnbuscarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarclienteActionPerformed(evt);
            }
        });

        btnfiltrar.setBackground(new java.awt.Color(52, 73, 94));
        btnfiltrar.setForeground(new java.awt.Color(255, 255, 255));
        btnfiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/loupe_78347.png"))); // NOI18N
        btnfiltrar.setText("Filtrar");
        btnfiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfiltrarActionPerformed(evt);
            }
        });

        lbltotalregistrosinventa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbltotalregistrosinventa.setForeground(new java.awt.Color(236, 240, 241));
        lbltotalregistrosinventa.setText("jLabel10");

        lbltotalmedidainventa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbltotalmedidainventa.setForeground(new java.awt.Color(236, 240, 241));
        lbltotalmedidainventa.setText("jLabel10");

        lbltotalventainventa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbltotalventainventa.setForeground(new java.awt.Color(236, 240, 241));
        lbltotalventainventa.setText("jLabel10");

        jButton1.setText("Estado de cuenta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Detalle de ventas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbltotalregistrosinventa)
                        .addGap(18, 18, 18)
                        .addComponent(lbltotalmedidainventa)
                        .addGap(18, 18, 18)
                        .addComponent(lbltotalventainventa))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(txtnombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnfiltrar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscarcliente)
                    .addComponent(btnfiltrar)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltotalregistrosinventa)
                    .addComponent(lbltotalmedidainventa)
                    .addComponent(lbltotalventainventa)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttotalmedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalmedidaActionPerformed
        // TODO add your handling code here:
        txttotalmedida.transferFocus();
    }//GEN-LAST:event_txttotalmedidaActionPerformed

    private void txttotalventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalventaActionPerformed
        // TODO add your handling code here:
        txttotalventa.transferFocus();
    }//GEN-LAST:event_txttotalventaActionPerformed

    private void txtabonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtabonoActionPerformed
        // TODO add your handling code here:
        txtabono.transferFocus();
    }//GEN-LAST:event_txtabonoActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
        
        habilitarabono();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        //validadion de ingreso de datos
        if(txtnombrecliente.getText().length() == 0){
            JOptionPane.showConfirmDialog(rootPane, "Debes Ingresar un cliente");
            txtnombrecliente.requestFocus();
            return;
        }
        

        if(txtdescripcion.getText().length() == 0){
            JOptionPane.showConfirmDialog(rootPane, "Debes Ingresar una descripcion para el abono");
            txtdescripcion.requestFocus();
            return;
        }

        if(txtabono.getText().length() == 0){
            JOptionPane.showConfirmDialog(rootPane, "Debes Ingresar un abono");
            txtabono.requestFocus();
            return;
        }
        vabono dts = new vabono();
        fabono func = new fabono();

        dts.setIdcliente(Integer.parseInt(txtidcliente.getText()));
        dts.setDescripcion(txtdescripcion.getText());
        
        Calendar cal;
        int d,m,a;
        cal = dcfechaabono.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR)-1900;
        dts.setFechaabono(new Date(a,m,d));
        
        dts.setAbono(Double.parseDouble(txtabono.getText()));
        
        if(accion.equals ("guardar")){
            
            if(func.insertar(dts)){
                    JOptionPane.showMessageDialog(rootPane, "El ingreso del producto fue realizado satisfactoriamente");
                    mostrar(idcliente);
                    inhabilitarabono();
                }                
            }
        else if(accion.equals("editar")){
            dts.setIdabono(Integer.parseInt(txtidabono.getText()));

            if(func.editar(dts)){
                JOptionPane.showMessageDialog(rootPane,"La edicion del producto fue realizado satisfactoriamente");
                mostrar(idcliente);
                inhabilitarabono();
            }
        }

    }//GEN-LAST:event_btnguardarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("Editar");
        habilitarabono();
        btneliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());
        txtidabono.setText(tablalistado.getValueAt(fila, 0).toString());
        txtdescripcion.setText(tablalistado.getValueAt(fila, 2).toString());
        dcfechaabono.setDate(Date.valueOf(tablalistado.getValueAt(fila,3).toString()));
        txtabono.setText(tablalistado.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if(!txtidabono.getText().equals("")){
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de elimiar este abono?","Confirmar",2);
            if(confirmacion == 0){
                fabono func = new fabono();
                vabono dts = new vabono();

                dts.setIdabono(Integer.parseInt(txtidabono.getText()));
                func.eliminar(dts);
                mostrar(idcliente);
                inhabilitarabono();
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnbuscarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarclienteActionPerformed
        // TODO add your handling code here:
        frmvistaventa form = new frmvistaventa();
        form.toFront();
        form.setVisible(true);
        
        btnfiltrar.setEnabled(true);
    }//GEN-LAST:event_btnbuscarclienteActionPerformed

    private void txtsaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsaldoActionPerformed

    private void txtabonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtabonoKeyReleased
        // TODO add your handling code here:
        /*Double resultado;
        resultado = Double.parseDouble(txttotalventa.getText())-Double.parseDouble(txtabono.getText());
        txtsaldo.setText(resultado.toString());*/
    }//GEN-LAST:event_txtabonoKeyReleased

    private void tablalistadoventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoventaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistadoventaMouseClicked

    private void btnfiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfiltrarActionPerformed
        // TODO add your handling code here:
        idcliente = txtidcliente.getText();
        //int seleccionado = cbocliente.getSelectedIndex();
        //mostrar(cbocliente.getItemAt(seleccionado));
        mostrar(idcliente);
        habilitar();
    }//GEN-LAST:event_btnfiltrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Map p = new HashMap();
        p.put("idcliente", txtidcliente.getText());
            JasperReport report;
            JasperPrint print;

            try {
                report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                        + "/src/Reportes/VentasAbonos.jrxml");
                print = JasperFillManager.fillReport(report, p, connection);

                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Reporte de ventas y abonos");
                view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Map p = new HashMap();
        p.put("idcliente", txtidcliente.getText());
            JasperReport report;
            JasperPrint print;

            try {
                report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                        + "/src/Reportes/ventasdetalladas.jrxml");
                print = JasperFillManager.fillReport(report, p, connection);

                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Reporte de ventas detalladas");
                view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(frmsaldoabono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmsaldoabono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmsaldoabono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmsaldoabono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmsaldoabono().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscarcliente;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnfiltrar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private com.toedter.calendar.JDateChooser dcfechaabono;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbltotalabonos;
    private javax.swing.JLabel lbltotalmedidainventa;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JLabel lbltotalregistrosinventa;
    private javax.swing.JLabel lbltotalventainventa;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTable tablalistadoventa;
    private javax.swing.JTextField txtabono;
    private javax.swing.JTextArea txtdescripcion;
    private javax.swing.JTextField txtidabono;
    public static javax.swing.JTextField txtidcliente;
    public static javax.swing.JTextField txtnombrecliente;
    private javax.swing.JTextField txtsaldo;
    public static javax.swing.JTextField txttotalmedida;
    public static javax.swing.JTextField txttotalventa;
    // End of variables declaration//GEN-END:variables
}
