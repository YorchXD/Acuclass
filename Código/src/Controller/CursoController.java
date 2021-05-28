package Controller;

import BD.ConsultaCurso;
import Model.Curso;
import Model.Estado;
import Model.Nivel;
import Model.Tipo_Division_Anual;
import View.Curso.ViewCurso;

public class CursoController
{
	public static Curso buscarCurso(Nivel nivel, Tipo_Division_Anual tipoDivisionAnual)
	{
		return ConsultaCurso.buscarCurso(nivel, tipoDivisionAnual);
	}
	
	public static boolean registrarCurso(Nivel nivel, Tipo_Division_Anual tipoDivisionAnual)
	{
		return ConsultaCurso.registrarCurso(nivel, tipoDivisionAnual);
	}
	
	public static boolean actualizarEstadoCurso(Curso curso)
	{
		if(curso.getEstado().equals(Estado.HABILITADO))
		{
			curso.setEstado(Estado.DESHABILITADO);
		}
		else
		{
			curso.setEstado(Estado.HABILITADO);
		}
		return ConsultaCurso.actualizarEstadoCurso(curso);
	}
	
	
	public static void crear()
	{
		ViewCurso.crear();
	}

	public static void ver()
	{
		ViewCurso.ver();
	}
	
	public static void verCursosRegistrados()
	{
		ViewCurso.verListadoCurso(ConsultaCurso.listadoCurso());
	}

	public static void modificar()
	{
		ViewCurso.modificar();
	}
}
