package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class TableroPanel extends JPanel {

    private int tamañoTablero; // Tamaño del tablero (ancho y alto)
    
    // Constructor
    public TableroPanel(int tamañoTablero) {
        this.tamañoTablero = tamañoTablero;
    }

    // Sobrescribe el método paintComponent para dibujar el tablero
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Calcula el tamaño de cada celda del tablero
        int tamañoCelda = getWidth() / tamañoTablero;
        

        // Dibuja el tablero de juego
        for (int fila = 0; fila < tamañoTablero; fila++) {
            for (int columna = 0; columna < tamañoTablero; columna++) {
                // Calcula la posición de la celda
                int x = columna * tamañoCelda;
                int y = fila * tamañoCelda;

             // Rellena el rectángulo representando una celda con color amarillo
                g2d.setColor(Color.YELLOW);
                g2d.fill(new Rectangle2D.Double(x, y, tamañoCelda, tamañoCelda));
                
                // Dibuja el borde del rectángulo
                g2d.setColor(Color.BLACK);
                g2d.draw(new Rectangle2D.Double(x, y, tamañoCelda, tamañoCelda));
            }
        }
    }

    // Método para actualizar el tamaño del tablero
    public void setTamañoTablero(int tamañoTablero) {
    	this.tamañoTablero= tamañoTablero;
        repaint();
    }
}
