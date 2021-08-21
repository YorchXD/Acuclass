package com.example.acuclass.data.model

class ProveedorUsuarios
{
    companion object
    {
        var usuarios: ArrayList<Usuario> = arrayListOf()
    }

    /*private val profesores = arrayListOf<Profesor>(
        Profesor(
            nombre = "Lenca Moncada",
            run ="33333333-3",
            especialidades = arrayListOf(Especialidad(id=1,nombre ="Pedagogía en lenguaje y comunicación"))
        ),
        Profesor(
            nombre = "Marta Pezoa",
            run ="444444444-4",
            especialidades = arrayListOf(Especialidad(id=1,nombre ="Pedagogía en ingles"))
        )
    )
    private val usuarios = arrayListOf(
        Usuario(
            nombre = "Yorch Sepúlveda",
            email = "yorch5.77@gmail.com",
            clave = "12345",
            run = "17824523-6",
            alumnos = arrayListOf(
                Alumno(
                    nombre = "Gregory Sepúlveda",
                    run = "19043138-k",
                    cursos = arrayListOf(
                        Curso(
                            profesorEncargado = profesores.get(0),
                            tipoCurso = Nivel.PRIMERO_BASICO,
                            letra="B",
                            anio = 2001,
                            tipoDivAnual = TipoDivisionAnual.SEMESTRAL
                        ),
                        Curso(
                            profesorEncargado = profesores.get(0),
                            tipoCurso = Nivel.SEGUNDO_BASICO,
                            letra="B",
                            anio = 2002,
                            tipoDivAnual = TipoDivisionAnual.SEMESTRAL
                        ),
                        Curso(
                            profesorEncargado = profesores.get(0),
                            tipoCurso = Nivel.TERCERO_BASICO,
                            letra="B",
                            anio = 2003,
                            tipoDivAnual = TipoDivisionAnual.SEMESTRAL
                        ),
                        Curso(
                            profesorEncargado = profesores.get(1),
                            tipoCurso = Nivel.CUARTO_BASICO,
                            letra="B",
                            anio = 2004,
                            tipoDivAnual = TipoDivisionAnual.SEMESTRAL
                        )
                    )
                )
            )
        ),
        Usuario(
            nombre = "Juan Perez",
            email = "juanitoperez@gmail.com",
            clave = "12345",
            run = "11111111-1",
            alumnos = arrayListOf(
                Alumno(
                    nombre = "Clemente Perez",
                    run = "22222222-2"
                )
            )
        )
    )*/

    /*fun buscarUsuario(email: String, clave: String): Usuario?
    {
        var usuarioAux = usuarios.find { usuario ->  usuario.email.equals(email) && usuario.clave.equals(clave)}
        return usuarioAux
    }*/

}