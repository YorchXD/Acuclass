package controller;

import BD.ConsultaCurso;
import View.Curso.ViewCurso;
import model.Curso;
import model.Estado;
import model.Nivel;
import model.Tipo_Division_Anual;

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

	public static void modificar()
	{
		ViewCurso.modificar();
	}
}
