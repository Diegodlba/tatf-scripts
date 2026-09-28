package com.tatf.tests.crearCuenta.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.tests.modal.pom.ModalPO;
import com.tatf.tests.crearCuenta.pom.CrearCuentaAdminPO;

//Clase que contiene las acciones necesarias para la creación de un usuario de tipo admin
public class CrearCuentaAdminTask {
    private final CrearCuentaAdminPO register;
    private final ModalPO modal;

    public CrearCuentaAdminTask(IBrowser browser) {
        this.register = new CrearCuentaAdminPO(browser);
        this.modal = new ModalPO(browser);
    }

    public void crearCuentaAdministrador(String nombre, String apellido, String email,
                                          String contrasena, String pais) {
        register.abrirFormulario();
        register.completarNombre(nombre);
        register.completarApellido(apellido);
        register.completarEmail(email);
        register.completarContrasena(contrasena);
        register.completarRepetirContrasena(contrasena);
        register.completarPais(pais);
        register.clickRegistrarse();
        modal.confirmar();
    }
}
