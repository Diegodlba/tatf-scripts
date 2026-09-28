package com.tatf.tests.crearCuenta.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.tests.modal.pom.ModalPO;
import com.tatf.tests.crearCuenta.pom.CrearUsuarioTesterPO;

//Clase que contiene las acciones necesarias para la creación de usuarios tipo Tester.
public class CreaerUsuarioTesterTask {
    private final CrearUsuarioTesterPO createUser;
    private final ModalPO modal;

    public CreaerUsuarioTesterTask(IBrowser browser) {
        this.createUser = new CrearUsuarioTesterPO(browser);
        this.modal = new ModalPO(browser);
    }

    public void crearCuentaTester(String nombre, String apellido, String email, String pais, String contrasena) {
        createUser.abrirFormulario();
        createUser.completarNombre(nombre);
        createUser.completarApellido(apellido);
        createUser.completarEmail(email);
        createUser.seleccionarPais(pais);
        createUser.completarContrasena(contrasena);
        createUser.seleccionarTesterJunior();
        createUser.clickCrearCuenta();
        modal.confirmar();
    }
}
