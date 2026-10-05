package com.tatf.tests.base;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.util.ConfigReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

// Clase base que contiene la configuración común para todos tests (esto es abrir el browser e ingresar al sitio de adminCES)
//Los datos ahora estan en el config.properties
public class BaseTest {
    private static final ConfigReader CONFIG = new ConfigReader("config.properties");

    protected static IBrowser browser;
    protected static String url;
    protected static String contrasenaAcceso;


    @BeforeAll
    static public void configuration() {
        browser = BrowserFactory.getBrowser(true);
        url = CONFIG.asString("adminces.url");
        contrasenaAcceso = CONFIG.asString("adminces.acceso.password");
    }

    @BeforeEach
    void abrirNavegador() {
        browser = BrowserFactory.getBrowser(true);
    }

    @AfterEach
    void cerrarNavegador() {
        BrowserFactory.quitBrowser();
    }
}
