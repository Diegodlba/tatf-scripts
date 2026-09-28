package com.tatf.tests.base;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

// Clase base que contiene la configuración común para la mayoria de los tests (Losque utilizan el usuario de admin predeterminado)
public class BaseTest {
    protected static IBrowser browser;
    protected static String url;
    protected static String passwordAcceso;
    protected static String adminEmail;
    protected static String adminPassword;

    @BeforeAll
    static public void configuration() {
        browser = BrowserFactory.getBrowser(true);
        url = "http://cestore.ces.com.uy/adminces/";
        passwordAcceso = "3)ea60e0be3ba12c6ecd%7297868%5c4";
        adminEmail = "yaniscorrea@gmail.com";
        adminPassword = "12345";
    }

    @AfterAll
    static public void close() {
        BrowserFactory.quitBrowser();
    }
}
