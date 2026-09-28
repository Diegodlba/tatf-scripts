package com.tatf.tests.reiniciarContrasena.pom;

import com.tatf.core.browser.IBrowser;

//Clase con los localizadors y acciones para el reinicio de contraseña de tipo admin
public class ReiniciarContrasenaPO {
    private final IBrowser browser;

    private final String menuReiniciarContrasena = "//*[contains(text(),'Reiniciar contraseña')]";
    private final String emailInput = "input[placeholder='Email']";
    private final String contrasenaInput = "input[placeholder='Contraseña']";
    private final String repetirContrasenaInput = "input[placeholder='Repetir contraseña']";
    private final String reiniciarButton = "//button[contains(.,'Rei. Contraseña')]";

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
        browser.find().xpath(reiniciarButton).click();
    }
}
