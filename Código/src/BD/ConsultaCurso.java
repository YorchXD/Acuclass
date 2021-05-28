package BD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import Model.Curso;
import Model.Estado;
import Model.Nivel;
import Model.Tipo_Division_Anual;


public class ConsultaCurso
{
	public static Map<Integer, Curso> listadoCurso()
	{
		Connection conexion = Conexion.conectar();
		Map<Integer, Curso> cursos = new HashMap<>();
		try
		{
			CallableStatement cs = conexion.prepareCall("{call listarCursos()}");			
			ResultSet rs = cs.executeQuery();
			int count = 1;
			while(rs.next())
			{
				Curso curso = new Curso(
						Nivel.valueOf(Nivel.class, rs.getString("nivel")),
						Tipo_Division_Anual.valueOf(Tipo_Division_Anual.class, rs.getString("tipoDivisionAnual")),
						Estado.valueOf(Estado.class, rs.getString("estado"))
						);
				cursos.put(count, curso);
				count++;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return cursos;
	}
	
	public static Curso buscarCurso(Nivel nivel, Tipo_Division_Anual tipoDivisionAnual)
	{
		Connection conexion = Conexion.conectar();
		Curso curso = null;
		try
		{
			CallableStatement cs = conexion.prepareCall("{call buscarCurso(?,?)}");
			cs.setString("in_nivel", nivel.toString());
			cs.setString("in_tipoDivAnual", tipoDivisionAnual.toString());
			
			ResultSet rs = cs.executeQuery();
			
			while(rs.next())
			{
				Nivel nivelAux = Nivel.valueOf(Nivel.class, rs.getString("nivel"));
				Estado estadoAux = Estado.valueOf(Estado.class, rs.getString("estado"));
				Tipo_Division_Anual tipoDivAnualAux = Tipo_Division_Anual.valueOf(Tipo_Division_Anual.class, rs.getString("tipoDivisionAnual"));
				curso = new Curso(nivelAux, tipoDivAnualAux, estadoAux);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return curso;
	}
	
	public static boolean registrarCurso(Nivel nivel, Tipo_Division_Anual tipoDivAnual)
	{
		Connection conexion = Conexion.conectar();
		try
		{
			
			CallableStatement cs = conexion.prepareCall("{call registrarCurso(?,?)}");
			cs.setString("in_nivel", nivel.toString());
			cs.setString("in_tipoDivAnual", tipoDivAnual.toString());
			cs.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	public static boolean actualizarEstadoCurso(Curso curso)
	{
		Connection conexion = Conexion.conectar();
		try
		{
			CallableStatement cs = conexion.prepareCall("{call actualizarEstadoCurso(?,?,?)}");
			cs.setString("in_nivel", curso.getNivel().toString());
			cs.setString("in_tipoDivAnual", curso.getTipoDivisionAnual().toString());
			cs.setString("in_estado", curso.getEstado().toString());
			cs.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
}
