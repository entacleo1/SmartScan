/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Students;

import admin.*;
import config.dbconnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author entac
 */
public class manage extends javax.swing.JFrame {

    /**
     * Creates new form manage
     */
    
    public dbconnector db = new dbconnector();
    
    public manage() {
        initComponents();
        tb();
        grade();
        
    }
    
    public void grade(){
      
    try{
       ResultSet res = db.getData("SELECT DISTINCT lvl FROM tbl_gradelvl ORDER BY lvl");
       
       while(res.next()){
           String lvl = res.getString("lvl");
           
           gradelvl.addItem(lvl);
       }
    }catch(SQLException ex){
        
        System.out.println("ERROR"+ex.getMessage());
        
    }
      
    }

    
        
    public void tb() {
    try {
        
        ResultSet res = db.getData("SELECT tbl_gradelvl.num, tbl_gradelvl.lvl, tbl_gradelvl.section,"
                         + " COUNT(tbl_students.s_section) as studcount FROM tbl_gradelvl "
                         + "LEFT JOIN tbl_students ON tbl_gradelvl.section = tbl_students.s_section "
                         + "AND tbl_gradelvl.lvl = tbl_students.s_grade " 
                         + "GROUP BY tbl_gradelvl.num, tbl_gradelvl.lvl, tbl_gradelvl.section "
                         + "ORDER BY tbl_gradelvl.lvl, tbl_gradelvl.section");
        
        int overCount = 0;
        
        
        while (res.next()) {
            String num = res.getString("num");
            String lvl = res.getString("lvl");
            String sec = res.getString("section");
            String count = res.getString("studcount");
            
            overCount += Integer.parseInt(count);

            
            
            String[] table = {num, lvl, sec, count};

            DefaultTableModel model = (DefaultTableModel) list.getModel();
            model.addRow(table);
        }
                overstud.setText("Overall Students: " + overCount);

    } catch (SQLException x) {
        System.out.println("Error: " + x.getMessage());
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
        lblback = new javax.swing.JLabel();
        overstud = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        gradelvl = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtsec = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblback.setFont(new java.awt.Font("DialogInput", 0, 11)); // NOI18N
        lblback.setText("[Back]");
        lblback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblbackMouseClicked(evt);
            }
        });
        jPanel1.add(lblback, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, -1, -1));

        overstud.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        overstud.setText("0");
        jPanel1.add(overstud, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 160, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/re.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, -1, 50));

        jLabel3.setText("Section");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        jPanel1.add(gradelvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 140, 30));

        jLabel4.setText("Grade");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));
        jPanel1.add(txtsec, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 170, 30));

        jToggleButton1.setText("Save");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 80, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/class.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel7.setText("Manage Grade & Section");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/delete.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, -1, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/kilid.jpg"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, -1, 110));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Grade Level", "Section", "Num. of Students"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(list);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 510, 320));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/scc.jpg"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -200, 850, -1));

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(866, 457));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbackMouseClicked
        addstud op = new addstud();
        op.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblbackMouseClicked

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        String add = "INSERT INTO tbl_gradelvl (lvl,section) "
                + "VALUES ('"+gradelvl.getSelectedItem()+"','"+txtsec.getText()+"')";
        if(txtsec.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please put a Section");
        }else{
        
            int l = JOptionPane.showConfirmDialog(null,"You Sure You want to Add the section?","Select",
                    JOptionPane.YES_NO_OPTION);
            
            if(l == 0){
           
                db.insertData(add);
                JOptionPane.showMessageDialog(null,"Section Saved");
                txtsec.setText("");
          
            }
           
          
        }
        
    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       DefaultTableModel model = (DefaultTableModel)list.getModel();
       model.setRowCount(0);
       tb();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       int row = list.getSelectedRow();
       
       if(row < 0){
           JOptionPane.showMessageDialog(null,"Please Select");
       }else{
           TableModel mod = list.getModel();
           Object val = mod.getValueAt(row, 0);
           String id = val.toString();
           
           int l = JOptionPane.showConfirmDialog(null, "You Sure you Want to Delete Section?", "Select", JOptionPane.YES_NO_OPTION);
           
           if(l == 0){
               int s_id = Integer.parseInt(id);
               db.delete(s_id,"tbl_gradelvl","num");
           }
           DefaultTableModel def = (DefaultTableModel)list.getModel();
           def.setRowCount(0);
           tb();
           
       }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        
        new studentup().setVisible(true);
       
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> gradelvl;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblback;
    private javax.swing.JTable list;
    private javax.swing.JLabel overstud;
    private javax.swing.JTextField txtsec;
    // End of variables declaration//GEN-END:variables
}