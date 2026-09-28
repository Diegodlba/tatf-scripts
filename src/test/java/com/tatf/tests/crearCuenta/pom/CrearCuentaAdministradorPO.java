package com.tatf.tests.crearCuenta.pom;

import com.tatf.core.browser.IBrowser;

//Clase que contiene los localizadores y acciones para la creación de usuario de tipo admin
public class CrearCuentaAdministradorPO {
    private final IBrowser browser;

    private final String menuRegistrarse = "//div[text()='Registrarse']";
    private final String nombreInput = "input[placeholder='Nombre']";
    private final String apellidoInput = "input[placeholder='Apellido']";
    private final String emailInput = "input[placeholder='Email']";
    private final String contrasenaInput = "input[placeholder='Contraseña']";
    private final String repetirContrasenaInput = "input[placeholder='Repetir contraseña']";
    private final String paisInput = "input[placeholder='Pais nacimiento']";
    private final String registrarseButton = "//button[contains(.,'Registrarse')]";

    public CrearCuentaAdministradorPO(IBrowser browser) {
        this.browser = browser;
    }

    public void abrirFormulario() {
        browser.find().xpath(menuRegistrarse).click();
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

    public void completarContrasena(String contrasena) {
        browser.find().css(contrasenaInput).write(contrasena);
    }

    public void completarRepetirContrasena(String contrasena) {
        browser.find().css(repetirContrasenaInput).write(contrasena);
    }

    public void completarPais(String pais) {
        browser.find().css(paisInput).write(pais);
    }

    public void clickRegistrarse() {
        browser.find().xpath(registrarseButton).click();
    }
}
