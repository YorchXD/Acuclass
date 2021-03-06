package Model;

public class Curso_Referencia
{
	private int id;
	private LetraCurso letra;
	private Profesor profesorEncargado;
	private Curso curso;
	private int anio;

	public Curso_Referencia(int id, LetraCurso letra, Profesor profesorEncargado, Curso curso, int anio)
	{
		this.id = id;
		this.letra = letra;
		this.profesorEncargado = profesorEncargado;
		this.curso = curso;
		this.anio = anio;
	}

	public Curso_Referencia(int id, LetraCurso letra, int anio)
	{
		this.id = id;
		this.letra = letra;
		this.anio = anio;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public LetraCurso getLetra()
	{
		return letra;
	}

	public void setLetra(LetraCurso letra)
	{
		this.letra = letra;
	}

	public Profesor getProfesorEncargado()
	{
		return profesorEncargado;
	}

	public void setProfesorEncargado(Profesor profesorEncargado)
	{
		this.profesorEncargado = profesorEncargado;
	}

	public Curso getCurso()
	{
		return curso;
	}

	public void setCurso(Curso curso)
	{
		this.curso = curso;
	}

	public int getAnio()
	{
		return anio;
	}

	public void setAnio(int anio)
	{
		this.anio = anio;
	}
}
