package com.example.acuclass.model

class ProveedorUsuarios
{
    /*companion object es para acceder desde fuera de la clase a los datos*/
    companion object
    {
        fun buscarUsuario(email: String, clave: String): Boolean
        {
            var usuarioAux = usuarios.find { usuario ->  usuario.email.equals(email) && usuario.clave.equals(clave)}
            if(usuarioAux!=null)
            {
                return true
            }
            return false
        }

        private val usuarios = listOf(
            Usuario(
                email = "yorch5.77@gmail.com",
                clave = "12345"
            ),
            Usuario(
                email = "juanitoperez@gmail.com",
                clave = "12345"
            )
        )
    }
}