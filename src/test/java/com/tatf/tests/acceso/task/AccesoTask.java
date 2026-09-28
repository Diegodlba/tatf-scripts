package com.tatf.tests.acceso.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.tests.acceso.pom.AccesoPO;

//Clase que contiene las tareas relacionadas con el acceso al sitio AdminCES
public class AccesoTask {
    private final IBrowser browser;
    private final AccesoPO acceso;

    public AccesoTask(IBrowser browser) {
        this.browser = browser;
        this.acceso = new AccesoPO(browser);
    }

    public void ingresarAlSitio(String url, String contrasena) {
        browser.interaction().navigateTo(url);
        acceso.completarContrasena(contrasena);
        acceso.clickIngresar();
        IVerify.create().verifyTrue(acceso.estaEnHome(),
                "No se pudo acceder al sitio AdminCES con la contraseña indicada");
    }


}
