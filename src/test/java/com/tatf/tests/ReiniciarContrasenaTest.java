package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ReiniciarContrasenaTest {

    //Utilizo variables para dejar el código mucho mas limpio y lejible, y para de ser necesario poder reutilizarlas dentro de la clase
    private static final String URL_HOME = "http://cestore.ces.com.uy/adminces/";
    private static final String EMAIL = "diego.admin@ces.com.uy";
    private static final String CONTRASENA_INICIAL = "12345Diego";
    private static final String CONTRASENA_NUEVA = "Nueva12345";
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
    void reiniciarContrasena() {
        //Utilizo la función auxiliar de acceso a AdminCES
        FlujosAdminCES.accesoAdminces(browser);
        // Precondición: cuenta de Administrador existente (función auxiliar)
        FlujosAdminCES.crearCuentaAdministrador(browser, "Diego", "de la Barrera", EMAIL, CONTRASENA_INICIAL, "Uruguay");

        browser.find().xpath("//*[contains(text(),'Reiniciar contraseña')]").click();
        browser.find().css("input[placeholder='Email']").write(EMAIL);
        browser.find().css("input[placeholder='Contraseña']").write(CONTRASENA_NUEVA);
        browser.find().css("input[placeholder='Repetir contraseña']").write(CONTRASENA_NUEVA);
        browser.find().xpath("//button[contains(.,'Rei. Contraseña')]").click();
        browser.wait("//button[contains(@class,'swal2-confirm')]").xpath();
        browser.find().xpath("//button[contains(@class,'swal2-confirm')]").click();

        //Función auxiliar de inicio de sesión como administrador
        FlujosAdminCES.iniciarSesionAdministrador(browser, EMAIL, CONTRASENA_NUEVA);

        //Capturo el elemento nombre para verificar que realmente pude loguearme con la nueva contraseña
        boolean sesionIniciada = browser.find().xpath("//*[contains(text(),'Diego')]").isDisplayed();
        IVerify.create().verifyTrue(sesionIniciada, "El login con la nueva contraseña no fue exitoso");
    }
}