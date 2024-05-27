package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class TableroPanel extends JPanel {

    private int tama�oTablero; // Tama�o del tablero (ancho y alto)
    
    // Constructor
    public TableroPanel(int tama�oTablero) {
        this.tama�oTablero = tama�oTablero;
    }

    // Sobrescribe el m�todo paintComponent para dibujar el tablero
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Calcula el tama�o de cada celda del tablero
        int tama�oCelda = getWidth() / tama�oTablero;
        

        // Dibuja el tablero de juego
        for (int fila = 0; fila < tama�oTablero; fila++) {
            for (int columna = 0; columna < tama�oTablero; columna++) {
                // Calcula la posici�n de la celda
                int x = columna * tama�oCelda;
                int y = fila * tama�oCelda;

             // Rellena el rect�ngulo representando una celda con color amarillo
                g2d.setColor(Color.YELLOW);
                g2d.fill(new Rectangle2D.Double(x, y, tama�oCelda, tama�oCelda));
                
                // Dibuja el borde del rect�ngulo
                g2d.setColor(Color.BLACK);
                g2d.draw(new Rectangle2D.Double(x, y, tama�oCelda, tama�oCelda));
            }
        }
    }

    // M�todo para actualizar el tama�o del tablero
    public void setTama�oTablero(int tama�oTablero) {
    	this.tama�oTablero= tama�oTablero;
        repaint();
    }
}
