/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Students;

import com.toedter.calendar.JTextFieldDateEditor;
import config.dbconnector;
import config.session;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author entac
 */
public class newstud extends javax.swing.JFrame {

    /**
     * Creates new form newstud
     */
    
    public String gender;
    public String action;
 
    dbconnector con = new dbconnector();
    session ses = session.getInstance();
    
    public newstud() {
        initComponents();
        gradesel();
        id_increment();
        statshow();
    }
    
    public String destination = "";
    File selectedFile;
   
    public String oldpath;
    public String path;
    
       public void addLogs(String action){
        String insertQuery = "INSERT INTO act_logs (stake_id, action) VALUES ("+ses.getId()+", '"+action+"')";
        con.insertData(insertQuery);
    }
    
     private void id_increment(){
        
        try{
       
        ResultSet res = con.getData("SELECT * FROM tbl_students ORDER BY s_id DESC LIMIT 1");
        
        if(res.next()){
            
        int id = res.getInt(1);
        int n = id+1;
        
        txtid.setText(Integer.toString(n));
        
        }
        
        }catch(SQLException e){
                System.out.println(""+e);
      
        }
    } 
     
     private void statshow(){
        
        try{
            ResultSet res = con.getData("SELECT * FROM tbl_stake WHERE position = '"+ses.getPos()+"'");
            
            if(res.next()){
                String posi = res.getString("position");
                
                if(posi.equals("Super Admin")){
                    System.out.println("Revealed");
                }else{
                    stat.hide();
                    txtstat.hide();
                }
            }
        }catch(SQLException e){
            System.out.println(""+e);
        }
    }
    
    public int existcheck(String path){
        File file = new File(path);
        String filename = file.getName();
        
        Path filePath = Paths.get("src/studentpics", filename);
        boolean fileExist = Files.exists(filePath);
        
        if(fileExist){
            return 1;
        }else{
            return 0;
        }
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
        lblback = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txttag = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtlast = new javax.swing.JTextField();
        txtmid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtguard = new javax.swing.JTextField();
        txtmobile = new javax.swing.JTextField();
        txtadd = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        txtbday = new com.toedter.calendar.JDateChooser();
        txtgrade = new javax.swing.JComboBox<>();
        txtsec = new javax.swing.JComboBox<>();
        lblpic = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        choose = new javax.swing.JLabel();
        stat = new javax.swing.JLabel();
        txtstat = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblback.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        lblback.setText("[Back]");
        lblback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblbackMouseClicked(evt);
            }
        });
        jPanel1.add(lblback, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 50, 20));

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel3.setText("Student Entry");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("DOB");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel9.setText("Gender");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel10.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("Grade Level & Section");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, -1, -1));

        jLabel11.setText("Parent/Guardian");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        jLabel12.setText("Mobile #");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, 20));

        lbl.setText("Address");
        jPanel2.add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, -1));

        jLabel4.setText("ID");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel5.setText("Last Name");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel6.setText("M.I");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel13.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("Contact Information");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        jLabel7.setText("First Name");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Basic Information");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setText("RFID Tag#");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel14.setText("Grade Level");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, -1));

        jLabel15.setText("Section");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, -1, 20));
        jPanel2.add(txttag, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 258, 31));

        txtid.setEnabled(false);
        jPanel2.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 258, 29));
        jPanel2.add(txtlast, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 258, 29));
        jPanel2.add(txtmid, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 258, 29));
        jPanel2.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 258, 29));
        jPanel2.add(txtguard, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 247, 31));
        jPanel2.add(txtmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 247, 31));
        jPanel2.add(txtadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 247, 60));

        save.setText("label");
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });
        jPanel2.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 330, 80, -1));

        jButton2.setText("Cancel");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 80, -1));

        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        jPanel2.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        jPanel2.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, -1, -1));

        txtbday.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(txtbday, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 260, 30));

        txtgrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        txtgrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgradeActionPerformed(evt);
            }
        });
        jPanel2.add(txtgrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 200, 30));

        jPanel2.add(txtsec, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 200, 30));

        lblpic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jPanel2.add(lblpic, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, 170, 150));

        jButton1.setText("Browse");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 220, 80, 30));

        choose.setText("0");
        jPanel2.add(choose, new org.netbeans.lib.awtextra.AbsoluteConstraints(784, 40, -1, 0));

        stat.setText("Status");
        jPanel2.add(stat, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, -1, -1));

        txtstat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Active" }));
        jPanel2.add(txtstat, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 280, 190, 30));

        jButton3.setText("Cancel");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void gradesel(){
        try{
           Statement st = con.connect.createStatement();
           ResultSet rs = st.executeQuery("SELECT DISTINCT lvl FROM tbl_gradelvl");
           
           while(rs.next()){
           String grade = rs.getString("lvl");
        
           txtgrade.addItem(grade);
          
           }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
            
    }
    
     public static String tag;
   
    
    private void lblbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbackMouseClicked
      addstud op = new addstud();
      
      op.setVisible(true);
      this.dispose();
      
    }//GEN-LAST:event_lblbackMouseClicked

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
      
        switch (action) {
            case "Add":
                try{
                    ResultSet res = con.getData("SELECT num FROM tbl_gradelvl WHERE lvl = '"+txtgrade.getSelectedItem()+"' AND section = '"+txtsec.getSelectedItem()+"'");
                    
                    if(res.next()){ 
                    String bday = ((JTextFieldDateEditor)txtbday.getDateEditor()).getText();
                    
                   
                    String sql = "INSERT INTO tbl_students(s_tag, s_last, s_mi, s_name,s_gradesec, s_bday, s_gender, s_mobile, s_guard, s_add, s_pic, s_stat,s_identification) "
                            + "VALUES ('"+txttag.getText()+"','"+txtlast.getText()+"','"+txtmid.getText()+"',"
                            + "'"+txtname.getText()+"','"+res.getString("num")+"',"
                            + "'"+bday+"','"+gender+"','"+txtmobile.getText()+"','"+txtguard.getText()+"',"
                            + "'"+txtadd.getText()+"','"+destination+"','"+txtstat.getSelectedItem()+"','student')";
                    
                    Statement stmt = con.connect.createStatement();
                    int row = stmt.executeUpdate(sql);
                    
                    if(row > 0 ){
                        JOptionPane.showMessageDialog(null,"Student Saved");
                        try{
                            Files.copy(selectedFile.toPath(),new File(destination).toPath(),StandardCopyOption.REPLACE_EXISTING);
                        }catch(IOException e){
                              System.out.println(""+e.getLocalizedMessage());
                     
                        }
                        addLogs("" +ses.getName()+ " " + " Added A new Student");
                        txtsec.removeAllItems();
                        txttag.setText("");
                        txtid.setText("");
                        txtlast.setText("");
                        txtmid.setText("");
                        txtname.setText("");
                        txtguard.setText("");
                        txtmobile.setText("");
                        txtadd.setText("");
                    }else{
                        JOptionPane.showMessageDialog(null,"Null");
                    }
                   }
                    
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, ""+ex );
                }       
                
                break;
                
            case "Update":
                
                try{
                
                ResultSet res = con.getData("SELECT num FROM tbl_gradelvl WHERE lvl = '"+txtgrade.getSelectedItem()+"' AND section = '"+txtsec.getSelectedItem()+"'");
                
                if(res.next()){
   
                String bday = ((JTextFieldDateEditor)txtbday.getDateEditor()).getText();
                con.update("UPDATE tbl_students SET  s_tag  ='"+txttag.getText()+"', s_last ='"+txtlast.getText()+"', "
                            + "s_mi  ='"+txtmid.getText()+"', s_name  ='"+txtname.getText()+"',"
                            + " s_gradesec ='"+res.getString("num")+"',"
                            + " s_bday  ='"+bday+"', s_gender  ='"+gender+"',s_mobile  ='"+txtmobile.getText()+"', "
                            + "s_guard  ='"+txtguard.getText()+"', s_add  ='"+txtadd.getText()+"', "
                            + "s_pic = '"+destination+"', s_stat = '"+txtstat.getSelectedItem()+"'"
                            + "WHERE s_id = '"+txtid.getText()+"'");
                addLogs("" +ses.getName()+ " " + " Updated Student " +txtid.getText());
                
                if(destination.isEmpty()){
                    File existing = new File(oldpath);
                    if(existing.exists()){
                        existing.delete();
                    }
                }else{
                    if(!(oldpath.equals(path))){
                        imageUpdater(oldpath,path);
                    }
                }
                
               addstud op = new addstud();
               op.setVisible(true);
               this.dispose();
                
                break;
              }
            }catch(SQLException e){
                        System.out.println("Fail");
            }
               
            
            default:
                JOptionPane.showMessageDialog(null,"No Action Selected");
                break;
                 
        } 
     
    }//GEN-LAST:event_saveMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        addstud op = new addstud();
        
        op.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
       male.setSelected(false);
      
      if(female.isSelected()){
          gender = "Female";
      }else{
          gender = null;
      }
     
    }//GEN-LAST:event_femaleActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
      female.setSelected(false);
      
      if(male.isSelected()){
          gender = "Male";
      }else{
          gender = null;
      }
     
    }//GEN-LAST:event_maleActionPerformed

    private void txtgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgradeActionPerformed
        txtsec.removeAllItems();
         
          try{
        Statement st = con.connect.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM tbl_gradelvl WHERE lvl = '"+txtgrade.getSelectedItem()+"'");
       
       
       while(rs.next()){
           
           String grade = rs.getString("section");
          txtsec.addItem(grade);
           
       }
      }catch(SQLException ex){
           System.out.println("Error");
          
      }

    }//GEN-LAST:event_txtgradeActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/studentpics/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(existcheck(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            lblpic.setIcon(ResizeImage(path, null, lblpic));
                            jButton1.setEnabled(true);
                            
                            
                        }
                    } catch (HeadlessException ex) {
                        System.out.println("File Error!");
                    }
                }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        lblpic.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_jButton3MouseClicked

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
            java.util.logging.Logger.getLogger(newstud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newstud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newstud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newstud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newstud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel choose;
    public javax.swing.JRadioButton female;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblback;
    public javax.swing.JLabel lblpic;
    public javax.swing.JRadioButton male;
    public javax.swing.JButton save;
    private javax.swing.JLabel stat;
    public javax.swing.JTextField txtadd;
    public com.toedter.calendar.JDateChooser txtbday;
    public javax.swing.JComboBox<String> txtgrade;
    public javax.swing.JTextField txtguard;
    public javax.swing.JTextField txtid;
    public javax.swing.JTextField txtlast;
    public javax.swing.JTextField txtmid;
    public javax.swing.JTextField txtmobile;
    public javax.swing.JTextField txtname;
    public javax.swing.JComboBox<String> txtsec;
    private javax.swing.JComboBox<String> txtstat;
    public javax.swing.JTextField txttag;
    // End of variables declaration//GEN-END:variables
}
