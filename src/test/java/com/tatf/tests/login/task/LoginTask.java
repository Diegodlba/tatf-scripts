package com.tatf.tests.login.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.tests.modal.pom.ModalPO;
import com.tatf.tests.login.pom.LoginPO;

//Clase que contiene las acciones necesarias para el login de usuarios de ambos tipos
public class LoginTask {
    private final LoginPO login;
    private final ModalPO modal;

    public LoginTask(IBrowser browser) {
        this.login = new LoginPO(browser);
        this.modal = new ModalPO(browser);
    }

    public void iniciarSesion(String email, String contrasena) {
        login.abrirFormulario();
        login.completarEmail(email);
        login.completarContrasena(contrasena);
        login.clickIniciarSesion();
        modal.confirmar();
    }

    public boolean sesionIniciada(String nombreEsperado) {
        return login.estaVisibleTexto(nombreEsperado);
    }
}
