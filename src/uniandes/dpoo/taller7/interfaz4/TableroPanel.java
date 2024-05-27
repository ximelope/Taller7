package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.taller7.modelo.Tablero;

public class TableroPanel extends JPanel {
    protected Tablero tablero; // Representación del tablero en 2D

    public TableroPanel(int tamañoTablero) {
        this.tablero = new Tablero(tamañoTablero);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int tamañoCelda = getWidth() / tablero.darTablero().length;

        // Dibuja el tablero de juego
        for (int fila = 0; fila < tablero.darTablero().length; fila++) {
            for (int columna = 0; columna < tablero.darTablero()[0].length; columna++) {
                int x = columna * tamañoCelda;
                int y = fila * tamañoCelda;
                Rectangle celda = new Rectangle(x, y, tamañoCelda, tamañoCelda);
                // Determina el color de la casilla según su estado en el tablero
                if (tablero.darTablero()[fila][columna]) {
                    g2d.setColor(Color.PINK);
                } else {
                    g2d.setColor(Color.BLACK);
                }
                g2d.fill(celda);
                g2d.setColor(Color.GRAY);
                g2d.draw(celda);
            }
        }
    }

    // Método para actualizar el tamaño del tablero
    public void setTamañoTablero(int tamañoTablero) {
    	
    	this.tablero = new Tablero(tamañoTablero);
        repaint();
    }
    public void mouseClicked(MouseEvent e) {
        int tamañoCelda = getWidth() / tablero.darTablero().length;
        int fila = e.getY() / tamañoCelda;
        int columna = e.getX() / tamañoCelda;
        // Realiza una jugada en la posición clicada
        tablero.jugar(fila, columna);
        // Vuelve a pintar el tablero
        repaint();
    }
    public void actualizarTablero(Tablero nuevoTablero) {
        this.tablero = nuevoTablero;
        repaint(); // Vuelve a pintar el tablero con el nuevo tablero
    }
    public void reiniciar() {
    	tablero.reiniciar();
    	
    }
}