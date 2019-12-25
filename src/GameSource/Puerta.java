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
public class Puerta {
    private int x;
    private int y;
    private boolean estado;

    public Puerta(int x, int y) {
        this.x = x;
        this.y = y;
        estado=false;
    }
    /**
     * pinta la puerta en la poscicion 
     * @param g componenete grfico
     */
    public void pintar(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 50, 50);
        g.setColor(new Color(140,30,15));
        g.fillRect(x+2, y+2, 21, 46);
        g.fillRect(x+27, y+2, 21, 46);
        g.setColor(new Color(200,88,33));
        g.fillRect(x+9, y+4, 11, 41);
        g.fillRect(x+29, y+4, 11, 41);
        g.fillRect(x+4, y+9, 6, 31);
        g.fillRect(x+39, y+9, 6, 31);
        g.setColor(new Color(140,30,15));
        g.fillRect(x+10, y+21, 29, 8);
        g.fillRect(x+13, y+8, 3, 3);
        g.fillRect(x+13, y+38, 3, 3);
        g.fillRect(x+33, y+8, 3, 3);
        g.fillRect(x+33, y+38, 3, 3);
        g.setColor(Color.BLACK);
        g.fillRect(x+14, y+18, 3, 14);
        g.fillRect(x+32, y+18, 3, 14);
    } 
    /**
     * obtiene un rectangulo en la poscicion de la puerta
     * @return rectangulo
     */
    public Rectangle getBouns(){
        return new Rectangle(x+3,y+3,44,44);
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
