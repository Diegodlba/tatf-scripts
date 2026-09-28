package com.tatf.tests.login.pom;

import com.tatf.core.browser.IBrowser;

//Clase con los localizadors y acciones para login tanto para usuarios admin como tester
public class LoginPO {
    private final IBrowser browser;

    private final String menuIniciarSesion = "//span[text()='Iniciar sesión']";
    private final String emailInput = "input[name='inputEmail']";
    private final String contrasenaInput = "input[name='inputPassword']";
    private final String ingresarButton = "//button[contains(.,'Iniciar Sesión')]";

    public LoginPO(IBrowser browser) {
        this.browser = browser;
    }

    public void abrirFormulario() {
        browser.find().xpath(menuIniciarSesion).click();
    }

    public void completarEmail(String email) {
        browser.find().css(emailInput).write(email);
    }

    public void completarContrasena(String contrasena) {
        browser.find().css(contrasenaInput).write(contrasena);
    }

    public void clickIniciarSesion() {
        browser.find().xpath(ingresarButton).click();
    }

    public boolean estaVisibleTexto(String texto) {
        return browser.find().xpath("//*[contains(text(),'" + texto + "')]").isDisplayed();
    }
}
