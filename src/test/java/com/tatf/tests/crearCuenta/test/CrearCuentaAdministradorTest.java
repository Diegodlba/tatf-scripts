package com.tatf.tests.crearCuenta.test;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.verification.IVerify;
import com.tatf.tests.acceso.task.AccesoTask;
import com.tatf.tests.base.BaseTest;
import com.tatf.tests.login.task.LoginTask;
import com.tatf.tests.crearCuenta.data.CrearCuentaAdministradorData;
import com.tatf.tests.crearCuenta.task.CrearCuentaAdministradorTask;
import com.tatf.tests.verUsuarios.task.VerUsuariosTask;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

//Clase de test de creacion de usuario e tipo admin
public class CrearCuentaAdministradorTest extends BaseTest {
    private AccesoTask acceso;
    private CrearCuentaAdministradorTask registro;
    private LoginTask login;
    private VerUsuariosTask verUsuarios;

    @BeforeEach
    void configurar() {
        acceso = new AccesoTask(browser);
        registro = new CrearCuentaAdministradorTask(browser);
        login = new LoginTask(browser);
        verUsuarios = new VerUsuariosTask(browser);
    }

    @ParameterizedTest(name = "Crear cuenta Administrador - {0} {1}")
    @CsvFileSource(resources = "/crear_cuenta_administrador.csv", useHeadersInDisplayName = true)
    void crearCuentaAdministrador(String nombre, String apellido, String email, String contrasena, String pais) {
        acceso.ingresarAlSitio(url, contrasenaAcceso);
        IVerify.create().verifyTrue(acceso.seAccedioAlSitio(),
                "No se pudo acceder al sitio AdminCES con la contraseña indicada");

        registro.crearCuentaAdministrador(nombre, apellido, email, contrasena, pais);

        login.iniciarSesion(email, contrasena);
        IVerify.create().verifyTrue(login.sesionIniciada(nombre), "El login no fue exitoso");

        verUsuarios.abrirListadoYEsperarFila(email);
        IVerify.create().verify(nombre, verUsuarios.obtenerNombre(email), "El nombre no coincide con lo ingresado");
        IVerify.create().verify(apellido, verUsuarios.obtenerApellido(email), "El apellido no coincide con lo ingresado");
        IVerify.create().verify(pais, verUsuarios.obtenerPais(email), "El país no coincide con lo ingresado");
        IVerify.create().verify(CrearCuentaAdministradorData.PERFIL_ESPERADO, verUsuarios.obtenerPerfil(email),
                "El perfil del usuario creado no es el esperado");
    }
}
