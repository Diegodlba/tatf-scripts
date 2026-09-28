package com.tatf.tests.reiniciarContrasena.pom;

import com.tatf.core.browser.IBrowser;

//Clase con los localizadors y acciones para el reinicio de contraseña de tipo admin
public class ReiniciarContrasenaPO {
    private final IBrowser browser;

    private final String menuReiniciarContrasena = "//*[contains(text(),'Reiniciar contraseña')]";
    private final String emailInput = "input[name='inputEmail']";
    private final String contrasenaInput = "input[name='inputPassword']";
    private final String repetirContrasenaInput = "input[name='inputRepeatPassword']";
    private final String reiniciarButton = "btnReset";

    public ReiniciarContrasenaPO(IBrowser browser) {
        this.browser = browser;
    }

    public void abrirFormulario() {
        browser.find().xpath(menuReiniciarContrasena).click();
    }

    public void completarEmail(String email) {
        browser.find().css(emailInput).write(email);
    }

    public void completarContrasena(String contrasena) {
        browser.find().css(contrasenaInput).write(contrasena);
    }

    public void completarRepetirContrasena(String contrasena) {
        browser.find().css(repetirContrasenaInput).write(contrasena);
    }

    public void clickReiniciar() {
        browser.find().id(reiniciarButton).click();
    }
}
