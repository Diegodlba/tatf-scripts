package com.tatf.tests.crearCuenta.test;

import com.tatf.tests.acceso.task.AccesoTask;
import com.tatf.tests.base.BaseTest;
import com.tatf.tests.login.task.LoginTask;
import com.tatf.tests.crearCuenta.data.CrearCuentaAdministradorData;
import com.tatf.tests.crearCuenta.task.CrearCuentaAdministradorTask;
import com.tatf.tests.verUsuarios.task.VerUsuariosTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("Crear cuenta Administrador - alta exitosa")
    void crearCuentaAdministrador() {
        acceso.ingresarAlSitio(url, contrasenaAcceso);

        registro.crearCuentaAdministrador(CrearCuentaAdministradorData.NOMBRE, CrearCuentaAdministradorData.APELLIDO, CrearCuentaAdministradorData.EMAIL,
                CrearCuentaAdministradorData.CONTRASENA, CrearCuentaAdministradorData.PAIS);

        login.iniciarSesion(CrearCuentaAdministradorData.EMAIL, CrearCuentaAdministradorData.CONTRASENA);

        login.verificarSesionIniciada(CrearCuentaAdministradorData.NOMBRE);

        verUsuarios.verificarUsuarioCreado(CrearCuentaAdministradorData.EMAIL, CrearCuentaAdministradorData.NOMBRE, CrearCuentaAdministradorData.APELLIDO,
                CrearCuentaAdministradorData.PAIS, CrearCuentaAdministradorData.PERFIL_ESPERADO);
    }
}
