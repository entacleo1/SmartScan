package user;

import admin.*;
import Students.addstud;
import config.dbconnector;
import config.session;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javaapplication20.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class user_dash extends javax.swing.JFrame {

    Color nav = new Color(204,0,0);
    Color def = new Color(255,0,0);
    session ses = session.getInstance();
    
    public user_dash() {
        
        initComponents();
        date();
        time(); 
        
      
    }

   
   


 public void name(String admin){
        lblname.setText(admin);
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
      public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
    
    
    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
    
}
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbllogout1 = new javax.swing.JLabel();
        txtdate = new javax.swing.JLabel();
        txttime = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        picture = new javax.swing.JLabel();
        rec = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbllogout6 = new javax.swing.JLabel();
        navstud1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbllogout5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

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
        jPanel2.add(lbllogout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, -1, -1));

        txtdate.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        txtdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtdate.setText("    jLabel1");
        jPanel2.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 310, -1));

        txttime.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        txttime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttime.setText("    jLabel1");
        jPanel2.add(txttime, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 310, -1));

        lblname.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lblname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblname.setText("0");
        lblname.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblname.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblnameMouseClicked(evt);
            }
        });
        jPanel2.add(lblname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 310, 50));

        picture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(picture, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 120, 100));

        rec.setBackground(new java.awt.Color(255, 0, 0));
        rec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                recMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                recMouseExited(evt);
            }
        });
        rec.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/rec.png"))); // NOI18N
        rec.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        lbllogout6.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lbllogout6.setText("Records");
        rec.add(lbllogout6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 30));

        jPanel2.add(rec, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 310, 30));

        navstud1.setBackground(new java.awt.Color(255, 0, 0));
        navstud1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navstud1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                navstud1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                navstud1MouseExited(evt);
            }
        });
        navstud1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/attedance.png"))); // NOI18N
        navstud1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        lbllogout5.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lbllogout5.setText("Attendance");
        navstud1.add(lbllogout5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 30));

        jPanel2.add(navstud1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 310, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("<html>SMART SCAN revolutionizes attendance tracking at Saint Cecilia's by utilizing RFID technology. This innovative system offers a streamlined approach to monitor the presence of students, teachers, and staff, ensuring precision and reliability. By automating the attendance process, SMART SCAN optimizes administrative tasks and promotes a more efficient educational environment.</html>");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 460, 280));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/rf.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC/scc copy 2.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1096, 557));
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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
        
        if(ses.getId() == 0){
            JOptionPane.showMessageDialog(null,"Empty Account, Please Log In First");
            Login op = new Login();
            
            op.setVisible(true);
            this.dispose();
        }else{
            
            lblname.setText("<html><body><center>"+ses.getLast() +", "+ses.getName() +"</center></body></html>");
            try{
                dbconnector db = new dbconnector();
                
                ResultSet res = db.getData("SELECT * FROM tbl_stake WHERE id = '"+ses.getId()+"'");
                
                if(res.next()){
                    picture.setIcon(ResizeImage(res.getString("pic"),null,picture));
                    
                }
            }catch(SQLException e){
                System.out.println(""+e.getLocalizedMessage());
            }
        }
    }//GEN-LAST:event_formWindowActivated

    private void recMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recMouseClicked
        records op = new records();
        
        op.action = "user";
        op.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_recMouseClicked

    private void recMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recMouseEntered
       rec.setBackground(nav);
    }//GEN-LAST:event_recMouseEntered

    private void recMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recMouseExited
       rec.setBackground(def);
    }//GEN-LAST:event_recMouseExited

    private void lblnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblnameMouseClicked
     
    }//GEN-LAST:event_lblnameMouseClicked

    private void navstud1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navstud1MouseClicked
        attendance op = new attendance();
        op.action = "dash_user";
        op.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_navstud1MouseClicked

    private void navstud1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navstud1MouseEntered
        navstud1.setBackground(nav);
    }//GEN-LAST:event_navstud1MouseEntered

    private void navstud1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navstud1MouseExited
        navstud1.setBackground(def);
    }//GEN-LAST:event_navstud1MouseExited

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
            java.util.logging.Logger.getLogger(user_dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user_dash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbllogout1;
    private javax.swing.JLabel lbllogout5;
    private javax.swing.JLabel lbllogout6;
    public javax.swing.JLabel lblname;
    private javax.swing.JPanel navstud1;
    private javax.swing.JLabel picture;
    private javax.swing.JPanel rec;
    private javax.swing.JLabel txtdate;
    private javax.swing.JLabel txttime;
    // End of variables declaration//GEN-END:variables
}
