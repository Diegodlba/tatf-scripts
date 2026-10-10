package com.tatf.tests.reiniciarContrasena.test;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.verification.IVerify;
import com.tatf.tests.acceso.task.AccesoTask;
import com.tatf.tests.base.BaseTest;
import com.tatf.tests.reiniciarContrasena.task.ReiniciarContrasenaTask;
import com.tatf.tests.login.task.LoginTask;
import com.tatf.tests.crearCuenta.task.CrearCuentaAdministradorTask;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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

    @ParameterizedTest(name = "Reiniciar contraseña - {0} {1}")
    @CsvFileSource(resources = "/reiniciar_contrasena.csv", useHeadersInDisplayName = true)
    @Tag("modulo-reiniciarContrasena")
    @Tag("regresion")
    @DisplayName("Reiniciar contraseña")
    void reiniciarContrasena(String nombre, String apellido, String email, String pais,
                             String contrasenaInicial, String contrasenaNueva) {
        acceso.ingresarAlSitio(url, contrasenaAcceso);
        IVerify.create().verifyTrue(acceso.seAccedioAlSitio(),
                "No se pudo acceder al sitio AdminCES con la contraseña indicada");

        // Precondición: existe una cuenta de Administrador
        register.crearCuentaAdministrador(nombre, apellido, email, contrasenaInicial, pais);

        forgotPassword.reiniciarContrasena(email, contrasenaNueva);

        login.iniciarSesion(email, contrasenaNueva);
        IVerify.create().verifyTrue(login.sesionIniciada(nombre), "El login con la nueva contraseña no fue exitoso");
    }
}
