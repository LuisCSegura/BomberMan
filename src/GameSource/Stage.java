/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameSource;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author LuisKa
 */
public class Stage {

    private int x;
    private int y;
    private int xAnt;
    private int yAnt;
    private int nivel;
    private Bomberman bomber;
    private Puerta puerta;
    private Poder poder;
    private Bloque[][] bloques;
    private int tiempo;
    private boolean corriendo;
    private int cantBombas;
    private int rangoBombas;
    private Font fuenteSubtitulo;
    private int contSubNivel;
    private int estado;
    LinkedList<Bomba> bombas;
    LinkedList<Enemigo> enemigos;

    public Stage(Font fuenteSubtitulo) {
        iniciar(fuenteSubtitulo);

    }
//    METODOS DE CONSTRUCCION
//    ----------------------------------------------------------------------------------------------------------

    /**
     * Asigna los bloques para cada fila y columna del juego
     */
    private void construirBloques() {

        for (int i = 0; i < bloques.length; i++) {
            for (int j = 0; j < bloques[i].length; j++) {
                if (i == 0 || i == 12) {
                    bloques[i][j] = new Bloque(j * 50, (i * 50) + 100, 1);
                } else if (i > 0 && i % 2 != 0) {
                    if (i == 1 && (j == 1 || j == 2)) {
                        bloques[i][j] = new Bloque(j * 50, (i * 50) + 100, 0);
                    } else if (j == 0 || j == 30) {
                        bloques[i][j] = new Bloque(j * 50, (i * 50) + 100, 1);
                    } else {
                        int a = (int) ((Math.random() * 4) + 1);
                        switch (a) {
                            case 1:
                                bloques[i][j] = new Bloque(j * 50, (i * 50) + 100, 2);
                                break;
                            default:
                                bloques[i][j] = new Bloque(j * 50, (i * 50) + 100, 0);
                                break;
                        }
                    }
                } else if (i > 0 && i % 2 == 0) {
                    if (i == 2 && j == 1) {
                        bloques[i][j] = new Bloque(j * 50, (i * 50) + 100, 0);
                    } else if (j == 0 || j % 2 == 0) {
                        bloques[i][j] = new Bloque(j * 50, (i * 50) + 100, 1);
                    } else {
                        int a = (int) ((Math.random() * 4) + 1);
                        switch (a) {
                            case 1:
                                bloques[i][j] = new Bloque(j * 50, (i * 50) + 100, 2);
                                break;
                            default:
                                bloques[i][j] = new Bloque(j * 50, (i * 50) + 100, 0);
                                break;
                        }
                    }
                }

            }
        }
    }

    /**
     * Asigna las posiciones la puerta y el poder en cada nivel ademas de un
     * bloque asiciado a ellas
     */
    private void construirPuertaPoder() {
        int cantBlock = cantBlocPorTipo(2);

        int blockPuerta = (int) ((Math.random() * cantBlock) + 1);
        int blockPoder = (int) ((Math.random() * cantBlock) + 1);
        while (blockPoder == blockPuerta) {
            blockPoder = (int) ((Math.random() * cantBlock) + 1);
        }
        int numBlock = 0;
        for (int i = 0; i < bloques.length; i++) {
            for (int j = 0; j < bloques[i].length; j++) {
                if (bloques[i][j].getTipo() == 2) {
                    numBlock++;
                    if (numBlock == blockPuerta) {
                        puerta = new Puerta(bloques[i][j].getX(), bloques[i][j].getY(), bloques[i][j]);
                    } else if (numBlock == blockPoder) {
                        int aleatorio = (int) (Math.random() * 100) + 1;
                        if (bomber.isDetonator()) {
                            while (aleatorio > 30 && aleatorio <= 40) {
                                aleatorio = (int) (Math.random() * 100) + 1;
                            }
                        }
                        if (bomber.isWallPass()) {
                            while (aleatorio > 70 && aleatorio <= 80) {
                                aleatorio = (int) (Math.random() * 100) + 1;
                            }
                        }
                        if (bomber.isBombPass()) {
                            while (aleatorio > 80 && aleatorio <= 100) {
                                aleatorio = (int) (Math.random() * 100) + 1;
                            }
                        }
                        if (bomber.getVelConst() > 2) {
                            while (aleatorio <= 10) {
                                aleatorio = (int) (Math.random() * 100) + 1;
                            }
                        }
                        int numPoder;
                        if (aleatorio <= 10) {
                            numPoder = 1;
                        } else if (aleatorio <= 30) {
                            numPoder = 2;
                        } else if (aleatorio <= 40) {
                            numPoder = 3;
                        } else if (aleatorio <= 70) {
                            numPoder = 4;
                        } else if (aleatorio <= 80) {
                            numPoder = 5;
                        } else {
                            numPoder = 6;
                        }
                        poder = new Poder(numPoder, bloques[i][j].getX(), bloques[i][j].getY(), bloques[i][j]);
                    }
                }
            }
        }

    }

    /**
     * Asisgna la cantidad de enemigos por nivel, además de sus posciciones en
     * los espacios vacios
     */
    private void construirEnemigos() {
        enemigos.clear();
        int cantEnemNvl1;
        int cantEnemNvl2;
        int cantEnemNvl3;
        LinkedList<Integer> bloquesOcupados = new LinkedList<>();
        switch (nivel) {
            case 1:
                cantEnemNvl1 = 5;
                cantEnemNvl2 = 0;
                cantEnemNvl3 = 0;
                break;
            case 2:
                cantEnemNvl1 = 5;
                cantEnemNvl2 = 3;
                cantEnemNvl3 = 0;
                break;
            case 3:
                cantEnemNvl1 = 5;
                cantEnemNvl2 = 3;
                cantEnemNvl3 = 2;
                break;
            case 4:
                cantEnemNvl1 = 6;
                cantEnemNvl2 = 4;
                cantEnemNvl3 = 3;
                break;
            default:
                cantEnemNvl1 = 7;
                cantEnemNvl2 = 5;
                cantEnemNvl3 = 4;
                break;
        }
        for (int i = 0; i < cantEnemNvl1; i++) {
            int bloqueEnem = (int) ((Math.random() * cantBlocPorTipo(0)) + 1);
            while (bloquesOcupados.contains(bloqueEnem)) {
                bloqueEnem = (int) ((Math.random() * cantBlocPorTipo(0)) + 1);
            }
            bloquesOcupados.add(bloqueEnem);
            agregarEnemigo(bloqueEnem, 1);
        }
        for (int i = 0; i < cantEnemNvl2; i++) {
            int bloqueEnem = (int) ((Math.random() * cantBlocPorTipo(0)) + 1);
            while (bloquesOcupados.contains(bloqueEnem)) {
                bloqueEnem = (int) ((Math.random() * cantBlocPorTipo(0)) + 1);
            }
            bloquesOcupados.add(bloqueEnem);
            agregarEnemigo(bloqueEnem, 2);
        }
        for (int i = 0; i < cantEnemNvl3; i++) {
            int bloqueEnem = (int) ((Math.random() * cantBlocPorTipo(0)) + 1);
            while (bloquesOcupados.contains(bloqueEnem)) {
                bloqueEnem = (int) ((Math.random() * cantBlocPorTipo(0)) + 1);
            }
            bloquesOcupados.add(bloqueEnem);
            agregarEnemigo(bloqueEnem, 3);
        }

    }

    /**
     * Asigna un enemigo por nivel en un bloque preestablecido
     *
     * @param bloque bloque en el que estara el enemigo
     * @param nivel nivel del enemigo
     */
    private void agregarEnemigo(int bloque, int nivel) {
        int cantBlock = 0;
        for (int i = 0; i < bloques.length; i++) {
            for (int j = 0; j < bloques[i].length; j++) {
                int xB = bloques[i][j].getX();
                int yB = bloques[i][j].getY();
                if (!((xB == 50 && yB == 150) || (xB == 100 && yB == 150) || (xB == 50 && yB == 200))) {
                    if (bloques[i][j].getTipo() == 0) {
                        cantBlock++;
                        if (cantBlock == bloque) {
                            Enemigo e = new Enemigo(xB, yB, nivel);
                            enemigos.add(e);
                        }
                    }
                }

            }
        }
    }
//    METODOS DE PINTAR 
//    ----------------------------------------------------------------------------------------------------------

    /**
     * Pinta todos los componentes de un nivel, realiza las operaciones mas
     * basicas y llama a los metodos necesarios
     *
     * @param g Objeto Graphis que permite pintar en la ventana
     */
    public void pintarNivel(Graphics g) {
        //        cambiar X y Y
        for (int i = 0; i < bloques.length; i++) {
            for (int j = 0; j < bloques[i].length; j++) {
                bloques[i][j].setX(bloques[i][j].getX() + (x - xAnt));
                bloques[i][j].setY(bloques[i][j].getY() + (y - yAnt));
            }
        }
        for (Enemigo enemigo : enemigos) {
            enemigo.setX(enemigo.getX() + (x - xAnt));
            enemigo.setY(enemigo.getY() + (y - yAnt));
        }
        for (Bomba bomba : bombas) {
            bomba.setX(bomba.getX() + (x - xAnt));
            bomba.setY(bomba.getY() + (y - yAnt));
        }
        puerta.setX(puerta.getX() + (x - xAnt));
        puerta.setY(puerta.getY() + (y - yAnt));
        poder.setX(poder.getX() + (x - xAnt));
        poder.setY(poder.getY() + (y - yAnt));

        bomber.setX(bomber.getX() + (x - xAnt));
        bomber.setY(bomber.getY() + (y - yAnt));

        xAnt = x;
        yAnt = y;
//        pintar fondo
        g.setColor(new Color(0, 148, 0));
        g.fillRect(0, y + 0, 1550 + 2 * x, 750);
        g.setColor(new Color(188, 188, 188));
        g.fillRect(0, y + 0, 800 + 2 * x, 100);

//        pintar datos
        g.setColor(Color.black);
        g.setFont(fuenteSubtitulo);
        g.drawString("TIME  " + tiempo, x + 25, y + 69);
        g.drawString("" + bomber.getPuntaje(), x + 400, y + 69);
        g.drawString("LEFT " + bomber.getVidas(), x + 600, y + 69);
        g.drawString("TIME  " + tiempo, x + 25, y + 67);
        g.drawString("" + bomber.getPuntaje(), x + 400, y + 67);
        g.drawString("LEFT " + bomber.getVidas(), x + 600, y + 67);
        g.drawString("TIME  " + tiempo, x + 28, y + 65);
        g.drawString("" + bomber.getPuntaje(), x + 403, y + 65);
        g.drawString("LEFT " + bomber.getVidas(), x + 603, y + 65);
        g.drawString("TIME  " + tiempo, x + 28, y + 69);
        g.drawString("" + bomber.getPuntaje(), x + 403, y + 69);
        g.drawString("LEFT " + bomber.getVidas(), x + 603, y + 69);
        g.drawString("TIME  " + tiempo, x + 28, y + 67);
        g.drawString("" + bomber.getPuntaje(), x + 403, y + 67);
        g.drawString("LEFT " + bomber.getVidas(), x + 603, y + 67);
        g.setColor(new Color(252, 252, 252));
        g.drawString("TIME  " + tiempo, x + 25, y + 65);
        g.drawString("" + bomber.getPuntaje(), x + 400, y + 65);
        g.drawString("LEFT " + bomber.getVidas(), x + 600, y + 65);

//        pintar Puerta y Poder
        puerta.pintar(g);
        poder.pintar(g);
//        pinatar bloques
        for (int i = 0; i < bloques.length; i++) {
            for (int j = 0; j < bloques[i].length; j++) {
                bloques[i][j].pintar(g);
            }
        }
//        pintar bombas
        for (Bomba bomba : bombas) {
            bomba.pintar(g, bloques, enemigos, bomber);
        }
//        pintar enenmigos
        for (Enemigo enemigo : enemigos) {
            enemigo.pintar(g);
        }
//        pintar bomberman
        bomber.pintar(g, bloques);
//        pintar estado
        if (estado == 0) {
            g.setColor(Color.BLACK);
            g.fillRect(0, y + 0, 850 + 2 * x, 850);
            g.setFont(fuenteSubtitulo);
            g.setColor(Color.GRAY);
            g.drawString("GAME OVER", x + 283, y + 383);
            g.drawString("GAME OVER", x + 280, y + 383);
            g.drawString("GAME OVER", x + 283, y + 380);
            g.setColor(Color.white);
            g.drawString("GAME OVER", x + 280, y + 380);
            bomber.reStart();
        } else if (estado == 2) {
            g.setColor(Color.BLACK);
            g.fillRect(0, y + 0, 850 + 2 * x, 850);
            g.setFont(fuenteSubtitulo);
            g.setColor(Color.GRAY);
            g.drawString("CONGRATULATIONS ", x + 203, y + 353);
            g.drawString("CONGRATULATIONS ", x + 200, y + 353);
            g.drawString("CONGRATULATIONS ", x + 203, y + 350);
            g.drawString("YOU WIN!", x + 293, y + 413);
            g.drawString("YOU WIN!", x + 290, y + 413);
            g.drawString("YOU WIN!", x + 293, y + 410);
            g.setColor(Color.white);
            g.drawString("CONGRATULATIONS ", x + 200, y + 350);
            g.drawString("YOU WIN!", x + 290, y + 410);
            bomber.reStart();
        } else if (estado == 3) {
            if (contSubNivel < 1000) {
                corriendo = false;
                g.setColor(Color.BLACK);
                g.fillRect(0, y + 0, 850 + 2 * x, 850);
                g.setFont(fuenteSubtitulo);
                g.setColor(Color.GRAY);
                g.drawString("STAGE   " + nivel, x + 310, y + 383);
                g.drawString("STAGE   " + nivel, x + 313, y + 380);
                g.drawString("STAGE   " + nivel, x + 313, y + 383);
                g.setColor(Color.white);
                g.drawString("STAGE   " + nivel, x + 310, y + 380);
                contSubNivel += 10;
            } else {
                contSubNivel = 0;
                estado = 1;
                corriendo = true;
            }
        }
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, x, y * 2 + 750);
        g.fillRect(x + 800, 0, x + 10, y * 2 + 750);

    }
//    METODOS DE ACCIONES
//    ----------------------------------------------------------------------------------------------------------

    /**
     * realiza todoas las acciones que implican movimientos o cambios en la
     * ventana, ademas de llamar a los metodos necesarios
     */
    public void moverNivel() {
        if (corriendo) {
//        perder el juego
            if (tiempo == 0) {
                bomber.setConVida(false);
            }
//        matar a bomberman
            if (!bomber.isConVida()) {
                bomber.setVelConst(0);
                bomber.setContTiempoMuerte(bomber.getContTiempoMuerte() + 10);
                if (bomber.getContTiempoMuerte() >= 2000) {
                    bomber.setVidas(bomber.getVidas() - 1);
                    bomber.setContTiempoMuerte(0);
                    if(bomber.getVidas() >= 0){
                    reiniciar();
                    }
                    else {
                        estado = 0;
                    }
                }

            }
//        agarrar poder

            agarrarPoder();
//        subir de nivel
            if (!puerta.isEstado() && !hayEnemigos()) {
                puerta.setEstado(true);
            }
            if (cruzoPuerta()) {
                subirNivel();
            }
//        mover enemigos
            for (Enemigo enemigo : enemigos) {
                enemigo.mover(bloques, bombas, bomber);
            }
//        mover bomberman
            if (bomber.isSpeed()) {
                moverBomber();
                moverBomber();
            } else {
                moverBomber();
            }
//        tangibilizar bomba
            for (Bomba bomba : bombas) {
                if (bomba.getEstado() == 1) {
                    bomba.tangForBomber(bomber);
                    bomba.tangForEnemies(enemigos);
                }
            }
//        mover bombas
            for (Bomba bomba : bombas) {
                bomba.mover(bomber, enemigos);
            }
//        mover bloques
            for (int i = 0; i < bloques.length; i++) {
                for (int j = 0; j < bloques[i].length; j++) {
                    bloques[i][j].mover();
                }
            }
//          mover poder
            poder.mover();
        }
    }

    private void moverBomber() {
        if (bomber.isConVida()) {
            if (!bomberEnRango()) {
                bomber.mover(bloques, bombas, bomberEnRango());
            } else if (bomber.getVelVar() > 0) {
                int tx = bomber.getX();
                int ty = bomber.getY();
                switch (bomber.getDireccion()) {
                    case 0:
                        bomber.mover(bloques, bombas, true);
                        if (bomber.getX() == tx && ty == bomber.getY() && bomberDesalineado()) {
                            alinearBomberX();
                        }
                        break;
                    case 1:
                        bomber.mover(bloques, bombas, true);
                        if (bomber.getX() == tx && ty == bomber.getY() && bomberDesalineado()) {
                            alinearBomberX();
                        }
                        break;
                    case 2:
                        bomber.cambiarPasos();
                        bomber.mover(bloques, bombas, true);
                        moverTodoDerecha(bomber.getVelConst());
                        if (bomber.vaAChocar(bloques, bombas)) {
                            moverTodoIzquierda(bomber.getVelConst());
                        }
                        break;
                    case 3:
                        bomber.cambiarPasos();
                        bomber.mover(bloques, bombas, true);
                        moverTodoIzquierda(bomber.getVelConst());
                        if (bomber.vaAChocar(bloques, bombas)) {
                            moverTodoDerecha(bomber.getVelConst());
                        }
                        break;
                }
            }
        }
    }

    private void alinearBomberX() {
        int xObjetivo = bomber.getBloque(bloques).getX();
        int dif = xObjetivo - bomber.getX();
        if (dif < 0) {
            moverTodoDerecha(1);
        } else if (dif > 0) {
            moverTodoIzquierda(1);
        }
    }

    private boolean bomberDesalineado() {
        return (bomber.getBloque(bloques).getX() != bomber.getX() || bomber.getBloque(bloques).getY() != bomber.getY());
    }

    public void moverBomberAbajo() {
        bomber.moverAbajo(bloques);
    }

    public void moverBomberArriba() {
        bomber.moverArriba(bloques);
    }

    public void moverBomberIzquierda() {
        bomber.moverIzquierda(bloques);
    }

    public void moverBomberDerecha() {
        bomber.moverDerecha(bloques);
    }

    public void detenerBomber() {
        bomber.detener();
    }

    private boolean bomberEnRango() {
        for (int i = 0; i < bloques.length; i++) {
            for (int j = 0; j < bloques[i].length; j++) {
                if (j == 7) {
                    if ((bomber.getDireccion() == 0 || bomber.getDireccion() == 1)
                            && bomber.getX() > bloques[i][j].getX()
                            && bomber.getX() < bloques[i][j].getX() + 750) {
                        return true;
                    } else if (bomber.getDireccion() == 2
                            && bomber.getX() > bloques[i][j].getX()
                            && bomber.getX() <= bloques[i][j].getX() + 750) {
                        return true;
                    } else if (bomber.getDireccion() == 3
                            && bomber.getX() >= bloques[i][j].getX()
                            && bomber.getX() < bloques[i][j].getX() + 750) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void moverTodoDerecha(int recorrido) {
        for (int i = 0; i < bloques.length; i++) {
            for (int j = 0; j < bloques[i].length; j++) {
                bloques[i][j].setX(bloques[i][j].getX() + recorrido);
            }
        }
        for (Enemigo enemigo : enemigos) {
            enemigo.setX(enemigo.getX() + recorrido);
        }
        for (Bomba bomba : bombas) {
            bomba.setX(bomba.getX() + recorrido);
        }
        puerta.setX(puerta.getX() + recorrido);
        poder.setX(poder.getX() + recorrido);
    }

    private void moverTodoIzquierda(int recorrido) {
        for (int i = 0; i < bloques.length; i++) {
            for (int j = 0; j < bloques[i].length; j++) {
                bloques[i][j].setX(bloques[i][j].getX() - recorrido);
            }
        }
        for (Enemigo enemigo : enemigos) {
            enemigo.setX(enemigo.getX() - recorrido);
        }
        for (Bomba bomba : bombas) {
            bomba.setX(bomba.getX() - recorrido);
        }
        puerta.setX(puerta.getX() - recorrido);
        poder.setX(poder.getX() - recorrido);
    }

    /**
     * agrega una bomba nueva a la lista de bombas a explotar
     */
    public void ponerBomba() {
        if ((cantBombasHay() < cantBombas && lugarDiferente()) && (bomber.isConVida()) && (bomber.getBloque(bloques).getTipo() == 0)) {
            bombas.add(new Bomba(bomber.getBloque(bloques).getX(), bomber.getBloque(bloques).getY(), rangoBombas));
        }
    }

    /**
     * cambia una variable que permite detonar las bombas activas en el momento
     * que se desee
     */
    public void explotarBombasManual() {
        if (bomber.isDetonator()) {
            for (Bomba bomba : bombas) {
                if (bomba.getEstado() == 1) {
                    bomba.setEstado(2);
                }
            }
        }

    }

    /**
     * aumenta el nivel del juego y restaura los valores necesarios para que el
     * jugador empice en la misma poscicion y con las mismas caracteristicas
     */
    public void subirNivel() {
        if (nivel < 5) {
            nivel += 1;
            bombas.clear();
            xAnt = 0;
            yAnt = 0;
            construirBloques();
            construirPuertaPoder();
            construirEnemigos();
            bomber.reUbicar();

            bomber.setVidas(bomber.getVidas() + 1);

            tiempo = 200;
            corriendo = false;
            estado = 3;

        } else {
            corriendo = false;
            estado = 2;
        }
    }

    /**
     * reinicia un mismo nivel cuando el bomberman muere y restaura todos los
     * valores a su estado original tanto los del nivel como los del bomberman
     */
    public void reiniciar() {
        xAnt = 0;
        yAnt = 0;
        bombas.clear();
        tiempo = 200;
        estado = 1;
        construirBloques();
        construirPuertaPoder();
        construirEnemigos();
        bomber.reset();
        corriendo = false;
        estado = 3;
    }

    public void iniciar(Font fuenteSubtitulo) {
        x = 0;
        y = 0;
        xAnt = 0;
        yAnt = 0;
        tiempo = 200;
        nivel = 1;
        cantBombas = 1;
        rangoBombas = 1;
        bomber = new Bomberman(50, 150);
        bloques = new Bloque[13][31];
        bombas = new LinkedList<>();
        enemigos = new LinkedList<>();
        corriendo = true;
        contSubNivel = 0;
        estado = 3;
        this.fuenteSubtitulo = fuenteSubtitulo;
        construirBloques();
        construirEnemigos();
        construirPuertaPoder();

    }
//    VALIDACIONES
//    ----------------------------------------------------------------------------------------------------------

    /**
     * recorre la lista de bombas para saber cuales bombas estan activas
     *
     * @return una cantidad de las bombas activas
     */
    private int cantBombasHay() {
        int cant = 0;
        for (Bomba bomba : bombas) {
            if (bomba.getEstado() == 1) {
                cant++;
            }
        }
        return cant;
    }

    /**
     * verifica que si se esta intentando poner dos bombas en el mismo lugar o
     * no
     *
     * @return true si el lugar es diferente al de cualquier bomba, false si en
     * esa poscicion ya hay una bomba
     */
    private boolean lugarDiferente() {

        for (Bomba bomba : bombas) {
            if (bomba.getEstado() == 1 && bomba.getX() == bomber.getBloque(bloques).getX() && bomba.getY() == bomber.getBloque(bloques).getY()) {
                return false;
            }

        }
        return true;
    }

    /**
     * verifica cuanto bloques hay en la matriz a partir de un tipo especifico
     * de bloque
     *
     * @param tipo tipo de bloque del que se desea saber la cantidad
     * @return una cantidad entera segun los bloques del tipo que existan
     */
    private int cantBlocPorTipo(int tipo) {
        int cantBlock = 0;
        for (int i = 0; i < bloques.length; i++) {
            for (int j = 0; j < bloques[i].length; j++) {
                int xB = bloques[i][j].getX();
                int yB = bloques[i][j].getY();
                if (!((xB == 50 && yB == 150) || (xB == 100 && yB == 150) || (xB == 50 && yB == 200))) {
                    if (bloques[i][j].getTipo() == tipo) {
                        cantBlock++;
                    }
                }

            }
        }
        return cantBlock;
    }

    /**
     * define las variables respectivas segun el tipo de poder que bomberman
     * agarra
     */
    private void agarrarPoder() {
        if (poder.isEstado() && bomber.getMiniBounds().intersects(poder.getBonds())) {
            if (poder.getPoder() == 1) {
                bomber.setSpeed(true);
            } else if (poder.getPoder() == 2) {
                cantBombas += 1;
            } else if (poder.getPoder() == 3) {
                bomber.setDetonator(true);
            } else if (poder.getPoder() == 4) {
                rangoBombas++;
                for (Bomba bomba : bombas) {
                    bomba.setRango(bomba.getRango() + 1);
                }
            } else if (poder.getPoder() == 5) {
                bomber.setWallPass(true);
            } else if (poder.getPoder() == 6) {
                bomber.setBombPass(true);
            }
            poder.setEstado(false);
        }
    }

    /**
     * verifica si hay enemigos vivos en el nivel
     *
     * @return true, si hay enemigos vivos, false si no
     */
    private boolean hayEnemigos() {
        for (Enemigo enemigo : enemigos) {
            if (enemigo.getEstado() == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * verifica si el bomberman ya cruzo la puerta que lo lleva a otro nivel
     *
     * @return
     */
    private boolean cruzoPuerta() {

        if (puerta.isEstado() && bomber.getMiniBounds().intersects(puerta.getBouns())) {
            return true;
        }
        return false;
    }
//    GETTERS
//    ----------------------------------------------------------------------------------------------------------

    public boolean isCorriendo() {
        return corriendo;
    }

    public int getTiempo() {
        return tiempo;
    }

    public int getEstado() {
        return estado;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNivel() {
        return nivel;
    }

    public Bomberman getBomber() {
        return bomber;
    }

    public Puerta getPuerta() {
        return puerta;
    }

    public Poder getPoder() {
        return poder;
    }

    public Bloque[][] getBloques() {
        return bloques;
    }

    public int getCantBombas() {
        return cantBombas;
    }

    public int getRangoBombas() {
        return rangoBombas;
    }

    public Font getFuenteSubtitulo() {
        return fuenteSubtitulo;
    }

    public int getContSubNivel() {
        return contSubNivel;
    }

    public LinkedList<Bomba> getBombas() {
        return bombas;
    }

    public LinkedList<Enemigo> getEnemigos() {
        return enemigos;
    }

//    SETTERS
//    ----------------------------------------------------------------------------------------------------------   
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setBomber(Bomberman bomber) {
        this.bomber = bomber;
    }

    public void setPuerta(Puerta puerta) {
        this.puerta = puerta;
    }

    public void setPoder(Poder poder) {
        this.poder = poder;
    }

    public void setBloques(Bloque[][] bloques) {
        this.bloques = bloques;
    }

    public void setCorriendo(boolean corriendo) {
        this.corriendo = corriendo;
    }

    public void setCantBombas(int cantBombas) {
        this.cantBombas = cantBombas;
    }

    public void setRangoBombas(int rangoBombas) {
        this.rangoBombas = rangoBombas;
    }

    public void setFuenteSubtitulo(Font fuenteSubtitulo) {
        this.fuenteSubtitulo = fuenteSubtitulo;
    }

    public void setContSubNivel(int contSubNivel) {
        this.contSubNivel = contSubNivel;
    }

    public void setBombas(LinkedList<Bomba> bombas) {
        this.bombas = bombas;
    }

    public void setEnemigos(LinkedList<Enemigo> enemigos) {
        this.enemigos = enemigos;
    }

}
