package com.tatf.tests.crearCuenta.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.tests.modal.pom.ModalPO;
import com.tatf.tests.crearCuenta.pom.CrearCuentaTesterPO;

//Clase que contiene las acciones necesarias para la creación de usuarios tipo Tester.
public class CrearCuentaTesterTask {
    private final CrearCuentaTesterPO createUser;
    private final ModalPO modal;

    public CrearCuentaTesterTask(IBrowser browser) {
        this.createUser = new CrearCuentaTesterPO(browser);
        this.modal = new ModalPO(browser);
    }

    public void crearCuentaTester(String nombre, String apellido, String email, String pais, String contrasena, String perfil) {
        createUser.abrirFormulario();
        createUser.completarNombre(nombre);
        createUser.completarApellido(apellido);
        createUser.completarEmail(email);
        createUser.seleccionarPais(pais);
        createUser.completarContrasena(contrasena);
        createUser.seleccionarPerfil(perfil);
        createUser.clickCrearCuenta();
        modal.confirmar();
    }
}
