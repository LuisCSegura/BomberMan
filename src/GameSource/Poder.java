/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameSource;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author LuisKa
 */
public class Poder {

    private int poder;
    private int x;
    private int y;
    private Bloque bloque;
    private boolean estado;
    private int contTiempo;
    
    public Poder(int poder, int x, int y, Bloque bloque) {
        this.poder = poder;
        this.x = x;
        this.y = y;
        this.bloque = bloque;
        estado = true;
        contTiempo = 0;

    }


    /**
     * pinta las caracteristicas de un poder segun su tipo
     *
     * @param g componente grafico
     */
    public void pintar(Graphics g) {
        
        if (estado) {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, 50, 50);
            g.setColor(new Color(230, 210, 0));
            g.fillRect(x + 2, y, 43, 47);
            g.fillRect(x, y + 2, 47, 43);
            g.setColor(Color.BLACK);
            g.fillRect(x + 4, y + 3, 39, 41);
            g.fillRect(x + 3, y + 4, 41, 39);
            g.setColor(new Color(120, 120, 0));
            g.fillRect(x + 6, y + 6, 37, 38);
            g.fillRect(x + 6, y + 6, 38, 37);

            switch (poder) {
                case 1:
//                    SPEED
                    g.setColor(Color.BLACK);
                    g.fillRect(x + 27, y + 6, 14, 3);
                    g.fillRect(x + 24, y + 9, 17, 3);
                    g.fillRect(x + 21, y + 12, 23, 17);
                    g.fillRect(x + 15, y + 15, 6, 3);
                    g.fillRect(x + 6, y + 18, 16, 11);
                    g.fillOval(x + 5, y + 28, 16, 16);
                    g.fillOval(x + 28, y + 28, 16, 16);
                    g.setColor(new Color(230, 210, 0));
                    g.fillRect(x + 24, y + 6, 14, 3);
                    g.fillRect(x + 21, y + 9, 17, 3);
                    g.fillRect(x + 18, y + 12, 23, 14);
                    g.fillRect(x + 12, y + 15, 6, 3);
                    g.fillRect(x + 6, y + 18, 13, 8);
                    g.fillOval(x + 5, y + 28, 13, 13);
                    g.fillOval(x + 28, y + 28, 13, 13);
                    g.setColor(Color.BLACK);
                    g.fillRect(x + 27, y + 6, 3, 3);
                    g.fillRect(x + 24, y + 9, 3, 3);
                    g.fillRect(x + 21, y + 12, 3, 3);
                    g.fillRect(x + 18, y + 15, 3, 3);
                    g.fillOval(x + 7, y + 30, 9, 9);
                    g.fillOval(x + 30, y + 30, 9, 9);
                    g.setColor(new Color(120, 120, 0));
                    g.fillOval(x + 10, y + 33, 5, 5);
                    g.fillOval(x + 33, y + 33, 5, 5);
                    break;
                case 2:
//                    BOMBS
                    g.setColor(Color.BLACK);
                    g.fillOval(x + 14, y + 11, 24, 27);
                    g.fillOval(x + 14, y + 14, 24, 27);
                    g.fillOval(x + 11, y + 14, 24, 27);
                    g.fillRect(x + 21, y + 9, 16, 6);
                    g.setColor(new Color(230, 210, 0));
                    g.fillOval(x + 11, y + 11, 24, 27);
                    g.fillRect(x + 21, y + 9, 13, 3);

                    break;
                case 3:
//                    DETONATOR
                    g.setColor(Color.BLACK);
                    int[] xsSombra = {x + 6, x + 6, x + 12, x + 21, x + 26, x + 26, x + 32, x + 41, x + 44, x + 44, x + 27, x + 25, x + 22};
                    int[] ysSombra = {y + 24, y + 12, y + 6, y + 6, y + 12, y + 12, y + 6, y + 6, y + 9, y + 27, y + 44, y + 44, y + 39};
                    g.fillPolygon(xsSombra, ysSombra, xsSombra.length);
                    g.setColor(new Color(230, 210, 0));
                    int[] xsCorazon = {x + 6, x + 6, x + 12, x + 18, x + 23, x + 26, x + 32, x + 38, x + 44, x + 44, x + 27, x + 23};
                    int[] ysCorazon = {y + 23, y + 12, y + 6, y + 6, y + 12, y + 12, y + 6, y + 6, y + 12, y + 23, y + 40, y + 40};
                    g.fillPolygon(xsCorazon, ysCorazon, xsCorazon.length);
                    g.setColor(Color.BLACK);
                    g.fillOval(x + 15, y + 17, 15, 15);
                    g.fillRect(x + 26, y + 15, 6, 3);
                    g.setColor(new Color(230, 210, 0));
                    g.fillArc(x + 18, y + 20, 9, 9, 90, 90);
                    g.setColor(Color.BLACK);
                    g.fillOval(x + 20, y + 22, 5, 5);
                    break;
                case 4:
//                    FLAMES
                    g.setColor(Color.BLACK);
                    int[] xsFlamaSombra = {x + 15, x + 9, x + 9, x + 18, x + 25, x + 35, x + 44, x + 44, x + 32, x + 27, x + 27, x + 34, 
                        x + 41, x + 44, x + 44, x + 42, x + 39, x + 39, x + 44, x + 44, x + 39, x + 40, x + 32};
                    int[] ysFlamaSombra = {y + 44, y + 37, y + 21, y + 12, y + 12, y + 6, y + 6, y + 11, y + 21, y + 19, y + 19, y + 19, 
                        y + 12, y + 12, y + 22, y + 22, y + 25, y + 27, y + 27, y + 36, y + 36, y + 36, y + 44};
                    g.fillPolygon(xsFlamaSombra, ysFlamaSombra, xsFlamaSombra.length);
                    g.setColor(new Color(230, 210, 0));
                    int[] xsFlama = {x + 16, x + 9, x + 9, x + 18, x + 25, x + 35, x + 41, x + 41, x + 32, x + 27, x + 27, x + 34, 
                        x + 41, x + 44, x + 44, x + 41, x + 35, x + 35, x + 44, x + 44, x + 39, x + 39, x + 31};
                    int[] ysFlama = {y + 41, y + 33, y + 21, y + 12, y + 12, y + 6, y + 6, y + 7, y + 16, y + 16, y + 19, y + 19, 
                        y + 12, y + 12, y + 18, y + 18, y + 24, y + 27, y + 27, y + 32, y + 32, y + 33, y + 41};
                    g.fillPolygon(xsFlama, ysFlama, xsFlama.length);
                    g.setColor(Color.BLACK);
                    g.fillRect(x + 14, y + 22, 3, 7);
                    g.fillRect(x + 20, y + 22, 3, 7);
                    g.fillRect(x + 14, y + 32, 12, 3);
                    g.fillRect(x + 26, y + 29, 3, 3);
                    g.fillRect(x + 25, y + 30, 3, 3);
                    g.fillRect(x + 24, y + 31, 3, 3);
                    break;
                case 5:
//                    WALLPASS
                    g.setColor(Color.BLACK);
                    g.fillRect(x+12, y+6, 15, 9);
                    g.fillRect(x+15, y+12, 9, 6);
                    g.fillRect(x+6, y+18, 9, 6);
                    g.fillRect(x+6, y+15, 6, 3);
                    g.fillRect(x+21, y+15, 12, 6);
                    g.fillRect(x+27, y+18, 6, 6);
                    g.fillRect(x+15, y+18, 12, 12);
                    g.fillRect(x+12, y+24, 6, 12);
                    g.fillRect(x+6, y+30, 9, 6);
                    g.fillRect(x+21, y+27, 12, 9);
                    g.fillRect(x+27, y+33, 6, 11);
                    g.fillRect(x+24, y+9, 20, 6);
                    g.fillRect(x+24, y+15, 20, 6);
                    g.fillRect(x+30, y+21, 14, 6);
                    g.fillRect(x+30, y+27, 14, 6);
                    g.fillRect(x+33, y+36, 11, 8);
                    g.setColor(new Color(230, 210, 0));
                    g.fillRect(x+12, y+6, 12, 6);
                    g.fillRect(x+15, y+12, 6, 6);
                    g.fillRect(x+6, y+18, 9, 3);
                    g.fillRect(x+6, y+15, 3, 3);
                    g.fillRect(x+21, y+15, 9, 3);
                    g.fillRect(x+27, y+18, 3, 3);
                    g.fillRect(x+15, y+18, 9, 9);
                    g.fillRect(x+12, y+24, 3, 9);
                    g.fillRect(x+6, y+30, 6, 3);
                    g.fillRect(x+21, y+27, 9, 6);
                    g.fillRect(x+27, y+33, 3, 7);
                    g.fillRect(x+24, y+9, 20, 3);
                    g.fillRect(x+24, y+15, 20, 3);
                    g.fillRect(x+30, y+21, 14, 3);
                    g.fillRect(x+30, y+27, 14, 3);
                    g.fillRect(x+33, y+36, 11, 3);
                    
                    break;
                case 6:
//                    BOMBPASS
                    g.setColor(Color.BLACK);
                    g.fillOval(x + 11, y + 11, 18, 21);
                    g.fillOval(x + 11, y + 14, 18, 21);
                    g.fillOval(x + 8, y + 14, 18, 21);
                    g.fillRect(x + 20, y + 6, 7, 6);
                    g.fillRect(x + 16, y + 9, 7, 6);
                    g.fillRect(x + 22, y + 9, 22, 6);
                    g.fillRect(x + 24, y + 15, 20, 6);
                    g.fillRect(x + 24, y + 21, 20, 6);
                    g.fillRect(x + 30, y + 27, 14, 6);
                    g.setColor(new Color(230, 210, 0));
                    g.fillOval(x + 8, y + 11, 18, 21);
                    g.fillRect(x + 20, y + 6, 4, 3);
                    g.fillRect(x + 16, y + 9, 4, 3);
                    g.fillRect(x + 27, y + 9, 17, 3);
                    g.fillRect(x + 24, y + 15, 20, 3);
                    g.fillRect(x + 24, y + 21, 20, 3);
                    g.fillRect(x + 30, y + 27, 14, 3);
                    
                    
                    break;
                default:
                    break;
            }

        }

    }
    public void mover(){
        if (estado) {
            if (bloque.getTipo() == 0) {
                contTiempo += 10;
            }
            if (contTiempo >= 10000) {
                estado = false;
                contTiempo = 0;
            }
        }
    }

    /**
     * obtiene un rectngulo en la poscicion y tamaño del poder
     *
     * @return rectangulo
     */
    public Rectangle getBonds() {
        return new Rectangle(x + 3, y + 3, 44, 44);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getPoder() {
        return poder;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isEstado() {
        return estado;
    }

}
