package com.tatf.tests.reiniciarContrasena.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.tests.modal.pom.ModalPO;
import com.tatf.tests.reiniciarContrasena.pom.ReiniciarContrasenaPO;

//Clase que contiene las acciones necesarias para el reinicio de contraseña de tipo admin
public class ReiniciarContrasenaTask {
    private final ReiniciarContrasenaPO forgotPassword;
    private final ModalPO modal;

    public ReiniciarContrasenaTask(IBrowser browser) {
        this.forgotPassword = new ReiniciarContrasenaPO(browser);
        this.modal = new ModalPO(browser);
    }

    public void reiniciarContrasena(String email, String nuevaContrasena) {
        forgotPassword.abrirFormulario();
        forgotPassword.completarEmail(email);
        forgotPassword.completarContrasena(nuevaContrasena);
        forgotPassword.completarRepetirContrasena(nuevaContrasena);
        forgotPassword.clickReiniciar();
        modal.confirmar();
    }
}
