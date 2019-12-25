/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameSource;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author LuisKa
 */
public class Enemigo {

    private int x;
    private int y;
    private int nivel;
    private int estado;
    private int velocidad;
    private int direccion;
    private int contPasos;
    private int puntos;
    private int relentizador;
    private boolean directOjos;
    private boolean capDeMoverse;
    private int contMuerte;
    private int contDer;
    private int contIzq;
    private Font fuentePuntaje;

    public Enemigo(int x, int y, int nivel) {
        this.x = x;
        this.y = y;
        this.nivel = nivel;
        estado = 1;
        direccion = 0;
        contPasos = 0;
        contMuerte = 0;
        contDer = 0;
        contIzq = 0;
        directOjos = false;
        capDeMoverse = true;
        relentizador=0;
        switch (nivel) {
            case 1:
                velocidad = 1;
                puntos = 100;
                break;
            case 2:
                velocidad = 1;
                puntos = 1000;
                break;
            default:
                velocidad = 1;
                puntos = 2000;
                break;
        }
        fuentePuntaje=Util.obtFuente("HYPERBLASTER.ttf", 25);

    }

    /**
     * *
     * pinta todas las carecteristicas grficas de cada tipode enemigo y su
     * estado
     *
     * @param g componente grfico
     */
    public void pintar(Graphics g) {
        if (estado == 1) {
            if (nivel == 1) {
                if (contPasos <= 150 || (contPasos > 300 && contPasos <= 450)) {
                    g.setColor(Color.BLACK);
                    g.fillOval(x + 4, y, 42, 43);
                    g.fillOval(x + 3, y - 1, 44, 37);
                    g.fillRect(x + 20, y + 42, 10, 7);
                    g.setColor(new Color(252, 116, 96));
                    g.fillOval(x + 7, y + 3, 36, 37);
                    g.fillOval(x + 6, y + 2, 38, 31);
                    g.fillRect(x + 23, y + 40, 4, 5);
                    g.setColor(Color.white);
                    g.fillRect(x + 23, y + 43, 4, 3);
                    g.fillRect(x + 16, y + 17, 6, 10);
                    g.fillRect(x + 28, y + 17, 6, 10);
                    g.setColor(Color.BLACK);
                    if (!directOjos) {
                        g.fillRect(x + 16, y + 20, 3, 7);
                        g.fillRect(x + 28, y + 20, 3, 7);
                    } else {
                        g.fillRect(x + 19, y + 20, 3, 7);
                        g.fillRect(x + 31, y + 20, 3, 7);
                    }
                    g.fillRect(x + 22, y + 33, 6, 4);
                } else if (contPasos <= 300) {

                    g.setColor(Color.BLACK);
                    g.fillOval(x + 2, y + 3, 46, 39);
                    g.fillOval(x + 1, y + 1, 48, 35);
                    g.fillRect(x + 20, y + 40, 10, 7);
                    g.setColor(new Color(252, 116, 96));
                    g.fillOval(x + 5, y + 6, 40, 33);
                    g.fillOval(x + 4, y + 4, 42, 29);
                    g.fillRect(x + 23, y + 38, 4, 5);
                    g.setColor(Color.white);
                    g.fillRect(x + 23, y + 41, 4, 3);
                    g.fillRect(x + 16, y + 17, 6, 10);
                    g.fillRect(x + 28, y + 17, 6, 10);
                    g.setColor(Color.BLACK);
                    if (!directOjos) {
                        g.fillRect(x + 16, y + 20, 3, 7);
                        g.fillRect(x + 28, y + 20, 3, 7);
                    } else {
                        g.fillRect(x + 19, y + 20, 3, 7);
                        g.fillRect(x + 31, y + 20, 3, 7);
                    }
                    g.fillRect(x + 22, y + 33, 6, 4);
                } else if (contPasos <= 600) {
                    g.setColor(Color.BLACK);
                    g.fillRect(x + 14, y + 1, 22, 4);
                    g.fillRect(x + 16, y, 18, 2);
                    int[] xsCuerpoSombra = {x + 5, x + 4, x + 4, x + 5, x + 12, x + 38, x + 44, x + 46, x + 46, x + 44, x + 27, x + 23};
                    int[] ysCuerpoSombra = {y + 29, y + 27, y + 11, y + 9, y + 2, y + 2, y + 8, y + 12, y + 26, y + 30, y + 47, y + 47};
                    g.fillPolygon(xsCuerpoSombra, ysCuerpoSombra, xsCuerpoSombra.length);
                    g.fillRect(x + 20, y + 43, 10, 7);
                    g.setColor(new Color(252, 116, 96));
                    g.fillRect(x + 16, y + 4, 18, 1);
                    g.fillRect(x + 18, y + 3, 14, 1);
                    int[] xsCuerpo = {x + 8, x + 7, x + 7, x + 8, x + 14, x + 36, x + 41, x + 43, x + 43, x + 41, x + 25};
                    int[] ysCuerpo = {y + 27, y + 25, y + 13, y + 11, y + 5, y + 5, y + 10, y + 14, y + 24, y + 28, y + 44};
                    g.fillPolygon(xsCuerpo, ysCuerpo, xsCuerpo.length);
                    g.fillRect(x + 23, y + 41, 4, 5);
                    g.setColor(Color.white);
                    g.fillRect(x + 23, y + 44, 4, 3);
                    g.fillRect(x + 16, y + 15, 6, 10);
                    g.fillRect(x + 28, y + 15, 6, 10);
                    g.setColor(Color.BLACK);
                    if (!directOjos) {
                        g.fillRect(x + 16, y + 18, 3, 7);
                        g.fillRect(x + 28, y + 18, 3, 7);
                    } else {
                        g.fillRect(x + 19, y + 18, 3, 7);
                        g.fillRect(x + 31, y + 18, 3, 7);
                    }
                    g.fillRect(x + 22, y + 31, 6, 4);
                }

            } else if (nivel == 2) {

                if (!directOjos) {
                    if (contPasos <= 150 || (contPasos > 300 && contPasos <= 450)) {
                        g.setColor(Color.BLACK);
                        g.fillRoundRect(x + 4, y + 4, 40, 42, 10, 10);
                        g.fillRoundRect(x + 1, y + 1, 22, 24, 10, 10);
                        g.fillRoundRect(x + 28, y + 1, 14, 9, 5, 5);
                        g.fillRoundRect(x + 16, y + 40, 14, 9, 12, 12);
                        g.fillRoundRect(x + 35, y + 28, 14, 21, 15, 15);
                        g.fillRect(x + 34, y + 11, 12, 24);
                        g.fillRect(x + 34, y + 13, 14, 6);
                        g.setColor(new Color(13, 188, 255));
                        g.fillRoundRect(x + 6, y + 6, 36, 38, 10, 10);
                        g.fillRoundRect(x + 3, y + 3, 18, 20, 10, 10);
                        g.fillRoundRect(x + 30, y + 3, 10, 5, 5, 5);
                        g.fillRoundRect(x + 18, y + 42, 10, 5, 12, 12);
                        g.fillRoundRect(x + 37, y + 30, 10, 17, 15, 15);
                        g.fillRect(x + 36, y + 13, 8, 20);
                        g.fillRect(x + 36, y + 15, 10, 2);
                        g.setColor(Color.white);
                        g.fillRect(x + 26, y + 6, 2, 2);
                        g.fillRect(x + 28, y + 8, 2, 6);
                        g.fillRect(x + 42, y + 13, 2, 5);
                        g.fillRect(x + 39, y + 26, 2, 5);
                        g.fillRect(x + 41, y + 31, 2, 8);
                        g.fillRect(x + 16, y + 20, 6, 9);
                        g.fillRect(x + 25, y + 20, 6, 9);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 16, y + 22, 3, 7);
                        g.fillRect(x + 25, y + 22, 3, 7);
                        g.fillRect(x + 19, y + 35, 6, 3);
                    } else if (contPasos <= 300) {
                        g.setColor(Color.BLACK);
                        g.fillRoundRect(x + 4, y + 4, 42, 42, 10, 10);
                        g.fillRoundRect(x + 1, y + 1, 25, 20, 10, 10);
                        g.fillRoundRect(x + 28, y + 1, 20, 12, 10, 10);
                        g.fillRoundRect(x + 20, y + 40, 16, 9, 12, 12);
                        g.fillRoundRect(x + 35, y + 14, 14, 16, 15, 15);
                        g.fillRoundRect(x + 1, y + 25, 14, 17, 15, 15);
                        g.setColor(new Color(13, 188, 255));
                        g.fillRoundRect(x + 6, y + 6, 38, 38, 10, 10);
                        g.fillRoundRect(x + 3, y + 3, 21, 16, 10, 10);
                        g.fillRoundRect(x + 30, y + 3, 16, 8, 10, 10);
                        g.fillRoundRect(x + 22, y + 42, 12, 5, 12, 12);
                        g.fillRoundRect(x + 37, y + 16, 10, 12, 15, 15);
                        g.fillRoundRect(x + 3, y + 27, 10, 13, 15, 15);
                        g.setColor(Color.white);
                        g.fillRect(x + 37, y + 4, 4, 2);
                        g.fillRect(x + 26, y + 6, 2, 2);
                        g.fillRect(x + 28, y + 8, 2, 6);
                        g.fillRect(x + 42, y + 13, 2, 5);
                        g.fillRect(x + 39, y + 26, 2, 5);
                        g.fillRect(x + 41, y + 31, 2, 8);
                        g.fillRect(x + 16, y + 20, 6, 9);
                        g.fillRect(x + 25, y + 20, 6, 9);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 16, y + 22, 3, 7);
                        g.fillRect(x + 25, y + 22, 3, 7);
                        g.fillRect(x + 19, y + 35, 6, 6);

                    } else if (contPasos <= 600) {
                        g.setColor(Color.BLACK);
                        g.fillRoundRect(x + 4, y + 9, 42, 34, 10, 10);
                        g.fillRoundRect(x + 4, y + 6, 32, 20, 10, 10);
                        g.fillRoundRect(x + 38, y + 6, 11, 15, 10, 10);
                        g.fillOval(x + 13, y, 20, 23);
                        g.fillRoundRect(x + 31, y + 26, 18, 23, 16, 16);
                        g.fillOval(x, y + 24, 32, 25);
                        g.setColor(new Color(13, 188, 255));
                        g.fillRoundRect(x + 6, y + 11, 38, 30, 10, 10);
                        g.fillRoundRect(x + 6, y + 8, 28, 16, 10, 10);
                        g.fillRoundRect(x + 40, y + 8, 7, 11, 10, 10);
                        g.fillOval(x + 15, y + 2, 16, 19);
                        g.fillRoundRect(x + 33, y + 28, 14, 19, 16, 16);
                        g.fillOval(x + 2, y + 26, 28, 21);
                        g.setColor(Color.white);

                        g.fillRect(x + 26, y + 6, 2, 2);
                        g.fillRect(x + 28, y + 8, 2, 6);
                        g.fillRect(x + 42, y + 13, 2, 5);
                        g.fillRect(x + 39, y + 26, 2, 5);
                        g.fillRect(x + 41, y + 31, 2, 8);
                        g.fillRect(x + 16, y + 20, 6, 9);
                        g.fillRect(x + 25, y + 20, 6, 9);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 16, y + 22, 3, 7);
                        g.fillRect(x + 25, y + 22, 3, 7);
                        g.fillRect(x + 19, y + 35, 6, 6);

                    }
                } else {
                    if (contPasos <= 150 || (contPasos > 300 && contPasos <= 450)) {
                        g.setColor(Color.BLACK);
                        g.fillRoundRect(x + 6, y + 4, 40, 42, 10, 10);
                        g.fillRoundRect(x + 27, y + 1, 22, 24, 10, 10);
                        g.fillRoundRect(x + 8, y + 1, 14, 9, 5, 5);
                        g.fillRoundRect(x + 20, y + 40, 14, 9, 12, 12);
                        g.fillRoundRect(x + 1, y + 28, 14, 21, 15, 15);
                        g.fillRect(x + 4, y + 11, 12, 24);
                        g.fillRect(x + 2, y + 13, 14, 6);
                        g.setColor(new Color(13, 188, 255));
                        g.fillRoundRect(x + 8, y + 6, 36, 38, 10, 10);
                        g.fillRoundRect(x + 29, y + 3, 18, 20, 10, 10);
                        g.fillRoundRect(x + 10, y + 3, 10, 5, 5, 5);
                        g.fillRoundRect(x + 22, y + 42, 10, 5, 12, 12);
                        g.fillRoundRect(x + 3, y + 30, 10, 17, 15, 15);
                        g.fillRect(x + 6, y + 13, 8, 20);
                        g.fillRect(x + 4, y + 15, 10, 2);
                        g.setColor(Color.white);
                        g.fillRect(x + 22, y + 6, 2, 2);
                        g.fillRect(x + 20, y + 8, 2, 6);
                        g.fillRect(x + 6, y + 13, 2, 5);
                        g.fillRect(x + 9, y + 26, 2, 5);
                        g.fillRect(x + 7, y + 31, 2, 8);
                        g.fillRect(x + 28, y + 20, 6, 9);
                        g.fillRect(x + 19, y + 20, 6, 9);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 31, y + 22, 3, 7);
                        g.fillRect(x + 22, y + 22, 3, 7);
                        g.fillRect(x + 25, y + 35, 6, 3);
                    } else if (contPasos <= 300) {
                        g.setColor(Color.BLACK);
                        g.fillRoundRect(x + 4, y + 4, 42, 42, 10, 10);
                        g.fillRoundRect(x + 24, y + 1, 25, 20, 10, 10);
                        g.fillRoundRect(x + 2, y + 1, 20, 12, 10, 10);
                        g.fillRoundRect(x + 14, y + 40, 16, 9, 12, 12);
                        g.fillRoundRect(x + 1, y + 14, 14, 16, 15, 15);
                        g.fillRoundRect(x + 35, y + 25, 14, 17, 15, 15);
                        g.setColor(new Color(13, 188, 255));
                        g.fillRoundRect(x + 6, y + 6, 38, 38, 10, 10);
                        g.fillRoundRect(x + 26, y + 3, 21, 16, 10, 10);
                        g.fillRoundRect(x + 4, y + 3, 16, 8, 10, 10);
                        g.fillRoundRect(x + 16, y + 42, 12, 5, 12, 12);
                        g.fillRoundRect(x + 3, y + 16, 10, 12, 15, 15);
                        g.fillRoundRect(x + 37, y + 27, 10, 13, 15, 15);
                        g.setColor(Color.white);
                        g.fillRect(x + 9, y + 4, 4, 2);
                        g.fillRect(x + 22, y + 6, 2, 2);
                        g.fillRect(x + 20, y + 8, 2, 6);
                        g.fillRect(x + 6, y + 13, 2, 5);
                        g.fillRect(x + 9, y + 26, 2, 5);
                        g.fillRect(x + 7, y + 31, 2, 8);
                        g.fillRect(x + 28, y + 20, 6, 9);
                        g.fillRect(x + 19, y + 20, 6, 9);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 31, y + 22, 3, 7);
                        g.fillRect(x + 22, y + 22, 3, 7);
                        g.fillRect(x + 25, y + 35, 6, 6);

                    } else if (contPasos <= 600) {
                        g.setColor(Color.BLACK);
                        g.fillRoundRect(x + 4, y + 9, 42, 34, 10, 10);
                        g.fillRoundRect(x + 14, y + 6, 32, 20, 10, 10);
                        g.fillRoundRect(x + 1, y + 6, 11, 15, 10, 10);
                        g.fillOval(x + 17, y, 20, 23);
                        g.fillRoundRect(x + 1, y + 26, 18, 23, 16, 16);
                        g.fillOval(x + 18, y + 24, 32, 25);
                        g.setColor(new Color(13, 188, 255));
                        g.fillRoundRect(x + 6, y + 11, 38, 30, 10, 10);
                        g.fillRoundRect(x + 16, y + 8, 28, 16, 10, 10);
                        g.fillRoundRect(x + 3, y + 8, 7, 11, 10, 10);
                        g.fillOval(x + 19, y + 2, 16, 19);
                        g.fillRoundRect(x + 3, y + 28, 14, 19, 16, 16);
                        g.fillOval(x + 20, y + 26, 28, 21);
                        g.setColor(Color.white);
                        g.fillRect(x + 22, y + 6, 2, 2);
                        g.fillRect(x + 20, y + 8, 2, 6);
                        g.fillRect(x + 6, y + 13, 2, 5);
                        g.fillRect(x + 9, y + 26, 2, 5);
                        g.fillRect(x + 7, y + 31, 2, 8);
                        g.fillRect(x + 28, y + 20, 6, 9);
                        g.fillRect(x + 19, y + 20, 6, 9);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 31, y + 22, 3, 7);
                        g.fillRect(x + 22, y + 22, 3, 7);
                        g.fillRect(x + 25, y + 35, 6, 6);

                    }
                }

            } else if (nivel == 3) {
                if (contPasos <= 150 || (contPasos > 300 && contPasos <= 450)) {
                    g.setColor(Color.BLACK);
                    g.fillRect(x + 7, y + 16, 36, 30);
                    g.fillOval(x + 6, y, 37, 39);
                    g.fillRoundRect(x + 10, y + 33, 16, 16, 8, 8);
                    g.fillRoundRect(x + 24, y + 33, 16, 16, 8, 8);
                    g.fillRect(x + 6, y + 40, 10, 7);
                    g.fillRect(x + 4, y + 40, 10, 5);
                    g.fillRect(x + 34, y + 40, 10, 7);
                    g.fillRect(x + 36, y + 40, 10, 5);
                    g.setColor(new Color(220, 0, 100));
                    g.fillRect(x + 10, y + 18, 30, 26);
                    g.fillOval(x + 9, y + 3, 31, 33);
                    g.fillRoundRect(x + 13, y + 36, 10, 10, 8, 8);
                    g.fillRoundRect(x + 27, y + 36, 10, 10, 8, 8);
                    g.fillRect(x + 9, y + 42, 4, 2);
                    g.fillRect(x + 7, y + 42, 4, 1);
                    g.fillRect(x + 37, y + 42, 4, 2);
                    g.fillRect(x + 39, y + 42, 4, 1);
                    if (!directOjos) {
                        g.setColor(Color.white);
                        g.fillRect(x + 19, y + 17, 6, 9);
                        g.fillRect(x + 28, y + 17, 6, 9);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 19, y + 20, 3, 7);
                        g.fillRect(x + 28, y + 20, 3, 7);
                        g.fillArc(x + 19, y + 26, 15, 13, 180, 180);
                    } else {
                        g.setColor(Color.white);
                        g.fillRect(x + 16, y + 17, 6, 9);
                        g.fillRect(x + 25, y + 17, 6, 9);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 19, y + 20, 3, 7);
                        g.fillRect(x + 28, y + 20, 3, 7);
                        g.fillArc(x + 16, y + 26, 15, 13, 180, 180);

                    }
                } else if (contPasos <= 300) {

                    if (!directOjos) {
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 7, y + 16, 36, 30);
                        g.fillOval(x + 6, y, 37, 39);
                        g.fillRoundRect(x + 30, y + 38, 16, 11, 10, 10);
                        g.fillRoundRect(x + 18, y + 38, 13, 11, 10, 10);
                        g.fillRoundRect(x + 4, y + 38, 13, 11, 10, 10);
                        g.setColor(new Color(220, 0, 100));
                        g.fillRect(x + 10, y + 18, 30, 26);
                        g.fillOval(x + 9, y + 3, 31, 33);
                        g.fillRoundRect(x + 33, y + 41, 10, 5, 10, 10);
                        g.fillRoundRect(x + 21, y + 41, 7, 5, 10, 10);
                        g.fillRoundRect(x + 20, y + 42, 9, 3, 10, 10);
                        g.fillRoundRect(x + 7, y + 41, 7, 5, 10, 10);
                        g.fillRoundRect(x + 6, y + 42, 9, 3, 10, 10);
                        g.setColor(Color.white);
                        g.fillRect(x + 19, y + 17, 6, 9);
                        g.fillRect(x + 28, y + 17, 6, 9);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 19, y + 20, 3, 7);
                        g.fillRect(x + 28, y + 20, 3, 7);
                        g.fillArc(x + 19, y + 26, 15, 13, 180, 180);
                    } else {
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 7, y + 16, 36, 30);
                        g.fillOval(x + 6, y, 37, 39);
                        g.fillRoundRect(x + 4, y + 38, 16, 11, 10, 10);
                        g.fillRoundRect(x + 19, y + 38, 13, 11, 10, 10);
                        g.fillRoundRect(x + 33, y + 38, 13, 11, 10, 10);
                        g.setColor(new Color(220, 0, 100));
                        g.fillRect(x + 10, y + 18, 30, 26);
                        g.fillOval(x + 9, y + 3, 31, 33);
                        g.fillRoundRect(x + 7, y + 41, 10, 5, 10, 10);
                        g.fillRoundRect(x + 22, y + 41, 7, 5, 10, 10);
                        g.fillRoundRect(x + 21, y + 42, 9, 3, 10, 10);
                        g.fillRoundRect(x + 36, y + 41, 7, 5, 10, 10);
                        g.fillRoundRect(x + 35, y + 42, 9, 3, 10, 10);
                        g.setColor(Color.white);
                        g.fillRect(x + 16, y + 17, 6, 9);
                        g.fillRect(x + 25, y + 17, 6, 9);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 19, y + 20, 3, 7);
                        g.fillRect(x + 28, y + 20, 3, 7);
                        g.fillArc(x + 16, y + 26, 15, 13, 180, 180);

                    }
                } else if (contPasos <= 600) {
                    if (!directOjos) {
                        g.setColor(Color.BLACK);
                        g.fillOval(x, y, 39, 39);
                        int[] xsCuerpoSombra = {x + 4, x + 16, x + 25, x + 27, x + 26, x + 28, x + 40, x + 50, x + 42, x + 38};
                        int[] ysCuerpoSombra = {y + 31, y + 46, y + 46, y + 43, y + 43, y + 46, y + 46, y + 33, y + 24, y + 15};
                        g.fillPolygon(xsCuerpoSombra, ysCuerpoSombra, xsCuerpoSombra.length);
                        g.setColor(new Color(220, 0, 100));
                        g.fillOval(x + 3, y + 3, 33, 33);
                        int[] xsCuerpo = {x + 8, x + 18, x + 23, x + 25, x + 28, x + 30, x + 38, x + 46, x + 40, x + 35};
                        int[] ysCuerpo = {y + 31, y + 43, y + 43, y + 40, y + 40, y + 43, y + 43, y + 33, y + 27, y + 15};
                        g.fillPolygon(xsCuerpo, ysCuerpo, xsCuerpo.length);
                        g.setColor(Color.white);
                        g.fillRect(x + 13, y + 16, 6, 9);
                        g.fillRect(x + 22, y + 16, 6, 9);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 13, y + 19, 3, 7);
                        g.fillRect(x + 22, y + 19, 3, 7);
                    } else {
                        g.setColor(Color.BLACK);
                        g.fillOval(x + 11, y, 39, 39);
                        int[] xsCuerpoSombra = {x + 46, x + 34, x + 25, x + 23, x + 24, x + 22, x + 10, x, x + 8, x + 12};
                        int[] ysCuerpoSombra = {y + 31, y + 46, y + 46, y + 43, y + 43, y + 46, y + 46, y + 33, y + 24, y + 15};
                        g.fillPolygon(xsCuerpoSombra, ysCuerpoSombra, xsCuerpoSombra.length);
                        g.setColor(new Color(220, 0, 100));
                        g.fillOval(x + 14, y + 3, 33, 33);
                        int[] xsCuerpo = {x + 42, x + 32, x + 27, x + 25, x + 22, x + 20, x + 12, x + 4, x + 10, x + 15};
                        int[] ysCuerpo = {y + 31, y + 43, y + 43, y + 40, y + 40, y + 43, y + 43, y + 33, y + 27, y + 15};
                        g.fillPolygon(xsCuerpo, ysCuerpo, xsCuerpo.length);
                        g.setColor(Color.white);
                        g.fillRect(x + 31, y + 16, 6, 9);
                        g.fillRect(x + 22, y + 16, 6, 9);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 34, y + 19, 3, 7);
                        g.fillRect(x + 25, y + 19, 3, 7);
                    }
                }

            }

        } else if (estado == 2) {
            if (contMuerte < 1000) {
                switch (nivel) {
                    case 1:
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 14, y + 1, 22, 4);
                        g.fillRect(x + 16, y, 18, 2);
                        int[] xsCuerpoSombra = {x + 5, x + 4, x + 4, x + 5, x + 12, x + 38, x + 44, x + 46, x + 46, x + 44, x + 27, x + 23};
                        int[] ysCuerpoSombra = {y + 29, y + 27, y + 11, y + 9, y + 2, y + 2, y + 8, y + 12, y + 26, y + 30, y + 47, y + 47};
                        g.fillPolygon(xsCuerpoSombra, ysCuerpoSombra, xsCuerpoSombra.length);
                        g.fillRect(x + 20, y + 43, 10, 7);
                        g.setColor(new Color(252, 116, 96));
                        g.fillRect(x + 16, y + 4, 18, 1);
                        g.fillRect(x + 18, y + 3, 14, 1);
                        int[] xsCuerpo = {x + 8, x + 7, x + 7, x + 8, x + 14, x + 36, x + 41, x + 43, x + 43, x + 41, x + 25};
                        int[] ysCuerpo = {y + 27, y + 25, y + 13, y + 11, y + 5, y + 5, y + 10, y + 14, y + 24, y + 28, y + 44};
                        g.fillPolygon(xsCuerpo, ysCuerpo, xsCuerpo.length);
                        g.fillRect(x + 23, y + 41, 4, 5);
                        g.setColor(Color.white);
                        g.fillRect(x + 23, y + 44, 4, 3);
                        g.fillRect(x + 13, y + 12, 9, 12);
                        g.fillRect(x + 28, y + 12, 9, 12);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 13, y + 9, 3, 3);
                        g.fillRect(x + 19, y + 9, 3, 3);
                        g.fillRect(x + 28, y + 9, 3, 3);
                        g.fillRect(x + 34, y + 9, 3, 3);
                        g.fillRect(x + 16, y + 15, 3, 6);
                        g.fillRect(x + 31, y + 15, 3, 6);
                        g.fillArc(x + 18, y + 17, 14, 21, 180, 180);
                        break;
                    case 2:
                        g.setColor(Color.BLACK);
                        g.fillRoundRect(x + 4, y + 4, 42, 42, 10, 10);
                        g.fillRoundRect(x + 4, y + 1, 10, 48, 4, 4);
                        g.fillRoundRect(x + 33, y + 1, 12, 48, 4, 4);
                        g.fillRoundRect(x + 16, y + 1, 14, 9, 5, 5);
                        g.fillRoundRect(x + 14, y + 40, 10, 9, 10, 10);
                        g.fillRoundRect(x + 22, y + 40, 10, 9, 10, 10);
                        g.fillRoundRect(x + 1, y + 4, 48, 11, 10, 10);
                        g.fillRoundRect(x + 1, y + 16, 48, 15, 10, 10);
                        g.fillRoundRect(x + 1, y + 33, 48, 11, 10, 10);
                        g.setColor(new Color(13, 188, 255));
                        g.fillRoundRect(x + 6, y + 6, 38, 38, 10, 10);
                        g.fillRoundRect(x + 6, y + 3, 6, 44, 4, 4);
                        g.fillRoundRect(x + 35, y + 3, 8, 44, 4, 4);
                        g.fillRoundRect(x + 18, y + 3, 10, 5, 5, 5);
                        g.fillRoundRect(x + 16, y + 42, 6, 5, 10, 10);
                        g.fillRoundRect(x + 24, y + 42, 6, 5, 10, 10);
                        g.fillRoundRect(x + 3, y + 6, 44, 7, 10, 10);
                        g.fillRoundRect(x + 3, y + 18, 44, 11, 10, 10);
                        g.fillRoundRect(x + 3, y + 35, 44, 7, 10, 10);
                        g.setColor(Color.white);
                        g.fillRect(x + 37, y + 4, 4, 2);
                        g.fillRect(x + 42, y + 13, 2, 5);
                        g.fillRect(x + 39, y + 26, 2, 5);
                        g.fillRect(x + 41, y + 31, 2, 8);
                        g.fillRect(x + 13, y + 12, 9, 15);
                        g.fillRect(x + 25, y + 12, 9, 15);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 16, y + 15, 3, 6);
                        g.fillRect(x + 28, y + 15, 3, 6);
                        g.fillRect(x + 21, y + 38, 5, 6);
                        g.fillOval(x + 15, y + 30, 16, 13);
                        break;
                    default:
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 7, y + 16, 36, 30);
                        g.fillOval(x + 6, y, 37, 39);
                        g.fillRect(x + 4, y + 39, 14, 10);
                        g.fillRect(x + 20, y + 39, 11, 10);
                        g.fillRect(x + 35, y + 39, 11, 10);

                        g.setColor(new Color(220, 0, 100));
                        g.fillRect(x + 10, y + 18, 30, 26);
                        g.fillOval(x + 9, y + 3, 31, 33);
                        g.fillRect(x + 7, y + 42, 8, 4);
                        g.fillRect(x + 23, y + 42, 5, 4);
                        g.fillRect(x + 38, y + 42, 5, 4);

                        g.setColor(Color.white);
                        g.fillRect(x + 13, y + 13, 9, 12);
                        g.fillRect(x + 28, y + 13, 9, 12);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 16, y + 16, 3, 6);
                        g.fillRect(x + 31, y + 16, 3, 6);
                        g.fillOval(x + 18, y + 28, 14, 14);
                        break;
                }
            } else if (contMuerte < 1150) {
                g.setColor(Color.BLACK);
                int[] xsMuerteSombra = {x + 6, x + 17, x + 44, x + 33};
                int[] ysMuerteSombra1 = {y + 14, y + 2, y + 36, y + 48};
                int[] ysMuerteSombra2 = {y + 36, y + 48, y + 14, y + 2};
                g.fillPolygon(xsMuerteSombra, ysMuerteSombra1, xsMuerteSombra.length);
                g.fillPolygon(xsMuerteSombra, ysMuerteSombra2, xsMuerteSombra.length);
                g.fillRect(x + 11, y + 11, 28, 28);
                g.setColor(new Color(252, 116, 96));
                int[] xsMuerte = {x + 10, x + 17, x + 40, x + 33};
                int[] ysMuerte1 = {y + 14, y + 6, y + 36, y + 44};
                int[] ysMuerte2 = {y + 36, y + 44, y + 14, y + 6};
                g.fillPolygon(xsMuerte, ysMuerte1, xsMuerte.length);
                g.fillPolygon(xsMuerte, ysMuerte2, xsMuerte.length);
                g.fillRect(x + 14, y + 14, 22, 22);
                g.setColor(Color.white);
                g.fillRect(x + 14, y + 14, 8, 12);
                g.fillRect(x + 28, y + 14, 8, 12);
                g.setColor(Color.BLACK);
                g.fillRect(x + 17, y + 20, 2, 3);
                g.fillRect(x + 31, y + 20, 2, 3);
                g.fillArc(x + 19, y + 26, 12, 18, 0, 180);

            } else if (contMuerte < 1300) {

                g.setColor(new Color(252, 116, 96));
                int[] xsMuerte = {x + 12, x + 18, x + 38, x + 32};
                int[] ysMuerte1 = {y + 15, y + 8, y + 35, y + 42};
                int[] ysMuerte2 = {y + 35, y + 42, y + 15, y + 8};
                g.fillPolygon(xsMuerte, ysMuerte1, xsMuerte.length);
                g.fillPolygon(xsMuerte, ysMuerte2, xsMuerte.length);
                g.fillRect(x + 20, y + 15, 10, 20);
                g.setColor(Color.white);
                int[] xsOjos1 = {x + 14, x + 22, x + 22, x + 20, x + 14};
                int[] xsOjos2 = {x + 36, x + 28, x + 28, x + 30, x + 36};
                int[] ysOjos = {y + 14, y + 14, y + 26, y + 26, y + 17};
                g.fillPolygon(xsOjos1, ysOjos, xsOjos1.length);
                g.fillPolygon(xsOjos2, ysOjos, xsOjos2.length);
                g.setColor(Color.BLACK);
                g.fillRect(x + 20, y + 17, 2, 3);
                g.fillRect(x + 28, y + 17, 2, 3);
                g.fillArc(x + 19, y + 26, 12, 14, 0, 180);

            } else if (contMuerte < 1450) {
                g.setColor(new Color(252, 116, 96));
                int[] xsMuerte = {x + 16, x + 16, x + 34, x + 34};
                int[] ysMuerte1 = {y + 17, y + 10, y + 33, y + 40};
                int[] ysMuerte2 = {y + 33, y + 40, y + 17, y + 10};
                g.fillPolygon(xsMuerte, ysMuerte1, xsMuerte.length);
                g.fillPolygon(xsMuerte, ysMuerte2, xsMuerte.length);
                g.fillRect(x + 20, y + 18, 10, 14);
                g.setColor(Color.white);
                int[] xsOjos1 = {x + 16, x + 22, x + 22, x + 16};
                int[] xsOjos2 = {x + 34, x + 28, x + 28, x + 34};
                int[] ysOjos = {y + 15, y + 15, y + 26, y + 17};
                g.fillPolygon(xsOjos1, ysOjos, xsOjos1.length);
                g.fillPolygon(xsOjos2, ysOjos, xsOjos2.length);
                g.setColor(Color.BLACK);
                g.fillRect(x + 20, y + 18, 2, 3);
                g.fillRect(x + 28, y + 18, 2, 3);
                g.fillRect(x + 22, y + 26, 6, 4);

            } else if (contMuerte < 1700) {
                g.setColor(new Color(252, 116, 96));
                g.drawLine(x + 14, y + 14, x + 20, y + 17);
                g.drawLine(x + 14, y + 15, x + 20, y + 18);
                g.drawLine(x + 14, y + 16, x + 20, y + 19);
                g.drawLine(x + 14, y + 17, x + 20, y + 20);
                g.drawLine(x + 36, y + 14, x + 30, y + 17);
                g.drawLine(x + 36, y + 15, x + 30, y + 18);
                g.drawLine(x + 36, y + 16, x + 30, y + 19);
                g.drawLine(x + 36, y + 17, x + 30, y + 20);
                g.drawLine(x + 14, y + 36, x + 20, y + 33);
                g.drawLine(x + 14, y + 35, x + 20, y + 32);
                g.drawLine(x + 14, y + 34, x + 20, y + 31);
                g.drawLine(x + 14, y + 33, x + 20, y + 30);
                g.drawLine(x + 36, y + 36, x + 30, y + 33);
                g.drawLine(x + 36, y + 35, x + 30, y + 32);
                g.drawLine(x + 36, y + 34, x + 30, y + 31);
                g.drawLine(x + 36, y + 33, x + 30, y + 30);
                g.setColor(Color.white);
                g.drawLine(x + 14, y + 14, x + 17, y + 16);
                g.drawLine(x + 14, y + 15, x + 17, y + 17);
                g.drawLine(x + 14, y + 16, x + 17, y + 18);
                g.drawLine(x + 14, y + 17, x + 17, y + 19);
                g.drawLine(x + 36, y + 14, x + 33, y + 16);
                g.drawLine(x + 36, y + 15, x + 33, y + 17);
                g.drawLine(x + 36, y + 16, x + 33, y + 18);
                g.drawLine(x + 36, y + 17, x + 33, y + 19);

            } else if (contMuerte < 3000) {
                int xPts;
                if (puntos < 1000) {
                    xPts = x + 10;
                } else {
                    xPts = x + 5;
                }
                g.setColor(Color.white);
                g.setFont(fuentePuntaje);
                g.drawString(String.valueOf(puntos), xPts, y + 30);
            }

        }
    }

    /**
     * crea un rectangulo en la posicion de la matriz en la que esta
     *
     * @return un rectangulo
     */
    public Rectangle getBonds() {
        return new Rectangle(x, y, 50, 50);
    }

    /**
     * genera un rectangulo en la forma del enemigo para que sea alcanzado por
     * la bomba
     *
     * @return rectangulo
     */
    public Rectangle getBondsEnem() {
        return new Rectangle(x + 5, y + 5, 40, 40);
    }

    public Rectangle getMiniBounds() {
        return new Rectangle(x + 24, y + 24, 2, 2);
    }

    public Bloque getBloque(Bloque[][] bloques) {
        for (Bloque[] bloque : bloques) {
            for (Bloque value : bloque) {
                if (getMiniBounds().intersects(value.getBonds())) {
                    return value;
                }

            }
        }
        return bloques[2][2];
    }

    /**
     * desplaza al enemigo y cambia su direccion dependiendo de su poscicion o
     * de el bloque contra el que choque
     *
     * @param bloques bloques de la matriz
     * @param bombas lista de bombas en el nivel
     * @param bomber bomberman
     */
    public void mover(Bloque[][] bloques, LinkedList<Bomba> bombas, Bomberman bomber) {
        relentizador++;
        if(relentizador==4){
            relentizador=0;
        }
        switch(nivel){
            case 1:
                if(relentizador==3){
                    capDeMoverse=!capDeMoverse;
                }
                break;
            case 2:
                if(relentizador==0||relentizador==2){
                    capDeMoverse=!capDeMoverse;
                }
                break;
        }
                
        
        cambiarMirada();
        if (estado == 2) {
            contMuerte += 10;
            if (contMuerte >= 3000) {
                contMuerte = 0;
                estado = 0;
            }
        }
        if (contPasos >= 600) {
            contPasos = 0;
        } else {
            contPasos += 10;
        }
        if (estado == 1 && capDeMoverse) {
            int tx = x;
            int ty = y;
            switch (direccion) {
                case 0:
                    y += velocidad;
                    break;
                case 1:
                    y -= velocidad;
                    break;
                case 2:
                    x -= velocidad;
                    break;
                case 3:
                    x += velocidad;
                    break;
                default:
                    break;
            }
            if (x == getBloque(bloques).getX() && y == getBloque(bloques).getY()) {
                cambiarDireccion();
            }
            if (vaAChocar(bloques, bombas, bomber)) {
                x = tx;
                y = ty;
                cambiarDireccion();

            }
        }
        capDeMoverse=true;

    }

    /**
     * verifica si va a chocar con un bloque, una bomba, o el bomberman
     *
     * @param bloques matriz d ebloques del nivel
     * @param bombas lista de bombas ene el nivel
     * @param bomber bomberman
     * @return true si va achocar, de lo contrario false
     */
    private boolean vaAChocar(Bloque[][] bloques, LinkedList<Bomba> bombas, Bomberman bomber) {
        for (Bloque[] bloque : bloques) {
            for (Bloque value : bloque) {

                if (nivel == 1 && value.getTipo() != 0 && getBonds().intersects(value.getBonds())) {
                    return true;
                } else if ((nivel == 2 || nivel == 3) && value.getTipo() == 1 && getBonds().intersects(value.getBonds())) {
                    return true;
                }
                if (value.getTipo() == 3 && getBondsEnem().intersects(value.getBonds())) {
                    estado = 2;
                }

            }
        }
        for (Bomba bomba : bombas) {
            if ((bomba.getEstado() == 1) &&(!bomba.isIntangibleEnemies())&& (getBonds().intersects(bomba.getBonesBomb()))) {
                return true;
            }
        }
        if (getBonds().intersects(bomber.getBonds())) {
                bomber.setConVida(false);
        }
        return false;
    }

    private void cambiarMirada() {
        if (direccion == 1 || direccion == 3) {
            contIzq = 0;
            if (contDer == 5) {
                directOjos = true;
            }
            contDer++;

        } else {
            contDer = 0;
            if (contIzq == 5) {
                directOjos = false;
            }
            contIzq++;
        }

    }

    /**
     * cambia de direccion de forma aleatoria
     */
    private void cambiarDireccion() {
        int d = (int) (Math.random() * 4) + 1;
        switch (d) {
            case 1:
                direccion = 0;
                break;
            case 2:
                direccion = 1;
                break;
            case 3:
                direccion = 2;
                break;
            default:
                direccion = 3;
                break;
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDireccion() {
        return direccion;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getEstado() {
        return estado;
    }

}
