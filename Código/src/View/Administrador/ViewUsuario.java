					CursoController.crear();
				case 13:
					AlumnoController.crear();
					break;
				case 14:
					AlumnoController.ver();
					break;
				case 15:
					AlumnoController.modificar();
					break;
					AlumnoController.cambiarEstado();
				case 16:
					break;
				default:
					System.out.println("Sesion cerrada...\n\n");
					break;
			}
		}
		while(opcion!=17);
	}