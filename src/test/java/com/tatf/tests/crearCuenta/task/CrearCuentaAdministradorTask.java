package com.tatf.tests.crearCuenta.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.tests.modal.pom.ModalPO;
import com.tatf.tests.crearCuenta.pom.CrearCuentaAdministradorPO;

//Clase que contiene las acciones necesarias para la creación de un usuario de tipo admin
public class CrearCuentaAdministradorTask {
    private final CrearCuentaAdministradorPO register;
    private final ModalPO modal;

    public CrearCuentaAdministradorTask(IBrowser browser) {
        this.register = new CrearCuentaAdministradorPO(browser);
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
