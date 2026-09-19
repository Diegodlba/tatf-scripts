package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CrearCuentaAdministradorTest {

    //Utilizo variables para dejar el código mucho mas limpio y lejible, y para de ser necesario poder reutilizarlas dentro de la clase
    private static final String EMAIL = "diego.admin@ces.com.uy";
    private static final String CONTRASENA = "12345Diego";
    private static IBrowser browser;

    @BeforeAll
    static void beforeAll() {
        browser = BrowserFactory.getBrowser(true);
    }

    @AfterAll
    static void afterAll() {
        BrowserFactory.quitBrowser();
    }

    @Test
    void crearCuentaAdministrador() {
        //Utilizo la función auxiliar de acceso a AdminCES
        FlujosAdminCES.accesoAdminces(browser);
        //Función auxiliar para crear cuentaAdministrador.
        FlujosAdminCES.crearCuentaAdministrador(browser, "Diego", "de la Barrera", EMAIL, CONTRASENA, "Uruguay");

        //Función auxiliar para iniciar sesión como administrador
        FlujosAdminCES.iniciarSesionAdministrador(browser, EMAIL, CONTRASENA);

        browser.find().xpath("//*[contains(text(),'Ver usuarios')]").click();
        String filaUsuario = "//tr[td[contains(text(),'" + EMAIL + "')]]";
        browser.wait(filaUsuario).xpath();

        //Capturo los elementos para las verificaciones
        String nombreObtenido = browser.find().xpath(filaUsuario + "/td[1]").getText();
        String apellidoObtenido = browser.find().xpath(filaUsuario + "/td[2]").getText();
        String paisObtenido = browser.find().xpath(filaUsuario + "/td[4]").getText();
        String perfilObtenido = browser.find().xpath(filaUsuario + "/td[5]").getText();

        //Realizo las verificaciones
        IVerify.create().verify("Administrador", perfilObtenido,
                "El perfil del usuario creado no es Administrador");

        IVerify.create().verify("Diego", nombreObtenido, "El nombre no coincide con lo ingresado");
        IVerify.create().verify("de la Barrera", apellidoObtenido, "El apellido no coincide con lo ingresado");
        IVerify.create().verify("Uruguay", paisObtenido, "El país no coincide con lo ingresado");
    }
}