package pk_formularios;

import javax.swing.JOptionPane;
import pk_conexion.conexion;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import pk_clases.Arreglos;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Eliminar_Admin extends javax.swing.JFrame {

    CallableStatement cst;
    Connection cn;
    Statement stm;
    ResultSet rs;
    Arreglos arre = new Arreglos();
    String puerto="1433" , pass="12345678";
    
    public Eliminar_Admin() {
        initComponents();
        listar();
        Llenar();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ELIMINAR PRODUCTO");
        setMinimumSize(new java.awt.Dimension(447, 330));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BUSCAR CODIGO POR NOMBRE  ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(12, 12, 300, 22);

        tblLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tblLista);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(12, 40, 401, 126);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INGRESAR CODIGO A ELIMINAR");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 190, 260, 17);
        getContentPane().add(txtCodigo);
        txtCodigo.setBounds(260, 180, 130, 40);

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk_imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(250, 230, 150, 50);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk_imagenes/descarga.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 240, 70, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk_imagenes/RTA1uwq4B9PmpB0_ukWe5zl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 440, 290);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String codigo;
        
        codigo = this.txtCodigo.getText();
        eliminarArreglo(codigo);

        Administrador entrar = new Administrador();
        entrar.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        close();
        JOptionPane.showMessageDialog(null, "Hasta Luego");
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private Vector listar() {
         Connection con=null;
         Statement stm=null;
         Vector reg=null;
         try{
         con = conexion.getConexion();
         stm=con.createStatement();
         ResultSet rs = stm.executeQuery("SELECT * FROM PRODUCTO "
                 + "ORDER BY ID_PRODUCT;");
         reg = new Vector();

             while(rs.next()){
             Vector item = new Vector();
             item.add(rs.getString("ID_PRODUCTO"));
             item.add(rs.getString("NIMBRE_PRODUCTO"));
             reg.add(item);
             }
         }
         catch(Exception e){
         System.out.print(e);
         }
         return reg;
    }

    private void Llenar() {
        Vector colu = new Vector();
        colu.addElement("Codigo");
        colu.addElement("Nombre");       
        Vector reg = new Vector();
        reg = listar();
        DefaultTableModel dtm = new DefaultTableModel(reg, colu);
        this.tblLista.setModel(dtm);
        
    }
    
        private void close(){
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea Volver al Inicio?",
                "Cerrar Ventana", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
          Login c = new Login();
          c.setVisible(true);
          dispose();
        }          
    } 
        
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
            java.util.logging.Logger.getLogger(Eliminar_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eliminar_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eliminar_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eliminar_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eliminar_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLista;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables

    private void eliminarArreglo(String codigo) {
        try {
            cst = DriverManager.getConnection("jdbc:sqlserver://localhost:"+puerto+";"
            + "database=MADEM;user=sa;password="+pass+";").prepareCall("{call sp_Eliminar(?)}");      
            
            cst.setString("Cod", codigo);
                        
            int rpta = cst.executeUpdate();
            if (rpta == 1) {
                JOptionPane.showMessageDialog(this,"* "+ codigo+ " eliminado correctamente!!", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
