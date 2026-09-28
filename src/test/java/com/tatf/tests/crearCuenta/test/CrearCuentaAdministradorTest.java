package com.tatf.tests.crearCuenta.test;

import com.tatf.tests.acceso.task.AccesoTask;
import com.tatf.tests.base.BaseTest;
import com.tatf.tests.login.task.LoginTask;
import com.tatf.tests.crearCuenta.data.CrearCuentaAdminData;
import com.tatf.tests.crearCuenta.task.CrearCuentaAdminTask;
import com.tatf.tests.viewUsers.task.VerUsuariosTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//Clase de test de creacion de usuario e tipo admin
public class CrearCuentaAdministradorTest extends BaseTest {

    private AccesoTask acceso;
    private CrearCuentaAdminTask register;
    private LoginTask login;
    private VerUsuariosTask viewUsers;

    @BeforeEach
    void configurar() {
        acceso = new AccesoTask(browser);
        register = new CrearCuentaAdminTask(browser);
        login = new LoginTask(browser);
        viewUsers = new VerUsuariosTask(browser);
    }

    @Test
    @DisplayName("Crear cuenta Administrador - alta exitosa")
    void crearCuentaAdministrador() {
        acceso.ingresarAlSitio(url, passwordAcceso);

        register.crearCuentaAdministrador(CrearCuentaAdminData.NOMBRE, CrearCuentaAdminData.APELLIDO, CrearCuentaAdminData.EMAIL,
                CrearCuentaAdminData.CONTRASENA, CrearCuentaAdminData.PAIS);

        login.iniciarSesion(CrearCuentaAdminData.EMAIL, CrearCuentaAdminData.CONTRASENA);

        viewUsers.verificarUsuarioCreado(CrearCuentaAdminData.EMAIL, CrearCuentaAdminData.NOMBRE, CrearCuentaAdminData.APELLIDO,
                CrearCuentaAdminData.PAIS, CrearCuentaAdminData.PERFIL_ESPERADO);
    }
}
