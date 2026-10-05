package com.tatf.tests.acceso.pom;

import com.tatf.core.browser.IBrowser;

// Clase que contiene los localizadores y las acciones para el acceso al sitio AdminCES

public class AccesoPO {
    private final IBrowser browser;

    private final String passwordInput = "pass";
    private final String ingresarButton = "//button[contains(.,'Ingresar')]";

    private final String tituloAdminCES = "//a[@href='/adminces']";


    public AccesoPO(IBrowser browser) {
        this.browser = browser;
    }

    public void completarContrasena(String contrasena) {
        browser.find().id(passwordInput).write(contrasena);
    }

    public void clickIngresar() {
        browser.find().xpath(ingresarButton).click();
    }

    public boolean estaEnHome() {
        return browser.find().xpath(tituloAdminCES).isDisplayed();
    }

    public void irAlSitio(String url) {
        browser.interaction().navigateTo(url);
    }

}
