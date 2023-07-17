/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decompressor.compressor;
import comp_decompressor.decompressor;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author FAROOQUE
 */
public class AppFrame extends JFrame implements ActionListener{
    
    JButton compressButton;
    JButton decompressButton;
          
     AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(164, 225, 255));
        this.setLayout(null);
        
        
        compressButton = new JButton("Select file to compress");
        compressButton.setBounds(600, 200, 200, 50);
        compressButton.addActionListener((ActionListener) this);
        compressButton.setBackground(new Color(165, 184, 193));
        compressButton.setForeground(Color.BLACK);
        compressButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(compressButton);
        
        decompressButton = new JButton("Select file to decompress");
        decompressButton.setBounds(600, 300, 200, 50);
        decompressButton.addActionListener((ActionListener) this);
        decompressButton.setBackground(new Color(165, 184, 193));
        decompressButton.setForeground(Color.BLACK);
        decompressButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(decompressButton);
        
        this.setSize(1000, 500);
//        this.getContentPane().setBackground(Color.magenta;
        this.setVisible(true);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser filechooser = new JFileChooser();
            int response =filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response =filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}