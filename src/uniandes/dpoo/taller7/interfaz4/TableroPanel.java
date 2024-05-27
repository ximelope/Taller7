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
    protected Tablero tablero; // Representaci�n del tablero en 2D

    public TableroPanel(int tama�oTablero) {
        this.tablero = new Tablero(tama�oTablero);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int tama�oCelda = getWidth() / tablero.darTablero().length;

        // Dibuja el tablero de juego
        for (int fila = 0; fila < tablero.darTablero().length; fila++) {
            for (int columna = 0; columna < tablero.darTablero()[0].length; columna++) {
                int x = columna * tama�oCelda;
                int y = fila * tama�oCelda;
                Rectangle celda = new Rectangle(x, y, tama�oCelda, tama�oCelda);
                // Determina el color de la casilla seg�n su estado en el tablero
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

    // M�todo para actualizar el tama�o del tablero
    public void setTama�oTablero(int tama�oTablero) {
    	
    	this.tablero = new Tablero(tama�oTablero);
        repaint();
    }
    public void mouseClicked(MouseEvent e) {
        int tama�oCelda = getWidth() / tablero.darTablero().length;
        int fila = e.getY() / tama�oCelda;
        int columna = e.getX() / tama�oCelda;
        // Realiza una jugada en la posici�n clicada
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