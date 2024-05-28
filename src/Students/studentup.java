/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Students;

import config.dbconnector;
import config.session;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author entac
 */
public final class studentup extends javax.swing.JFrame {

    /**
     * Creates new form studentup
     */
    
    public dbconnector db = new dbconnector();
    session ses = session.getInstance();
    public studentup() {
        initComponents();
        tb();
    }
    public static String del;
    
       public void addLogs(String action){
        String insertQuery = "INSERT INTO act_logs (stake_id, action) VALUES ("+ses.getId()+", '"+action+"')";
        boolean rowsInserted = db.insertData(insertQuery);
    }
    public boolean duplicate(){
        try{
        
        String sq = "SELECT * FROM tbl_gradelvl WHERE lvl = '"+grade.getText()+"'";
        ResultSet res = db.getData(sq);
        
        if(res.next()){
            del = res.getString("lvl");
            if(del.equals(grade.getText())){
                JOptionPane.showMessageDialog(null, "Record Existed"); 
            }  
            return true;
          }else{
            return false;
        }
        }catch(SQLException ex){
            System.out.println("ERROR"+ex.getMessage());
            return false;
            
        }
    }
        
    public void tb(){
       
        try{
            
            Statement st = db.connect.createStatement();
            String sq = "SELECT DISTINCT lvl, COUNT(section)as sec FROM tbl_gradelvl GROUP BY lvl ORDER BY lvl";
            ResultSet res = st.executeQuery(sq);
            
            while(res.next()){
                String lvl = res.getString("lvl");
                String count = res.getString("sec");
             
                
                String tab[] = {lvl,count};
                
                DefaultTableModel def = (DefaultTableModel)gradelist.getModel();
                def.addRow(tab);
            }
            
            
        }catch(SQLException ex){
            System.out.println("Error" + ex);   
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        grade = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        lblback = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gradelist = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel1.setText("Update Grade");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setText("Grade");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        jPanel1.add(grade, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 150, 30));

        jToggleButton1.setText("Add");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 70, 30));

        lblback.setFont(new java.awt.Font("DialogInput", 0, 11)); // NOI18N
        lblback.setText("[Back]");
        lblback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblbackMouseClicked(evt);
            }
        });
        jPanel1.add(lblback, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/delete.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/kilid.jpg"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 110));

        gradelist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grade", "Sections"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(gradelist);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbackMouseClicked
     this.dispose();
    }//GEN-LAST:event_lblbackMouseClicked

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
     if(grade.getText().isEmpty()){
         JOptionPane.showMessageDialog(null, "Empty Input");
     }else if(duplicate()){
         System.out.println("Duplicated");
     }else{
         if(db.insertData("INSERT INTO tbl_gradelvl (lvl,section) VALUES('"+grade.getText()+"', 'A')")){
             JOptionPane.showMessageDialog(null,"Record Saved");
             DefaultTableModel def = (DefaultTableModel)gradelist.getModel();
             addLogs("" +ses.getName()+ " " + "Added a Grade Level " +grade.getText());
             def.setRowCount(0);
             tb();
         }else{
             JOptionPane.showMessageDialog(null,"Error");         }
     }
    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        int row = gradelist.getSelectedRow();

    if (row < 0) {
        JOptionPane.showMessageDialog(null, "Please Select");
    } else {
         TableModel mod = gradelist.getModel();
               
           try{
               ResultSet res = db.getData("SELECT * FROM tbl_gradelvl WHERE lvl = '"+mod.getValueAt(row, 0 )+"'");
               
               if(res.next()){
                 Object val = res.getString("num");
                 String id = val.toString();
               
                 int l = JOptionPane.showConfirmDialog(null, "If you Delete this all section under This Grade will be deleted", "Select", JOptionPane.YES_NO_OPTION);
                 
                 if(l == 0){
                
                    int s_id = Integer.parseInt(id);
                    db.delete(s_id,"tbl_gradelvl","num");
                    addLogs("" +ses.getName()+ " " + " Deleted " +mod.getValueAt(row, 0 ));
                    
                 }
            }        
           } catch (SQLException ex) {
                Logger.getLogger(studentup.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
          DefaultTableModel def = (DefaultTableModel)gradelist.getModel();
           def.setRowCount(0);
           tb();
    }
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(studentup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField grade;
    private javax.swing.JTable gradelist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblback;
    // End of variables declaration//GEN-END:variables
}
