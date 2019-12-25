/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameSource;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LuisKa
 */
public class PanelBomberman extends JPanel implements KeyListener {

    Stage nivel;
    int ms;
    int seg;
    int cont;
    boolean jugando;
    int contGameOver;
    int posFlecha;
    int ultPulsada;
    Font fuenteTitulo;
    Font fuenteSubtitulo;
    Font fuenteMiniSub;
    Font fuenteSimb;

    public PanelBomberman() {
        super();
        nivel = new Stage(fuenteSubtitulo);
        ms = 0;
        seg = 0;
        setFocusable(true);
        addKeyListener(this);
        cont = 0;
        jugando = false;
        contGameOver = 0;
        ultPulsada = 0;
        fuenteTitulo = Util.obtFuente("Bomberfont-Regular.ttf", 203);
        fuenteSubtitulo = Util.obtFuente("ARCADEPI.ttf", 30);
        fuenteMiniSub = fuenteSubtitulo.deriveFont(Font.PLAIN, 25);
        fuenteSimb = Util.obtFuente("seguisym.ttf", 30);
        posFlecha = 540;

    }

    @Override
    public void paint(Graphics g) {
        int x = (getWidth() - 800) / 2;
        int y = (getHeight() - 750) / 2;
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        if (jugando) {
            nivel.setX(x);
            nivel.setY(y);
            if (nivel.isCorriendo()) {
                ms += 10;
                seg = ms / 1000;
                if (seg != cont) {
                    if (nivel.getTiempo() > 0) {
                        nivel.setTiempo(nivel.getTiempo() - 1);
                    }
                    cont = seg;
                }

            }
            if (nivel.getEstado() == 2 || nivel.getEstado() == 0) {
                contGameOver += 10;
                if (contGameOver >= 5000) {
                    jugando = false;
                    nivel.setEstado(1);
                    contGameOver = 0;
                }

            }

            nivel.pintarNivel(g);
            nivel.moverNivel();
        } else {
            pintarMenu(x, y, g);
            
        }

    }
    private void pintarMenu(int x, int y,Graphics g){
       g.setColor(Color.GRAY);
            g.setFont(fuenteSimb);
            g.drawString("▶", x + 255, y + posFlecha + 3);
            g.setColor(Color.WHITE);
            g.setFont(fuenteSimb);
            g.drawString("▶", x + 255, y + posFlecha);
            g.setColor(new Color(247, 185, 55));
            g.fillRect(x + 55, y + 55, 690, 427);
            g.setColor(Color.BLACK);
            g.fillRect(x + 60, y + 60, 680, 417);
            g.setColor(new Color(181, 18, 16));
            g.fillRect(x + 62, y + 62, 678, 415);
            g.setColor(Color.WHITE);
            g.fillRect(x + 55, y + 55, 688, 2);
            g.fillRect(x + 55, y + 477, 687, 2);
            g.fillRect(x + 55, y + 55, 2, 425);
            g.fillRect(x + 740, y + 55, 2, 423);
            g.setFont(fuenteTitulo);
            g.setColor(Color.black);
            g.drawString("B", x + 62, y + 247);
            g.drawString("O", x + 161, y + 247);
            g.drawString("M", x + 286, y + 247);
            g.drawString("B", x + 409, y + 247);
            g.drawString("E", x + 507, y + 247);
            g.drawString("R", x + 604, y + 247);
            g.drawString("M", x + 234, y + 445);
            g.drawString("A", x + 357, y + 445);
            g.drawString("N", x + 458, y + 447);
            g.setColor(new Color(247, 185, 55));
            g.drawString("B", x + 47, y + 227);
            g.drawString("O", x + 146, y + 227);
            g.drawString("M", x + 271, y + 227);
            g.drawString("B", x + 394, y + 227);
            g.drawString("E", x + 492, y + 227);
            g.drawString("R", x + 589, y + 227);
            g.drawString("M", x + 219, y + 424);
            g.drawString("A", x + 342, y + 424);
            g.drawString("N", x + 443, y + 426);
            g.setFont(fuenteSubtitulo);
            g.setColor(Color.GRAY);
            g.drawString("START", x + 333, y + 543);
            g.drawString("START", x + 330, y + 543);
            g.drawString("START", x + 333, y + 540);

            g.drawString("CONTINUE", x + 333, y + 588);
            g.drawString("CONTINUE", x + 330, y + 588);
            g.drawString("CONTINUE", x + 333, y + 585);

            g.drawString("TOP         00", x + 218, y + 663);
            g.drawString("TOP         00", x + 215, y + 663);
            g.drawString("TOP         00", x + 218, y + 660);

            g.drawString("COPYRIGTH 2019 STUDIO BOUNDS", x + 83, y + 713);
            g.drawString("COPYRIGTH 2019 STUDIO BOUNDS", x + 80, y + 713);
            g.drawString("COPYRIGTH 2019 STUDIO BOUNDS", x + 83, y + 710);

            g.setColor(Color.white);
            g.drawString("START", x + 330, y + 540);
            g.drawString("CONTINUE", x + 330, y + 585);
            g.drawString("TOP         00", x + 215, y + 660);
            g.drawString("COPYRIGTH 2019 STUDIO BOUNDS", x + 80, y + 710);

            pintarBrillo(g, x + 84, y + 83, 90, 90);
            pintarBrillo(g, x + 124, y + 121, 270, 90);
            pintarBrillo(g, x + 124, y + 209, 270, 90);
            pintarBrillo(g, x + 183, y + 83, 90, 90);
            pintarBrillo(g, x + 246, y + 207, 270, 90);
            pintarBrillo(g, x + 308, y + 83, 90, 90);
            pintarBrillo(g, x + 387, y + 83, 90, 90);
            pintarBrillo(g, x + 430, y + 83, 90, 90);
            pintarBrillo(g, x + 470, y + 121, 270, 90);
            pintarBrillo(g, x + 470, y + 209, 270, 90);
            pintarBrillo(g, x + 527, y + 83, 90, 90);
            pintarBrillo(g, x + 625, y + 84, 90, 90);
            pintarBrillo(g, x + 663, y + 121, 270, 90);
            pintarBrillo(g, x + 255, y + 281, 90, 90);
            pintarBrillo(g, x + 335, y + 281, 90, 90);
            pintarBrillo(g, x + 377, y + 282, 90, 90);
            pintarBrillo(g, x + 418, y + 320, 270, 90);
            pintarBrillo(g, x + 479, y + 281, 90, 90);
            pintarBrillo(g, x + 541, y + 278, 138, 60);
    }

    private void pintarBrillo(Graphics g, int x, int y, int in, int fn) {
        g.drawArc(x, y, 24, 24, in, fn);
        g.drawArc(x + 1, y + 1, 22, 22, in, fn);
        g.drawArc(x + 2, y + 2, 20, 20, in, fn);
    }

    /**
     * pide confirmacion de si cerrar o no el juego
     */
    public void pausarIniciar() {
        nivel.setCorriendo(!nivel.isCorriendo());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 750);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!jugando) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                posFlecha = 540;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                posFlecha = 585;
            }
        }
        if (nivel.isCorriendo()) {
            if (e.getKeyCode() == KeyEvent.VK_S) {
                nivel.moverBomberAbajo();
                ultPulsada = e.getKeyCode();
            }
            if (e.getKeyCode() == KeyEvent.VK_W) {
                nivel.moverBomberArriba();
                ultPulsada = e.getKeyCode();
            }
            if (e.getKeyCode() == KeyEvent.VK_A) {
                nivel.moverBomberIzquierda();
                ultPulsada = e.getKeyCode();
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                nivel.moverBomberDerecha();
                ultPulsada = e.getKeyCode();
            }

            if (e.getKeyCode() == KeyEvent.VK_K) {
                if (nivel.isCorriendo()) {
                    nivel.ponerBomba();
                }

            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            pausarIniciar();
        }
        if (e.getKeyCode() == KeyEvent.VK_L) {
            if (nivel.isCorriendo()) {
                nivel.explotarBombasManual();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!jugando) {
                jugando = true;
                nivel.iniciar(fuenteSubtitulo);
            }

        }
        if (nivel.isCorriendo()) {
            if (e.getKeyCode() == KeyEvent.VK_S && e.getKeyCode() == ultPulsada) {
                nivel.detenerBomber();
            }
            if (e.getKeyCode() == KeyEvent.VK_W && e.getKeyCode() == ultPulsada) {
                nivel.detenerBomber();
            }
            if (e.getKeyCode() == KeyEvent.VK_A && e.getKeyCode() == ultPulsada) {
                nivel.detenerBomber();
            }
            if (e.getKeyCode() == KeyEvent.VK_D && e.getKeyCode() == ultPulsada) {
                nivel.detenerBomber();
            }
        }

    }

}
