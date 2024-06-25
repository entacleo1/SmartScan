/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import jssc.SerialPort;
import jssc.SerialPortException;

/**
 *
 * @author entac
 */
public class smsSender {
 
   private static final String PORT_NAME = "COM3";
    private SerialPort serialPort;

    public void initialize() {
        serialPort = new SerialPort(PORT_NAME);
        try {
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
        } catch (SerialPortException ex) {
            System.out.println("Error initializing the serial port: " + ex);
        }
    }

    public void sendSMS(String phoneNumber, String message) {
        try {
            sendCommand("AT\r");
            Thread.sleep(1000);
            sendCommand("AT+CMGF=1\r");
            Thread.sleep(1000);
            sendCommand("AT+CMGS=\"" + phoneNumber + "\"\r");
            Thread.sleep(1000);
            sendCommand(message + "\r");
            Thread.sleep(1000);
            serialPort.writeByte((byte) 26); 
            Thread.sleep(1000);
        } catch (Exception e) {
            System.err.println("Error sending SMS: " + e);
        }
    }

    private void sendCommand(String command) throws SerialPortException {
        serialPort.writeBytes(command.getBytes());
    }

    public void close() {
        try {
            if (serialPort != null) {
                serialPort.closePort();
            }
        } catch (SerialPortException ex) {
            System.out.println("Error closing the serial port: " + ex);
        }
    }
}
