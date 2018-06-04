
package pk_formularios;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import pk_conexion.conexion;
import pk_clases.GenerarCodigo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import static pk_conexion.conexion.main;


public class Compras extends javax.swing.JFrame{
    CallableStatement cst;
    static ResultSet rs=null;
    PreparedStatement s;
    Connection con=null;
    Vector registros=null;
    double sum=0, suma=0;
    String puerto="1433" , pass="12345678";    
    String[] titulos={"Producto","Precio Unitario","Cantidad","Precio Total"};
    DefaultTableModel modelo = new DefaultTableModel(null,titulos); 
    
    String clav;
    
    public Compras() {
        initComponents();
        setLocationRelativeTo(null);  
        Actualizar();
        CargarCategoria();
        //Muestras la tabla la tabla con los campos que le diste al inicio
        this.tblCarrito.setModel(modelo);  
        
        txtPrecio.setEditable(false);
        txtStock.setEditable(false);
        txtHora_Actual.setEditable(false);
    }   
    
    private void close(){
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea Volver al Inicio?",
                "Cerrar Ventana", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
          Login c = new Login();
          c.setVisible(true);
          dispose();
        }          
    } 
    
    public void Actualizar(){
        Timer timer = new Timer (1000, new ActionListener () 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
                Llenar_Hora();
            } 
        }); 
        timer.start();   
    };
    
    void Llenar_Hora(){
        java.util.Date d = new java.util.Date(); 
        Timestamp timestamp1 = new Timestamp(d.getTime());
        txtHora_Actual.setText(String.valueOf(timestamp1));
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Eliminar = new javax.swing.JMenuItem();
        jLabel9 = new javax.swing.JLabel();
        txtHora_Actual = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarrito = new javax.swing.JTable();
        cbxCategoria = new javax.swing.JComboBox<String>();
        txtStock = new javax.swing.JTextField();
        btnAñadir_Arreglo = new javax.swing.JButton();
        txtCompra = new javax.swing.JTextField();
        cbxProducto = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnConfirmar_Compra = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        txtRUC = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtCodVenta = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnComprobante = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        fondoVenta = new javax.swing.JLabel();
        prefondo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Eliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(680, 700));
        getContentPane().setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Hora actual:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(280, 50, 80, 14);

        txtHora_Actual.setEditable(false);
        txtHora_Actual.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtHora_ActualPropertyChange(evt);
            }
        });
        getContentPane().add(txtHora_Actual);
        txtHora_Actual.setBounds(360, 40, 186, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk_imagenes/descarga.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(570, 30, 70, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cantidad:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(410, 170, 80, 17);

        txtPrecio.setEditable(false);
        txtPrecio.setBorder(null);
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        getContentPane().add(txtPrecio);
        txtPrecio.setBounds(320, 160, 60, 30);

        tblCarrito.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCarrito.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tblCarrito);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 200, 420, 150);

        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Seleccione--" }));
        cbxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(cbxCategoria);
        cbxCategoria.setBounds(120, 120, 110, 30);

        txtStock.setEditable(false);
        getContentPane().add(txtStock);
        txtStock.setBounds(130, 160, 70, 30);

        btnAñadir_Arreglo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAñadir_Arreglo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk_imagenes/carrito-de-compras.png"))); // NOI18N
        btnAñadir_Arreglo.setText("Añadir a Carrito");
        btnAñadir_Arreglo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadir_ArregloActionPerformed(evt);
            }
        });
        getContentPane().add(btnAñadir_Arreglo);
        btnAñadir_Arreglo.setBounds(470, 200, 180, 40);
        getContentPane().add(txtCompra);
        txtCompra.setBounds(500, 160, 90, 30);

        cbxProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Seleccione--" }));
        cbxProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProductoActionPerformed(evt);
            }
        });
        getContentPane().add(cbxProducto);
        cbxProducto.setBounds(320, 120, 280, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio: S/.");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(220, 170, 90, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Stock");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 170, 60, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("RUC:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 500, 40, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Producto");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(240, 120, 80, 17);

        btnConfirmar_Compra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnConfirmar_Compra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk_imagenes/comprado.png"))); // NOI18N
        btnConfirmar_Compra.setText("COMPRAR");
        btnConfirmar_Compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmar_CompraActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirmar_Compra);
        btnConfirmar_Compra.setBounds(470, 300, 180, 50);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk_imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar Producto");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(470, 250, 180, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Registro del Comprador");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(50, 400, 230, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Categoria");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(40, 120, 80, 17);
        getContentPane().add(txtDNI);
        txtDNI.setBounds(80, 450, 100, 30);
        getContentPane().add(txtRUC);
        txtRUC.setBounds(80, 490, 100, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DNI:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(40, 460, 40, 17);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("NOMBRE DEL CLIENTE: ");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(260, 460, 180, 17);
        getContentPane().add(txtCliente);
        txtCliente.setBounds(440, 450, 220, 30);
        getContentPane().add(txtRazonSocial);
        txtRazonSocial.setBounds(390, 490, 270, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("RAZÓN SOCIAL: ");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(260, 500, 130, 17);

        txtSubTotal.setEditable(false);
        getContentPane().add(txtSubTotal);
        txtSubTotal.setBounds(170, 530, 100, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("VENTA N.");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(460, 420, 60, 15);

        txtCodVenta.setEditable(false);
        txtCodVenta.setBorder(null);
        getContentPane().add(txtCodVenta);
        txtCodVenta.setBounds(520, 420, 90, 20);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("SubTotal: S/.");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(70, 540, 140, 20);

        btnComprobante.setText("GENERAR COMPROBANTE");
        btnComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprobanteActionPerformed(evt);
            }
        });
        getContentPane().add(btnComprobante);
        btnComprobante.setBounds(200, 600, 250, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Total: S/.");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(400, 540, 140, 20);

        txtTotal.setEditable(false);
        getContentPane().add(txtTotal);
        txtTotal.setBounds(470, 530, 100, 30);

        fondoVenta.setForeground(new java.awt.Color(255, 255, 255));
        fondoVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        getContentPane().add(fondoVenta);
        fondoVenta.setBounds(20, 390, 650, 200);

        prefondo.setForeground(new java.awt.Color(255, 255, 255));
        prefondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        getContentPane().add(prefondo);
        prefondo.setBounds(20, 100, 650, 280);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk_imagenes/RTA1uwq4B9PmpB0_ukWe5zl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 700, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char c=evt.getKeyChar();
        if(Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Ingresa Solo Numeros");
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void cbxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaActionPerformed
        txtPrecio.setText(null);
        txtStock.setText(null);
        this.CargarProducto();
       // this.Sacar_Datos();
    }//GEN-LAST:event_cbxCategoriaActionPerformed

    private void cbxProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProductoActionPerformed
       Sacar_Datos();
    }//GEN-LAST:event_cbxProductoActionPerformed

    private void btnAñadir_ArregloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadir_ArregloActionPerformed
        //float pre;     
        DecimalFormat df2 = new DecimalFormat("####.00");        

        if(Integer.parseInt(txtStock.getText())<Integer.parseInt(txtCompra.getText())){
           JOptionPane.showMessageDialog(null, "Cantidad excede al disponible");
        }else {
            String datos[]=new String[4];   
        float precio=(Float.parseFloat(txtPrecio.getText())*Float.parseFloat(txtCompra.getText()));
        datos[0]=(String) cbxProducto.getSelectedItem();
        datos[1]=(String) txtPrecio.getText();
        datos[2]=txtCompra.getText();
        //pre=df2.format(precio);
        datos[3]=String.valueOf(precio);
        //JOptionPane.showMessageDialog(null, datos[3]);
        modelo.addRow(datos);
            txtCompra.setText("");
            Vaciar();
        }
    }//GEN-LAST:event_btnAñadir_ArregloActionPerformed

    private void caltot(){
    
            double S=0, igv, tot, aux=0;
            for (int i=0;i<tblCarrito.getRowCount();i++){
                //aux = 0;
                //JOptionPane.showMessageDialog(null, (Double.parseDouble(modelo.getValueAt(i,3).toString())));
                aux = Double.parseDouble(modelo.getValueAt(i,3).toString());
                JOptionPane.showMessageDialog(null, aux);
                S = S + aux;
            }
            for (int fila=0;fila<tblCarrito.getRowCount();fila++){
                aux = Double.parseDouble(modelo.getValueAt(fila,3).toString());
                S=S+aux;            
            }         
            S=redondear(S);
            txtSubTotal.setText(String.valueOf(S));
            igv=0.09*S;
            igv=redondear(igv);
            tot=S*1.09;
            tot=redondear(tot);
            txtTotal.setText(String.valueOf(tot));
            
        }
        
    private double redondear(double num){
        return Math.rint(num*100)/100;
    }
    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int fila= tblCarrito.getSelectedRow();
        if(fila>=0)
           modelo.removeRow(fila);    
        else{
        JOptionPane.showMessageDialog(null,"No seleciono fila");
        }  
    }//GEN-LAST:event_EliminarActionPerformed

    private void btnConfirmar_CompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmar_CompraActionPerformed
        int venta;
        String nom,cant_anterior; 
        float ganancia;
        
        int seleccion = JOptionPane.showOptionDialog(null,"Boleta o Factura?", "Comprobante de Pago",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] {"Boleta", "Factura"},null);
        if (seleccion == 0){
            txtDNI.setEnabled(true);
            txtCliente.setEnabled(true);
            txtRUC.setEnabled(false);
            txtRazonSocial.setEnabled(false);
        }    
        else if(seleccion == 1){
            txtDNI.setEnabled(false);
            txtCliente.setEnabled(false);
            txtRUC.setEnabled(true);
            txtRazonSocial.setEnabled(true);
        }
        
        cargarcodigo();
        
        //JOptionPane.showMessageDialog(null, tblCarrito.getRowCount());
        for (int fila=0;fila<tblCarrito.getRowCount();fila++){
            nom=tblCarrito.getValueAt(fila, 0).toString();
            venta=Integer.parseInt(tblCarrito.getValueAt(fila,2).toString());
            ganancia=Float.parseFloat(tblCarrito.getValueAt(fila, 3).toString());
            
            //Actualizamos stock en DB
            Actualizar_Stock(nom,venta);
            
            //iNGRESAMOS VENTA A db
            Ingresar_Venta(nom,venta,ganancia);            
        }                   
        JOptionPane.showMessageDialog(null,"Compra exitosa");
        this.caltot();
        Limpiar_tabla(); 
    }//GEN-LAST:event_btnConfirmar_CompraActionPerformed

    private void txtHora_ActualPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtHora_ActualPropertyChange
        txtHora_Actual.setHorizontalAlignment(txtHora_Actual.CENTER);//left izquierda - right derecha
    }//GEN-LAST:event_txtHora_ActualPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        close();
        JOptionPane.showMessageDialog(null, "Hasta Luego");        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblCarrito.getModel();
        dtm.removeRow(tblCarrito.getSelectedRow());
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprobanteActionPerformed
        JFileChooser dlg = new JFileChooser();
        int option = dlg.showSaveDialog(this);
        String ruta="";
        if(option == JFileChooser.APPROVE_OPTION){
            File f=dlg.getSelectedFile();
            ruta = f.toString();
        }
        
        Connection cn;
        Vector reg=null;
        try{
            reg = new Vector();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection("jdbc:sqlserver://localhost:"+puerto+";databaseName=MADEM;"
                +"user=sa;password="+pass+";");
            Statement stm=cn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM ventas");
            while(rs.next()){
                Vector item = new Vector();
                item.add(rs.getString("nom"));
                item.add(rs.getInt("cant"));
                item.add(rs.getFloat("ganancia"));
                item.add(rs.getString("fecha"));
                reg.add(item);
            }
            FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            String contenido = ""+reg;
            doc.add(new Paragraph(contenido));
            doc.close();
            JOptionPane.showMessageDialog(null, "El pdf se creo en la ruta seleccionada");
        }catch(Exception e){
            System.out.print(e);
        }
    }//GEN-LAST:event_btnComprobanteActionPerformed
         
    void cargarcodigo(){
        con = conexion.getConexion();
        int j;
        String c="";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select max(numero)from numeros"); 
            if(rs.next()){
                c=rs.getString(1);
            }
            if(c==null){
                txtCodVenta.setText("CDOO1");
            }else{
                char r1=c.charAt(2);
                char r2=c.charAt(3);
                char r3=c.charAt(4);
                String r ="";
                r=""+r1+r2+r3;
                j=Integer.parseInt(r);
                GenerarCodigo gen = new GenerarCodigo();
                gen.generar(j);
                txtCodVenta.setText(" CD"+gen.serie());
            }
        }
        catch (Exception e){
           
        }
   }
       
    void Actualizar_Stock(String nom, int venta){        
        //JOptionPane.showMessageDialog(null, "Se actualizara la BD");
        try{
            //JOptionPane.showMessageDialog(null, "INICIA");
            cst = DriverManager.getConnection("jdbc:sqlserver://localhost:"+puerto
            + "; database=MADEM;user=sa;password="+pass+";").prepareCall("{call sp_modificar_stock(?,?)}");            
            cst.setString("nom_produc", nom);
            cst.setInt("cantidad", venta);
            int rpta = cst.executeUpdate();
            /*if (rpta == 1) {
                JOptionPane.showMessageDialog(this,"* "+ nom + " se actualizo stock");
            }            */
        }catch(SQLException e){
          JOptionPane.showMessageDialog(rootPane, e.getMessage());    
        }
    }
    
    void Ingresar_Venta(String nom,int cant, float ganancia){
        Calendar c;
        c = Calendar.getInstance();
        int d = c.get(Calendar.DATE) , m = (c.get(Calendar.MONTH)+1) , a = c.get(Calendar.YEAR);
        String fecha = d + "-" + m +"-"+a;
        try {
            cst = DriverManager.getConnection("jdbc:sqlserver://localhost:"+puerto
            + "; database=MADEM;user=sa;password="+pass+";").prepareCall("{call sp_registrarVenta(?,?,?,?)}");          
            cst.setString("nom", nom);
            cst.setInt("cant", cant);
            cst.setFloat("ganacia", ganancia);
            cst.setString("fecha", fecha);
            int rpta = cst.executeUpdate();
            /*if (rpta == 1) {
                JOptionPane.showMessageDialog(this,"SE REGISTRO LA VENTA");
            }   */
          //JOptionPane.showMessageDialog(null, "Se registro en la BD");
       }catch (SQLException e){
          JOptionPane.showMessageDialog(null, "Error de Conexion");
       }
     
   }
    
    void Limpiar_tabla(){
        for (int i = 0; i < tblCarrito.getRowCount(); i++) {
           modelo.removeRow(i);//Eliminamos fila por fila
           i=-1;
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
    
    public void CargarProducto(){
        cbxProducto.removeAllItems();
        Connection cn=null;
        Vector registros=null;
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection("jdbc:sqlserver://localhost:"+puerto+";databaseName=MADEM;"
               +"user=sa;password="+pass+";");
            Statement stm=cn.createStatement();
            String query2=("Select distinct * from PRODUCTO P join CATEGORIA C on P.ID_CATEGORIA=C.ID_CATEGORIA where C.DESCRIPCION_CATEGORIA='"+cbxCategoria.getSelectedItem()+"';");
            ResultSet rs=stm.executeQuery(query2);
            registros=new Vector();
            while(rs.next()){
                //JOptionPane.showMessageDialog(null, "Se asigno los valores");
                cbxProducto.addItem(rs.getString("NOMBRE_PRODUCTO"));                
            }
        }catch(SQLException e){
          JOptionPane.showMessageDialog(rootPane, e.getMessage());    
        }catch(ClassNotFoundException e){}

    }
    
    void Sacar_Datos(){
        try{
            con=conexion.getConexion();
            Statement stm=con.createStatement();
            String query="SELECT * FROM PRODUCTO P JOIN CATEGORIA C ON P.ID_CATEGORIA=C.ID_CATEGORIA WHERE P.NOMBRE_PRODUCTO='"        
                +cbxProducto.getSelectedItem()+"' and C.DESCRIPCION_CATEGORIA='"+cbxCategoria.getSelectedItem()+"'"; 
            ResultSet rs=stm.executeQuery(query);
            registros=new Vector();
            while (rs.next()){
                //JOptionPane.showMessageDialog(null, "Se llenaron los datos");
                txtStock.setText(""+rs.getInt("STOCK_PRODUCTO"));
                txtPrecio.setText(""+rs.getFloat("PRECIO_POR_UNIDAD"));
            }
        }catch(SQLException e){
          JOptionPane.showMessageDialog(rootPane, e.getMessage());    
        } 
    }
    
    void Vaciar(){
        cbxCategoria.setSelectedIndex(0);
        //cbxProducto.setSelectedIndex(0);
        this.txtStock.setText("");
        this.txtPrecio.setText("");
        this.txtCompra.setText("");
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
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JButton btnAñadir_Arreglo;
    private javax.swing.JButton btnComprobante;
    private javax.swing.JButton btnConfirmar_Compra;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox cbxProducto;
    private javax.swing.JLabel fondoVenta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel prefondo;
    private javax.swing.JTable tblCarrito;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodVenta;
    private javax.swing.JTextField txtCompra;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtHora_Actual;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRUC;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtStock;
    public static javax.swing.JTextField txtSubTotal;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private double suma(double sum) {
        suma = suma + suma;
        return suma;
    }
}
