/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author entac
 */
public class excelExport {
    
    session ses = session.getInstance();
    
       
     public void openFile(String file){
         try{
             File path = new File(file);
             Desktop.getDesktop().open(path);
             
         }catch(IOException e ){
             System.out.println(""+e);
         }
     }
  public void export(DefaultTableModel list) {
    try {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showSaveDialog(null);
        File saveFile = jFileChooser.getSelectedFile();
        
        if (saveFile != null) {
            // Ensure file extension is .xlsx
            if (!saveFile.getAbsolutePath().endsWith(".xlsx")) {
                saveFile = new File(saveFile.toString() + ".xlsx");
            }
            
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("customer");
            
            // Create header row
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < list.getColumnCount(); i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(list.getColumnName(i));
            }
            
            // Populate data rows
            for (int j = 0; j < list.getRowCount(); j++) {
                Row dataRow = sheet.createRow(j + 1);
                for (int k = 0; k < list.getColumnCount(); k++) {
                    Cell cell = dataRow.createCell(k);
                    Object value = list.getValueAt(j, k);
                    if (value != null) {
                        cell.setCellValue(value.toString());
                    }
                }
            }
            
            // Write to file
            try (FileOutputStream out = new FileOutputStream(saveFile)) {
                wb.write(out);
            }
            
            // Open file using desktop
            openFile(saveFile.getAbsolutePath());
        } else {
            JOptionPane.showMessageDialog(null, "No file selected.");
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error exporting data to Excel file: " + e.getMessage());
    }
}



}
