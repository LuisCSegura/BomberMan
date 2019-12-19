/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameSource;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author louis
 */
public class Util {
    public static Font obtFuente(String nombreArchivo,int tamanno) {
        try {
            InputStream myStream = new BufferedInputStream(new FileInputStream("src/GameSource/fonts/"+nombreArchivo));
            Font fuente = Font.createFont(Font.TRUETYPE_FONT, myStream);
            fuente = fuente.deriveFont(Font.PLAIN, tamanno);
            return fuente;
        } catch (FontFormatException ex) {
            System.out.println("ERROR de formato");
        } catch (IOException ex) {
            System.out.println("ERROR de entrada");
        }
        return null;
    }
}
