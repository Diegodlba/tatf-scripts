package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EliminarCuentaTesterTest {

    //Utilizo variables para dejar el código mucho mas limpio y lejible, y para de ser necesario poder reutilizarlas dentro de la clase
    private static final String ADMIN_EMAIL = "yaniscorrea@gmail.com";
    private static final String ADMIN_CONTRASENA = "12345";
    private static final String EMAIL_TESTER = "diego.tester@ces.com.uy.com";
    private static IBrowser browser;

    @BeforeAll
    static void beforeAll() {
        browser = BrowserFactory.getBrowser(true);
        //Utilizo la función auxiliar de acceso a AdminCES
        FlujosAdminCES.accesoAdminces(browser);
        // Precondición: iniciar sesión como Administrador (función auxiliar)
        FlujosAdminCES.iniciarSesionAdministrador(browser, ADMIN_EMAIL, ADMIN_CONTRASENA);
    }

    @AfterAll
    static void afterAll() {
        BrowserFactory.quitBrowser();
    }

    @Test
    void eliminarCuentaTester() {
        //Precondición: que existe una cuenta Tester (función auxiliar)
        FlujosAdminCES.crearCuentaTester(browser, "Diego", "de la Barrera", EMAIL_TESTER, "Uruguay", "Tester#2026");

        browser.find().xpath("//*[contains(text(),'Ver usuarios')]").click();
        String filaUsuario = "//tr[td[contains(text(),'" + EMAIL_TESTER + "')]]";
        browser.wait(filaUsuario).xpath();
        browser.find().xpath(filaUsuario + "//button").click();

        browser.wait("//button[contains(@class,'swal2-confirm')]").xpath();
        browser.find().xpath("//button[contains(@class,'swal2-confirm')]").click();

        browser.wait("//button[contains(@class,'swal2-confirm')]").xpath();
        browser.find().xpath("//button[contains(@class,'swal2-confirm')]").click();

        browser.find().xpath("//*[contains(text(),'Ver usuarios')]").click();
        browser.wait("dataTable").id();

        // Inento capturar el elemento para luego verificar que no existe (isEmpty) y verificar que efectivamente fue eliminado
        boolean sigueExistiendo = !browser.find().idList(EMAIL_TESTER).isEmpty();
        IVerify.create().verifyFalse(sigueExistiendo, "El usuario Tester eliminado sigue apareciendo en la lista");
    }
}
