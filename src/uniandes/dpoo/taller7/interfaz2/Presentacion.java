package uniandes.dpoo.taller7.interfaz2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Presentacion extends JFrame implements ActionListener{
	public JLabel superior;
	public JComboBox<String> menu;
	
	public Presentacion () {
		this.setSize(800, 800);
		this.setTitle("Taller 7");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panelSuperior = new JPanel();
        JLabel labelTamaño = new JLabel("Tamaño:");
        JComboBox<String> comboBoxTamaño = new JComboBox<>(new String[]{"5x5", "6x6", "7x7"});
        JLabel labelDificultad = new JLabel("Dificultad:");
        JRadioButton radioButtonFacil = new JRadioButton("Fácil");
        JRadioButton radioButtonMedio = new JRadioButton("Medio");
        JRadioButton radioButtonDificil = new JRadioButton("Difícil");
        ButtonGroup grupoDificultad = new ButtonGroup();
        grupoDificultad.add(radioButtonFacil);
        grupoDificultad.add(radioButtonMedio);
        grupoDificultad.add(radioButtonDificil);
        
        // Agregar componentes al panel superior
        panelSuperior.add(labelTamaño);
        panelSuperior.add(comboBoxTamaño);
        panelSuperior.add(labelDificultad);
        panelSuperior.add(radioButtonFacil);
        panelSuperior.add(radioButtonMedio);
        panelSuperior.add(radioButtonDificil);
        
        // Configuración del layout para el panel superior
        panelSuperior.setLayout(new FlowLayout());
        
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new GridLayout(4, 1)); // 4 filas, 1 columna
        
        // Crear botones
        JButton buttonNuevo = new JButton("Nuevo");
        JButton buttonReiniciar = new JButton("Reiniciar");
        JButton buttonTop10 = new JButton("Top 10");
        JButton buttonCambiarJugador = new JButton("Cambiar Jugador");
        
        // Agregar botones al panel derecho
        panelDerecho.add(buttonNuevo);
        panelDerecho.add(buttonReiniciar);
        panelDerecho.add(buttonTop10);
        panelDerecho.add(buttonCambiarJugador);
        
     // Creación del panel inferior
        JPanel panelInferior = new JPanel();
        JLabel labelJugadas = new JLabel("Número de Jugadas:");
        JTextField textFieldJugadas = new JTextField(10); // 10 caracteres de ancho
        JLabel labelJugadores = new JLabel("Número de Jugadores:");
        JTextField textFieldJugadores = new JTextField(10); // 10 caracteres de ancho
        
        // Agregar componentes al panel inferior
        panelInferior.add(labelJugadas);
        panelInferior.add(textFieldJugadas);
        panelInferior.add(labelJugadores);
        panelInferior.add(textFieldJugadores);
        
        // Configuración del layout para el panel inferior
        panelInferior.setLayout(new FlowLayout());
        
        // Agregar el panel superior y el panel derecho a la ventana
        add(panelSuperior, BorderLayout.NORTH);
        add(panelDerecho, BorderLayout.EAST); // Agregar el panel derecho a la derecha
        add(panelInferior, BorderLayout.SOUTH);
        this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new Presentacion();
	}
	
}