package com.tatf.tests.crearCuenta.test;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.verification.IVerify;
import com.tatf.tests.acceso.task.AccesoTask;
import com.tatf.tests.base.AdminPredeterminado;
import com.tatf.tests.base.BaseTest;
import com.tatf.tests.crearCuenta.task.CrearCuentaTesterTask;
import com.tatf.tests.login.task.LoginTask;
import com.tatf.tests.verUsuarios.task.VerUsuariosTask;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


//Clase para test de la creación de usuario de tipo tester (Precondición: sesión de Administrador iniciada)
public class CrearCuentaTesterTest extends BaseTest {

    private AccesoTask acceso;
    private LoginTask login;
    private CrearCuentaTesterTask createUser;
    private VerUsuariosTask viewUsers;

    @BeforeEach
    void configurar() {
        acceso = new AccesoTask(browser);
        login = new LoginTask(browser);
        createUser = new CrearCuentaTesterTask(browser);
        viewUsers = new VerUsuariosTask(browser);
    }

    @ParameterizedTest(name = "Crear cuenta Tester - {5}")
    @CsvFileSource(resources = "/crear_cuenta_tester.csv", useHeadersInDisplayName = true)
    @Tag("modulo-crearCuenta")
    @Tag("humo")
    @Tag("regresion")
    @DisplayName("Crear cuenta Tester")
    void crearCuentaTester(String nombre, String apellido, String email, String pais, String contrasena, String perfil) {
        acceso.ingresarAlSitio(url, contrasenaAcceso);
        IVerify.create().verifyTrue(acceso.seAccedioAlSitio(),
                "No se pudo acceder al sitio AdminCES con la contraseña indicada");

        //Precondición: sesión de Administrador iniciada
        login.iniciarSesion(AdminPredeterminado.EMAIL, AdminPredeterminado.PASSWORD);
        IVerify.create().verifyTrue(login.sesionIniciada(AdminPredeterminado.NOMBRE), "El login no fue exitoso");

        createUser.crearCuentaTester(nombre, apellido, email, pais, contrasena, perfil);

        viewUsers.abrirListadoYEsperarFila(email);
        IVerify.create().verify(nombre, viewUsers.obtenerNombre(email), "El nombre no coincide con lo ingresado");
        IVerify.create().verify(apellido, viewUsers.obtenerApellido(email), "El apellido no coincide con lo ingresado");
        IVerify.create().verify(pais, viewUsers.obtenerPais(email), "El país no coincide con lo ingresado");
        IVerify.create().verify(perfil, viewUsers.obtenerPerfil(email), "El perfil del usuario creado no es el esperado");
    }
}