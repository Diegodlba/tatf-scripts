package com.tatf.tests.acceso.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.tests.acceso.pom.AccesoPO;

//Clase que contiene las tareas relacionadas con el acceso al sitio AdminCES
public class AccesoTask {
    private final AccesoPO acceso;

    public AccesoTask(IBrowser browser) {
        this.acceso = new AccesoPO(browser);
    }

    public void ingresarAlSitio(String url, String contrasena) {
        acceso.irAlSitio(url);
        acceso.completarContrasena(contrasena);
        acceso.clickIngresar();
    }

    public boolean seAccedioAlSitio() {
        return acceso.estaEnHome();
    }
}