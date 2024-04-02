package admin;

import Students.addstud;
import config.dbconnector;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javaapplication20.*;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Dash extends javax.swing.JFrame {

    Color nav = new Color(204,0,0);
    Color def = new Color(255,0,0);
    
    public Dash() {
        
        initComponents();
        date();
        time();
        name();
    }

 
      private void name(){
        dbconnector db = new dbconnector();
        try{
        Statement stmt = db.connect.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_stake");
        
        while(rs.next()){
           String name = rs.getString("name");
            
           lblname.setText(name);
        }
      }catch(SQLException ex){
            System.out.println("Error");
      }
    }
    
   
   
   
    private void date(){
        
        Date d = new Date();
        
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
         
        String dt = sdf.format(d);
        txtdate.setText(dt);
             
    }
    
        Timer t;
        SimpleDateFormat st;
    
    private void time(){

        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm:ss a");
                
                String tm = st.format(dt);
                txttime.setText(tm);
                
            }
        });
        
        t.start();
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbllogout1 = new javax.swing.JLabel();
        txtdate = new javax.swing.JLabel();
        txttime = new javax.swing.JLabel();
        navdash = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbllogout2 = new javax.swing.JLabel();
        navmanage = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbllogout3 = new javax.swing.JLabel();
        navstud = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbllogout4 = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbllogout1.setBackground(new java.awt.Color(0, 0, 0));
        lbllogout1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lbllogout1.setText("[Log out]");
        lbllogout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllogout1MouseClicked(evt);
            }
        });
        jPanel2.add(lbllogout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 80, -1));

        txtdate.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        txtdate.setText("    jLabel1");
        jPanel2.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 160, -1));

        txttime.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        txttime.setText("    jLabel1");
        jPanel2.add(txttime, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 160, -1));

        navdash.setBackground(new java.awt.Color(255, 0, 0));
        navdash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                navdashMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                navdashMouseExited(evt);
            }
        });
        navdash.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/dash1.png"))); // NOI18N
        navdash.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        lbllogout2.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lbllogout2.setText("Dashboard");
        navdash.add(lbllogout2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 80, 30));

        jPanel2.add(navdash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 210, 30));

        navmanage.setBackground(new java.awt.Color(255, 0, 0));
        navmanage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navmanageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                navmanageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                navmanageMouseExited(evt);
            }
        });
        navmanage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/manage1.png"))); // NOI18N
        navmanage.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        lbllogout3.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lbllogout3.setText("Manage");
        navmanage.add(lbllogout3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 80, 30));

        jPanel2.add(navmanage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 210, 30));

        navstud.setBackground(new java.awt.Color(255, 0, 0));
        navstud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navstudMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                navstudMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                navstudMouseExited(evt);
            }
        });
        navstud.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/studemt1.png"))); // NOI18N
        navstud.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        lbllogout4.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lbllogout4.setText("Students");
        navstud.add(lbllogout4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 80, 30));

        jPanel2.add(navstud, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 210, 30));

        lblname.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lblname.setText("    jLabel1");
        jPanel2.add(lblname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 160, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(942, 489));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbllogout1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogout1MouseClicked
       Login ot = new Login();
        
       int l = JOptionPane.showConfirmDialog(null,"You Sure you want to Log Out?", "Select", JOptionPane.YES_NO_OPTION);
       if(l == 0){
       
           ot.setVisible(true);
           this.dispose();
       }
       
    }//GEN-LAST:event_lbllogout1MouseClicked

    private void navdashMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navdashMouseEntered
       navdash.setBackground(nav);
    }//GEN-LAST:event_navdashMouseEntered

    private void navdashMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navdashMouseExited
        navdash.setBackground(def);
    }//GEN-LAST:event_navdashMouseExited

    private void navmanageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navmanageMouseEntered
        navmanage.setBackground(nav);
    }//GEN-LAST:event_navmanageMouseEntered

    private void navmanageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navmanageMouseExited
         navmanage.setBackground(def);
    }//GEN-LAST:event_navmanageMouseExited

    private void navstudMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navstudMouseEntered
        navstud.setBackground(nav);
    }//GEN-LAST:event_navstudMouseEntered

    private void navstudMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navstudMouseExited
        navstud.setBackground(def);
    }//GEN-LAST:event_navstudMouseExited

    private void navstudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navstudMouseClicked
        addstud op = new addstud();
        op.setVisible(true);
        
    }//GEN-LAST:event_navstudMouseClicked

    private void navmanageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navmanageMouseClicked
        manage op = new manage();
        op.setVisible(true);
    }//GEN-LAST:event_navmanageMouseClicked

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
            java.util.logging.Logger.getLogger(Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbllogout1;
    private javax.swing.JLabel lbllogout2;
    private javax.swing.JLabel lbllogout3;
    private javax.swing.JLabel lbllogout4;
    private javax.swing.JLabel lblname;
    private javax.swing.JPanel navdash;
    private javax.swing.JPanel navmanage;
    private javax.swing.JPanel navstud;
    private javax.swing.JLabel txtdate;
    private javax.swing.JLabel txttime;
    // End of variables declaration//GEN-END:variables
}
