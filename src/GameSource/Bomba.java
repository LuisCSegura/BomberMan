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
 *
 * @author LuisKa
 */
public class Bomba {

    private int x;
    private int y;
    private int rango;
    private int tiempo;
    private int tiempoDetonacion;
    private int estado;
    private int contTiempo;
    private int pasos;
    private int contPasos;
    private boolean intangibleBomber;
    private boolean intangibleEnemies;
    private boolean pegoEnemies;

    public Bomba(int x, int y, int rango) {
        this.x = x;
        this.y = y;
        this.rango = rango;
        tiempo = 0;
        tiempoDetonacion = 0;
        estado = 1;
        contTiempo = 0;
        pasos = 0;
        contPasos = 0;
        intangibleBomber = true;
        intangibleEnemies = true;
        pegoEnemies=false;
    }

    /**
     * pinta las caracteristicas visuales de la bomba sin explotar
     *
     * @param g componente grfico
     */
    public void pintar(Graphics g, Bloque[][] bloques, LinkedList<Enemigo> enemigos, Bomberman bomber) {
        if (estado == 1) {
            
            if (pasos == 0) {
                g.setColor(Color.BLACK);
                g.fillOval(x, y + 1, 50, 49);
                g.setColor(Color.white);
                g.fillArc(x + 5, y + 6, 40, 38, 125, 55);
                g.setColor(Color.BLACK);
                g.fillOval(x + 10, y + 11, 30, 28);
                g.setColor(Color.white);
                g.fillRect(x + 25, y + 3, 2, 7);
                g.fillRect(x + 25, y + 3, 4, 2);
                g.fillRect(x + 28, y, 2, 4);
                g.fillRect(x + 28, y, 7, 2);
                g.fillRect(x + 38, y, 2, 2);
                g.fillRect(x + 41, y + 4, 2, 2);
                g.fillRect(x + 44, y, 2, 2);
            } else if (pasos == 1 || pasos == 3) {
                g.setColor(Color.BLACK);
                g.fillOval(x + 2, y + 1, 46, 49);
                g.setColor(Color.white);
                g.fillArc(x + 7, y + 6, 36, 38, 125, 55);
                g.setColor(Color.BLACK);
                g.fillOval(x + 12, y + 11, 26, 28);
                g.setColor(Color.white);
                g.fillRect(x + 25, y + 3, 2, 7);
                g.fillRect(x + 25, y + 3, 4, 2);
                g.fillRect(x + 28, y, 2, 4);
                g.fillRect(x + 28, y, 6, 2);
                g.fillRect(x + 38, y, 2, 2);
                g.fillRect(x + 36, y + 4, 2, 2);
            } else if (pasos == 2) {
                g.setColor(Color.BLACK);
                g.fillOval(x + 4, y, 42, 50);
                g.setColor(Color.white);
                g.fillArc(x + 9, y + 6, 32, 38, 125, 55);
                g.setColor(Color.BLACK);
                g.fillOval(x + 14, y + 11, 22, 28);
                g.setColor(Color.white);
                g.fillRect(x + 25, y + 5, 2, 7);
                g.fillRect(x + 25, y + 5, 4, 2);
                g.fillRect(x + 28, y + 2, 2, 4);
                g.fillRect(x + 28, y + 2, 7, 2);
                g.fillRect(x + 40, y, 2, 2);
                g.fillRect(x + 42, y + 6, 2, 2);

            }
        }
        if (estado==2){
            pintarExplosion(g, bloques, enemigos, bomber);
        }
        
    }
    public void mover(Bomberman bomber, LinkedList<Enemigo> enemigos ){
        if (estado == 1) {
            tiempo += 10;
            contPasos += 10;
            if (contPasos == 200) {
                pasos += 1;
                if (pasos == 4) {
                    pasos = 0;
                }
                contPasos = 0;
            }
        }
        
        if (!bomber.isDetonator()) {
                if (estado == 1 && tiempo >= 2000) {
                    estado=2;
                }
        }
        if (estado==2){
            tiempoDetonacion+=10;
            contTiempo += 10;
            if (contTiempo >= 500) {
                contTiempo = 0;
            }
        }
        if (estado == 2 && tiempoDetonacion >= 500) {
            estado=0;
            int cantEnem = 0;
                int puntosEnem = 0;
                for (Enemigo enemigo : enemigos) {
                    if (enemigo.getEstado() == 2) {
                        cantEnem++;
                        puntosEnem += enemigo.getPuntos();
                    }

                }
                bomber.setPuntaje(bomber.getPuntaje() + (puntosEnem * cantEnem));
                cantEnem = 0;
                puntosEnem = 0;
        }
    }

    /**
     * pinata los componenetes de la bomba al explotar
     *
     * @param g componente grfico
     * @param bloques matriz de bloques del nivel
     * @param enemigos lista de enemigos del nivel
     * @param bomber bomberman
     */
    public void pintarExplosion(Graphics g, Bloque[][] bloques, LinkedList<Enemigo> enemigos, Bomberman bomber) {
            int ySup = y - 50;
            int yInf = y + 50;
            int xIzq = x - 50;
            int xDer = x + 50;
            boolean arriba = true;
            boolean abajo = true;
            boolean izquierda = true;
            boolean derecha = true;

            for (int i = 0; i < rango; i++) {
                if (arriba) {
                    if (!vaAChocar(x, ySup, bloques, enemigos, bomber)) {
                        if (i < rango - 1) {
                            pintarBrazos(g, 0, ySup, yInf, xDer, xIzq);
                        } else {
                            pintarExtremos(g, 0, ySup, yInf, xDer, xIzq);
                        }

                    } else {
                        arriba = false;
                    }
                }
                if (abajo) {
                    if (!vaAChocar(x, yInf, bloques, enemigos, bomber)) {
                        if (i < rango - 1) {
                            pintarBrazos(g, 1, ySup, yInf, xDer, xIzq);
                        } else {
                            pintarExtremos(g, 1, ySup, yInf, xDer, xIzq);
                        }
                    } else {
                        abajo = false;
                    }
                }

                if (izquierda) {
                    if (!vaAChocar(xIzq, y, bloques, enemigos, bomber)) {
                        if (i < rango - 1) {
                            pintarBrazos(g, 2, ySup, yInf, xDer, xIzq);
                        } else {
                            pintarExtremos(g, 2, ySup, yInf, xDer, xIzq);
                        }

                    } else {
                        izquierda = false;
                    }
                }
                if (derecha) {
                    if (!vaAChocar(xDer, y, bloques, enemigos, bomber)) {
                        if (i < rango - 1) {
                            pintarBrazos(g, 3, ySup, yInf, xDer, xIzq);
                        } else {
                            pintarExtremos(g, 3, ySup, yInf, xDer, xIzq);
                        }
                    } else {
                        derecha = false;
                    }
                }

                ySup -= 50;
                yInf += 50;
                xIzq -= 50;
                xDer += 50;

            }
            if (contTiempo < 50 || contTiempo >= 450) {
                g.setColor(new Color(216, 40, 0));
                g.fillOval(x + 3, y + 3, 44, 44);
                g.fillRect(x + 15, y, 20, 50);
                g.fillRect(x, y + 15, 50, 20);
                g.fillRect(x + 14, y + 3, 22, 44);
                g.fillRect(x + 3, y + 14, 44, 22);
                g.setColor(new Color(252, 116, 96));
                g.fillOval(x + 10, y + 10, 30, 30);
                g.fillRect(x + 19, y, 12, 50);
                g.fillRect(x, y + 19, 50, 12);
                g.fillRect(x + 18, y + 6, 14, 38);
                g.fillRect(x + 6, y + 18, 38, 14);
                g.setColor(new Color(252, 188, 176));
                g.fillOval(x + 12, y + 12, 26, 26);
                g.fillRect(x + 20, y + 7, 10, 36);
                g.fillRect(x + 7, y + 20, 36, 10);
                g.fillRect(x + 22, y + 5, 6, 40);
                g.fillRect(x + 5, y + 22, 40, 6);
                g.fillRect(x + 13, y + 9, 3, 3);
                g.fillRect(x + 13, y + 36, 3, 3);
                g.fillRect(x + 36, y + 36, 3, 3);
                g.setColor(new Color(216, 40, 0));
                g.fillRect(x + 15, y + 15, 3, 6);
                g.fillRect(x + 23, y + 18, 3, 6);
                g.fillRect(x + 28, y + 16, 3, 6);
                g.fillRect(x + 21, y + 27, 3, 6);
                g.fillRect(x + 34, y + 20, 3, 6);
                g.fillRect(x + 31, y + 29, 3, 6);
                g.fillRect(x + 31, y + 25, 4, 4);
                g.fillRect(x + 24, y + 25, 4, 4);
                g.fillRect(x + 13, y + 27, 4, 4);
                g.fillRect(x + 23, y + 13, 4, 4);
                g.fillRect(x + 23, y + 35, 3, 3);
                g.fillRect(x + 12, y + 24, 3, 3);
                g.fillRect(x + 34, y + 24, 3, 3);
                g.fillRect(x + 40, y + 22, 3, 3);
                g.fillRect(x + 32, y + 21, 3, 3);
                g.fillRect(x + 12, y + 22, 3, 3);
                g.fillRect(x + 10, y + 24, 3, 3);
                g.fillRect(x + 24, y + 26, 3, 3);
                g.fillRect(x + 29, y + 22, 3, 3);
                g.fillRect(x + 25, y + 16, 2, 4);
                g.fillRect(x + 16, y + 16, 2, 4);
                g.fillRect(x + 13, y + 12, 2, 4);
                g.fillRect(x + 16, y + 22, 3, 6);
                g.fillRect(x + 17, y + 22, 3, 6);
                g.fillRect(x + 15, y + 24, 3, 6);
                g.fillRect(x + 25, y + 10, 6, 3);
                g.fillRect(x + 29, y + 29, 6, 3);
                g.fillRect(x + 25, y + 7, 6, 3);
                g.fillRect(x + 20, y + 8, 3, 5);

            } else if (contTiempo < 100 || contTiempo >= 400) {
                g.setColor(new Color(216, 40, 0));
                g.fillOval(x, y, 50, 50);
                g.fillRect(x + 12, y, 26, 50);
                g.fillRect(x, y + 12, 50, 26);
                g.fillRect(x + 10, y + 2, 30, 46);
                g.fillRect(x + 2, y + 10, 46, 30);
                g.setColor(new Color(252, 116, 96));
                g.fillOval(x + 9, y + 9, 32, 32);
                g.fillRect(x + 19, y, 12, 50);
                g.fillRect(x, y + 19, 50, 12);
                g.fillRect(x + 18, y + 5, 14, 40);
                g.fillRect(x + 5, y + 18, 40, 14);
                g.setColor(new Color(252, 188, 176));
                g.fillOval(x + 12, y + 12, 26, 26);
                g.fillRect(x + 22, y, 6, 50);
                g.fillRect(x, y + 22, 50, 6);
                g.fillRect(x + 22, y + 6, 8, 38);
                g.fillRect(x + 6, y + 22, 38, 8);
                g.fillRect(x + 20, y + 9, 8, 32);
                g.fillRect(x + 9, y + 20, 32, 8);
                g.fillRect(x + 13, y + 9, 3, 3);
                g.fillRect(x + 34, y + 9, 3, 3);
                g.fillRect(x + 37, y + 7, 3, 3);
                g.fillRect(x + 32, y + 5, 2, 2);
                g.fillRect(x + 9, y + 10, 3, 2);
                g.fillRect(x + 10, y + 14, 7, 2);
                g.fillRect(x + 10, y + 12, 3, 3);
                g.fillRect(x + 13, y + 36, 3, 3);
                g.fillRect(x + 11, y + 38, 2, 2);
                g.fillRect(x + 17, y + 38, 2, 2);
                g.fillRect(x + 36, y + 36, 3, 3);
                g.fillRect(x + 39, y + 34, 2, 3);

            } else if (contTiempo < 150 || contTiempo >= 350) {
                g.setColor(new Color(216, 40, 0));
                g.fillRoundRect(x, y + 3, 50, 44, 5, 5);
                g.fillRoundRect(x + 3, y, 44, 50, 5, 5);
                g.setColor(new Color(252, 116, 96));
                g.fillOval(x + 3, y + 3, 44, 44);
                g.fillRect(x + 16, y, 18, 50);
                g.fillRect(x, y + 16, 50, 18);
                g.fillRect(x + 15, y + 2, 20, 46);
                g.fillRect(x + 2, y + 15, 46, 20);
                g.fillRect(x + 42, y + 42, 3, 2);
                g.fillRect(x + 12, y + 1, 2, 2);
                g.setColor(new Color(252, 188, 176));
                g.fillOval(x + 10, y + 10, 30, 30);
                g.fillRect(x + 20, y, 10, 50);
                g.fillRect(x, y + 20, 50, 10);
                g.fillRect(x + 19, y + 3, 12, 44);
                g.fillRect(x + 16, y + 10, 12, 32);
                g.fillRect(x + 3, y + 19, 44, 12);
                g.fillRect(x + 2, y + 17, 2, 15);
                g.fillRect(x + 17, y, 15, 2);
                g.fillRect(x + 46, y + 17, 2, 16);
                g.fillRect(x + 41, y + 18, 3, 15);
                g.fillRect(x + 17, y + 46, 16, 4);
            } else if (contTiempo < 350) {
                g.setColor(new Color(216, 40, 0));
                g.fillRoundRect(x, y, 50, 50, 5, 5);
                g.setColor(new Color(252, 116, 96));
                g.fillRoundRect(x + 3, y + 3, 44, 44, 5, 5);
                g.fillRect(x, y + 5, 50, 40);
                g.fillRect(x + 5, y, 40, 50);
                g.setColor(new Color(252, 188, 176));
                g.fillRoundRect(x + 5, y + 5, 40, 40, 7, 7);
                g.fillRect(x, y + 10, 50, 30);
                g.fillRect(x + 10, y, 30, 50);
                g.setColor(new Color(252, 116, 96));
                g.fillRect(x + 10, y + 10, 3, 5);
                g.fillRect(x + 7, y + 7, 3, 4);
                g.fillRect(x + 40, y + 5, 3, 4);
                g.fillRect(x + 37, y + 4, 3, 4);
                g.fillRect(x + 41, y + 8, 6, 4);
                g.fillRect(x + 41, y + 40, 6, 4);
            }
            
        

    }

    private void pintarBrazos(Graphics g, int dir, int ySup, int yInf, int xDer, int xIzq) {
        switch (dir) {
            case 0:
                if (contTiempo < 50 || contTiempo >= 450) {
                    g.setColor(new Color(216, 40, 0));
                    distVertical(g, 50, 7, 15, ySup, 20, 4);
                    g.fillRect(x + 17, ySup, 16, 50);
                    g.setColor(new Color(252, 116, 96));
                    distVertical(g, 50, 8, 19, ySup, 12, 5);
                    g.fillRect(x + 21, ySup, 8, 50);

                } else if (contTiempo < 100 || contTiempo >= 400) {
                    g.setColor(new Color(216, 40, 0));
                    distVertical(g, 50, 8, 12, ySup, 26, 5);
                    g.fillRect(x + 14, ySup, 22, 50);
                    g.setColor(new Color(252, 116, 96));
                    distVertical(g, 50, 9, 19, ySup, 12, 6);
                    g.fillRect(x + 21, ySup, 8, 50);
                    g.setColor(new Color(252, 188, 176));
                    distVertical(g, 50, 10, 22, ySup, 6, 7);
                    g.fillRect(x + 24, ySup, 2, 50);

                } else if (contTiempo < 150 || contTiempo >= 350) {
                    g.setColor(new Color(216, 40, 0));
                    distVertical(g, 50, 9, 5, ySup, 40, 6);
                    g.fillRect(x + 7, ySup, 36, 50);
                    g.setColor(new Color(252, 116, 96));
                    distVertical(g, 50, 10, 16, ySup, 18, 7);
                    g.fillRect(x + 18, ySup, 14, 50);
                    g.setColor(new Color(252, 188, 176));
                    distVertical(g, 50, 11, 20, ySup, 10, 8);
                    g.fillRect(x + 22, ySup, 6, 50);
                } else if (contTiempo < 350) {
                    g.setColor(new Color(216, 40, 0));
                    distVertical(g, 50, 10, 1, ySup, 48, 7);
                    g.fillRect(x + 3, ySup, 44, 50);
                    g.setColor(new Color(252, 116, 96));
                    distVertical(g, 50, 11, 5, ySup, 40, 8);
                    g.fillRect(x + 7, ySup, 36, 50);
                    g.setColor(new Color(252, 188, 176));
                    distVertical(g, 50, 12, 10, ySup, 30, 9);
                    g.fillRect(x + 12, ySup, 26, 50);
                }
                break;
            case 1:
                if (contTiempo < 50 || contTiempo >= 450) {
                    g.setColor(new Color(216, 40, 0));
                    distVertical(g, 50, 7, 15, yInf, 20, 4);
                    g.fillRect(x + 17, yInf, 16, 50);
                    g.setColor(new Color(252, 116, 96));
                    distVertical(g, 50, 8, 19, yInf, 12, 5);
                    g.fillRect(x + 21, yInf, 8, 50);

                } else if (contTiempo < 100 || contTiempo >= 400) {
                    g.setColor(new Color(216, 40, 0));
                    distVertical(g, 50, 8, 12, yInf, 26, 5);
                    g.fillRect(x + 14, yInf, 22, 50);
                    g.setColor(new Color(252, 116, 96));
                    distVertical(g, 50, 9, 19, yInf, 12, 6);
                    g.fillRect(x + 21, yInf, 8, 50);
                    g.setColor(new Color(252, 188, 176));
                    distVertical(g, 50, 10, 22, yInf, 6, 7);
                    g.fillRect(x + 24, yInf, 2, 50);

                } else if (contTiempo < 150 || contTiempo >= 350) {
                    g.setColor(new Color(216, 40, 0));
                    distVertical(g, 50, 9, 5, yInf, 40, 6);
                    g.fillRect(x + 7, yInf, 36, 50);
                    g.setColor(new Color(252, 116, 96));
                    distVertical(g, 50, 10, 16, yInf, 18, 7);
                    g.fillRect(x + 18, yInf, 14, 50);
                    g.setColor(new Color(252, 188, 176));
                    distVertical(g, 50, 11, 20, yInf, 10, 8);
                    g.fillRect(x + 22, yInf, 6, 50);
                } else if (contTiempo < 350) {
                    g.setColor(new Color(216, 40, 0));
                    distVertical(g, 50, 10, 1, yInf, 48, 7);
                    g.fillRect(x + 3, yInf, 44, 50);
                    g.setColor(new Color(252, 116, 96));
                    distVertical(g, 50, 11, 5, yInf, 40, 8);
                    g.fillRect(x + 7, yInf, 36, 50);
                    g.setColor(new Color(252, 188, 176));
                    distVertical(g, 50, 12, 10, yInf, 30, 9);
                    g.fillRect(x + 12, yInf, 26, 50);
                }
                break;
            case 2:
                if (contTiempo < 50 || contTiempo >= 450) {
                    g.setColor(new Color(216, 40, 0));
                    distHorizontal(g, 50, 7, 15, xIzq, 20, 4);
                    g.fillRect(xIzq, y + 17, 50, 16);
                    g.setColor(new Color(252, 116, 96));
                    distHorizontal(g, 50, 8, 19, xIzq, 12, 5);
                    g.fillRect(xIzq, y + 21, 50, 8);

                } else if (contTiempo < 100 || contTiempo >= 400) {
                    g.setColor(new Color(216, 40, 0));
                    distHorizontal(g, 50, 8, 12, xIzq, 26, 5);
                    g.fillRect(xIzq, y + 14, 50, 22);
                    g.setColor(new Color(252, 116, 96));
                    distHorizontal(g, 50, 9, 19, xIzq, 12, 6);
                    g.fillRect(xIzq, y + 21, 50, 8);
                    g.setColor(new Color(252, 188, 176));
                    distHorizontal(g, 50, 10, 22, xIzq, 6, 7);
                    g.fillRect(xIzq, y + 24, 50, 2);

                } else if (contTiempo < 150 || contTiempo >= 350) {
                    g.setColor(new Color(216, 40, 0));
                    distHorizontal(g, 50, 9, 5, xIzq, 40, 6);
                    g.fillRect(xIzq, y + 7, 50, 36);
                    g.setColor(new Color(252, 116, 96));
                    distHorizontal(g, 50, 10, 16, xIzq, 18, 7);
                    g.fillRect(xIzq, y + 18, 50, 14);
                    g.setColor(new Color(252, 188, 176));
                    distHorizontal(g, 50, 11, 20, xIzq, 10, 8);
                    g.fillRect(xIzq, y + 22, 50, 6);

                } else if (contTiempo < 350) {
                    g.setColor(new Color(216, 40, 0));
                    distHorizontal(g, 50, 10, 1, xIzq, 48, 7);
                    g.fillRect(xIzq, y + 3, 50, 44);
                    g.setColor(new Color(252, 116, 96));
                    distHorizontal(g, 50, 11, 5, xIzq, 40, 8);
                    g.fillRect(xIzq, y + 7, 50, 36);
                    g.setColor(new Color(252, 188, 176));
                    distHorizontal(g, 50, 12, 10, xIzq, 30, 9);
                    g.fillRect(xIzq, y + 12, 50, 26);
                }
                break;
            case 3:
                if (contTiempo < 50 || contTiempo >= 450) {
                    g.setColor(new Color(216, 40, 0));
                    distHorizontal(g, 50, 7, 15, xDer, 20, 4);
                    g.fillRect(xDer, y + 17, 50, 16);
                    g.setColor(new Color(252, 116, 96));
                    distHorizontal(g, 50, 8, 19, xDer, 12, 5);
                    g.fillRect(xDer, y + 21, 50, 8);

                } else if (contTiempo < 100 || contTiempo >= 400) {
                    g.setColor(new Color(216, 40, 0));
                    distHorizontal(g, 50, 8, 12, xDer, 26, 5);
                    g.fillRect(xDer, y + 14, 50, 22);
                    g.setColor(new Color(252, 116, 96));
                    distHorizontal(g, 50, 9, 19, xDer, 12, 6);
                    g.fillRect(xDer, y + 21, 50, 8);
                    g.setColor(new Color(252, 188, 176));
                    distHorizontal(g, 50, 10, 22, xDer, 6, 7);
                    g.fillRect(xDer, y + 24, 50, 2);

                } else if (contTiempo < 150 || contTiempo >= 350) {
                    g.setColor(new Color(216, 40, 0));
                    distHorizontal(g, 50, 9, 5, xDer, 40, 6);
                    g.fillRect(xDer, y + 7, 50, 36);
                    g.setColor(new Color(252, 116, 96));
                    distHorizontal(g, 50, 10, 16, xDer, 18, 7);
                    g.fillRect(xDer, y + 18, 50, 14);
                    g.setColor(new Color(252, 188, 176));
                    distHorizontal(g, 50, 11, 20, xDer, 10, 8);
                    g.fillRect(xDer, y + 22, 50, 6);
                } else if (contTiempo < 350) {
                    g.setColor(new Color(216, 40, 0));
                    distHorizontal(g, 50, 10, 1, xDer, 48, 7);
                    g.fillRect(xDer, y + 3, 50, 44);
                    g.setColor(new Color(252, 116, 96));
                    distHorizontal(g, 50, 11, 5, xDer, 40, 8);
                    g.fillRect(xDer, y + 7, 50, 36);
                    g.setColor(new Color(252, 188, 176));
                    distHorizontal(g, 50, 12, 10, xDer, 30, 9);
                    g.fillRect(xDer, y + 12, 50, 26);
                }
                break;
        }

    }

    private void distVertical(Graphics g, int lim, int frecuencia, int origen, int dy, int largo, int ancho) {
        int al = 1;
        for (int i = 0; i < lim - ancho - 1; i += frecuencia) {
            g.fillRect(x + origen + al, dy + i, largo, ancho + al);
            al = -al;
        }
    }

    private void distHorizontal(Graphics g, int lim, int frecuencia, int origen, int dx, int largo, int ancho) {
        int al = 1;
        for (int i = 0; i < lim - ancho - 1; i += frecuencia) {
            g.fillRect(dx + i, y + origen + al, ancho + al, largo);
            al = -al;
        }
    }

    private void distExtremoVertical(Graphics g, int lim, int frecuencia, int origenX, int origenY, int dy, int largo) {
        int al = 1;
        for (int i = 0; i < lim; i += frecuencia) {
            g.fillRect(x + origenX + i, dy + origenY + al, largo + al, 3);
            al = -al;
        }
    }

    private void distExtremoHorizontal(Graphics g, int lim, int frecuencia, int origenX, int origenY, int dx, int largo) {
        int al = 1;
        for (int i = 0; i < lim; i += frecuencia) {
            g.fillRect(dx + origenX + al, y + origenY + i, 3, largo + al);
            al = -al;
        }
    }

    private void pintarExtremos(Graphics g, int dir, int ySup, int yInf, int xDer, int xIzq) {
        switch (dir) {
            case 0:
                if (contTiempo < 50 || contTiempo >= 450) {
                    g.setColor(new Color(216, 40, 0));
                    distVertical(g, 33, 7, 15, ySup + 17, 20, 4);
                    distExtremoVertical(g, 20, 7, 15, 15, ySup, 4);
                    g.fillRect(x + 17, ySup + 17, 16, 33);
                    g.setColor(new Color(252, 116, 96));
                    distVertical(g, 29, 8, 19, ySup + 21, 12, 5);
                    distExtremoVertical(g, 12, 8, 19, 19, ySup, 5);
                    g.fillRect(x + 21, ySup + 21, 8, 29);

                } else if (contTiempo < 100 || contTiempo >= 400) {
                    g.setColor(new Color(216, 40, 0));
                    distVertical(g, 38, 8, 12, ySup + 12, 26, 5);
                    distExtremoVertical(g, 26, 8, 12, 10, ySup, 5);
                    g.fillRect(x + 14, ySup + 12, 22, 38);
                    g.setColor(new Color(252, 116, 96));
                    distVertical(g, 31, 9, 19, ySup + 19, 12, 6);
                    distExtremoVertical(g, 12, 9, 19, 17, ySup, 6);
                    g.fillRect(x + 21, ySup + 19, 8, 31);
                    g.setColor(new Color(252, 188, 176));
                    distVertical(g, 28, 10, 22, ySup + 22, 6, 7);
                    distExtremoVertical(g, 6, 10, 22, 20, ySup, 7);
                    g.fillRect(x + 24, ySup + 22, 2, 28);

                } else if (contTiempo < 150 || contTiempo >= 350) {
                    g.setColor(new Color(216, 40, 0));
                    distVertical(g, 43, 9, 5, ySup + 7, 40, 6);
                    distExtremoVertical(g, 40, 9, 5, 5, ySup, 6);
                    g.fillRect(x + 7, ySup + 7, 36, 43);
                    g.setColor(new Color(252, 116, 96));
                    distVertical(g, 32, 10, 16, ySup + 18, 18, 7);
                    distExtremoVertical(g, 18, 10, 16, 16, ySup, 7);
                    g.fillRect(x + 18, ySup + 18, 14, 32);
                    g.setColor(new Color(252, 188, 176));
                    distVertical(g, 28, 11, 20, ySup + 22, 10, 8);
                    distExtremoVertical(g, 10, 11, 20, 20, ySup, 8);
                    g.fillRect(x + 22, ySup + 22, 6, 28);

                } else if (contTiempo < 350) {
                    g.setColor(new Color(216, 40, 0));
                    distVertical(g, 48, 10, 1, ySup + 2, 48, 7);
                    distExtremoVertical(g, 48, 10, 1, 1, ySup, 7);
                    g.fillRect(x + 3, ySup + 2, 44, 48);
                    g.setColor(new Color(252, 116, 96));
                    distVertical(g, 44, 11, 5, ySup + 6, 40, 8);
                    distExtremoVertical(g, 40, 11, 5, 5, ySup, 8);
                    g.fillRect(x + 7, ySup + 6, 36, 44);
                    g.setColor(new Color(252, 188, 176));
                    distVertical(g, 39, 12, 10, ySup + 11, 30, 9);
                    distExtremoVertical(g, 30, 12, 10, 10, ySup, 9);
                    g.fillRect(x + 12, ySup + 11, 26, 39);
                }
                break;
            case 1:
                if (contTiempo < 50 || contTiempo >= 450) {
                    g.setColor(new Color(216, 40, 0));
                    distVertical(g, 35, 7, 15, yInf, 20, 4);
                    distExtremoVertical(g, 20, 7, 15, 32, yInf, 4);
                    g.fillRect(x + 17, yInf, 16, 35);
                    g.setColor(new Color(252, 116, 96));
                    distVertical(g, 31, 8, 19, yInf, 12, 5);
                    distExtremoVertical(g, 12, 8, 19, 28, yInf, 5);
                    g.fillRect(x + 21, yInf, 8, 31);

                } else if (contTiempo < 100 || contTiempo >= 400) {
                    g.setColor(new Color(216, 40, 0));
                    distVertical(g, 40, 8, 12, yInf, 26, 5);
                    distExtremoVertical(g, 26, 8, 12, 37, yInf, 5);
                    g.fillRect(x + 14, yInf, 22, 40);
                    g.setColor(new Color(252, 116, 96));
                    distVertical(g, 33, 9, 19, yInf, 12, 6);
                    distExtremoVertical(g, 12, 9, 19, 30, yInf, 6);
                    g.fillRect(x + 21, yInf, 8, 33);
                    g.setColor(new Color(252, 188, 176));
                    distVertical(g, 30, 10, 22, yInf, 6, 7);
                    distExtremoVertical(g, 6, 10, 22, 27, yInf, 7);
                    g.fillRect(x + 24, yInf, 2, 30);

                } else if (contTiempo < 150 || contTiempo >= 350) {
                    g.setColor(new Color(216, 40, 0));
                    distVertical(g, 45, 9, 5, yInf, 40, 6);
                    distExtremoVertical(g, 40, 9, 5, 42, yInf, 6);
                    g.fillRect(x + 7, yInf, 36, 45);
                    g.setColor(new Color(252, 116, 96));
                    distVertical(g, 34, 10, 16, yInf, 18, 7);
                    distExtremoVertical(g, 18, 10, 16, 31, yInf, 7);
                    g.fillRect(x + 18, yInf, 14, 34);
                    g.setColor(new Color(252, 188, 176));
                    distVertical(g, 30, 11, 20, yInf, 10, 8);
                    distExtremoVertical(g, 10, 11, 20, 27, yInf, 8);
                    g.fillRect(x + 22, yInf, 6, 30);
                } else if (contTiempo < 350) {
                    g.setColor(new Color(216, 40, 0));
                    distVertical(g, 48, 10, 1, yInf, 48, 7);
                    distExtremoVertical(g, 48, 10, 1, 46, yInf, 7);
                    g.fillRect(x + 3, yInf, 44, 49);
                    g.setColor(new Color(252, 116, 96));
                    distVertical(g, 46, 11, 5, yInf, 40, 8);
                    distExtremoVertical(g, 40, 11, 5, 42, yInf, 8);
                    g.fillRect(x + 7, yInf, 36, 45);
                    g.setColor(new Color(252, 188, 176));
                    distVertical(g, 41, 12, 10, yInf, 30, 9);
                    distExtremoVertical(g, 30, 12, 10, 37, yInf, 9);
                    g.fillRect(x + 12, yInf, 26, 40);
                }
                break;
            case 2:
                if (contTiempo < 50 || contTiempo >= 450) {
                    g.setColor(new Color(216, 40, 0));
                    distHorizontal(g, 33, 7, 15, xIzq + 17, 20, 4);
                    distExtremoHorizontal(g, 20, 7, 15, 15, xIzq, 4);
                    g.fillRect(xIzq + 17, y + 17, 33, 16);
                    g.setColor(new Color(252, 116, 96));
                    distHorizontal(g, 29, 8, 19, xIzq + 21, 12, 5);
                    distExtremoHorizontal(g, 12, 8, 19, 19, xIzq, 5);
                    g.fillRect(xIzq + 21, y + 21, 29, 8);

                } else if (contTiempo < 100 || contTiempo >= 400) {
                    g.setColor(new Color(216, 40, 0));
                    distHorizontal(g, 38, 8, 12, xIzq + 12, 26, 5);
                    distExtremoHorizontal(g, 26, 8, 12, 10, xIzq, 5);
                    g.fillRect(xIzq + 12, y + 14, 38, 22);
                    g.setColor(new Color(252, 116, 96));
                    distHorizontal(g, 31, 9, 19, xIzq + 19, 12, 6);
                    distExtremoHorizontal(g, 12, 9, 19, 17, xIzq, 6);
                    g.fillRect(xIzq + 19, y + 21, 31, 8);
                    g.setColor(new Color(252, 188, 176));
                    distHorizontal(g, 28, 10, 22, xIzq + 22, 6, 7);
                    distExtremoHorizontal(g, 6, 10, 22, 20, xIzq, 7);
                    g.fillRect(xIzq + 22, y + 24, 28, 2);

                } else if (contTiempo < 150 || contTiempo >= 350) {
                    g.setColor(new Color(216, 40, 0));
                    distHorizontal(g, 43, 9, 5, xIzq + 7, 40, 6);
                    distExtremoHorizontal(g, 40, 9, 5, 5, xIzq, 6);
                    g.fillRect(xIzq + 7, y + 7, 43, 36);
                    g.setColor(new Color(252, 116, 96));
                    distHorizontal(g, 32, 10, 16, xIzq + 18, 18, 7);
                    distExtremoHorizontal(g, 18, 10, 16, 16, xIzq, 7);
                    g.fillRect(xIzq + 18, y + 18, 32, 14);
                    g.setColor(new Color(252, 188, 176));
                    distHorizontal(g, 28, 11, 20, xIzq + 22, 10, 8);
                    distExtremoHorizontal(g, 10, 11, 20, 20, xIzq, 8);
                    g.fillRect(xIzq + 22, y + 22, 28, 6);

                } else if (contTiempo < 350) {
                    g.setColor(new Color(216, 40, 0));
                    distHorizontal(g, 48, 10, 1, xIzq + 2, 48, 7);
                    distExtremoHorizontal(g, 48, 10, 1, 0, xIzq, 7);
                    g.fillRect(xIzq + 2, y + 3, 48, 44);
                    g.setColor(new Color(252, 116, 96));
                    distHorizontal(g, 44, 11, 5, xIzq + 6, 40, 8);
                    distExtremoHorizontal(g, 40, 11, 5, 4, xIzq, 8);
                    g.fillRect(xIzq + 6, y + 7, 44, 36);
                    g.setColor(new Color(252, 188, 176));
                    distHorizontal(g, 39, 12, 10, xIzq + 11, 30, 9);
                    distExtremoHorizontal(g, 30, 12, 10, 9, xIzq, 9);
                    g.fillRect(xIzq + 11, y + 12, 39, 26);
                }
                break;
            case 3:
                if (contTiempo < 50 || contTiempo >= 450) {
                    g.setColor(new Color(216, 40, 0));
                    distHorizontal(g, 35, 7, 15, xDer, 20, 4);
                    distExtremoHorizontal(g, 20, 7, 32, 15, xDer, 4);
                    g.fillRect(xDer, y + 17, 35, 16);
                    g.setColor(new Color(252, 116, 96));
                    distHorizontal(g, 31, 8, 19, xDer, 12, 5);
                    distExtremoHorizontal(g, 12, 8, 28, 19, xDer, 5);
                    g.fillRect(xDer, y + 21, 31, 8);

                } else if (contTiempo < 100 || contTiempo >= 400) {
                    g.setColor(new Color(216, 40, 0));
                    distHorizontal(g, 40, 8, 12, xDer, 26, 5);
                    distExtremoHorizontal(g, 26, 8, 35, 12, xDer, 5);
                    g.fillRect(xDer, y + 14, 40, 22);
                    g.setColor(new Color(252, 116, 96));
                    distHorizontal(g, 33, 9, 19, xDer, 12, 6);
                    distExtremoHorizontal(g, 12, 9, 28, 19, xDer, 6);
                    g.fillRect(xDer, y + 21, 33, 8);
                    g.setColor(new Color(252, 188, 176));
                    distHorizontal(g, 30, 10, 22, xDer, 6, 7);
                    distExtremoHorizontal(g, 6, 10, 25, 22, xDer, 7);
                    g.fillRect(xDer, y + 24, 30, 2);

                } else if (contTiempo < 150 || contTiempo >= 350) {
                    g.setColor(new Color(216, 40, 0));
                    distHorizontal(g, 45, 9, 5, xDer, 40, 6);
                    distExtremoHorizontal(g, 40, 9, 42, 5, xDer, 6);
                    g.fillRect(xDer, y + 7, 45, 36);
                    g.setColor(new Color(252, 116, 96));
                    distHorizontal(g, 34, 10, 16, xDer, 18, 7);
                    distExtremoHorizontal(g, 18, 10, 31, 16, xDer, 7);
                    g.fillRect(xDer, y + 18, 34, 14);
                    g.setColor(new Color(252, 188, 176));
                    distHorizontal(g, 30, 11, 20, xDer, 10, 8);
                    distExtremoHorizontal(g, 10, 11, 27, 20, xDer, 8);
                    g.fillRect(xDer, y + 22, 30, 6);
                } else if (contTiempo < 350) {
                    g.setColor(new Color(216, 40, 0));
                    distHorizontal(g, 48, 10, 1, xDer, 48, 7);
                    distExtremoHorizontal(g, 48, 10, 46, 1, xDer, 7);
                    g.fillRect(xDer, y + 3, 49, 44);
                    g.setColor(new Color(252, 116, 96));
                    distHorizontal(g, 46, 11, 5, xDer, 40, 8);
                    distExtremoHorizontal(g, 40, 11, 42, 5, xDer, 8);
                    g.fillRect(xDer, y + 7, 45, 36);
                    g.setColor(new Color(252, 188, 176));
                    distHorizontal(g, 41, 12, 10, xDer, 30, 9);
                    distExtremoHorizontal(g, 30, 12, 37, 10, xDer, 9);
                    g.fillRect(xDer, y + 12, 40, 26);
                }
                break;
        }

    }
    

    /**
     * crea un rectangulo en la poscicon de las explosiones de la bomba
     *
     * @param x poscicion en x de la explosion
     * @param y poscicion en y de la explosion
     * @return rectangulo
     */
    public Rectangle getBones(int x, int y) {
        return new Rectangle(x+3, y+3, 44, 44);
    }

    /**
     * retorna un rectangulo en la poscicion de la bomba sin explotar
     *
     * @return rectangulo
     */
    public Rectangle getBonesBomb() {
        return new Rectangle(x, y, 50, 50);
    }

    /**
     * verifica si va a chocar conra un muro, un enemigo, o un bomberman
     *
     * @param x poscicion ene x de la explosion
     * @param y poscicion en y de la explosion
     * @param bloques matriz de bloques del nivel
     * @param enemigos lista de enemigos vivios del nivel
     * @param bomber bomberman
     * @return true si va achocar un un bloque, false si no
     */
    private boolean vaAChocar(int x, int y, Bloque[][] bloques, LinkedList<Enemigo> enemigos, Bomberman bomber) {
        for (int i = 0; i < bloques.length; i++) {
            for (int j = 0; j < bloques[i].length; j++) {
                if (bloques[i][j].getTipo() == 3 && bomber.getBonds().intersects(bloques[i][j].getBonds())) {
                    bomber.setConVida(false);
                }
                if (bloques[i][j].getTipo() != 0 && getBones(x, y).intersects(bloques[i][j].getBonds())) {
                    if (bloques[i][j].getTipo() == 2) {
                        bloques[i][j].setTipo(3);
                    }
                    return true;
                }
            }
        }
        for (Enemigo enemigo : enemigos) {
            if ((enemigo.getEstado() == 1 && getBones(x, y).intersects(enemigo.getBondsEnem())) || enemigo.getEstado() == 1 && (getBonesBomb().intersects(enemigo.getBonds()))) {
                enemigo.setEstado(2);
            }
        }
        if ((getBones(x, y).intersects(bomber.getBonds())) || (getBonesBomb().intersects(bomber.getBonds()))) {
                bomber.setConVida(false);
        }
        return false;
    }

    public void tangForBomber(Bomberman bomber) {
        if (!(getBonesBomb().intersects(bomber.getBondsBomber()))) {
            intangibleBomber = false;
        }
    }

    public void tangForEnemies(LinkedList<Enemigo> enemigos) {
        boolean pegaEnemigo = false;
        for (Enemigo enemigo : enemigos) {
            if ((estado==1)&&(enemigo.getEstado()==1) && getBonesBomb().intersects(enemigo.getBonds())) {
                if (!pegoEnemies) {
                    if (enemigo.getDireccion() == 1 || enemigo.getDireccion() == 3) {
                        enemigo.setDireccion(enemigo.getDireccion() - 1);
                    } else {
                        enemigo.setDireccion(enemigo.getDireccion() + 1);
                    }
                }
                pegaEnemigo = true;
                
            }
        }
        if (!pegaEnemigo) {
            intangibleEnemies = false;
        }else{
            pegoEnemies=true;
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setTiempoDetonacion(int tiempoDetonacion) {
        this.tiempoDetonacion = tiempoDetonacion;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRango() {
        return rango;
    }

    public int getTiempo() {
        return tiempo;
    }

    public int getEstado() {
        return estado;
    }

    public int getTiempoDetonacion() {
        return tiempoDetonacion;
    }

    public int getContTiempo() {
        return contTiempo;
    }

    public int getPasos() {
        return pasos;
    }

    public int getContPasos() {
        return contPasos;
    }

    public void setContTiempo(int contTiempo) {
        this.contTiempo = contTiempo;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

    public void setContPasos(int contPasos) {
        this.contPasos = contPasos;
    }

    public boolean isIntangibleBomber() {
        return intangibleBomber;
    }

    public boolean isIntangibleEnemies() {
        return intangibleEnemies;
    }

    public void setIntangibleBomber(boolean intangibleBomber) {
        this.intangibleBomber = intangibleBomber;
    }

    public void setIntangibleEnemies(boolean intangibleEnemies) {
        this.intangibleEnemies = intangibleEnemies;
    }

}
