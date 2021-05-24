package model;

import java.util.ArrayList;

public class Apoderado extends Usuario
{
	private ArrayList<Alumno> alumnos;

	public Apoderado(String nombre, String email, String clave, String estado, String run, String tipoUsuario)
	{
		super(nombre, email, clave, estado, run, tipoUsuario);
		this.alumnos = new ArrayList<Alumno>();
	}

	public Alumno getAlumno(int index)
	{
		return alumnos.get(index);
	}

	public boolean addAlumno(Alumno e)
	{
		return alumnos.add(e);
	}

	public Alumno removeAlumno(int index)
	{
		return alumnos.remove(index);
	}

	public ArrayList<Alumno> getAlumnos()
	{
		return alumnos;
	}
}
