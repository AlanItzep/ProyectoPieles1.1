/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Alan Itzep
 */
public class frminicio extends javax.swing.JFrame {

    /**
     * Creates new form frminicio
     */
    public frminicio() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Files/3dglasses_78346.png")));  
        this.setExtendedState(frminicio.MAXIMIZED_BOTH);
        this.setTitle("Sistema Administracion de venta de Pieles");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        lblacceso = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblidpersona = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblapellido = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuventas = new javax.swing.JMenu();
        mnuagregar = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        mnuconsultas = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        mnuconfiguraciones = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        mnuayuda = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DATOS DEL EMPLEADO");
        escritorio.add(jLabel1);
        jLabel1.setBounds(20, 20, 290, 50);

        lblacceso.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblacceso.setForeground(new java.awt.Color(255, 255, 153));
        lblacceso.setText("SSS");
        escritorio.add(lblacceso);
        lblacceso.setBounds(160, 180, 230, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 153));
        jLabel4.setText("NOMBRE:");
        escritorio.add(jLabel4);
        jLabel4.setBounds(60, 120, 90, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 153));
        jLabel5.setText("APELLIDO:");
        escritorio.add(jLabel5);
        jLabel5.setBounds(50, 150, 99, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 153));
        jLabel6.setText("ACCESO:");
        escritorio.add(jLabel6);
        jLabel6.setBounds(70, 180, 79, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 153));
        jLabel7.setText("ID:");
        escritorio.add(jLabel7);
        jLabel7.setBounds(120, 90, 30, 30);

        lblidpersona.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblidpersona.setForeground(new java.awt.Color(255, 255, 153));
        lblidpersona.setText("SSS");
        escritorio.add(lblidpersona);
        lblidpersona.setBounds(160, 90, 230, 30);

        lblnombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(255, 255, 153));
        lblnombre.setText("SSS");
        escritorio.add(lblnombre);
        lblnombre.setBounds(160, 120, 230, 30);

        lblapellido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblapellido.setForeground(new java.awt.Color(255, 255, 153));
        lblapellido.setText("SSS");
        escritorio.add(lblapellido);
        lblapellido.setBounds(160, 150, 230, 30);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/controller_78338.png"))); // NOI18N
        jMenu1.setText("Sistema pieles");
        jMenu1.setMaximumSize(new java.awt.Dimension(150, 32767));
        jMenu1.setPreferredSize(new java.awt.Dimension(150, 32));
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        menuBar.add(jMenu1);

        mnuventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/devices1_78351.png"))); // NOI18N
        mnuventas.setText("Venta");
        mnuventas.setPreferredSize(new java.awt.Dimension(119, 32));
        mnuventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuventasMouseClicked(evt);
            }
        });
        menuBar.add(mnuventas);

        mnuagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/folder_78343.png"))); // NOI18N
        mnuagregar.setText("Agregar");
        mnuagregar.setMaximumSize(new java.awt.Dimension(119, 32767));
        mnuagregar.setPreferredSize(new java.awt.Dimension(119, 32));

        jMenuItem1.setText("Productos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuagregar.add(jMenuItem1);

        jMenuItem4.setText("Clientes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mnuagregar.add(jMenuItem4);

        menuBar.add(mnuagregar);

        mnuconsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/printer_78349.png"))); // NOI18N
        mnuconsultas.setText("Consultas");
        mnuconsultas.setPreferredSize(new java.awt.Dimension(119, 32));

        jMenuItem6.setText("Abono");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mnuconsultas.add(jMenuItem6);

        jMenuItem2.setText("Inventario");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuconsultas.add(jMenuItem2);

        jMenuItem7.setText("Reportes");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        mnuconsultas.add(jMenuItem7);

        menuBar.add(mnuconsultas);

        mnuconfiguraciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/settings_78352.png"))); // NOI18N
        mnuconfiguraciones.setText("Configuraciones");
        mnuconfiguraciones.setPreferredSize(new java.awt.Dimension(145, 32));

        jMenuItem3.setText("Usuarios y accesos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuconfiguraciones.add(jMenuItem3);

        menuBar.add(mnuconfiguraciones);

        mnuayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/minimize_78340.png"))); // NOI18N
        mnuayuda.setText("Ayuda");
        mnuayuda.setPreferredSize(new java.awt.Dimension(119, 32));

        jMenuItem8.setText("Acerca de...");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        mnuayuda.add(jMenuItem8);

        menuBar.add(mnuayuda);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        frmproducto form = new frmproducto();        // TODO add your handling code here:
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
        try {   
            form.setSelected(true);   
            form.setMaximizable(true);   
            form.setMaximum(true);   
        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        frmcliente form = new frmcliente();   // TODO add your handling code here:
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
        try {   
            form.setSelected(true);   
            form.setMaximizable(true);   
            form.setMaximum(true);   
        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        frmempleado form = new frmempleado();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
        try {   
            form.setSelected(true);   
            form.setMaximizable(true);   
            form.setMaximum(true);   
        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        frmsaldoabono form = new frmsaldoabono();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
        try {   
            form.setSelected(true);   
            form.setMaximizable(true);   
            form.setMaximum(true);   
        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        frminventario form = new frminventario();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
        try {   
            form.setSelected(true);   
            form.setMaximizable(true);   
            form.setMaximum(true);   
        }catch(Exception e){}
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        frmreportes form = new frmreportes();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
        try {   
            form.setSelected(true);   
            form.setMaximizable(true);   
            form.setMaximum(true);   
        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem7ActionPerformed
 
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        Acercade form  = new Acercade();
        escritorio.add(form);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = form.getSize();
        form.setLocation((desktopSize.width - FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void mnuventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuventasMouseClicked
        // TODO add your handling code here:
        frmventa form = new frmventa();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
        try {   
            form.setSelected(true);   
            form.setMaximizable(true);   
            form.setMaximum(true);   
        }catch(Exception e){}

        frmventa.txtidempleado.setText(lblidpersona.getText());
        frmventa.txtnombreempleado.setText(lblnombre.getText() + " " + lblapellido.getText());
        frmventa.idusuario = Integer.parseInt(lblidpersona.getText());
    }//GEN-LAST:event_mnuventasMouseClicked

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
            java.util.logging.Logger.getLogger(frminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frminicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    public static javax.swing.JLabel lblacceso;
    public static javax.swing.JLabel lblapellido;
    public static javax.swing.JLabel lblidpersona;
    public static javax.swing.JLabel lblnombre;
    private javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenu mnuagregar;
    public static javax.swing.JMenu mnuayuda;
    public static javax.swing.JMenu mnuconfiguraciones;
    public static javax.swing.JMenu mnuconsultas;
    public static javax.swing.JMenu mnuventas;
    // End of variables declaration//GEN-END:variables

}
