/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.awt.print.PrinterException;
import java.text.MessageFormat;
import javax.swing.JTable;

/**
 *
 * @author entac
 */
public class TablePrinter {

    public JTable tableToPrint;
    public String title;

    public TablePrinter(JTable tableToPrint, String title) {
        this.tableToPrint = tableToPrint;
        this.title = title;
    }

  

    public void print() {
        MessageFormat header = new MessageFormat(title);
        MessageFormat footer = new MessageFormat("Page {0,number,integer}");

        try {
            // Use JTable.PrintMode.FIT_WIDTH to fit the table width to a single page
            tableToPrint.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            System.out.println("Cannot Print Table: " + ex);
        }
    }
}
