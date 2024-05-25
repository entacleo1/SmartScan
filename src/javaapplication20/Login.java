package javaapplication20;

import java.awt.Color;
import admin.*;
import config.dbconnector;
import config.hasher;
import config.session;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import user.user_dash;


public class Login extends javax.swing.JFrame {
    public static dbconnector db = new dbconnector();

    public Login() {
        setUndecorated(true);
        initComponents(); 
    
         addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_F1) {
                   tagTimer();      
                }
            }
        });
             
        setFocusable(true);
        
        addKeyListener(new java.awt.event.KeyAdapter() { 
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_F2) {
                    attendance op = new attendance();
                    op.setVisible(true);
                    op.action = "login";
                    dispose();       
                }
            }
        });
             
        setFocusable(true);
       
    } 
    
    int seconds;
   
    public void tagTimer(){
        seconds = 15;
        txtuser.setEditable(false);
        txtuser.setBackground(new Color(222,225,229));
        txtpass.setEnabled(false);
      
        Timer count = new Timer(1000, (ActionEvent e) -> {
            lbltime.setVisible(true);
            lbltime.setText("You have "+ (seconds) + " seconds to scan Identification Card");
            txttag.requestFocusInWindow();
            if(seconds<=5){
                txttag.setForeground(new Color(255, 97, 126));
            }else{
                txttag.setForeground(new Color(80, 114, 123));
            }
            seconds--;
        });
        count.setRepeats(true);
        
        Timer timer = new Timer(16000, (ActionEvent e) -> {
            lbltime.hide();
            txtuser.requestFocus();
            txtuser.setEditable(true);
            txtuser.setBackground(Color.WHITE);
            txtpass.setEnabled(true);
            count.stop();
        });
        timer.setRepeats(false);
        
        
        count.start();
        timer.start();
    }
    
    private static void createSession(ResultSet res) throws SQLException {
            session ses = session.getInstance();
            ses.setId(res.getInt("id"));
            ses.setName(res.getString("name"));
            ses.setLast(res.getString("last"));
            ses.setTag(res.getString("tag"));
            ses.setUser(res.getString("user"));
            ses.setEmail(res.getString("email"));
            ses.setMid(res.getString("mid"));
            ses.setGender(res.getString("gender"));
            ses.setAdd(res.getString("address"));
            ses.setBday(res.getDate("bod").toString());
            ses.setPic(res.getString("pic"));
            ses.setTag(res.getString("tag"));
            ses.setPos(res.getString("position"));
        }

    
    
  
    public static boolean loginAcc(String user, String pass){
      
        try{
            
            
            String sql = "SELECT * FROM tbl_stake  WHERE user = '" + user + "'";  
            ResultSet res = db.getData(sql);
           
            if(res.next()){
 
            String hashed = res.getString("pass");
            String rehash = hasher.passHash(pass);
                
            if(hashed.equals(rehash)){
            createSession(res);
            return true;

           }
         
            return false;   
                         
            }else{
               
                return false;
            }
        }catch (SQLException ex) {
            return false;
        }

    }
    public static boolean tags(String tag){
        dbconnector connector = new dbconnector();
        try{
            String query = "SELECT * FROM tbl_stake  WHERE tag = '" + tag + "'";
            ResultSet res = connector.getData(query);
              
            if(res.next()){
                createSession(res);
                return true;
            }else{
                return false;
            }
        }catch (SQLException ex) {
            return false;
        }

    }
    
    public static boolean stattag(String tag){
        
        try{
            String sql = "SELECT * FROM tbl_stake  WHERE tag = '"+tag+"' AND status = 'Active'";
            ResultSet res = db.getData(sql);
         
            return res.next();
        }catch (SQLException ex) {
            return false;
        }

    }
    
          
     public static boolean stat(String user){
        
        try{
            String sql = "SELECT * FROM tbl_stake  WHERE user = '"+user+"' AND status = 'Active'";
            ResultSet res = db.getData(sql);
         
            return res.next();
        }catch (SQLException ex) {
            return false;
        }

    }
     public static boolean tagtype(String tag){
        
        try{
            String sql = "SELECT * FROM tbl_stake  WHERE tag = '"+tag+"' AND (position = 'Admin' OR position = 'Super Admin')  ";
            ResultSet resultSet = db.getData(sql);
            return resultSet.next();
        }catch (SQLException ex) {
            return false;
        }

    }
     
     public static boolean type(String user){
        
        try{
            String sql = "SELECT * FROM tbl_stake  WHERE user = '"+user+"' AND (position = 'Admin' OR position = 'Super Admin')  ";
            ResultSet resultSet = db.getData(sql);
            return resultSet.next();
        }catch (SQLException ex) {
            return false;
        }

    }
     
     public static boolean archive(String user){
        
        try{
            String sql = "SELECT * FROM tbl_stake  WHERE user = '"+user+"' AND status = 'Archive'";
            ResultSet res = db.getData(sql);
         
            return res.next();
        }catch (SQLException ex) {
            return false;
        }

    }
     
     public static boolean tagarchive(String user){
        
        try{
            String sql = "SELECT * FROM tbl_stake  WHERE user = '"+user+"' AND status = 'Archive'";
            ResultSet res = db.getData(sql);
         
            return res.next();
        }catch (SQLException ex) {
            return false;
        }

    } 
    
   
    
    Color txt = new Color(153,153,153);
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblexit = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        lbltitle = new javax.swing.JLabel();
        txttag = new javax.swing.JTextField();
        lbltag = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblattend = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        cmdlogin = new javax.swing.JButton();
        lbluspic = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        lbllogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblexit.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblexit.setText("[Exit]");
        lblexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblexitMouseClicked(evt);
            }
        });
        jPanel1.add(lblexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 50, -1));

        lbltime.setBackground(new java.awt.Color(0, 0, 0));
        lbltime.setFont(new java.awt.Font("DialogInput", 1, 10)); // NOI18N
        lbltime.setText("0");
        jPanel1.add(lbltime, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 300, 30));

        lbltitle.setBackground(new java.awt.Color(0, 0, 0));
        lbltitle.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        lbltitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/Smart scan2.png"))); // NOI18N
        jPanel1.add(lbltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 200, 150));

        txttag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttagActionPerformed(evt);
            }
        });
        jPanel1.add(txttag, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 150, 180, 28));

        lbltag.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lbltag.setText("[TAG#]");
        lbltag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbltagMouseClicked(evt);
            }
        });
        jPanel1.add(lbltag, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblattend.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblattend.setText("[Attendance]");
        lblattend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblattendMouseClicked(evt);
            }
        });
        jPanel2.add(lblattend, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassKeyPressed(evt);
            }
        });
        jPanel2.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 196, 29));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/pass.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, 29));

        cmdlogin.setBackground(new java.awt.Color(255, 255, 255));
        cmdlogin.setText("LOGIN");
        cmdlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdloginMouseClicked(evt);
            }
        });
        jPanel2.add(cmdlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 230, 31));

        lbluspic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/username.png"))); // NOI18N
        jPanel2.add(lbluspic, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, 28));
        jPanel2.add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 196, 28));

        lbllogin.setBackground(new java.awt.Color(0, 0, 0));
        lbllogin.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        lbllogin.setText("Admin LogIn");
        jPanel2.add(lbllogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdloginMouseClicked
     
       if(!loginAcc(txtuser.getText(),txtpass.getText())){
            JOptionPane.showMessageDialog(null,"Invalid");
         }else{
           if(stat(txtuser.getText())){
               if(type(txtuser.getText())){
                   Dash op = new Dash();
                   JOptionPane.showMessageDialog(null,"Welcome Admin");
                   op.setVisible(true);
                   this.dispose();
               }else{
                   JOptionPane.showMessageDialog(null, "Welcome User");
                   user_dash ud = new user_dash();
                   ud.setVisible(true);
                   this.dispose();
                   
               }
           }else if(archive(txtuser.getText())){
               JOptionPane.showMessageDialog(null, "Invalid, Please Contact Admin");
           }else{
                JOptionPane.showMessageDialog(null, "Account Pending, Please Contact Admin");
           }
            }
    }//GEN-LAST:event_cmdloginMouseClicked

    private void txtpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyPressed
    
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
             if(!loginAcc(txtuser.getText(),txtpass.getText())){
            JOptionPane.showMessageDialog(null,"Invalid");
         }else{
           if(stat(txtuser.getText())){
               if(type(txtuser.getText())){
                   Dash op = new Dash();
                   JOptionPane.showMessageDialog(null,"Welcome Admin");
                   op.setVisible(true);
                   this.dispose();
               }else{
                   JOptionPane.showMessageDialog(null, "Welcome User");
                   user_dash ud = new user_dash();
                   ud.setVisible(true);
                   this.dispose();
                   
               }
           }else if(archive(txtuser.getText())){
               JOptionPane.showMessageDialog(null, "Invalid, Please Contact Admin");
           }else{
                JOptionPane.showMessageDialog(null, "Account Pending, Please Contact Admin");
           }
            }
        }
       
    }//GEN-LAST:event_txtpassKeyPressed

    private void lblexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblexitMouseClicked
       int l = JOptionPane.showConfirmDialog(null,"You Sure You want to Exit the System?","Select",JOptionPane.YES_NO_OPTION);
       if(l == 0){
           System.exit(0);
       }
    }//GEN-LAST:event_lblexitMouseClicked

    private void lbltagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbltagMouseClicked
       tagTimer();
       
    }//GEN-LAST:event_lbltagMouseClicked

    private void lblattendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblattendMouseClicked
       attendance op = new attendance();
       op.action = "login";
       op.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_lblattendMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        lbltime.hide();
        txtuser.requestFocus();
       
    }//GEN-LAST:event_formWindowActivated

    private void txttagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttagActionPerformed
       if(!tags(txttag.getText())){
            JOptionPane.showMessageDialog(null,"Invalid");
            txttag.setText("");
         }else{
           if(stattag(txttag.getText())){
               if(tagtype(txttag.getText())){
                   Dash op = new Dash();
                   JOptionPane.showMessageDialog(null,"Welcome Admin");
                   op.setVisible(true);
                   this.dispose();
               }else{
                   JOptionPane.showMessageDialog(null, "Welcome User");
                   user_dash ud = new user_dash();
                   ud.setVisible(true);
                   this.dispose();
                   
               }
           }else if(tagarchive(txttag.getText())){
               JOptionPane.showMessageDialog(null, "Invalid, Please Contact Admin");
           }else{
                JOptionPane.showMessageDialog(null, "Account Pending, Please Contact Admin");
           }
            }
    }//GEN-LAST:event_txttagActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblattend;
    private javax.swing.JLabel lblexit;
    private javax.swing.JLabel lbllogin;
    private javax.swing.JLabel lbltag;
    private javax.swing.JLabel lbltime;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JLabel lbluspic;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txttag;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
