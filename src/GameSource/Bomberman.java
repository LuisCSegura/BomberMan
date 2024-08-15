/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameSource;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 * @author LuisKa
 */
public class Bomberman {

    private int x;
    private int y;
    private int direccion;
    private int velConst;
    private int velVar;
    private int puntaje;
    private int vidas;
    private boolean conVida;
    private int pasos;
    private int contPasos;
    // poderes
    private boolean detonator;
    private boolean wallPass;
    private boolean bombPass;
    private boolean speed;
    private int contTiempoMuerte;

    public Bomberman(int x, int y) {
        this.x = x;
        this.y = y;
        direccion = 0;
        velConst = 2;
        velVar = 0;
        puntaje = 0;
        vidas = 2;
        conVida = true;
        // poderes
        detonator = false;
        wallPass = false;
        bombPass = false;
        speed = false;
        pasos = 0;
        contPasos = 0;
        contTiempoMuerte = 0;

    }

    /**
     * pinta todas las caracteristicas del bomberman, dependiend de su direccion
     * y su estado
     *
     * @param g componente grfico que permite dibujar en la ventana
     */
    public void pintar(Graphics g) {
        g.setColor(Color.white);
        if (conVida) {
            switch (direccion) {
                case 0: {
                    // cabeza
                    g.fillRect(x + 13, y + 5, 24, 10);
                    g.fillRect(x + 17, y + 1, 16, 18);
                    g.fillRect(x + 16, y + 2, 18, 16);
                    g.fillRect(x + 15, y + 3, 20, 14);
                    g.fillRect(x + 14, y + 4, 22, 12);
                    g.setColor(new Color(252, 116, 96));
                    g.fillRect(x + 16, y + 7, 18, 6);
                    g.setColor(Color.BLACK);
                    g.fillRect(x + 20, y + 7, 3, 6);
                    g.fillRect(x + 28, y + 7, 3, 6);
                    // manos
                    g.setColor(new Color(252, 252, 252));
                    if (pasos == 0 || pasos == 2) {
                        int[] xs = { x + 36, x + 40, x + 40, x + 36, x + 35, x + 15, x + 14, x + 10, x + 10, x + 14 };
                        int[] ys = { y + 22, y + 26, y + 31, y + 31, y + 30, y + 30, y + 31, y + 31, y + 26, y + 22 };
                        g.fillPolygon(xs, ys, xs.length);
                        g.setColor(new Color(252, 116, 96));
                        g.fillOval(x + 6, y + 27, 7, 7);
                        g.fillOval(x + 36, y + 27, 7, 7);
                    } else if (pasos == 1) {
                        int[] xs = { x + 36, x + 41, x + 41, x + 38, x + 35, x + 15, x + 12, x + 9, x + 9, x + 14 };
                        int[] ys = { y + 22, y + 25, y + 29, y + 29, y + 29, y + 31, y + 34, y + 34, y + 30, y + 22 };
                        g.fillPolygon(xs, ys, xs.length);
                        g.setColor(new Color(252, 116, 96));
                        g.fillOval(x + 7, y + 31, 7, 7);
                        g.fillOval(x + 35, y + 22, 7, 7);
                    } else if (pasos == 3) {
                        int[] xs = { x + 36, x + 41, x + 41, x + 38, x + 35, x + 15, x + 12, x + 9, x + 9, x + 14 };
                        int[] ys = { y + 22, y + 30, y + 34, y + 34, y + 31, y + 29, y + 29, y + 29, y + 25, y + 22 };
                        g.fillPolygon(xs, ys, xs.length);
                        g.setColor(new Color(252, 116, 96));
                        g.fillOval(x + 7, y + 22, 7, 7);
                        g.fillOval(x + 36, y + 31, 7, 7);
                    }

                    // torso
                    g.setColor(new Color(60, 188, 252));
                    if (pasos == 0 || pasos == 2) {
                        g.fillRect(x + 19, y + 19, 12, 10);
                        g.fillRect(x + 18, y + 23, 14, 10);
                        g.fillRect(x + 17, y + 24, 16, 10);
                        g.fillRect(x + 16, y + 25, 18, 15);
                    } else if (pasos == 1) {
                        g.fillRect(x + 19, y + 19, 12, 10);
                        int[] xsTorso = { x + 19, x + 31, x + 34, x + 34, x + 16, x + 16 };
                        int[] ysTorso = { y + 22, y + 22, y + 25, y + 40, y + 40, y + 22 };
                        g.fillPolygon(xsTorso, ysTorso, xsTorso.length);

                    } else if (pasos == 3) {
                        g.fillRect(x + 19, y + 19, 12, 10);
                        int[] xsTorso = { x + 19, x + 31, x + 34, x + 34, x + 16, x + 16 };
                        int[] ysTorso = { y + 22, y + 22, y + 22, y + 40, y + 40, y + 25 };
                        g.fillPolygon(xsTorso, ysTorso, xsTorso.length);
                    }

                    // pies
                    g.setColor(new Color(252, 252, 252));
                    if (pasos == 0 || pasos == 2) {

                        g.fillRect(x + 17, y + 38, 5, 7);
                        g.fillRect(x + 28, y + 38, 5, 7);
                        g.fillRect(x + 17, y + 38, 6, 4);
                        g.fillRect(x + 27, y + 38, 6, 4);
                        g.fillRect(x + 16, y + 38, 5, 5);
                        g.fillRect(x + 29, y + 38, 5, 5);
                        g.setColor(new Color(252, 116, 96));
                        g.fillRect(x + 17, y + 45, 5, 5);
                        g.fillRect(x + 28, y + 45, 5, 5);
                        g.fillRect(x + 16, y + 48, 6, 2);
                        g.fillRect(x + 28, y + 48, 6, 2);

                    } else if (pasos == 1) {
                        g.fillRect(x + 17, y + 38, 5, 5);
                        g.fillRect(x + 28, y + 35, 5, 10);
                        g.fillRect(x + 29, y + 34, 3, 2);
                        g.fillRect(x + 27, y + 37, 6, 5);
                        g.fillRect(x + 16, y + 38, 7, 3);
                        g.fillRect(x + 29, y + 37, 5, 6);
                        g.setColor(new Color(252, 116, 96));
                        g.fillRect(x + 17, y + 43, 5, 3);
                        g.fillRect(x + 18, y + 44, 3, 3);
                        g.fillRect(x + 28, y + 44, 5, 4);
                        g.fillRect(x + 29, y + 43, 3, 6);
                        g.setColor(new Color(252, 252, 252));
                        g.fillRect(x + 18, y + 38, 3, 6);

                    } else if (pasos == 3) {
                        g.fillRect(x + 28, y + 38, 5, 5);
                        g.fillRect(x + 17, y + 35, 5, 10);
                        g.fillRect(x + 18, y + 34, 3, 2);
                        g.fillRect(x + 17, y + 37, 6, 5);
                        g.fillRect(x + 27, y + 38, 7, 3);
                        g.fillRect(x + 16, y + 37, 5, 6);
                        g.setColor(new Color(252, 116, 96));
                        g.fillRect(x + 28, y + 43, 5, 3);
                        g.fillRect(x + 29, y + 44, 3, 3);
                        g.fillRect(x + 17, y + 44, 5, 4);
                        g.fillRect(x + 18, y + 43, 3, 6);
                        g.setColor(new Color(252, 252, 252));
                        g.fillRect(x + 29, y + 38, 3, 6);
                    }

                    break;
                }
                case 1: {
                    // cabeza
                    g.setColor(new Color(252, 252, 252));
                    g.fillRect(x + 13, y + 5, 24, 10);
                    g.fillRect(x + 17, y + 1, 16, 18);
                    g.fillRect(x + 16, y + 2, 18, 16);
                    g.fillRect(x + 15, y + 3, 20, 14);
                    g.fillRect(x + 14, y + 4, 22, 12);
                    g.setColor(new Color(60, 188, 252));
                    g.fillRect(x + 22, y + 5, 6, 3);
                    g.fillRect(x + 18, y + 7, 4, 3);

                    // manos
                    g.setColor(new Color(252, 116, 96));
                    if (pasos == 0 || pasos == 2) {

                        g.fillOval(x + 6, y + 27, 7, 7);
                        g.fillOval(x + 36, y + 27, 7, 7);
                        g.setColor(new Color(252, 252, 252));
                        int[] xs = { x + 36, x + 40, x + 40, x + 36, x + 35, x + 15, x + 14, x + 10, x + 10, x + 14 };
                        int[] ys = { y + 22, y + 26, y + 31, y + 31, y + 30, y + 30, y + 31, y + 31, y + 26, y + 22 };
                        g.fillPolygon(xs, ys, xs.length);

                    } else if (pasos == 1) {

                        g.fillOval(x + 7, y + 31, 7, 7);
                        g.fillOval(x + 35, y + 22, 7, 7);
                        g.setColor(new Color(252, 252, 252));
                        int[] xs = { x + 36, x + 41, x + 41, x + 38, x + 35, x + 15, x + 12, x + 9, x + 9, x + 14 };
                        int[] ys = { y + 22, y + 25, y + 29, y + 29, y + 29, y + 31, y + 34, y + 34, y + 30, y + 22 };
                        g.fillPolygon(xs, ys, xs.length);

                    } else if (pasos == 3) {

                        g.fillOval(x + 7, y + 22, 7, 7);
                        g.fillOval(x + 36, y + 31, 7, 7);
                        g.setColor(new Color(252, 252, 252));
                        int[] xs = { x + 36, x + 41, x + 41, x + 38, x + 35, x + 15, x + 12, x + 9, x + 9, x + 14 };
                        int[] ys = { y + 22, y + 30, y + 34, y + 34, y + 31, y + 29, y + 29, y + 29, y + 25, y + 22 };
                        g.fillPolygon(xs, ys, xs.length);

                    }

                    // torso
                    g.setColor(new Color(60, 188, 252));
                    g.fillRect(x + 19, y + 19, 12, 10);
                    g.fillRect(x + 16, y + 22, 18, 18);
                    g.setColor(new Color(252, 252, 252));
                    g.fillRect(x + 16, y + 31, 18, 3);
                    g.setColor(new Color(252, 116, 96));
                    g.fillRect(x + 22, y + 27, 6, 4);
                    g.fillRect(x + 21, y + 28, 8, 2);
                    // pies
                    g.setColor(new Color(252, 252, 252));
                    if (pasos == 0 || pasos == 2) {

                        g.fillRect(x + 17, y + 38, 5, 7);
                        g.fillRect(x + 28, y + 38, 5, 7);
                        g.fillRect(x + 17, y + 38, 6, 4);
                        g.fillRect(x + 27, y + 38, 6, 4);
                        g.fillRect(x + 16, y + 38, 5, 5);
                        g.fillRect(x + 29, y + 38, 5, 5);
                        g.setColor(new Color(252, 116, 96));
                        g.fillRect(x + 17, y + 45, 5, 5);
                        g.fillRect(x + 28, y + 45, 5, 5);
                        g.fillRect(x + 16, y + 48, 6, 2);
                        g.fillRect(x + 28, y + 48, 6, 2);

                    } else if (pasos == 1) {
                        g.fillRect(x + 17, y + 38, 5, 5);
                        g.fillRect(x + 28, y + 35, 5, 10);
                        g.fillRect(x + 29, y + 34, 3, 2);
                        g.fillRect(x + 27, y + 37, 6, 5);
                        g.fillRect(x + 16, y + 38, 7, 3);
                        g.fillRect(x + 29, y + 37, 5, 6);
                        g.setColor(new Color(252, 116, 96));
                        g.fillRect(x + 17, y + 43, 5, 3);
                        g.fillRect(x + 18, y + 44, 3, 3);
                        g.fillRect(x + 28, y + 44, 5, 4);
                        g.fillRect(x + 29, y + 43, 3, 6);
                        g.setColor(new Color(252, 252, 252));
                        g.fillRect(x + 18, y + 38, 3, 6);

                    } else if (pasos == 3) {
                        g.fillRect(x + 28, y + 38, 5, 5);
                        g.fillRect(x + 17, y + 35, 5, 10);
                        g.fillRect(x + 18, y + 34, 3, 2);
                        g.fillRect(x + 17, y + 37, 6, 5);
                        g.fillRect(x + 27, y + 38, 7, 3);
                        g.fillRect(x + 16, y + 37, 5, 6);
                        g.setColor(new Color(252, 116, 96));
                        g.fillRect(x + 28, y + 43, 5, 3);
                        g.fillRect(x + 29, y + 44, 3, 3);
                        g.fillRect(x + 17, y + 44, 5, 4);
                        g.fillRect(x + 18, y + 43, 3, 6);
                        g.setColor(new Color(252, 252, 252));
                        g.fillRect(x + 29, y + 38, 3, 6);
                    }
                    break;
                }
                case 2:
                    if (pasos == 0 || pasos == 2) {
                        g.setColor(new Color(252, 252, 252));
                        g.fillOval(x + 13, y + 21, 7, 11);
                        g.setColor(new Color(252, 116, 96));
                        g.fillOval(x + 11, y + 28, 7, 7);
                    } else if (pasos == 1) {
                        g.setColor(new Color(252, 252, 252));
                        g.fillOval(x + 14, y + 28, 11, 7);
                        g.fillOval(x + 35, y + 37, 8, 7);
                        g.fillOval(x + 33, y + 39, 6, 5);
                        g.setColor(new Color(252, 116, 96));
                        g.fillOval(x + 10, y + 27, 7, 7);
                    } else if (pasos == 3) {
                        g.setColor(new Color(252, 116, 96));
                        g.fillOval(x + 37, y + 26, 7, 7);
                    }

                    // torso
                    if (pasos == 0 || pasos == 2) {
                        g.setColor(new Color(60, 188, 252));
                        g.fillRect(x + 16, y + 10, 18, 28);
                        g.fillRect(x + 25, y + 37, 6, 3);
                        g.fillOval(x + 29, y + 21, 8, 17);
                    } else if (pasos == 1) {
                        g.setColor(new Color(60, 188, 252));
                        int[] xsTorso = { x + 16, x + 32, x + 43, x + 26 };
                        int[] ysTorso = { y + 26, y + 15, y + 37, y + 44 };
                        g.fillPolygon(xsTorso, ysTorso, xsTorso.length);
                    } else if (pasos == 3) {
                        g.setColor(new Color(60, 188, 252));
                        int[] xsTorso = { x + 11, x + 35, x + 35 };
                        int[] ysTorso = { y + 14, y + 10, y + 39 };
                        g.fillPolygon(xsTorso, ysTorso, xsTorso.length);
                        g.fillRoundRect(x + 19, y + 23, 19, 18, 3, 3);
                        g.fillOval(x + 15, y + 34, 10, 10);
                    }

                    // cabeza
                    if (pasos == 0 || pasos == 2 || pasos == 3) {
                        g.setColor(new Color(252, 252, 252));
                        int[] xsCabeza = { x + 11, x + 15, x + 32, x + 39, x + 39, x + 34, x + 33, x + 26, x + 15,
                                x + 11 };
                        int[] ysCabeza = { y + 5, y + 1, y + 1, y + 8, y + 11, y + 16, y + 16, y + 19, y + 19, y + 14 };
                        g.fillPolygon(xsCabeza, ysCabeza, xsCabeza.length);
                        g.setColor(new Color(252, 116, 96));
                        int[] xsojo = { x + 11, x + 28, x + 30, x + 25, x + 11 };
                        int[] ysojo = { y + 7, y + 7, y + 9, y + 13, y + 13 };
                        g.fillPolygon(xsojo, ysojo, xsojo.length);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 14, y + 7, 3, 6);
                        g.fillRect(x + 20, y + 7, 3, 6);
                        g.setColor(new Color(252, 252, 252));
                        g.fillRect(x + 35, y + 1, 2, 2);
                        g.setColor(new Color(252, 116, 96));
                        g.fillRect(x + 37, y + 1, 3, 2);
                    } else if (pasos == 1) {
                        g.setColor(new Color(252, 252, 252));
                        int[] xsCabeza = { x + 10, x + 14, x + 31, x + 38, x + 38, x + 33, x + 32, x + 25, x + 14,
                                x + 10 };
                        int[] ysCabeza = { y + 8, y + 4, y + 4, y + 11, y + 14, y + 19, y + 19, y + 22, y + 22,
                                y + 17 };
                        g.fillPolygon(xsCabeza, ysCabeza, xsCabeza.length);
                        g.setColor(new Color(252, 116, 96));
                        int[] xsojo = { x + 10, x + 27, x + 29, x + 24, x + 10 };
                        int[] ysojo = { y + 10, y + 10, y + 12, y + 16, y + 16 };
                        g.fillPolygon(xsojo, ysojo, xsojo.length);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 13, y + 10, 3, 6);
                        g.fillRect(x + 19, y + 10, 3, 6);
                        g.setColor(new Color(60, 188, 252));
                        g.fillRect(x + 34, y + 5, 2, 2);
                        g.fillRect(x + 35, y + 3, 2, 2);
                        g.setColor(new Color(252, 116, 96));
                        g.fillRect(x + 36, y + 1, 2, 2);
                    }
                    // pies
                    if (pasos == 0 || pasos == 2) {
                        g.setColor(new Color(252, 252, 252));
                        g.fillRect(x + 28, y + 38, 5, 7);
                        g.fillRect(x + 27, y + 38, 7, 5);
                        g.fillRect(x + 19, y + 38, 5, 4);
                        g.fillRect(x + 18, y + 38, 7, 2);
                        g.setColor(new Color(252, 116, 96));
                        g.fillRect(x + 19, y + 42, 5, 5);
                        g.fillRect(x + 16, y + 45, 7, 2);
                        g.fillRect(x + 28, y + 45, 5, 5);
                        g.fillRect(x + 25, y + 48, 7, 2);
                    } else if (pasos == 1) {
                        g.setColor(new Color(252, 252, 252));
                        g.fillRoundRect(x + 23, y + 38, 6, 7, 2, 3);
                        g.fillRect(x + 23, y + 38, 3, 4);
                        g.fillOval(x + 25, y + 40, 6, 9);
                        g.setColor(new Color(252, 116, 96));
                        g.fillRect(x + 26, y + 45, 5, 5);
                        g.fillRect(x + 23, y + 48, 8, 2);
                        g.fillRect(x + 42, y + 39, 3, 5);
                        g.fillRect(x + 45, y + 42, 2, 5);
                    } else if (pasos == 3) {
                        g.setColor(new Color(252, 252, 252));
                        g.fillOval(x + 14, y + 35, 4, 9);
                        g.fillOval(x + 17, y + 38, 3, 3);
                        g.fillRect(x + 28, y + 36, 3, 8);
                        g.fillRect(x + 28, y + 38, 12, 6);
                        g.setColor(new Color(252, 116, 96));
                        g.fillRect(x + 11, y + 36, 4, 8);
                        g.fillRect(x + 11, y + 34, 2, 10);
                        g.fillRect(x + 32, y + 47, 4, 2);
                        int[] xsBota = { x + 35, x + 35, x + 36, x + 40, x + 43 };
                        int[] ysBota = { y + 49, y + 46, y + 43, y + 39, y + 42 };
                        g.fillPolygon(xsBota, ysBota, xsBota.length);
                    }

                    // manos
                    if (pasos == 0 || pasos == 2) {
                        g.setColor(new Color(252, 252, 252));
                        g.fillArc(x + 20, y + 22, 17, 14, 270, 200);
                        g.setColor(new Color(60, 188, 252));
                        g.fillArc(x + 13, y + 25, 18, 8, 270, 200);
                        g.setColor(new Color(255, 123, 108));
                        g.fillOval(x + 25, y + 31, 7, 7);
                    } else if (pasos == 1) {
                        g.setColor(new Color(252, 252, 252));
                        g.fillOval(x + 28, y + 21, 7, 7);
                        int[] xsBrazos = { x + 29, x + 36, x + 43, x + 37 };
                        int[] ysBrazos = { y + 26, y + 25, y + 36, y + 36 };
                        g.fillPolygon(xsBrazos, ysBrazos, xsBrazos.length);
                        g.setColor(new Color(252, 116, 96));
                        g.fillOval(x + 36, y + 31, 7, 7);
                    } else if (pasos == 3) {
                        g.setColor(new Color(252, 252, 252));
                        g.fillOval(x + 22, y + 21, 10, 7);
                        g.fillOval(x + 15, y + 24, 15, 7);
                        g.setColor(new Color(252, 116, 96));
                        g.fillOval(x + 10, y + 22, 7, 7);
                    }
                    break;

                case 3:
                    if (pasos == 0 || pasos == 2) {
                        g.setColor(new Color(252, 252, 252));
                        g.fillOval(x + 29, y + 21, 7, 11);
                        g.setColor(new Color(255, 123, 108));
                        g.fillOval(x + 32, y + 28, 7, 7);
                    } else if (pasos == 1) {
                        g.setColor(new Color(252, 252, 252));
                        g.fillOval(x + 25, y + 28, 11, 7);
                        g.fillOval(x + 7, y + 37, 8, 7);
                        g.fillOval(x + 11, y + 39, 6, 5);
                        g.setColor(new Color(255, 123, 108));
                        g.fillOval(x + 33, y + 27, 7, 7);
                    } else if (pasos == 3) {
                        g.setColor(new Color(252, 116, 96));
                        g.fillOval(x + 6, y + 26, 7, 7);
                    }

                    // torso
                    if (pasos == 0 || pasos == 2) {
                        g.setColor(new Color(60, 188, 252));
                        g.fillRect(x + 16, y + 10, 18, 28);
                        g.fillOval(x + 12, y + 21, 8, 17);
                        g.fillRect(x + 20, y + 37, 6, 3);
                    } else if (pasos == 1) {
                        g.setColor(new Color(60, 188, 252));
                        int[] xsTorso = { x + 34, x + 18, x + 7, x + 24 };
                        int[] ysTorso = { y + 26, y + 15, y + 37, y + 44 };
                        g.fillPolygon(xsTorso, ysTorso, xsTorso.length);
                    } else if (pasos == 3) {
                        g.setColor(new Color(60, 188, 252));
                        int[] xsTorso = { x + 39, x + 15, x + 15 };
                        int[] ysTorso = { y + 14, y + 10, y + 39 };
                        g.fillPolygon(xsTorso, ysTorso, xsTorso.length);
                        g.fillRoundRect(x + 12, y + 23, 19, 18, 3, 3);
                        g.fillOval(x + 25, y + 34, 10, 10);
                    }

                    // cabeza
                    if (pasos == 0 || pasos == 2 || pasos == 3) {
                        g.setColor(new Color(252, 252, 252));
                        int[] xsCabeza = { x + 39, x + 35, x + 18, x + 11, x + 11, x + 16, x + 17, x + 24, x + 34,
                                x + 39 };
                        int[] ysCabeza = { y + 5, y + 1, y + 1, y + 8, y + 11, y + 16, y + 16, y + 19, y + 19, y + 14 };
                        g.fillPolygon(xsCabeza, ysCabeza, xsCabeza.length);
                        g.setColor(new Color(252, 116, 96));
                        int[] xsojo = { x + 39, x + 22, x + 20, x + 24, x + 39 };
                        int[] ysojo = { y + 7, y + 7, y + 9, y + 13, y + 13 };
                        g.fillPolygon(xsojo, ysojo, xsojo.length);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 33, y + 7, 3, 6);
                        g.fillRect(x + 27, y + 7, 3, 6);
                        g.setColor(new Color(252, 252, 252));
                        g.fillRect(x + 13, y + 1, 2, 2);
                        g.setColor(new Color(252, 116, 96));
                        g.fillRect(x + 10, y + 1, 3, 2);
                    } else if (pasos == 1) {
                        g.setColor(new Color(252, 252, 252));
                        int[] xsCabeza = { x + 40, x + 36, x + 19, x + 12, x + 12, x + 17, x + 18, x + 25, x + 35,
                                x + 40 };
                        int[] ysCabeza = { y + 8, y + 4, y + 4, y + 11, y + 14, y + 19, y + 19, y + 22, y + 22,
                                y + 17 };
                        g.fillPolygon(xsCabeza, ysCabeza, xsCabeza.length);
                        g.setColor(new Color(252, 116, 96));
                        int[] xsojo = { x + 40, x + 23, x + 21, x + 25, x + 40 };
                        int[] ysojo = { y + 10, y + 10, y + 12, y + 16, y + 16 };
                        g.fillPolygon(xsojo, ysojo, xsojo.length);
                        g.setColor(Color.BLACK);
                        g.fillRect(x + 34, y + 10, 3, 6);
                        g.fillRect(x + 28, y + 10, 3, 6);
                        g.setColor(new Color(60, 188, 252));
                        g.fillRect(x + 14, y + 5, 2, 2);
                        g.fillRect(x + 13, y + 3, 2, 2);
                        g.setColor(new Color(252, 116, 96));
                        g.fillRect(x + 12, y + 1, 2, 2);
                    }
                    // pies
                    if (pasos == 0 || pasos == 2) {
                        g.setColor(new Color(252, 252, 252));
                        g.fillRect(x + 17, y + 38, 5, 7);
                        g.fillRect(x + 16, y + 38, 7, 5);
                        g.fillRect(x + 26, y + 38, 5, 4);
                        g.fillRect(x + 25, y + 38, 7, 2);
                        g.setColor(new Color(252, 116, 96));
                        g.fillRect(x + 26, y + 42, 5, 5);
                        g.fillRect(x + 27, y + 45, 7, 2);
                        g.fillRect(x + 17, y + 45, 5, 5);
                        g.fillRect(x + 18, y + 48, 7, 2);
                    } else if (pasos == 1) {
                        g.setColor(new Color(252, 252, 252));
                        g.fillOval(x + 21, y + 37, 7, 8);
                        g.fillRect(x + 25, y + 38, 3, 3);
                        g.fillOval(x + 19, y + 40, 6, 9);
                        g.setColor(new Color(252, 116, 96));
                        g.fillRect(x + 20, y + 45, 5, 5);
                        g.fillRect(x + 20, y + 48, 8, 2);
                        g.fillRect(x + 6, y + 39, 3, 5);
                        g.fillRect(x + 4, y + 42, 2, 5);
                    } else if (pasos == 3) {
                        g.setColor(new Color(252, 252, 252));
                        g.fillOval(x + 32, y + 35, 4, 9);
                        g.fillOval(x + 30, y + 38, 3, 3);
                        g.fillRect(x + 19, y + 36, 3, 8);
                        g.fillRect(x + 10, y + 38, 12, 6);
                        g.setColor(new Color(252, 116, 96));
                        g.fillRect(x + 35, y + 36, 4, 8);
                        g.fillRect(x + 37, y + 34, 2, 10);
                        g.fillRect(x + 14, y + 47, 4, 2);
                        int[] xsBota = { x + 15, x + 15, x + 14, x + 10, x + 7 };
                        int[] ysBota = { y + 49, y + 46, y + 43, y + 39, y + 42 };
                        g.fillPolygon(xsBota, ysBota, xsBota.length);
                    }

                    // manos
                    if (pasos == 0 || pasos == 2) {
                        g.setColor(new Color(252, 252, 252));
                        g.fillArc(x + 13, y + 22, 17, 14, 90, 200);
                        g.setColor(new Color(60, 188, 252));
                        g.fillArc(x + 19, y + 25, 18, 8, 90, 200);
                        g.setColor(new Color(255, 123, 108));
                        g.fillOval(x + 18, y + 31, 7, 7);
                    } else if (pasos == 1) {
                        g.setColor(new Color(252, 252, 252));
                        g.fillOval(x + 15, y + 21, 7, 7);
                        int[] xsBrazos = { x + 22, x + 15, x + 7, x + 13 };
                        int[] ysBrazos = { y + 25, y + 24, y + 36, y + 36 };
                        g.fillPolygon(xsBrazos, ysBrazos, xsBrazos.length);
                        g.setColor(new Color(252, 116, 96));
                        g.fillOval(x + 7, y + 31, 7, 7);
                    } else if (pasos == 3) {
                        g.setColor(new Color(252, 252, 252));
                        g.fillOval(x + 18, y + 21, 10, 7);
                        g.fillOval(x + 20, y + 24, 15, 7);
                        g.setColor(new Color(252, 116, 96));
                        g.fillOval(x + 33, y + 22, 7, 7);
                    }
                    break;

                default:
                    break;
            }
        } else {
            if (contTiempoMuerte <= 200) {
                g.setColor(new Color(252, 252, 252));
                g.fillRect(x + 11, y + 5, 28, 10);
                g.fillRect(x + 15, y + 1, 20, 18);
                g.fillRect(x + 14, y + 2, 22, 16);
                g.fillRect(x + 13, y + 3, 24, 14);
                g.fillRect(x + 12, y + 4, 26, 12);
                g.fillOval(x + 12, y + 21, 4, 4);
                g.fillOval(x + 11, y + 37, 7, 7);
                g.fillOval(x + 35, y + 21, 4, 4);
                g.fillOval(x + 32, y + 37, 7, 7);
                g.setColor(Color.BLACK);
                g.fillRect(x + 17, y + 7, 3, 3);
                g.fillRect(x + 28, y + 7, 3, 3);
                g.setColor(new Color(60, 188, 252));
                g.fillOval(x + 11, y + 18, 28, 27);
                g.setColor(new Color(252, 116, 96));
                g.fillOval(x + 6, y + 17, 7, 7);
                g.fillOval(x + 8, y + 40, 7, 7);
                g.fillOval(x + 37, y + 17, 7, 7);
                g.fillOval(x + 35, y + 40, 7, 7);
            } else if (contTiempoMuerte <= 350) {
                g.setColor(new Color(252, 252, 252));
                g.fillRect(x + 11, y + 5, 28, 10);
                g.fillRect(x + 15, y + 1, 20, 18);
                g.fillRect(x + 14, y + 2, 22, 16);
                g.fillRect(x + 13, y + 3, 24, 14);
                g.fillRect(x + 12, y + 4, 26, 12);
                g.setColor(Color.BLACK);
                g.fillRect(x + 14, y + 4, 3, 3);
                g.fillRect(x + 17, y + 7, 3, 3);
                g.fillRect(x + 20, y + 10, 3, 3);
                g.fillRect(x + 14, y + 10, 3, 3);
                g.fillRect(x + 20, y + 4, 3, 3);
                g.fillRect(x + 25, y + 4, 3, 3);
                g.fillRect(x + 28, y + 7, 3, 3);
                g.fillRect(x + 31, y + 10, 3, 3);
                g.fillRect(x + 25, y + 10, 3, 3);
                g.fillRect(x + 31, y + 4, 3, 3);
                g.setColor(new Color(60, 188, 252));
                int[] xsCuerpo = { x + 34, x + 46, x + 46, x + 35, x + 15, x + 4, x + 4, x + 16, x + 15,
                        x + 25, x + 34, x + 36, x + 27, x + 38, x + 36, x + 30, x + 30, x + 28, x + 28, x + 15, x + 15,
                        x + 21, x + 21, x + 12, x + 15, x + 16 };
                int[] ysCuerpo = { y + 15, y + 26, y + 35, y + 49, y + 49, y + 35, y + 26, y + 15, y + 23,
                        y + 29, y + 18, y + 20, y + 31, y + 38, y + 40, y + 36, y + 42, y + 42, y + 35, y + 38, y + 35,
                        y + 35, y + 31, y + 25, y + 23, y + 15 };
                g.fillPolygon(xsCuerpo, ysCuerpo, xsCuerpo.length);
                g.setColor(new Color(252, 116, 96));
                g.fillOval(x + 6, y + 17, 7, 7);
                g.fillOval(x + 8, y + 42, 7, 7);
                g.fillOval(x + 37, y + 17, 7, 7);
                g.fillOval(x + 35, y + 42, 7, 7);
                g.setColor(Color.WHITE);
                g.fillRect(x + 18, y + 23, 2, 2);
                g.fillRect(x + 16, y + 28, 2, 2);
                g.fillRect(x + 19, y + 30, 2, 2);
                g.fillRect(x + 19, y + 33, 2, 2);
                g.fillRect(x + 24, y + 27, 2, 2);
                g.fillRect(x + 29, y + 30, 2, 2);
                g.fillRect(x + 30, y + 36, 2, 2);
                g.fillRect(x + 25, y + 36, 2, 2);
                g.fillRect(x + 18, y + 38, 2, 2);
            } else if (contTiempoMuerte <= 500) {
                g.setColor(new Color(252, 252, 252));
                g.fillRect(x + 11, y + 5, 28, 10);
                g.fillRect(x + 15, y + 1, 20, 18);
                g.fillRect(x + 14, y + 2, 22, 16);
                g.fillRect(x + 13, y + 3, 24, 14);
                g.fillRect(x + 12, y + 4, 26, 12);
                g.setColor(Color.BLACK);
                g.fillRect(x + 14, y + 4, 3, 3);
                g.fillRect(x + 17, y + 7, 3, 3);
                g.fillRect(x + 20, y + 10, 3, 3);
                g.fillRect(x + 14, y + 10, 3, 3);
                g.fillRect(x + 20, y + 4, 3, 3);
                g.fillRect(x + 25, y + 4, 3, 3);
                g.fillRect(x + 28, y + 7, 3, 3);
                g.fillRect(x + 31, y + 10, 3, 3);
                g.fillRect(x + 25, y + 10, 3, 3);
                g.fillRect(x + 31, y + 4, 3, 3);
                g.setColor(new Color(60, 188, 252));
                int[] xsCuerpo = { x + 34, x + 43, x + 43, x + 35, x + 15, x + 7, x + 7, x + 16, x + 16, x + 22,
                        x + 26, x + 36, x + 29, x + 38, x + 32, x + 26, x + 15, x + 13, x + 13, x + 20, x + 12, x + 16,
                        x + 16 };
                int[] ysCuerpo = { y + 13, y + 28, y + 37, y + 49, y + 49, y + 37, y + 28, y + 13, y + 20, y + 26,
                        y + 19, y + 19, y + 26, y + 38, y + 42, y + 35, y + 43, y + 40, y + 33, y + 32, y + 25, y + 20,
                        y + 13 };
                g.fillPolygon(xsCuerpo, ysCuerpo, xsCuerpo.length);
                g.setColor(new Color(252, 116, 96));
                g.fillOval(x + 6, y + 17, 7, 7);
                g.fillOval(x + 8, y + 42, 7, 7);
                g.fillOval(x + 37, y + 17, 7, 7);
                g.fillOval(x + 35, y + 42, 7, 7);
                g.setColor(Color.WHITE);
                g.fillRect(x + 22, y + 25, 2, 2);
                g.fillRect(x + 16, y + 29, 2, 2);
                g.fillRect(x + 19, y + 31, 2, 2);
                g.fillRect(x + 32, y + 23, 2, 2);
                g.fillRect(x + 30, y + 26, 2, 2);
                g.fillRect(x + 32, y + 29, 2, 2);
                g.fillRect(x + 28, y + 38, 2, 2);
                g.fillRect(x + 25, y + 36, 2, 2);
                g.fillRect(x + 22, y + 38, 2, 2);
            } else if (contTiempoMuerte <= 650) {
                g.setColor(new Color(252, 252, 252));
                g.fillRect(x + 11, y + 8, 28, 6);
                g.fillRect(x + 11, y + 8, 5, 11);
                g.fillRect(x + 34, y + 8, 5, 11);
                g.fillRect(x + 15, y + 4, 20, 10);
                g.fillRect(x + 14, y + 5, 22, 8);
                g.fillRect(x + 13, y + 6, 24, 6);
                g.fillRect(x + 12, y + 7, 26, 4);
                g.setColor(Color.BLACK);
                g.fillRect(x + 14, y + 8, 3, 3);
                g.fillRect(x + 20, y + 8, 3, 3);
                g.fillRect(x + 25, y + 8, 3, 3);
                g.fillRect(x + 31, y + 8, 3, 3);
                g.setColor(new Color(60, 188, 252));
                g.fillRect(x + 16, y + 11, 18, 3);
                g.fillRect(x + 14, y + 14, 6, 3);
                g.fillRect(x + 25, y + 14, 12, 3);
                g.fillRect(x + 12, y + 17, 6, 3);
                g.fillRect(x + 28, y + 17, 10, 3);
                g.fillRect(x + 12, y + 20, 3, 3);
                g.fillRect(x + 4, y + 24, 5, 10);
                g.fillRect(x + 9, y + 40, 5, 2);
                g.fillRect(x + 20, y + 47, 10, 2);
                g.fillRect(x + 23, y + 44, 7, 5);
                g.fillRect(x + 38, y + 27, 5, 7);
                g.fillRect(x + 36, y + 24, 3, 4);
                g.fillRect(x + 32, y + 24, 4, 2);
                g.fillRect(x + 37, y + 40, 2, 2);
                g.setColor(new Color(252, 116, 96));
                g.fillOval(x + 6, y + 17, 7, 7);
                g.fillOval(x + 8, y + 42, 7, 7);
                g.fillOval(x + 37, y + 17, 7, 7);
                g.fillOval(x + 35, y + 42, 7, 7);
                g.setColor(Color.WHITE);
                g.fillRect(x + 9, y + 29, 2, 2);
                g.fillRect(x + 20, y + 14, 2, 2);
                g.fillRect(x + 18, y + 16, 2, 2);
                g.fillRect(x + 14, y + 40, 2, 2);
                g.fillRect(x + 25, y + 42, 2, 2);
                g.fillRect(x + 23, y + 44, 2, 2);
                g.fillRect(x + 36, y + 27, 2, 2);
                g.fillRect(x + 30, y + 24, 2, 2);
                g.fillRect(x + 32, y + 22, 6, 2);
            } else if (contTiempoMuerte <= 800) {
                g.setColor(new Color(252, 252, 252));
                g.fillRect(x + 11, y + 8, 6, 2);
                g.fillRect(x + 24, y + 8, 15, 2);
                g.fillRect(x + 11, y + 8, 3, 5);
                g.fillRect(x + 15, y + 4, 20, 1);
                g.fillRect(x + 14, y + 5, 22, 1);
                g.fillRect(x + 13, y + 6, 24, 1);
                g.fillRect(x + 12, y + 7, 26, 1);
                g.setColor(new Color(60, 188, 252));
                g.fillRect(x + 27, y + 8, 8, 2);
                g.fillRect(x + 30, y + 10, 3, 2);
                g.fillRect(x + 27, y + 6, 2, 2);
                g.fillRect(x + 19, y + 6, 2, 2);
                g.fillRect(x + 18, y + 10, 2, 2);
                g.fillRect(x + 5, y + 12, 2, 2);
                g.fillRect(x + 43, y + 12, 2, 2);
                g.fillRect(x + 5, y + 10, 4, 2);
                g.fillRect(x + 41, y + 10, 4, 2);
                g.fillRect(x + 6, y + 27, 3, 8);
                g.fillRect(x + 9, y + 25, 2, 2);
                g.fillRect(x + 1, y + 25, 3, 2);
                g.fillRect(x + 1, y + 33, 3, 5);
                g.fillRect(x + 3, y + 40, 3, 2);
                g.fillRect(x + 42, y + 38, 2, 5);
                g.fillRect(x + 44, y + 40, 2, 5);
                g.fillRect(x + 22, y + 47, 6, 2);
                g.fillRect(x + 42, y + 24, 5, 5);
                g.fillRect(x + 40, y + 21, 5, 4);
                g.fillRect(x + 34, y + 21, 6, 2);
                g.setColor(new Color(252, 116, 96));
                g.fillOval(x + 6, y + 17, 7, 7);
                g.fillOval(x + 8, y + 42, 7, 7);
                g.fillOval(x + 37, y + 17, 7, 7);
                g.fillOval(x + 35, y + 42, 7, 7);
                g.setColor(Color.WHITE);
                g.fillRect(x + 9, y + 33, 2, 2);
                g.fillRect(x + 12, y + 22, 2, 2);
                g.fillRect(x + 22, y + 45, 4, 2);
                g.fillRect(x + 40, y + 24, 2, 2);
                g.fillRect(x + 42, y + 27, 2, 2);
                g.fillRect(x + 42, y + 36, 2, 2);
            } else if (contTiempoMuerte <= 1000) {
                g.setColor(new Color(60, 188, 252));
                g.fillRect(x + 11, y + 21, 5, 2);
                g.fillRect(x + 35, y + 21, 5, 2);
                g.setColor(new Color(252, 116, 96));
                g.fillOval(x + 6, y + 17, 7, 7);
                g.fillOval(x + 8, y + 42, 7, 7);
                g.fillOval(x + 37, y + 17, 7, 7);
                g.fillOval(x + 35, y + 42, 7, 7);
            }

        }
    }

    public void mover(Bloque[][] bloques, LinkedList<Bomba> bombas, boolean enRango) {
        int tx = x;
        int ty = y;
        if (enRango) {
            if (direccion == 0 || direccion == 1) {
                avanzar(bloques, bombas);
            }
        } else {
            avanzar(bloques, bombas);
        }
        if (x == tx && y == ty && velVar > 0) {
            if (direccion == 2 || direccion == 3) {
                alinearY(bloques);
            } else {
                if (!enRango) {
                    alinearX(bloques);
                }
            }
        }
    }

    /**
     * crea un rectangulo en la poscicion del bomberman
     *
     * @return un rectangulo en la poscicion del bomberman
     */
    public Rectangle getBonds() {
        return new Rectangle(x + 15, y + 10, 20, 30);
    }

    public Rectangle getBondsBomber() {
        return new Rectangle(x, y, 50, 50);
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
     * permite reposcicionar al bomberman en su poscicion original en la
     * pantalla
     */
    public void reUbicar() {
        x = 50;
        y = 150;
        velVar = 0;
        contTiempoMuerte = 0;
    }

    /**
     * restaura los valores prederminados del bomberman
     */
    public void reset() {
        x = 50;
        y = 150;
        direccion = 0;
        velConst = 2;
        velVar = 0;
        conVida = true;
        pasos = 0;
        contPasos = 0;
        contTiempoMuerte = 0;
    }

    public void reStart() {
        x = 50;
        y = 150;
        direccion = 0;
        velConst = 2;
        velVar = 0;
        puntaje = 0;
        vidas = 3;
        conVida = true;
        // poderes
        detonator = false;
        speed = false;
        pasos = 0;
        contPasos = 0;
        contTiempoMuerte = 0;
    }

    public void moverAbajo() {
        direccion = 0;
        velVar = velConst;
    }

    public void moverArriba() {
        direccion = 1;
        velVar = velConst;
    }

    public void moverIzquierda() {
        direccion = 2;
        velVar = velConst;
    }

    public void moverDerecha() {
        direccion = 3;
        velVar = velConst;
    }

    public void detener() {
        velVar = 0;
    }

    private void alinearY(Bloque[][] bloques) {
        int yObjetivo = getBloque(bloques).getY();
        int dif = yObjetivo - y;
        if (dif < 0) {
            y -= 1;
        } else if (dif > 0) {
            y += 1;
        }
    }

    private void alinearX(Bloque[][] bloques) {
        int xObjetivo = getBloque(bloques).getX();
        int dif = xObjetivo - x;
        if (dif < 0) {
            x -= 1;
        } else if (dif > 0) {
            x += 1;
        }
    }

    public void avanzar(Bloque[][] bloques, LinkedList<Bomba> bombas) {
        int tx = x;
        int ty = y;
        if (velVar > 0) {
            cambiarPasos();
        }
        if (direccion == 0) {
            y += velVar;
        }
        if (direccion == 1) {
            y -= velVar;
        }
        if (direccion == 2) {
            x -= velVar;
        }
        if (direccion == 3) {
            x += velVar;
        }
        if (vaAChocar(bloques, bombas)) {

            x = tx;
            y = ty;
        }

    }

    public void cambiarPasos() {
        int velPasos = 70;
        if (speed) {
            velPasos += 60;
        }
        if (direccion == 0 || direccion == 1) {
            velPasos += 20;
        }
        contPasos += 10;
        if (contPasos >= velPasos) {
            pasos += 1;
            if (pasos == 4) {
                pasos = 0;
            }
            contPasos = 0;
        }
    }

    /**
     * verifica si el bomberman va a chocar con un muro
     *
     * @param bloques matriz de bloques del nivel
     * @return true en caso chocar, false en caso de no chocar
     */
    public boolean vaAChocar(Bloque[][] bloques, LinkedList<Bomba> bombas) {
        for (Bloque[] bloque : bloques) {
            for (Bloque value : bloque) {
                if (!wallPass) {
                    if (value.getTipo() != 0 && getBondsBomber().intersects(value.getBonds())) {
                        return true;
                    }
                } else {
                    if (value.getTipo() != 0 && value.getTipo() != 2 && getBondsBomber().intersects(value.getBonds())) {
                        return true;
                    }
                }

            }
        }
        for (Bomba bomba : bombas) {
            if ((!bombPass) && (bomba.getEstado() == 1) && (!bomba.isIntangibleBomber())
                    && (getBondsBomber().intersects(bomba.getBonesBomb()))) {
                return true;
            }
        }
        return false;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVelConst(int velocidad) {
        this.velConst = velocidad;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public void setDetonator(boolean detonator) {
        this.detonator = detonator;
    }

    public void setConVida(boolean conVida) {
        this.conVida = conVida;
    }

    public int getX() {
        return x;
    }

    public boolean isSpeed() {
        return speed;
    }

    public void setSpeed(boolean speed) {
        this.speed = speed;
    }

    public int getY() {
        return y;
    }

    public int getDireccion() {
        return direccion;
    }

    public int getVelConst() {
        return velConst;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getVidas() {
        return vidas;
    }

    public boolean isDetonator() {
        return detonator;
    }

    public boolean isConVida() {
        return conVida;
    }

    public int getVelVar() {
        return velVar;
    }

    public int getContTiempoMuerte() {
        return contTiempoMuerte;
    }

    public void setContTiempoMuerte(int contTiempoMuerte) {
        this.contTiempoMuerte = contTiempoMuerte;
    }

    public boolean isWallPass() {
        return wallPass;
    }

    public boolean isBombPass() {
        return bombPass;
    }

    public void setWallPass(boolean wallPass) {
        this.wallPass = wallPass;
    }

    public void setBombPass(boolean bombPass) {
        this.bombPass = bombPass;
    }

}