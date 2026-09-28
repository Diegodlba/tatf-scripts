package com.tatf.tests.verUsuarios.test;


import com.tatf.tests.acceso.task.AccesoTask;
import com.tatf.tests.base.BaseTest;
import com.tatf.tests.crearCuenta.task.CrearCuentaTesterTask;
import com.tatf.tests.login.task.LoginTask;
import com.tatf.tests.verUsuarios.data.VerUsuariosData;
import com.tatf.tests.verUsuarios.task.VerUsuariosTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("Eliminar cuenta Tester - baja exitosa")
    void eliminarCuentaTester() {
        acceso.ingresarAlSitio(url, passwordAcceso);

        // Precondición 1: sesión de Administrador iniciada
        login.iniciarSesion(adminEmail, adminPassword);

        // Precondición 2: existe una cuenta Tester
        createUser.crearCuentaTester(VerUsuariosData.NOMBRE, VerUsuariosData.APELLIDO, VerUsuariosData.EMAIL,
                VerUsuariosData.PAIS, VerUsuariosData.CONTRASENA);

        viewUsers.eliminarUsuarioYConfirmar(VerUsuariosData.EMAIL);
        viewUsers.verificarUsuarioEliminado(VerUsuariosData.EMAIL);
    }
}
