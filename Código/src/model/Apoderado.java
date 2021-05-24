package model;

import java.util.ArrayList;

public class Apoderado
{
	private ArrayList<Alumno> alumnos;

	public Apoderado()
	{
		super();
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
