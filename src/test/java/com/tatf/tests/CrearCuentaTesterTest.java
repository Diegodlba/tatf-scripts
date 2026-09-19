package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CrearCuentaTesterTest {

    //Utilizo variables para dejar el código mucho mas limpio y lejible, y para de ser necesario poder reutilizarlas dentro de la clase
    private static final String ADMIN_EMAIL = "yaniscorrea@gmail.com";
    private static final String ADMIN_CONTRASENA = "12345";
    private static final String EMAIL_TESTER = "diego.tester@ces.com.uy";
    private static final String CONTRASENA_TESTER = "12345Diego";
    private static IBrowser browser;

    @BeforeAll
    static void beforeAll() {
        browser = BrowserFactory.getBrowser(true);
        //Utilizo la función auxiliar de acceso a AdminCES
        FlujosAdminCES.accesoAdminces(browser);
        //Precondición: estar logueado como administrador, para ello utilizo la función auxiliar de inicio de sesión de administrador.
        FlujosAdminCES.iniciarSesionAdministrador(browser, ADMIN_EMAIL, ADMIN_CONTRASENA);
    }

    @AfterAll
    static void afterAll() {
        BrowserFactory.quitBrowser();
    }

    @Test
    void crearCuentaTester() {
        // Utilizo la finción auxiliar para creación de cuenta de tipo Tester
        FlujosAdminCES.crearCuentaTester(browser, "Diego", "de la Barrera", EMAIL_TESTER, "Uruguay", CONTRASENA_TESTER);

        browser.find().xpath("//*[contains(text(),'Ver usuarios')]").click();
        String filaUsuario = "//tr[td[contains(text(),'" + EMAIL_TESTER + "')]]";
        browser.wait(filaUsuario).xpath();

        //Capturo los elementos para luego realizar las verifiaciones
        String nombreObtenido = browser.find().xpath(filaUsuario + "/td[1]").getText();
        String apellidoObtenido = browser.find().xpath(filaUsuario + "/td[2]").getText();
        String paisObtenido = browser.find().xpath(filaUsuario + "/td[4]").getText();
        String perfilObtenido = browser.find().xpath(filaUsuario + "/td[5]").getText();

        //Realizo las verificaciones
        IVerify.create().verify("Tester Junior", perfilObtenido,
                "El perfil del usuario creado no es Tester Junior");

        IVerify.create().verify("Diego", nombreObtenido, "El nombre no coincide con lo ingresado");
        IVerify.create().verify("de la Barrera", apellidoObtenido, "El apellido no coincide con lo ingresado");
        IVerify.create().verify("Uruguay", paisObtenido, "El país no coincide con lo ingresado");
    }
}
