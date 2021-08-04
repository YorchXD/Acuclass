package com.example.acuclass.viewmodel


import com.example.acuclass.model.Alumno
import com.example.acuclass.model.ProveedorUsuarios
import com.example.acuclass.model.Usuario
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito

class UsuarioViewModelTest
{
    private lateinit var proveedorUsuarioMockito: ProveedorUsuarios
    private lateinit var usuarioViewModel: UsuarioViewModel
    private lateinit var usuarioEsperado:Usuario

    @Before
    fun setUp()
    {
        usuarioViewModel = UsuarioViewModel()
        proveedorUsuarioMockito = Mockito.mock(ProveedorUsuarios::class.java)

        //Usuario esperado
        usuarioEsperado = Usuario(
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
        )
        Mockito.`when`(proveedorUsuarioMockito.buscarUsuario("yorch5.77@gmail.com", "12345")).thenReturn(usuarioEsperado)
    }

    @Test
    fun pruebasTestMokito()
    {
        assertEquals(usuarioEsperado,usuarioViewModel.buscarUsuario("yorch5.77@gmail.com","12345"))
    }

    @Test
    fun obtenerUsuario()
    {
        //Dado que
        val email = "yorch5.77@gmail.com"
        val clave = "12345"

        //Cuando
        val usuarioActual: Usuario? = usuarioViewModel.buscarUsuario(email, clave)

        //verificamos
        assertEquals(usuarioEsperado.run, usuarioActual?.run)

    }
}