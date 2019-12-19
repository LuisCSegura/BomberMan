/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameSource;
import javax.swing.JFrame;
/**
 *
 * @author LuisKa
 */
public class Main {
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        JFrame frm = new JFrame("BomberMan");
        PanelBomberman panel = new PanelBomberman();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.add(panel);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        while (true) {
            frm.repaint();
            Thread.sleep(10);
        }
    }

}
