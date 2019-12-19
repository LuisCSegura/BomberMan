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
public class Bloque {

    private int x;
    private int y;
    private int tipo;
    private int destruccion;

    public Bloque(int x, int y, int tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        destruccion = 0;
    }

    /**
     * pinta todos los componentes de los bloques segun su tipo
     *
     * @param g componente grfico
     */
    public void pintar(Graphics g) {

        if (tipo == 1) {
            g.setColor(new Color(188, 188, 188));
            g.fillRect(x, y, 50, 50);
            g.setColor(Color.BLACK);
            g.fillRect(x + 47, y, 3, 50);
            g.fillRect(x , y+45, 50,5 );
            g.setColor(new Color(240,240,240));
            g.fillRect(x, y, 47, 3);
            g.fillRect(x, y, 3, 46);
        } else if (tipo == 2) {
            g.setColor(new Color(188, 188, 188));
            g.fillRect(x, y, 50, 50);
            g.setColor(new Color(243,243,243));
            g.fillRect(x, y + 3, 50, 3);
            g.fillRect(x, y + 20, 50, 3);
            g.fillRect(x, y, 3, 17);
            g.fillRect(x + 23, y + 17, 3, 16);
            g.fillRect(x, y + 36, 50, 3);
            g.fillRect(x + 33, y + 33, 3, 17);
            g.setColor(Color.BLACK);
            g.fillRect(x, y, 50, 3);
            g.fillRect(x, y + 17, 50, 3);
            g.fillRect(x + 47, y, 3, 17);
            g.fillRect(x + 20, y + 17, 3, 16);
            g.fillRect(x, y + 33, 50, 3);
            g.fillRect(x + 30, y + 33, 3, 17);
            g.fillRect(x, y + 47, 50, 3);
            g.fillRect(x, y + 3, 3, 3);
            g.fillRect(x + 23, y + 20, 3, 3);
            g.fillRect(x + 33, y + 36, 3, 3);
        } else if (tipo == 3) {
            if (destruccion < 80) {
                g.setColor(new Color(252, 116, 96));
                g.fillRect(x, y, 50, 50);
                g.setColor(new Color(252, 188, 176));
                g.fillRect(x, y + 3, 50, 3);
                g.fillRect(x, y + 20, 50, 3);
                g.fillRect(x, y, 3, 17);
                g.fillRect(x + 23, y + 17, 3, 16);
                g.fillRect(x, y + 36, 50, 3);
                g.fillRect(x + 33, y + 33, 3, 17);
                g.setColor(new Color(216, 40, 0));
                g.fillRect(x, y, 50, 3);
                g.fillRect(x, y + 17, 50, 3);
                g.fillRect(x + 47, y, 3, 17);
                g.fillRect(x + 20, y + 17, 3, 16);
                g.fillRect(x, y + 33, 50, 3);
                g.fillRect(x + 30, y + 33, 3, 17);
                g.fillRect(x, y + 47, 50, 3);
                g.fillRect(x, y + 3, 3, 3);
                g.fillRect(x + 23, y + 20, 3, 3);
                g.fillRect(x + 33, y + 36, 3, 3);
            } else if (destruccion < 160) {
                g.setColor(new Color(216, 40, 0));
                g.fillRect(x + 3, y + 6, 44, 11);
                g.fillRect(x + 6, y + 8, 44, 7);
                g.fillRect(x , y + 23, 14, 10);
                g.fillRect(x +3, y + 25, 14, 6);
                g.fillRect(x + 23, y + 23, 27, 10);
                g.fillRect(x , y + 39, 27, 11);
                g.fillRect(x +3, y + 41, 27, 7);
                g.fillRect(x + 36, y + 39, 14,11);
                g.setColor(new Color(252, 188, 176));
                g.fillRect(x + 3, y , 44, 11);
                g.fillRect(x , y+5 , 44, 6);
                g.fillRect(x , y + 17, 14, 10);
                g.fillRect(x + 23, y + 17, 27, 10);
                g.fillRect(x + 20, y + 22, 27, 6);
                g.fillRect(x , y + 33, 27, 11);
                g.fillRect(x + 36, y + 33, 14,11);
                g.fillRect(x + 33, y + 38, 14,7);
                g.setColor(new Color(252, 116, 96));
                g.fillRect(x + 3, y + 3, 44, 11);
                g.fillRect(x + 6, y + 5, 44, 7);
                g.fillRect(x , y + 20, 14, 10);
                g.fillRect(x +3, y + 22, 14, 6);
                g.fillRect(x + 23, y + 20, 27, 10);
                g.fillRect(x , y + 36, 27, 11);
                g.fillRect(x+3 , y + 38, 27, 7);
                g.fillRect(x + 36, y + 36, 14,11);
                
            } else if (destruccion < 240) {
                g.setColor(new Color(216, 40, 0));
                g.fillRect(x + 5, y + 8, 40, 7);
                g.fillRect(x + 8, y + 10, 40, 3);
                g.fillRect(x , y + 25, 12, 6);
                g.fillRect(x +3, y + 26, 12, 2);
                g.fillRect(x + 25, y + 25, 25, 6);
                g.fillRect(x , y + 41, 25, 7);
                g.fillRect(x +3, y + 43, 25, 3);
                g.fillRect(x + 38, y + 41, 12,7);
                g.setColor(new Color(252, 188, 176));
                g.fillRect(x + 5, y +2, 40, 7);
                g.fillRect(x +2, y+7 , 40, 2);
                g.fillRect(x , y + 19, 12, 6);
                g.fillRect(x + 25, y + 19, 25, 6);
                g.fillRect(x + 22, y + 24, 25, 2);
                g.fillRect(x , y + 35, 25, 7);
                g.fillRect(x + 38, y + 35, 12,7);
                g.fillRect(x + 35, y + 40, 12,3);
                g.setColor(new Color(252, 116, 96));
                g.fillRect(x + 5, y + 5, 40, 7);
                g.fillRect(x + 8, y + 7, 40, 3);
                g.fillRect(x , y + 22, 12, 6);
                g.fillRect(x +3, y + 24, 12, 2);
                g.fillRect(x + 25, y + 22, 25, 6);
                g.fillRect(x , y + 38, 25, 7);
                g.fillRect(x+3 , y + 40, 25, 3);
                g.fillRect(x + 38, y + 38, 12,7);
            } else if (destruccion < 320) {
                g.setColor(new Color(216, 40, 0));
                g.fillRect(x + 5, y + 5, 42, 8);
                g.fillRect(x , y + 23, 14, 5);
                g.fillRect(x + 25, y + 26, 25, 2);
                g.fillRect(x , y + 38, 27, 8);
                g.fillRect(x + 38, y + 43, 12,3);
                g.setColor(new Color(252, 188, 176));
                g.fillRect(x + 5, y +4, 40, 3);
                g.fillRect(x , y + 22, 12, 2);
                g.fillRect(x + 25, y + 22, 25, 2);
                g.fillRect(x , y + 37, 25, 3);
                g.fillRect(x + 38, y + 37, 12,3);
                g.setColor(new Color(252, 116, 96));
                g.fillRect(x + 5, y + 7, 40, 3);
                g.fillRect(x , y + 24, 12, 2);
                g.fillRect(x + 25, y + 24, 25, 2);
                g.fillRect(x , y + 40, 25, 3);
                g.fillRect(x + 38, y + 40, 12,3);
            }else if (destruccion<400){
                g.setColor(new Color(216, 40, 0));
                g.fillRect(x + 6, y + 6, 40, 5);
                g.fillRect(x , y + 23, 13, 4);
                g.fillRect(x + 26, y + 25, 24, 2);
                g.fillRect(x , y + 39, 26, 5);
                g.fillRect(x + 39, y + 41, 11,3);
                g.setColor(new Color(252, 188, 176));
                g.fillRect(x + 6, y +6, 38, 3);
                g.fillRect(x , y + 23, 11, 2);
                g.fillRect(x + 26, y + 23, 24, 2);
                g.fillRect(x , y + 39, 24, 3);
                g.fillRect(x + 39, y + 39, 11,3);     
            }else if(destruccion<500){
                g.setColor(new Color(252, 116, 96));
                g.fillRect(x + 12, y + 7, 28, 3);
                g.fillRect(x , y + 24, 9, 2);
                g.fillRect(x + 32, y + 24, 20, 2);
                g.fillRect(x , y + 40, 22, 3);
                
              
            }

        }

    }
    public void mover(){
        if (tipo == 3) {
            destruccion+=10;
            if(destruccion>=500){
                tipo=0;
            }
        }
    }

    /**
     * obtiene un rectangulo en la posccion y tamaño del bloque
     *
     * @return rectangulo
     */
    public Rectangle getBonds() {
        return new Rectangle(x, y, 50, 50);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setDestruccion(int destruccion) {
        this.destruccion = destruccion;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTipo() {
        return tipo;
    }

    public int getDestruccion() {
        return destruccion;
    }

}
