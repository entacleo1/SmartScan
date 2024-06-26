/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.dbconnector;
import config.session;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author entac
 */
public class archives extends javax.swing.JFrame {

    /**
     * Creates new form records
     */
    public archives() {
        initComponents();
        tb();
    }
    session ses = session.getInstance();
    dbconnector db = new dbconnector();
    public String action;
     public String destination = "";
    File selectedFile;
   
    public String oldpath;
    public String path;
    
      public void addLogs(String action){
        String insertQuery = "INSERT INTO act_logs (stake_id, action) VALUES ("+ses.getId()+", '"+action+"')";
        db.insertData(insertQuery);
    }
    
      private void tb() {
   

    try {
        
        ResultSet res = db.getData("SELECT * FROM tbl_stake WHERE status = 'Archive' ORDER BY last");

        while (res.next()) {

            String id = String.valueOf(res.getString("id"));
            String tag = res.getString("tag");
            String last = res.getString("last");
            String mid = res.getString("mid");
            String first = res.getString("name");
            String email = res.getString("email");
            String dob = res.getString("bod");
            String gender = res.getString("gender");
            String address = res.getString("address");
            String stat = res.getString("status");
            String pos = res.getString("pos_type");
                  
          
            

            String table[] = {id,tag,last,mid,first,email,dob,gender,address,stat,pos};

            DefaultTableModel tblmod = (DefaultTableModel)rec_list.getModel();
            tblmod.addRow(table);

        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
}
      
        public int existcheck(String path){
        File file = new File(path);
        String filename = file.getName();
        
        Path filePath = Paths.get("src/stakepics", filename);
        boolean fileExist = Files.exists(filePath);
        
        if(fileExist){
            return 1;
        }else{
            return 0;
        }
    }
        
         public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
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
        txtsearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rec_list = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel1.setText("Archives");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel2.setText("[BACK]");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, -1, -1));

        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 200, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/search.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 30, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/delete.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/update.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/re.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel9.setText("Any Key or TAG#");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/kilid.jpg"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, -1, 110));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rec_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tag#", "Last Name", "M.I", "Name", "Email", "Date of Birth", "Gender", "Address", "Status", "Position"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(rec_list);
        if (rec_list.getColumnModel().getColumnCount() > 0) {
            rec_list.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(945, 499));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed

    }//GEN-LAST:event_txtsearchActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        String stat = txtsearch.getText();
            String sql = "SELECT * FROM tbl_stake WHERE name LIKE '%" + stat + "%' OR last LIKE '%" + stat + "%' OR tag LIKE '%"+stat+"%'";
           try {
      
        
        ResultSet res = db.getData(sql);
      
        DefaultTableModel tblmod = (DefaultTableModel)rec_list.getModel();
        tblmod.setRowCount(0);
        
        
        while (res.next()) {
        

          String id = String.valueOf(res.getString("id"));
            String tag = res.getString("tag");
            String last = res.getString("last");
            String mid = res.getString("mid");
            String first = res.getString("name");
            String email = res.getString("email");
            String dob = res.getString("bod");
            String gender = res.getString("gender");
            String address = res.getString("address");
            String stats = res.getString("status");
            String pos = res.getString("pos_type");
                  
          
            

            String table[] = {id,tag,last,mid,first,email,dob,gender,address,stats,pos};  
            
            DefaultTableModel model = (DefaultTableModel)rec_list.getModel();
            model.addRow(table);
          
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_txtsearchKeyReleased

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
  
     stakes op = new stakes();

        op.setVisible(true);
        this.dispose();
               
       
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        int row = rec_list.getSelectedRow();
       
        newadmin up = new newadmin();
        
        if(row < 0 ){
            JOptionPane.showMessageDialog(null, "Please Select");
        }else{
                TableModel model = rec_list.getModel();
                int a = JOptionPane.showConfirmDialog(null,"Are you Sure You want to Retrieve " + model.getValueAt(row, 0) , "Select", JOptionPane.YES_NO_OPTION);
                if( a == 0){
                     addLogs("" +ses.getName()+ " " + "Restored User " +model.getValueAt(row, 0));
                    db.update("UPDATE tbl_stake SET status = 'Active' WHERE id = '"+model.getValueAt(row,0)+"'",false);
                    JOptionPane.showMessageDialog(null,"Item Restored");
                }
            
        }    
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
      
      int row = rec_list.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please Select An Item");
        } else {
            TableModel mod = rec_list.getModel();
            Object val = mod.getValueAt(row, 0);
            String id = val.toString();

            int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to permanently delete ID " + id + "?", "Select", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {
                try {
                    int s_id = Integer.parseInt(id);

                    // Fetch the picture path before deleting the record
                    ResultSet res = db.getData("SELECT pic FROM tbl_stake WHERE id = '" + id + "'");
                    String picPath = null;
                    if (res.next()) {
                        picPath = res.getString("pic");
                    }

                    // Delete the record from the database
                    db.delete(s_id, "tbl_stake", "id");

                    // Delete the associated image file if it exists
                    if (picPath != null && !picPath.isEmpty()) {
                        File existingFile = new File(picPath);
                        if (existingFile.exists() && existingFile.isFile()) {
                            if (existingFile.delete()) {
                                System.out.println("File deleted successfully");
                            } else {
                                System.err.println("Failed to delete the file");
                            }
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Item Deleted");
                } catch (SQLException ex) {
                    Logger.getLogger(archives.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "An error occurred while deleting the item.");
                } catch (NumberFormatException ex) {
                    Logger.getLogger(archives.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Invalid ID format.");
                }
            }
}

    }//GEN-LAST:event_jLabel4MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

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
            java.util.logging.Logger.getLogger(archives.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(archives.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(archives.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(archives.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new archives().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable rec_list;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
