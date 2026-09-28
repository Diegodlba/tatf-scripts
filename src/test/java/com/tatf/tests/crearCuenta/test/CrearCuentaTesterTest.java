package com.tatf.tests.crearCuenta.test;

import com.tatf.tests.acceso.task.AccesoTask;
import com.tatf.tests.base.BaseTest;
import com.tatf.tests.crearCuenta.data.CrearCuentaTesterData;
import com.tatf.tests.crearCuenta.task.CrearCuentaTesterTask;
import com.tatf.tests.login.task.LoginTask;
import com.tatf.tests.verUsuarios.task.VerUsuariosTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("Crear cuenta Tester - exito en la creación de cuenta tster junior")
    void crearCuentaTester() {
        acceso.ingresarAlSitio(url, contrasenaAcceso);

        //Precondición: sesión de Administrador iniciada
        login.iniciarSesion(adminEmail, adminPassword);

        login.verificarSesionIniciada(adminNombre);

        createUser.crearCuentaTester(CrearCuentaTesterData.NOMBRE, CrearCuentaTesterData.APELLIDO, CrearCuentaTesterData.EMAIL,
                CrearCuentaTesterData.PAIS, CrearCuentaTesterData.CONTRASENA);

        viewUsers.verificarUsuarioCreado(CrearCuentaTesterData.EMAIL, CrearCuentaTesterData.NOMBRE, CrearCuentaTesterData.APELLIDO,
                CrearCuentaTesterData.PAIS, CrearCuentaTesterData.PERFIL_ESPERADO);
    }
}
