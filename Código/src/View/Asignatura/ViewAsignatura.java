package View.Asignatura;

import java.util.Map;

import Controller.AsignaturaController;
import Utilidades.Utilidades;

public class ViewAsignatura
{
	public static void crear()
	{
		String nombre = Utilidades.solicitarNombre(Utilidades.ASIGNATURA);
		System.out.println(AsignaturaController.registrarAsignatura(nombre));
	}
	
	public static void verListadoAsignatura(Map<Integer, String> asignaturas)
	{
		if(!asignaturas.isEmpty())
		{
			System.out.println("\n********************************************************");
			System.out.println("*               Asignaturas registradas                *");
			System.out.println("********************************************************\n");
			for (Map.Entry<Integer,String> asignatura : asignaturas.entrySet())
			{
				System.out.println(asignatura.getKey() + ". " + asignatura.getValue());
			}
			System.out.println("********************************************************\n");
		}
		else
		{
			System.out.println("\nNo existen asignaturas registradas.\n");
		}
	}
	
	public static int solicitarSeleccionAsignatura(Map<Integer, String> asignaturas)
	{
		String opcion = "0";
		boolean validar2=true;
		if(!asignaturas.isEmpty())
		{
			boolean validar = false;
			do
			{
				System.out.println("\n********************************************************");
				System.out.println("*             Menu asignaturas registradas             *");
				System.out.println("********************************************************\n");
				for (Map.Entry<Integer,String> asignatura : asignaturas.entrySet())
				{
					System.out.println(asignatura.getKey() + ". " + asignatura.getValue());
				}
				System.out.println("********************************************************\n");
				System.out.print("\nIngrese su opcion: ");
				
				opcion = Utilidades.extracted().nextLine();
				validar = Utilidades.esNumero(opcion);
				if(!validar )
				{
					System.out.println("Ha ingresado un parametro incorrecto. Por favor, ingrese una opcion valida..\n\n");
				}
				else if(Integer.parseInt(opcion)<1 || Integer.parseInt(opcion)>asignaturas.size())
				{
					System.out.println("La opcion ingresada no es valida. Favor ingrese una opcion segun las opciones que muestra el menu.\n\n");
				}
				else
				{
					validar2 = false;
				}
			}
			while(validar2);
		}
		else
		{
			System.out.println("\nNo existen asignaturas registradas.\n");
		}
		return Integer.parseInt(opcion);
	}
	
	public static void modificarAsignatura(Map<Integer, String> asignaturas)
	{
		int idAsignatura = solicitarSeleccionAsignatura(asignaturas);
		
		if(idAsignatura!=0)
		{
			String nuevoNombre = Utilidades.solicitarNombre(Utilidades.ASIGNATURA);
			System.out.println(AsignaturaController.actualizarNombreAsignatura(nuevoNombre, idAsignatura));
		}
	}

}
