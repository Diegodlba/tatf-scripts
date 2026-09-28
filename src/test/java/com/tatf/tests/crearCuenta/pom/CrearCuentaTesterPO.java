package com.tatf.tests.crearCuenta.pom;

import com.tatf.core.browser.IBrowser;

//Clase con los localizadors y acciones para la creación del usuario tipo tester
public class CrearCuentaTesterPO {
    private final IBrowser browser;

    private final String menuCrearUsuario = "//*[contains(text(),'Crear usuario')]";
    private final String nombreInput = "input[name='inputFirstName']";
    private final String apellidoInput = "input[name='inputLastName']";
    private final String emailInput = "input[name='inputEmail']";
    private final String paisSelect = "select[name='inputCountry']";
    private final String contrasenaInput = "input[name='inputPassword']";
    private final String radioTesterJunior = "testerJunior";
    private final String crearCuentaButton = "btnRegister";

    public CrearCuentaTesterPO(IBrowser browser) {
        this.browser = browser;
    }

    public void abrirFormulario() {
        browser.find().xpath(menuCrearUsuario).click();
    }

    public void completarNombre(String nombre) {
        browser.find().css(nombreInput).write(nombre);
    }

    public void completarApellido(String apellido) {
        browser.find().css(apellidoInput).write(apellido);
    }

    public void completarEmail(String email) {
        browser.find().css(emailInput).write(email);
    }

    public void seleccionarPais(String pais) {
        browser.find().css(paisSelect).selectValue(pais);
    }

    public void completarContrasena(String contrasena) {
        browser.find().css(contrasenaInput).write(contrasena);
    }

    public void seleccionarTesterJunior() {
        browser.find().id(radioTesterJunior).click();
    }

    public void clickCrearCuenta() {
        browser.find().id(crearCuentaButton).click();
    }
}
