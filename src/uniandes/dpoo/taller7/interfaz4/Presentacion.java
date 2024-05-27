package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import uniandes.dpoo.taller7.modelo.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presentacion extends JFrame implements ActionListener , MouseListener{
	public TableroPanel tableroPanel;
    JButton buttonNuevo;
    JButton buttonReiniciar;
    JButton buttonTop10;
    JButton buttonCambiarJugador;
	private JComboBox<String> comboBoxTama�o;
	private JLabel jugadas;
	private int jugada = 1;
	

	
	public Presentacion () {
		this.setSize(800, 800);
		this.setTitle("Taller 7");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		// Panel Superior
		JPanel panelSuperior = new JPanel();
        JLabel labelTama�o = new JLabel("Tama�o:");
        comboBoxTama�o = new JComboBox<>(new String[]{"5x5", "6x6", "7x7"});
        JLabel labelDificultad = new JLabel("Dificultad:");
        JRadioButton radioButtonFacil = new JRadioButton("F�cil");
        JRadioButton radioButtonMedio = new JRadioButton("Medio");
        JRadioButton radioButtonDificil = new JRadioButton("Dif�cil");
        ButtonGroup grupoDificultad = new ButtonGroup();
        grupoDificultad.add(radioButtonFacil);
        grupoDificultad.add(radioButtonMedio);
        grupoDificultad.add(radioButtonDificil);
        
        // Agregar componentes al panel superior
        panelSuperior.add(labelTama�o);
        panelSuperior.add(comboBoxTama�o);
        panelSuperior.add(labelDificultad);
        panelSuperior.add(radioButtonFacil);
        panelSuperior.add(radioButtonMedio);
        panelSuperior.add(radioButtonDificil);
        
        // Configuraci�n del layout para el panel superior
        panelSuperior.setLayout(new FlowLayout());
        
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new GridLayout(4, 1)); // 4 filas, 1 columna
        
        // Crear botones
        buttonNuevo = new JButton("Nuevo");
        buttonReiniciar = new JButton("Reiniciar");
        buttonTop10 = new JButton("Top 10");
        buttonCambiarJugador = new JButton("Cambiar Jugador");
        
        // Agregar botones al panel derecho
        panelDerecho.add(buttonNuevo);
        panelDerecho.add(buttonReiniciar);
        panelDerecho.add(buttonTop10);
        panelDerecho.add(buttonCambiarJugador);
        
     // Creaci�n del panel inferior
        JPanel panelInferior = new JPanel();
        jugadas = new JLabel("N�mero de Jugadas: 0 ");
        JLabel labelJugadores = new JLabel("N�mero de Jugadores:");
        JTextField textFieldJugadores = new JTextField(10); // 10 caracteres de ancho
        
        // Agregar componentes al panel inferior
        panelInferior.add(jugadas);
        panelInferior.add(labelJugadores);
        panelInferior.add(textFieldJugadores);
        
        // Configuraci�n del layout para el panel inferior
        panelInferior.setLayout(new FlowLayout());
        
        // Agregar el panel superior y el panel derecho a la ventana
        add(panelSuperior, BorderLayout.NORTH);
        add(panelDerecho, BorderLayout.EAST); // Agregar el panel derecho a la derecha
        add(panelInferior, BorderLayout.SOUTH);
        tableroPanel = new TableroPanel(5); // Tama�o por defecto
        add(tableroPanel, BorderLayout.CENTER); // Agregar el panel de tablero al centro

        // Listener para el JComboBox del tama�o del tablero
        comboBoxTama�o.addActionListener(this);
        tableroPanel.addMouseListener(this);
 
        this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// Verificar si el evento proviene del JComboBox de tama�o del tablero
	    if (e.getSource() == comboBoxTama�o) {
	        // Obtener el tama�o seleccionado del JComboBox
	        String tama�oSeleccionado = (String) comboBoxTama�o.getSelectedItem();
	        int tama�o = 5;
	        if (tama�oSeleccionado == "6x6") {
	        	tama�o = 6;
	        } else if (tama�oSeleccionado == "7x7")
	        	tama�o = 7;
	        
	        // Actualizar el tama�o del tablero y volver a graficarlo
	        tableroPanel.setTama�oTablero(tama�o);
	        
	    }else if (e.getSource() == buttonNuevo) {
	    	String tama�oSeleccionado = (String) comboBoxTama�o.getSelectedItem();
	        int tama�o = Integer.parseInt(tama�oSeleccionado.split("x")[0]); // Obtener solo el n�mero del tama�
	        
	        // Crear un nuevo tablero con el tama�o y la dificultad seleccionados
	        Tablero nuevoTablero = new Tablero(tama�o);
	        nuevoTablero.desordenar(2);
	        
	        // Actualizar el panel de juego con el nuevo tablero
	        tableroPanel.actualizarTablero(nuevoTablero);
            
        } else if (e.getSource() == buttonReiniciar) {
        	tableroPanel.reiniciar();
            
            // Actualizar el panel de juego con el tablero reiniciado
            tableroPanel.repaint();
        } else if (e.getSource() == buttonTop10) {
            // Acci�n para el bot�n Top 10
        } else if (e.getSource() == buttonCambiarJugador) {
            // Acci�n para el bot�n Cambiar Jugador
        }
	}
	public void actualizarJugadas() {
        jugadas.setText("N�mero de Jugadas: " + jugada);
    }
	public static void main(String[] args) {
		new Presentacion();
	}
	public void mouseClicked(MouseEvent e) {
		tableroPanel.mouseClicked(e);
		
		actualizarJugadas();
		jugada++;
    }
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
