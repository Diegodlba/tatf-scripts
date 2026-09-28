package com.tatf.tests.reiniciarContrasena.test;

import com.tatf.tests.acceso.task.AccesoTask;
import com.tatf.tests.base.BaseTest;
import com.tatf.tests.reiniciarContrasena.data.ReiniciarContrasenaData;
import com.tatf.tests.reiniciarContrasena.task.ReiniciarContrasenaTask;
import com.tatf.tests.login.task.LoginTask;
import com.tatf.tests.crearCuenta.task.CrearCuentaAdministradorTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//Clase para test del reinicio de contraseña de admin (Precondición: existe una cuenta de Administrador)
public class ReiniciarContrasenaTest extends BaseTest {

    private AccesoTask acceso;
    private CrearCuentaAdministradorTask register;
    private ReiniciarContrasenaTask forgotPassword;
    private LoginTask login;

    @BeforeEach
    void configurar() {
        acceso = new AccesoTask(browser);
        register = new CrearCuentaAdministradorTask(browser);
        forgotPassword = new ReiniciarContrasenaTask(browser);
        login = new LoginTask(browser);
    }

    @Test
    @DisplayName("Reiniciar contraseña - login exitoso con la nueva contraseña")
    void reiniciarContrasena() {
        acceso.ingresarAlSitio(url, contrasenaAcceso);

        // Precondición: existe una cuenta de Administrador
        register.crearCuentaAdministrador(ReiniciarContrasenaData.NOMBRE, ReiniciarContrasenaData.APELLIDO,
                ReiniciarContrasenaData.EMAIL, ReiniciarContrasenaData.CONTRASENA_INICIAL, ReiniciarContrasenaData.PAIS);

        forgotPassword.reiniciarContrasena(ReiniciarContrasenaData.EMAIL, ReiniciarContrasenaData.CONTRASENA_NUEVA);

        login.iniciarSesion(ReiniciarContrasenaData.EMAIL, ReiniciarContrasenaData.CONTRASENA_NUEVA);
        login.verificarSesionIniciada(ReiniciarContrasenaData.NOMBRE);
    }
}
