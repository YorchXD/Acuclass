package model;

public class Profesor extends Usuario
{
	private String especialidad;

	public Profesor(String especialidad)
	{
		super();
		this.especialidad = especialidad;
	}

	public String getEspecialidad()
	{
		return especialidad;
	}

	public void setEspecialidad(String especialidad)
	{
		this.especialidad = especialidad;
	}
	
	public void mostrarDatos()
	{
		System.out.println("\n#########################Datos del profesor#########################");
		super.mostrarDatos();
		System.out.println("especialidad: " + this.especialidad);
		System.out.println("\n####################################################################\n");
	}
}
