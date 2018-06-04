package pk_formularios;

import javax.swing.JOptionPane;
import pk_conexion.conexion;
import java.sql.*;
import java.util.*;

public class Ingresar_Admin extends javax.swing.JFrame {

    CallableStatement cst;
    Connection cn;
    Statement stm;
    ResultSet rs;
    String puerto="1433" , pass="12345678";
   
    
    public Ingresar_Admin() {
        initComponents();
        ListaCategorias();
        ListaProveedores();
        this.setLocationRelativeTo(null);
        this.setSize(490,520);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        cbxCate = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPrecUni = new javax.swing.JTextField();
        cbxProveedor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INGRESAR PRODUCTO");
        setMinimumSize(new java.awt.Dimension(405, 335));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CODIGO:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 40, 70, 17);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 80, 70, 17);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PRECIO DE COMPRA:");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 260, 150, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("STOCK:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 120, 60, 17);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CATEGORIA:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 160, 90, 30);
        getContentPane().add(txtCodigo);
        txtCodigo.setBounds(160, 30, 170, 30);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(160, 70, 170, 30);
        getContentPane().add(txtPrecio);
        txtPrecio.setBounds(270, 260, 150, 30);
        getContentPane().add(txtStock);
        txtStock.setBounds(160, 110, 170, 30);

        btnIngresar.setBackground(new java.awt.Color(255, 255, 255));
        btnIngresar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk_imagenes/agregar.png"))); // NOI18N
        btnIngresar.setText("AGREGAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar);
        btnIngresar.setBounds(160, 360, 170, 50);

        getContentPane().add(cbxCate);
        cbxCate.setBounds(160, 160, 260, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk_imagenes/descarga.png"))); // NOI18N
        jButton1.setMaximumSize(new java.awt.Dimension(63, 60));
        jButton1.setMinimumSize(new java.awt.Dimension(63, 60));
        jButton1.setPreferredSize(new java.awt.Dimension(63, 60));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(350, 30, 70, 40);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PROVEEDOR:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(50, 210, 100, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("PRECIO DE VENTA POR UNIDAD:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(50, 300, 230, 30);
        getContentPane().add(txtPrecUni);
        txtPrecUni.setBounds(270, 300, 150, 30);

        getContentPane().add(cbxProveedor);
        cbxProveedor.setBounds(160, 210, 260, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk_imagenes/RTA1uwq4B9PmpB0_ukWe5zl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 932, 806);

        pack();
    }// </editor-fold>//GEN-END:initComponents

        java.util.Date d = new java.util.Date(); 
        Timestamp timestamp1 = new Timestamp(d.getTime());

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String nombre, cate, proveedor ;
        int stock, codigo;
        float precio_uni, precio_tot;

        codigo = Integer.parseInt(this.txtCodigo.getText());
        nombre = this.txtNombre.getText();
        stock = Integer.parseInt(this.txtStock.getText());
        cate = this.cbxCate.getSelectedItem().toString();
        proveedor = this.cbxProveedor.getSelectedItem().toString();
        precio_uni = Float.parseFloat(this.txtPrecUni.getText());
        precio_tot = Float.parseFloat(this.txtPrecio.getText());
        
        Calendar c;
        c = Calendar.getInstance();
        int d = c.get(Calendar.DATE) , m = (c.get(Calendar.MONTH)+1) , a = c.get(Calendar.YEAR);
        String fecha = d + "-" + m +"-"+a;
   
        try {
            cst = DriverManager.getConnection("jdbc:sqlserver://localhost:"+puerto
            + "; database=MADEM;user=sa;password="+pass+";").prepareCall("{call sp_Registrar(?,?,?,?,?,?,?,?)}");            
            cst.setInt("cod_pro", codigo);
            cst.setString("nom_prod", nombre);
            cst.setString("des_prov", proveedor);
            cst.setFloat("precio_total", precio_tot);
            cst.setFloat("precio_pro_uni", precio_uni);
            cst.setInt("stock_pro", stock);
            cst.setString("fec_ingre", fecha);
            cst.setString("des_cat", cate);
            
            int rpta = cst.executeUpdate();
            if (rpta == 1) {
                JOptionPane.showMessageDialog(this,"* "+ nombre + " registrado correctamente!!", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
                
        Administrador entrar = new Administrador();
        entrar.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        close();
        JOptionPane.showMessageDialog(null, "Hasta Luego");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void close(){
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea Volver al Inicio?",
                "Cerrar Ventana", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
//          Marca_salida();
          Login c = new Login();
          c.setVisible(true);
          dispose();
        }          
    } 
        
    private void ListaCategorias() {
        Vector carreras = null;
        try{
            stm = DriverManager.getConnection("jdbc:sqlserver://localhost:"+puerto+";"
            + "database=MADEM;user=sa;password="+pass+";").createStatement();
            String query = "SELECT DISTINCT * FROM CATEGORIA;";
            rs = stm.executeQuery(query);
            carreras = new Vector();
            while(rs.next()){
                cbxCate.addItem(rs.getString("DESCRIPCION_CATEGORIA"));
            }
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    private void ListaProveedores() {
        Vector carreras = null;
        try{
            stm = DriverManager.getConnection("jdbc:sqlserver://localhost:"+puerto+";"
            + "database=MADEM;user=sa;password="+pass+";").createStatement();
            String query = "SELECT DISTINCT * FROM PROVEEDOR;";
            rs = stm.executeQuery(query);
            carreras = new Vector();
            while(rs.next()){
                cbxProveedor.addItem(rs.getString("DESCRIPCION"));
            }
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
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
            java.util.logging.Logger.getLogger(Ingresar_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingresar_Admin().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JComboBox<String> cbxCate;
    private javax.swing.JComboBox<String> cbxProveedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecUni;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
