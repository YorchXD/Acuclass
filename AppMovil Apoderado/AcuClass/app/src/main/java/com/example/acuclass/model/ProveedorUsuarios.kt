package com.example.acuclass.model

class ProveedorUsuarios
{
    private val usuarios = arrayListOf(
        Usuario(
            nombre = "Yorch Sepúlveda",
            email = "yorch5.77@gmail.com",
            clave = "12345",
            run = "17824523-6",
            alumnos = arrayListOf(
                Alumno(
                    nombre = "Gregory Sepúlveda",
                    run = "19043138-k"
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
    )

    fun buscarUsuario(email: String, clave: String): Usuario?
    {
        var usuarioAux = usuarios.find { usuario ->  usuario.email.equals(email) && usuario.clave.equals(clave)}
        if(usuarioAux!=null)
        {
            return usuarioAux
        }
        return null
    }


    /*companion object es para acceder desde fuera de la clase a los datos*/
    /*companion object
    {
        fun buscarUsuario(email: String, clave: String): Usuario?
        {
            var usuarioAux = usuarios.find { usuario ->  usuario.email.equals(email) && usuario.clave.equals(clave)}
            if(usuarioAux!=null)
            {
                return usuarioAux
            }
            return null
        }

        private val usuarios = listOf(
            Usuario(
                nombre = "Yorch Sepúlveda",
                email = "yorch5.77@gmail.com",
                clave = "12345",
                run = "17824523-6",
                alumnos = listOf(
                    Alumno(
                        nombre = "Gregory Sepúlveda",
                        run = "19043138-k"
                    )
                )
            ),
            Usuario(
                nombre = "Juan Perez",
                email = "juanitoperez@gmail.com",
                clave = "12345",
                run = "11111111-1",
                alumnos = listOf(
                    Alumno(
                        nombre = "Clemente Perez",
                        run = "22222222-2"
                    )
                )
            )
        )
    }*/
}