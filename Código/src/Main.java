
import controller.LoginController;
import model.Usuario;

public class Main
{
	public static void main(String[] args)
	{
		do
		{
			Usuario usuario = LoginController.solicitarDatosAcceso();
			/* Si el usuario se encuentra, muestra los datos del usuario */
			usuario.mostrarDatos();
			switch (usuario.getTipoUsuario())
			{
				case "ADMINISTRADOR":
					System.out.println("Ir al controlador administrador");
					break;
				case "PROFESOR":
					System.out.println("Ir al controlador profesor");
					break;
				default:
					System.out.println("Ir al controlador apoderado");
					break;
			}
		}
		while (true);
	}
}
