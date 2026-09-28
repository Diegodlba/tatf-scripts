package com.tatf.tests.viewUsers.pom;

import com.tatf.core.browser.IBrowser;

//Clase que contiene los localizadores y acciones para eliminar el usuario tipo tester
public class VerUsuariosPO {
    private final IBrowser browser;

    private final String menuVerUsuarios = "//*[contains(text(),'Ver usuarios')]";
    private final String tablaId = "dataTable";

    public VerUsuariosPO(IBrowser browser) {
        this.browser = browser;
    }

    public void abrirListado() {
        browser.find().xpath(menuVerUsuarios).click();
        browser.wait(tablaId).id();
    }

    private String filaPorEmail(String email) {
        return "//tr[td[contains(text(),'" + email + "')]]";
    }

    public void esperarFila(String email) {
        browser.wait(filaPorEmail(email)).xpath();
    }

    public String obtenerNombre(String email) {
        return browser.find().xpath(filaPorEmail(email) + "/td[1]").getText();
    }

    public String obtenerApellido(String email) {
        return browser.find().xpath(filaPorEmail(email) + "/td[2]").getText();
    }

    public String obtenerPais(String email) {
        return browser.find().xpath(filaPorEmail(email) + "/td[4]").getText();
    }

    public String obtenerPerfil(String email) {
        return browser.find().xpath(filaPorEmail(email) + "/td[5]").getText();
    }

    public void eliminarUsuario(String email) {
        browser.find().id(email).click();
    }

    public boolean existeUsuario(String email) {
        return !browser.find().idList(email).isEmpty();
    }
}
