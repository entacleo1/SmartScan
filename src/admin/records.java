/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.TablePrinter;
import config.dbconnector;
import config.session;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import user.user_dash;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**


/**
 *
 * @author entac
 */
public class records extends javax.swing.JFrame {

    /**
     * Creates new form records
     */
    public records() {
         
        initComponents();
        tb();
        dt();
        section.hide();
        type.hide();
        
    }
    session ses = session.getInstance();
    dbconnector db = new dbconnector();
    public String action;
    
  public void addLogs(String action){
        String insertQuery = "INSERT INTO act_logs (stake_id, action) VALUES ("+ses.getId()+", '"+action+"')";
        db.insertData(insertQuery);
    }
  
    private void dt(){
         try {
            ResultSet res = db.getData("SELECT DISTINCT date FROM records");
            
            while(res.next()){
                dets.addItem(res.getString("date"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(records.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
 
    
    
      private void tb() {
   

    try {
        
        ResultSet res = db.getData("SELECT * FROM records ORDER BY date DESC");

        while (res.next()) {

            String id = String.valueOf(res.getString("reference_id"));
            String tag = res.getString("tags");
            String last = res.getString("last");
            String mid = res.getString("mid");
            String first = res.getString("name");
            String posi = res.getString("pos_type");
            String pos = res.getString("pos");
            String tmin = res.getString("time_in");
            String tmout = res.getString("time_out");
            String date = res.getString("date");
      
            

            String table[] = {id,tag,last,mid,first,pos,posi,tmin,tmout,date};

            DefaultTableModel tblmod = (DefaultTableModel)rec_list.getModel();
            tblmod.addRow(table);

        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
}
      
     public void openFile(String file){
         try{
             File path = new File(file);
             Desktop.getDesktop().open(path);
             
         }catch(IOException e ){
             System.out.println(""+e);
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
        dets = new javax.swing.JComboBox<>();
        filter = new javax.swing.JComboBox<>();
        txtsearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        section = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rec_list = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setText("Records");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel2.setText("[BACK]");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, -1, -1));

        dets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detsActionPerformed(evt);
            }
        });
        jPanel1.add(dets, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 100, 30));

        filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Records", "Students", "Teachers/Staff" }));
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });
        jPanel1.add(filter, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 30));

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
        jPanel1.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 200, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/search.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 30, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/kilid.jpg"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, -1, 110));

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel4.setText("Export to EXCEL");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, -1, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel5.setText("Print Table");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, -1, 20));

        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });
        jPanel1.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 100, 30));

        section.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionActionPerformed(evt);
            }
        });
        jPanel1.add(section, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 100, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel6.setText("Any Key or TAG#");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, 20));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rec_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tag#", "Last Name", "M.I", "Name", "Grade/Position", "Sec/Type", "Time In", "Time Out", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
         String query = txtsearch.getText();
         String searchQuery = "SELECT * FROM records WHERE reference_id LIKE '%" + query + "%' OR name LIKE '%" + query + "%' "
                               + "OR last LIKE '%"+query+"%' OR tags LIKE '%"+query+"%' ";
         
    try {
        
        ResultSet res = db.getData(searchQuery);
        
        
            DefaultTableModel mod = (DefaultTableModel)rec_list.getModel();
            mod.setRowCount(0);

     while (res.next()) {

            String id = String.valueOf(res.getString("reference_id"));
            String tag = res.getString("tags");
            String last = res.getString("last");
            String mid = res.getString("mid");
            String first = res.getString("name");
            String posi = res.getString("pos_type");
            String pos = res.getString("pos");
            String tmin = res.getString("time_in");
            String tmout = res.getString("time_out");
            String date = res.getString("date");
      
            

            String table[] = {id,tag,last,mid,first,pos,posi,tmin,tmout,date};

            DefaultTableModel tblmod = (DefaultTableModel)rec_list.getModel();
            tblmod.addRow(table);
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
         
    }//GEN-LAST:event_txtsearchKeyReleased

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
      if(filter.getSelectedItem().equals("All Records")){
      
        section.hide();
        type.hide();
      }else if(filter.getSelectedItem().equals("Students")){
          type.removeAllItems();

          try {
              ResultSet res = db.getData("SELECT DISTINCT lvl, section FROM tbl_gradelvl");
              
              while(res.next()){
                  type.addItem(res.getString("lvl"));
                  section.removeAllItems();
                
              }
              
              ResultSet sec = db.getData("SELECT section FROM tbl_gradelvl WHERE lvl = '"+type.getSelectedItem()+"'");
               while(sec.next()){
                  section.addItem(sec.getString("section"));
               
              }
          } catch (SQLException ex) {
              Logger.getLogger(records.class.getName()).log(Level.SEVERE, null, ex);
          }
          section.setVisible(true);
          type.setVisible(true);
      }else if(filter.getSelectedItem().equals("Teachers/Staff")){
          section.hide();
          section.removeAllItems();
          type.removeAllItems();
            try {
              ResultSet res = db.getData("SELECT pos_type FROM tbl_stake");
              
              while(res.next()){
                  type.addItem(res.getString("pos_type"));
                 
              }
          } catch (SQLException ex) {
              Logger.getLogger(records.class.getName()).log(Level.SEVERE, null, ex);
          }
          type.setVisible(true);
      }

    }//GEN-LAST:event_filterActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        switch(action){
            case "user":
                user_dash ud = new user_dash();
                
                ud.setVisible(true);
                this.dispose();
                
                break;
            case "admin":
                Dash op = new Dash();
                
                op.setVisible(true);
                this.dispose();
                break;
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
         try{
           JFileChooser jFileChooser = new JFileChooser();
           jFileChooser.showSaveDialog(this);
           File saveFile = jFileChooser.getSelectedFile();
           
           if(saveFile != null){
               saveFile = new File(saveFile.toString()+".xlsx");
               Workbook wb = new XSSFWorkbook();
               Sheet sheet = wb.createSheet("customer");
               
               Row rowCol = sheet.createRow(0);
               for(int i=0;i<rec_list.getColumnCount();i++){
                   Cell cell = rowCol.createCell(i);
                   cell.setCellValue(rec_list.getColumnName(i));
               }
               
               for(int j=0;j<rec_list.getRowCount();j++){
                   Row row = sheet.createRow(j+1);
                   for(int k=0;k<rec_list.getColumnCount();k++){
                       Cell cell = row.createCell(k);
                       if(rec_list.getValueAt(j, k)!=null){
                           cell.setCellValue(rec_list.getValueAt(j, k).toString());
                       }
                   }
               }
               FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
               wb.write(out);
               wb.close();
               out.close();
               openFile(saveFile.toString());
               addLogs(""+ses.getName()+" Records Exported to Excel");
               
           }else{
               JOptionPane.showMessageDialog(null,"Error al generar archivo");
           }
       }catch(FileNotFoundException e){
           System.out.println(e);
       }catch(IOException io){
           System.out.println(io);
       }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void detsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detsActionPerformed
          try {
        String st;
        if (filter.getSelectedItem().equals("Students")) {
            st = "student";   
 
                ResultSet res = db.getData("SELECT * FROM records WHERE date = '" + dets.getSelectedItem() + "' "
                        + "AND reference_type = '" + st + "' "
                        + "AND pos = '" + type.getSelectedItem() + "' "
                        + "AND pos_type = '" + section.getSelectedItem() + "'");

                DefaultTableModel tblmod = (DefaultTableModel) rec_list.getModel();
                tblmod.setRowCount(0);

                while (res.next()) {
                    String id = String.valueOf(res.getString("reference_id"));
                    String tag = res.getString("tags");
                    String last = res.getString("last");
                    String mid = res.getString("mid");
                    String first = res.getString("name");
                    String posi = res.getString("pos_type");
                    String pos = res.getString("pos");
                    String tmin = res.getString("time_in");
                    String tmout = res.getString("time_out");
                    String date = res.getString("date");

                    String table[] = {id, tag, last, mid, first, pos, posi, tmin, tmout, date};
                    tblmod.addRow(table);
                }
             
            
        } else if (filter.getSelectedItem().equals("Teachers/Staff")) {
            st = "stake";
            ResultSet res = db.getData("SELECT * FROM records WHERE date = '" + dets.getSelectedItem() + "' "
                    + "AND reference_type = '" + st + "' AND pos_type = '"+type.getSelectedItem()+"'");

            DefaultTableModel tblmod = (DefaultTableModel) rec_list.getModel();
            tblmod.setRowCount(0);

            while (res.next()) {
                String id = String.valueOf(res.getString("reference_id"));
                String tag = res.getString("tags");
                String last = res.getString("last");
                String mid = res.getString("mid");
                String first = res.getString("name");
                String posi = res.getString("pos_type");
                String pos = res.getString("pos");
                String tmin = res.getString("time_in");
                String tmout = res.getString("time_out");
                String date = res.getString("date");

                String table[] = {id, tag, last, mid, first, pos, posi, tmin, tmout, date};
                tblmod.addRow(table);
            }
        } else {
            ResultSet res = db.getData("SELECT * FROM records WHERE date = '" + dets.getSelectedItem() + "'");

            DefaultTableModel tblmod = (DefaultTableModel) rec_list.getModel();
            tblmod.setRowCount(0);

            while (res.next()) {
                String id = String.valueOf(res.getString("reference_id"));
                String tag = res.getString("tags");
                String last = res.getString("last");
                String mid = res.getString("mid");
                String first = res.getString("name");
                String posi = res.getString("pos_type");
                String pos = res.getString("pos");
                String tmin = res.getString("time_in");
                String tmout = res.getString("time_out");
                String date = res.getString("date");

                String table[] = {id, tag, last, mid, first, pos, posi, tmin, tmout, date};
                tblmod.addRow(table);
            }
        }

    } catch (SQLException ex) {
        Logger.getLogger(records.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    }//GEN-LAST:event_detsActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void sectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sectionActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       TablePrinter pr = new TablePrinter(rec_list,"ATTENDANCE SHEET");
       pr.print();        
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new records().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> dets;
    private javax.swing.JComboBox<String> filter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable rec_list;
    private javax.swing.JComboBox<String> section;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
