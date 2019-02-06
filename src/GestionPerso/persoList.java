/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionPerso;

import java.sql.*;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author B4DNetwork
 */
public class persoList extends javax.swing.JFrame {
    //connection variables 
    private Connection myconn = null;
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/personalMGMT";
    //Connection variables end
    
    
    
    public persoList() {
        initComponents();
        //Mysql Connection 
        try {
            myconn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Connected");
        }catch(SQLException e){
            System.err.println(e);
        }
        //MysqlConnection end
        
        //Fonctions ComboBox
        this.setFonctionsComboItems();
        
        //Services ComboBox
        this.setServicesComboItems();
        
        //Default listing
        try{
            String sqlQuery = "Select Nom , Prenom , DateNai , DateEmb, FonctionNom , ServiceNom , Montant From Employes E , Fonctions , Services , Salaires Sal"
                    + " Where E.ServiceId = Services.ServiceId And Sal.EmployeId = E.EmployeId And E.FonctionId = Fonctions.FonctionId;";
            PreparedStatement myStatement = myconn.prepareStatement(sqlQuery);
            fillEmployeesList(myStatement); // Default list
        }catch(SQLException e){
            System.err.print(e);
        }   
    }
    
    public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}
    
    
    public void fillEmployeesList(PreparedStatement myStatement){
        try{
            ResultSet myResults = myStatement.executeQuery();
            //jTable2 = new JTable(buildTableModel(myResults));
            jTable2.setModel(buildTableModel(myResults));
        }catch(SQLException e){
            System.err.print(e);
        }   
    }
    
    public void setFonctionsComboItems(){
        
        // Fonctions ComboBox
        jComboBox1.addItem("");
        jComboBox1.setSelectedIndex(0);
        //Sql Query and statement
        try{
            String sqlQuery = "SELECT FonctionNom FROM Fonctions";
            PreparedStatement myStatement = myconn.prepareStatement(sqlQuery);
            ResultSet myResults = myStatement.executeQuery();
            //jTable2 = new JTable(buildTableModel(myResults));
            while(myResults.next()){
                jComboBox1.addItem(myResults.getString("FonctionNom"));
            }
        }catch(SQLException e){
            System.err.print(e);
        }
        
    }
    
    public void setServicesComboItems(){
        // Services ComboBox
        jComboBox2.addItem("");
        jComboBox2.setSelectedIndex(0);
        //Sql Query and statement
        try{
            String sqlQuery = "SELECT ServiceNom FROM Services";
            PreparedStatement myStatement = myconn.prepareStatement(sqlQuery);
            ResultSet myResults = myStatement.executeQuery();
            //jTable2 = new JTable(buildTableModel(myResults));
            while(myResults.next()){
                jComboBox2.addItem(myResults.getString("ServiceNom"));
            }
        }catch(SQLException e){
            System.err.print(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 500));

        jPanel1.setBackground(new java.awt.Color(250, 200, 120));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setMinimumSize(new java.awt.Dimension(600, 100));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 100));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 600, 230));

        jPanel4.setBackground(new java.awt.Color(250, 200, 120));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel1.setText("RECHERCHE");

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel3.setText("Nom/Prénom :");

        jTextField1.setToolTipText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel5.setText("Service :");

        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel4.setText("Fonction :");

        jButton4.setFont(new java.awt.Font("Noto Sans", 1, 13)); // NOI18N
        jButton4.setText("Chercher");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 44, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 270, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String nameSearchQuery = jTextField1.getText();
        String FonctionSelect =(String) jComboBox1.getSelectedItem();
        String ServiceSelect =  (String) jComboBox2.getSelectedItem();
        String FonctionQuery;
        String ServiceQuery;
        if(FonctionSelect.equals("")){
            FonctionQuery = "SELECT FonctionNom FROM Fonctions";
            //System.out.print(FonctionQuery);
        }else{
            FonctionQuery = "'"+FonctionSelect+"'"; 
        }
        
        if(ServiceSelect.equals("")){
            ServiceQuery = "SELECT ServiceNom FROM Services";
        }else{
            ServiceQuery ="'"+ServiceSelect+"'"; 
        }
        
        if(nameSearchQuery.equals("")){
            try{
            String sqlQuery = "Select Nom , Prenom , DateNai , DateEmb, FonctionNom , ServiceNom , Montant   From Employes E, Fonctions F , Services S , Salaires Sal"
                    + " Where E.ServiceId = S.ServiceId And Sal.EmployeId = E.EmployeId AND E.FonctionId = F.FonctionId AND F.FonctionNom IN ("+FonctionQuery+") And S.ServiceNom IN ("+ServiceQuery+")";
            PreparedStatement myStatement = myconn.prepareStatement(sqlQuery);
            fillEmployeesList(myStatement);
            }catch(SQLException e){
                System.err.println(e);
            }
        }else{
            try{
            String sqlQuery = "Select Nom , Prenom , DateNai , DateEmb, FonctionNom , ServiceNom , Montant From Employes E, Fonctions F , Services S , Salaires Sal"
                    + " Where E.ServiceId = S.ServiceId And Sal.EmployeId = E.EmployeId AND E.FonctionId = F.FonctionId AND F.FonctionNom IN ("+FonctionQuery+") And S.ServiceNom IN ("+ServiceQuery+")"
                    + "AND (E.Nom LIKE '%"+nameSearchQuery+"%' OR E.Prenom LIKE '%"+nameSearchQuery+"%')";
            PreparedStatement myStatement = myconn.prepareStatement(sqlQuery);
            fillEmployeesList(myStatement);
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(persoList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(persoList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(persoList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(persoList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new persoList().setVisible(true);
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
