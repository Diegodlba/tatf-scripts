package com.tatf.tests.verUsuarios.test;


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

import static com.tatf.tests.base.AdminPredeterminado.*;

//Clase de test de eliminación de usuario tipo tester (Precondición 1: sesión de Administrador iniciada , Precondición 2: existe una cuenta Tester)
public class EliminarCuentaTesterTest extends BaseTest {

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

    @ParameterizedTest(name = "Eliminar cuenta Tester - {0} {1}")
    @CsvFileSource(resources = "/eliminar_cuenta_tester.csv", useHeadersInDisplayName = true)
    @Tag("modulo-verUsuarios")
    @Tag("regresion")
    @DisplayName("Eliminar cuenta tester")
    void eliminarCuentaTester(String nombre, String apellido, String email, String pais, String contrasena, String perfil) {
        acceso.ingresarAlSitio(url, contrasenaAcceso);
        IVerify.create().verifyTrue(acceso.seAccedioAlSitio(),
                "No se pudo acceder al sitio AdminCES con la contraseña indicada");

        // Precondición 1: sesión de Administrador iniciada
        login.iniciarSesion(AdminPredeterminado.EMAIL, AdminPredeterminado.PASSWORD);
        IVerify.create().verifyTrue(login.sesionIniciada(AdminPredeterminado.NOMBRE), "El login no fue exitoso");

        // Precondición 2: existe una cuenta Tester
        createUser.crearCuentaTester(nombre, apellido, email, pais, contrasena, perfil);

        viewUsers.abrirListadoYEsperarFila(email);
        IVerify.create().verify(nombre, viewUsers.obtenerNombre(email), "El nombre no coincide con lo ingresado");
        IVerify.create().verify(apellido, viewUsers.obtenerApellido(email), "El apellido no coincide con lo ingresado");
        IVerify.create().verify(pais, viewUsers.obtenerPais(email), "El país no coincide con lo ingresado");
        IVerify.create().verify(perfil, viewUsers.obtenerPerfil(email),
                "El perfil del usuario creado no es el esperado");

        viewUsers.eliminarUsuarioYConfirmar(email);

        IVerify.create().verifyFalse(viewUsers.usuarioExiste(email),
                "El usuario Tester eliminado sigue apareciendo en la lista");
    }
}
