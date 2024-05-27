package uniandes.dpoo.taller7.modelo;

public class RegistroTop10
{
	// ********************************
	// Atributos
	// ********************************

	/**
	 * El nombre asociado al registro: s�lo debe tener 3 caracteres y no debe
	 * incluir el caracter ';'
	 */
	private String nombre;

	/**
	 * La cantidad de puntos del registro
	 */
	private int puntos;

	// ********************************
	// Constructores
	// ********************************

	/**
	 * Crea un nuevo registro y modifica el nombre para que cumpla con las
	 * siguientes reglas:
	 * 
	 * - Debe tener s�lo tres caracteres
	 * 
	 * - No puede incluir el caracter ';'
	 * 
	 * - Las letras deben estar en may�sculas
	 * 
	 * @param nombre El nombre para el registro
	 * @param puntos La cantidad de puntos
	 */
	public RegistroTop10(String nombre, int puntos)
	{
		this.nombre = nombre.toUpperCase().replace(";", "*");
		this.puntos = puntos;

		if (this.nombre.length() > 3)
			this.nombre = this.nombre.substring(0, 3);
	}

	// ********************************
	// M�todos
	// ********************************

	/**
	 * Retorna la cantidad de puntos
	 * 
	 * @return puntos
	 */
	public int darPuntos()
	{
		return puntos;
	}

	/**
	 * Retorna el nombre
	 * 
	 * @return nombre
	 */
	public String darNombre()
	{
		return nombre;
	}

	@Override
	public String toString()
	{
		return nombre + " ..... " + puntos;
	}
}
