package View.Usuario;

import Controller.AlumnoController;
import Controller.AsignaturaController;
import Controller.CursoController;
import Utilidades.Utilidades;


public class ViewUsuario
{
	/*Opciones administrador*/
	public static void menuAdministrador()
	{
		System.out.println("####################Menu Administrador####################");
		System.out.println("1. Crear Curso");
		System.out.println("2. Ver cursos registrados con su estado");
		System.out.println("3. Ver curso");
		System.out.println("4. Habilitar o deshabiliatar curso");
		
		System.out.println("5. Crear asignatura");
		System.out.println("6. Ver asignaturas registradas");
		System.out.println("7. Modificar asignatura");
		
		System.out.println("8. Asociar asignatura a curso");
		System.out.println("9. Ver asignaturas asociadas a un curso");
		System.out.println("10. Habilitar o deshabiliatar asignatura de un curso");
		System.out.println("11. Quitar asignatura de un curso");
		
		System.out.println("12. Crear unidad");
		System.out.println("13. Ver unidad");
		System.out.println("14. Modificar unidad");
		System.out.println("15. Habilitar o deshabiliatar unidad");
		
		System.out.println("16. Crear Alumno");
		System.out.println("17. Ver Alumno");
		System.out.println("18. Modificar Alumno");
		System.out.println("19. Habilitar o deshabiliatar Alumno");

		System.out.println("20. Cerrar sesion");
		
		System.out.print("\nIngrese su opcion: ");
	}
	
	public static int accionEjecucionAdministrador()
	{
		boolean validar = false;
		String opcion;
		do
		{
			menuAdministrador();
			opcion = Utilidades.extracted().nextLine();
			validar = Utilidades.esNumero(opcion);
			
			if(!validar )
			{
				System.out.println("Ha ingresado un parametro incorrecto. Por favor, ingrese una opcion valida..\n\n");
				opcion="-1";
			}
			else if(Integer.parseInt(opcion)<1 || Integer.parseInt(opcion)>20)
			{
				System.out.println("La opcion ingresada no es valida. Favor ingrese una opcion segun las opciones que muestra el menu.\n\n");
			}
		}
		while(Integer.parseInt(opcion)<1 || Integer.parseInt(opcion)>20);
		
		return Integer.parseInt(opcion);
	}
	
	public static void seleccionarOpcionAdministrador()
	{	
		int opcion;
		do
		{
			opcion = accionEjecucionAdministrador();
			
			switch(opcion)
			{
				case 1:
					CursoController.crear();
					break;
				case 2:
					CursoController.verCursosRegistrados();
					break;
				case 3:
					CursoController.ver();
					break;
				case 4:
					CursoController.modificar();
					break;
				case 5:
					AsignaturaController.crear();
					break;
				case 6:
					AsignaturaController.verAsignaturasRegistradas();
					break;
				case 7:
					AsignaturaController.modificar();
					break;
				case 8:
					System.out.println("Asociar asignatura a curso");
					break;
				case 9:
					System.out.println("Ver listado de asignaturas asociadas a un curso");
					break;
				case 10:
					System.out.println("Modificar estado de asignatura asociada a un curso");
					break;
				case 11:
					System.out.println("Quitar asignatura de curso");
					break;
				case 12:
					System.out.println("Ir a crear unidad");
					break;
				case 13:
					System.out.println("Ir a ver unidad");
					break;
				case 14:
					System.out.println("Ir a modificar unidad");
					break;
				case 15:
					System.out.println("Ir a habilitar o deshabilitar unidad");
					break;
				case 16:
					AlumnoController.crear();
					break;
				case 17:
					AlumnoController.ver();
					break;
				case 18:
					AlumnoController.modificar();
					break;
				case 19:
					AlumnoController.cambiarEstado();
					break;
				default:
					System.out.println("Sesion cerrada...\n\n");
					break;
			}
		}
		while(opcion!=20);
	}
	/*Fin opciones administrador*/
	
	/*Opciones profesor*/
	/*Fin opciones profesor*/
	
	/*Opciones apoderado*/
	/*Fin opciones apoderado*/

}
