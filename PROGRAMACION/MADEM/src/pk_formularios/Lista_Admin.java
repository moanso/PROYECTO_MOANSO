package pk_formularios;

import pk_conexion.conexion;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Lista_Admin extends javax.swing.JFrame {
    String puerto="1433" , pass="12345678";
    public Lista_Admin() {
        initComponents();
        CargarCategoria();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        cbxCategoria = new javax.swing.JComboBox<String>();
        cbxStock = new javax.swing.JComboBox();
        btnConsultar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(510, 535));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CATEGORIA:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(12, 16, 120, 20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("STOCK:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 50, 110, 20);

        tblLista.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblLista);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 452, 330);

        cbxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(cbxCategoria);
        cbxCategoria.setBounds(140, 10, 110, 30);

        getContentPane().add(cbxStock);
        cbxStock.setBounds(140, 50, 110, 30);

        btnConsultar.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultar.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk_imagenes/list-on-a-notebook-stroke-symbol_icon-icons.com_57808.png"))); // NOI18N
        btnConsultar.setText("CONSULTAR");
        btnConsultar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultar);
        btnConsultar.setBounds(280, 20, 170, 50);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk_imagenes/descarga.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(390, 450, 70, 40);

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk_imagenes/RTA1uwq4B9PmpB0_ukWe5zl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9.jpg"))); // NOI18N
        getContentPane().add(lblFondo);
        lblFondo.setBounds(0, 0, 500, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        Llenar();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void cbxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaActionPerformed
        listarCategoria();
        CargarStock();
    }//GEN-LAST:event_cbxCategoriaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        close();
        JOptionPane.showMessageDialog(null, "Hasta Luego");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void close(){
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea Volver al Inicio?",
                "Cerrar Ventana", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
          Login c = new Login();
          c.setVisible(true);
          dispose();
        }          
    } 
        
    public void CargarCategoria(){
        Connection cn=null;
        Vector registros=null;
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection("jdbc:sqlserver://localhost:"+puerto+";databaseName=MADEM;"
               +"user=sa;password="+pass+";");
            Statement stm=cn.createStatement();
            String query2="Select distinct * from CATEGORIA; ";
            ResultSet rs=stm.executeQuery(query2);
            registros=new Vector();
            while(rs.next()){
                cbxCategoria.addItem(rs.getString("DESCRIPCION_CATEGORIA"));                
            }
        }catch(SQLException e){
          JOptionPane.showMessageDialog(rootPane, e.getMessage());    
        }catch(ClassNotFoundException e){}

    }
    
public void CargarStock(){
        cbxStock.removeAllItems();
        Connection cn=null;
        Vector registros=null;
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection("jdbc:sqlserver://localhost:"+puerto+";databaseName=MADEM;"
               +"user=sa;password="+pass+";");
            Statement stm=cn.createStatement();
            String query2="Select distinct * from CATEGORIA C join PRODUCTO P"
                    + " on(C.ID_CATEGORIA=P.ID_CATEGORIA) where C.DESCRIPCION_CATEGORIA ='"+cbxCategoria.getSelectedItem()+"'";
            ResultSet rs=stm.executeQuery(query2);
            registros=new Vector();
            while(rs.next()){
                cbxStock.addItem(rs.getInt("STOCK_PRODUCTO"));
            }
        }catch(SQLException e){
          JOptionPane.showMessageDialog(rootPane, e.getMessage());    
        }catch(ClassNotFoundException e){}

    }
    private Vector listar() {
        Connection cn=null;
        Vector reg=null;
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection("jdbc:sqlserver://localhost:"+puerto+";databaseName=MADEM;"
               +"user=sa;password="+pass+";");
            Statement stm=cn.createStatement();
         ResultSet rs = stm.executeQuery("SELECT * FROM CATEGORIA C join PRODUCTO P"
                 + " ON C.ID_CATEGORIA=P.ID_CATEGORIA and DESCRIPCION_CATEGORIA='"+cbxCategoria.getSelectedItem()+"' and "
                         + "STOCK_PRODUCTO="+cbxStock.getSelectedItem()+";");
         reg = new Vector();

             while(rs.next()){
             Vector item = new Vector();
             item.add(rs.getInt("ID_PRODUCTO"));
             item.add(rs.getString("NOMBRE_PRODUCTO"));
             item.add(rs.getFloat("PRECIO_POR_UNIDAD"));
             item.add(rs.getInt("STOCK_PRODUCTO"));
             reg.add(item);
             }
         }
         catch(Exception e){
         System.out.print(e);
         }
         return reg;
    }
    
    private Vector listarCategoria() {
         Connection con=null;
         Statement stm=null;
         Vector reg=null;
         try{
         con = conexion.getConexion();
         stm=con.createStatement();
         ResultSet rs = stm.executeQuery("SELECT * FROM CATEGORIA C join PRODUCTO P"
                 + " ON C.ID_CATEGORIA=P.ID_CATEGORIA; ");
         reg = new Vector();

             while(rs.next()){
             Vector item = new Vector();
             item.add(rs.getInt("cod_pro"));
             item.add(rs.getString("nom_prod"));
             item.add(rs.getString("des_prov"));
             item.add(rs.getFloat("precio_total"));
             item.add(rs.getFloat("precio_pro_uni"));
             item.add(rs.getInt("stock_pro"));
             item.add(rs.getString("fec_ingre"));
             item.add(rs.getString("des_cat"));
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
        colu.addElement("ID PRODUCTO");
        colu.addElement("NOMBRE PRODUCTO");
        colu.addElement("PRECIO");
        colu.addElement("STOCK");
        Vector reg = new Vector();
        reg = listar();
        DefaultTableModel dtm = new DefaultTableModel(reg, colu);
        this.tblLista.setModel(dtm);
        
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
            java.util.logging.Logger.getLogger(Lista_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lista_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lista_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lista_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lista_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox cbxStock;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JTable tblLista;
    // End of variables declaration//GEN-END:variables
}
