/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication20;

import admin.Dash;
import config.dbconnector;
import config.smsSender;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import user.user_dash;

/**
 *
 * @author entac
 */
public final class attendance extends javax.swing.JFrame {

    /**
     * Creates new form attendance
     */
    
  
            ;   
    public String action;
    String pic1path = "";
    String oldpath = "";
    
    public attendance() {
        setUndecorated(true);
        initComponents();
        
        Action escAction = new AbstractAction() {
        @Override
            public void actionPerformed(ActionEvent e) {
              switch(action){
                  case "login":
                      Login lg = new Login();
                      
                      lg.setVisible(true);
                      dispose();
                      
                      break;
                      
                  case "dash" :
                      Dash dh = new Dash();
                      
                      dh.setVisible(true);
                      dispose();
                      
                      break;
                      
                      
              }
                
            }
        };
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Escape_pressed");
        this.getRootPane().getActionMap().put("Escape_pressed", escAction);
        
          
        setFocusable(true);
        tag.requestFocus();
        time();
        RunningJLabel();
        date();
        
      
        
    } 
    
     int seconds;
   
    public void tagTimer(){
        seconds = 3;
        
        Timer count = new Timer(1000, (ActionEvent e) -> {
            
            tag.setEnabled(false);
            seconds--;
            
        });
        count.setRepeats(true);
        
        Timer timer = new Timer(4000, (ActionEvent e) -> {
            
            tag.setEnabled(true);
            tag.requestFocus();
            count.stop();
        });
        timer.setRepeats(false);
        
        
        count.start();
        timer.start();
    }
    
      
   
    
    int xCoordinate;
    int yCoordinate;
    
     public void RunningJLabel() {
      
        xCoordinate = 0; // Start from the left
        yCoordinate = getContentPane().getHeight() -30; // Start from the bottom
        
        move.setBounds(xCoordinate, yCoordinate, 400, 30);
        move.setText("WELCOME CECILIANS, ALLEVO!!!");
        Timer timer = new Timer(50, (ActionEvent e) -> {
            xCoordinate += 2; // Change the increment value to control the speed
            move.setBounds(xCoordinate, yCoordinate, 400, 30);
            if (xCoordinate >= getContentPane().getWidth()) {
                xCoordinate = -400; // Reset position when JLabel moves out of JFrame
            }
        });
        timer.start();
    }


    
 
    
    private void date(){
        
        Date d = new Date();
        
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
         
        String dt = sdf.format(d);
        date.setText(dt);
             
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
                time.setText(tm);
                
            }
        });
        
        t.start();
        
    }
        public static int getHeightFromWidth(ImageIcon imageIcon, int desiredWidth) {
        // Get the original width and height of the image
        int originalWidth = imageIcon.getIconWidth();
        int originalHeight = imageIcon.getIconHeight();

        // Calculate the new height based on the desired width and the aspect ratio
        int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
        return newHeight;
}

        public ImageIcon ResizeImage(ImageIcon imageIcon, JLabel label) {
            if (imageIcon == null) {
                return null; // Handle null case
            }

            int newHeight = getHeightFromWidth(imageIcon, label.getWidth());

            // Scale the image to fit the label's width while maintaining aspect ratio
            Image img = imageIcon.getImage();
            Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
            return new ImageIcon(newImg);
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
        pic = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        grade = new javax.swing.JLabel();
        attend = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        pos = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pic3 = new javax.swing.JLabel();
        pic2 = new javax.swing.JLabel();
        pic1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tag = new javax.swing.JTextField();
        move = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setText("Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, -1));

        pic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 240, 220));

        name.setFont(new java.awt.Font("DialogInput", 1, 28)); // NOI18N
        name.setText("0");
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, -1, -1));

        grade.setFont(new java.awt.Font("DialogInput", 1, 28)); // NOI18N
        grade.setText("0");
        jPanel1.add(grade, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, -1, -1));

        attend.setFont(new java.awt.Font("DialogInput", 1, 28)); // NOI18N
        attend.setText("0");
        jPanel1.add(attend, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, -1, -1));

        id.setFont(new java.awt.Font("DialogInput", 1, 28)); // NOI18N
        id.setText("0");
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, -1));

        date.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        date.setText("0");
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, -1, -1));

        time.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        time.setText("0");
        jPanel1.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));

        pos.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        pos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pos.setText("<html><body>0</body></html>");
        jPanel1.add(pos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 200, 120));

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel4.setText("Status:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, -1));

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel5.setText("ID:");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        pic3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(pic3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 390, 160, 130));

        pic2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(pic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 160, 130));

        pic1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(pic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, 160, 130));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/final1.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 530));

        tag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tagActionPerformed(evt);
            }
        });
        jPanel1.add(tag, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 170, 20));

        move.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        move.setForeground(new java.awt.Color(204, 0, 0));
        move.setText("0");
        jPanel1.add(move, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 30, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tagActionPerformed
       dbconnector db = new dbconnector();
       smsSender sms = new smsSender();
       
        try {
              ResultSet res = db.getData("SELECT COALESCE(s_name,name) AS all_name,\n" +
                                    "COALESCE(s_last,last) AS all_last,\n" +
                                    "COALESCE(s_mi,mid) AS all_mid,\n" +
                                    "COALESCE(s_pic,pic) AS all_pic,\n" +
                                    "COALESCE(lvl,pos_type) AS all_type,\n" +
                                    "COALESCE(s_id,id) AS all_id,\n" +
                                    "COALESCE(s_tag,tag) AS all_tag, \n" +
                                    "COALESCE(s_mobile) AS mobile, \n" +
                                    "COALESCE(s_identification, identification) AS all_identity \n" +
                                    "FROM (SELECT * FROM tbl_stake s LEFT OUTER JOIN tbl_students st ON s.id = st.s_id\n" +
                                    "LEFT JOIN tbl_gradelvl grd ON grd.num = st.s_gradesec \n" +
                                    "UNION\n" +
                                    "SELECT * FROM tbl_stake s RIGHT OUTER JOIN tbl_students st ON s.id = st.s_id \n" +
                                    "LEFT JOIN tbl_gradelvl grd ON grd.num = st.s_gradesec) AS combined_data\n" +
                                    "WHERE s_tag= '"+tag.getText()+"' OR tag = '"+tag.getText()+"'");

                 if(res.next()){
                    String n = res.getString("all_name");
                    String l = res.getString("all_last"); 
                    String m = res.getString("all_mid");   
                    name.setText(l + ", " + n + " " + m);

                    ImageIcon[] previousImages = new ImageIcon[3];
                    previousImages[0] = (ImageIcon) pic.getIcon();
                    previousImages[1] = (ImageIcon) pic1.getIcon();
                    previousImages[2] = (ImageIcon) pic2.getIcon();

                    ImageIcon newImageIcon = ResizeImage(new ImageIcon(res.getString("all_pic")), pic);
                    pic.setIcon(newImageIcon);

                    pic1.setIcon(ResizeImage(previousImages[0], pic1));
                    pic2.setIcon(ResizeImage(previousImages[1], pic2));
                    pic3.setIcon(ResizeImage(previousImages[2], pic3));

                    grade.setText(res.getString("all_type"));
                    id.setText(res.getString("all_id"));
                  
                    String choose = res.getString("all_identity");
                    
                    switch(choose){
                        case "stake":
                            
                        ResultSet stakeRec = db.getData("SELECT * FROM tbl_records WHERE stake_id = '"+res.getString("all_id")+"' AND time_out IS NULL");
                        
                        if(stakeRec.next()){
                            db.update("UPDATE tbl_records SET time_out = CURRENT_TIMESTAMP WHERE stake_id = '"+res.getString("all_id")+"'",false);
                            attend.setText("Log Out");    
                            tag.setText("");
                        }else{
                            db.insertData("INSERT INTO tbl_records (stake_id, date,time_in,time_out)"
                                    + "VALUES('"+res.getString("all_id")+"',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,NULL)");
                            attend.setText("Log In");
                            
                            Thread smsThread = new Thread(() -> {
                                
                            sms.initialize();
                            
                             try {
                                 sms.sendSMS(res.getString("mobile"), "Student Log In");
                             } catch (SQLException ex) {
                                 Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null, ex);
                             }
                            sms.close();
                            });
                        
                            smsThread.start();
            
                            
                            
                            tag.setText("");
                        }
                        pos.setText("Position");
                        
                        break;
                        
                        case "student":
                        ResultSet studRec = db.getData("SELECT * FROM tbl_records WHERE student_id = '"+res.getString("all_id")+"' AND time_out IS NULL");
                        
                        if(studRec.next()){
                            db.update("UPDATE tbl_records SET time_out = CURRENT_TIMESTAMP WHERE student_id = '"+res.getString("all_id")+"'",false);
                            attend.setText("Log Out");
                            
                            Thread smsThread = new Thread(() -> {
                                
                            sms.initialize();
                            
                             try {
                                 sms.sendSMS(res.getString("mobile"), "Student Log Out");
                             } catch (SQLException ex) {
                                 Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null, ex);
                             }
                             
                           
                             sms.close();
                            
                             });
                             smsThread.start();
                            
                            
                            
                            tag.setText("");
                            
                        }else{
                            db.insertData("INSERT INTO tbl_records (student_id, date,time_in,time_out)"
                                    + "VALUES('"+res.getString("all_id")+"',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,NULL)");
                            attend.setText("Log In");
                            
                            
                            Thread smsThread = new Thread(() -> {
                                
                            sms.initialize();
                            
                             try {
                                 sms.sendSMS(res.getString("mobile"), "Student Log In");
                             } catch (SQLException ex) {
                                 Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null, ex);
                             }
                            sms.close();
                            });
                        
                            smsThread.start();
                            
                            
                            
                            tag.setText("");
                        }
                        pos.setText("Grade/Course");
                            
                        break;
                    }
                    

                 }else{
                    id.setText("Not Existed");
                    tag.setText("Not Existed");
                    name.setText("Not Existed");
                    pic.setIcon(null);
                    grade.setText("Not Existed");
                    id.setText("Not Existed");
                    tag.setText("");
                 }
            
            
          } catch (SQLException ex) {
            Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tagActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
     switch(action){
         case "login":
             
             Login op = new Login();
             op.setVisible(true);
             this.dispose();
             
             break;
         case "dash":
             
             
             Dash dsh = new Dash();
             dsh.setVisible(true);
             this.dispose();
             break;
         case "dash_user":
             
             user_dash udh = new user_dash();
             
             udh.setVisible(true);
             this.dispose();
              
             break;
     }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
     
    
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new attendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attend;
    private javax.swing.JLabel date;
    private javax.swing.JLabel grade;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel move;
    private javax.swing.JLabel name;
    private javax.swing.JLabel pic;
    private javax.swing.JLabel pic1;
    private javax.swing.JLabel pic2;
    private javax.swing.JLabel pic3;
    private javax.swing.JLabel pos;
    private javax.swing.JTextField tag;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
