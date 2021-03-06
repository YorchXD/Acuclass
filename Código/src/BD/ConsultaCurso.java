package BD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import Model.Asignatura;
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
			while(rs.next())
			{
				Curso curso = new Curso(
						rs.getInt("id"),
						Nivel.valueOf(Nivel.class, rs.getString("nivel")),
						Tipo_Division_Anual.valueOf(Tipo_Division_Anual.class, rs.getString("tipoDivisionAnual")),
						Estado.valueOf(Estado.class, rs.getString("estado"))
						);
				cursos.put(curso.getId(), curso);
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
				int id =  rs.getInt("id");
				Nivel nivelAux = Nivel.valueOf(Nivel.class, rs.getString("nivel"));
				Estado estadoAux = Estado.valueOf(Estado.class, rs.getString("estado"));
				Tipo_Division_Anual tipoDivAnualAux = Tipo_Division_Anual.valueOf(Tipo_Division_Anual.class, rs.getString("tipoDivisionAnual"));
				curso = new Curso(id, nivelAux, tipoDivAnualAux, estadoAux);
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

	public static int existenciaAsociacionCurso(int idCurso, int idAsignatura)
	{
		Connection conexion = Conexion.conectar();
		int existe = 0;
		try
		{
			CallableStatement cs = conexion.prepareCall("{call buscarAsociacionCursoAsignatura(?,?)}");
			cs.setInt("in_refCurso", idCurso);
			cs.setInt("in_refAsignatura", idAsignatura);
			
			ResultSet rs = cs.executeQuery();
			
			while(rs.next())
			{
				existe =  rs.getInt("existe");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return existe;
	}

	public static boolean registrarAsociacionCurso(int idCurso, int idAsignatura)
	{
		Connection conexion = Conexion.conectar();
		try
		{
			
			CallableStatement cs = conexion.prepareCall("{call registrarAsociacionCursoAsignatura(?,?)}");
			cs.setInt("in_refCurso", idCurso);
			cs.setInt("in_refAsignatura", idAsignatura);
			cs.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	public static boolean buscarAsignaturasCurso(Curso curso)
	{
		Connection conexion = Conexion.conectar();
		try
		{
			CallableStatement cs = conexion.prepareCall("{call listarAsignaturasCursos(?)}");	
			cs.setInt("in_refCurso", curso.getId());
			ResultSet rs = cs.executeQuery();
			while(rs.next())
			{
				Asignatura asignatura = new Asignatura(
						rs.getInt("id"),
						rs.getString("nombre"),
						Estado.valueOf(Estado.class, rs.getString("estado"))
						);
				curso.getAsignaturas().put(asignatura.getId(), asignatura);
			}
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	public static boolean actualizarEstadoAsignatura(int refCurso, Asignatura asignatura)
	{
		Connection conexion = Conexion.conectar();
		try
		{
			CallableStatement cs = conexion.prepareCall("{call actualizarEstadoAsignatura(?,?,?)}");
			cs.setInt("in_refCurso", refCurso);
			cs.setInt("in_refAsignatura", asignatura.getId());
			cs.setString("in_estado", asignatura.getEstado().toString());
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
