package com.example.acuclass.ui.viewmodel


import com.example.acuclass.data.model.Alumno
import com.example.acuclass.data.model.ProveedorUsuarios
import com.example.acuclass.data.model.Usuario
import org.junit.Test
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UsuarioViewModelTest
{
    @Mock
    private lateinit var proveedorUsuarioMockito: ProveedorUsuarios
    private lateinit var usuarioViewModel: UsuarioViewModel
    private lateinit var usuarioEsperado: Usuario
    @Before
    fun setUp()
    {
        usuarioViewModel = UsuarioViewModel()
        //proveedorUsuarioMockito = Mockito.mock(ProveedorUsuarios::class.java)
        //Usuario esperado
        usuarioEsperado = Usuario(
            nombre = "Yorch Sepúlveda",
            email = "yorch5.77@gmail.com",
            clave = "12345",
            run = "17824523-6",
            alumnos = arrayListOf(Alumno(nombre = "Gregory Sepúlveda", run = "19043138-k", edad = 10)
            )
        )
        /*Mockito.`when`(proveedorUsuarioMockito.buscarUsuario("yorch5.77@gmail.com", "12345")
        ).thenReturn(usuarioEsperado)
        usuarioViewModel.setProveedorUsuario(proveedorUsuarioMockito)*/
    }
    /*@Test
    fun pruebasTestMokito()
    {
        //`when`(proveedorUsuarioMockito.buscarUsuario("yorch5.77@gmail.com", "12345")).thenReturn(usuarioEsperado)
        assertEquals(usuarioEsperado,usuarioViewModel.buscarUsuario("yorch5.77@gmail.com","12345"))
        verify(proveedorUsuarioMockito).buscarUsuario("yorch5.77@gmail.com", "12345")
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
    }*/

    @Test
    fun obtenerDatosJson()
    {
        //usuarioViewModel.onCreate()
        usuarioViewModel.buscarUsuario("yorch5.77@gmail.com", "12345")
        //println(usuarioViewModel.usuario.value)

    }
}