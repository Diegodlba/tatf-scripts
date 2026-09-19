package com.tatf.tests;

import com.tatf.core.browser.IBrowser;

//funciones auxiliares para reutilizar
public final class FlujosAdminCES {

    private static final String URL_HOME = "http://cestore.ces.com.uy/adminces/";
    private static final String CONTRASENA_ADMINCES = "3)ea60e0be3ba12c6ecd%7297868%5c4";

    private FlujosAdminCES() {
    }

    //función utilizada para pasar a la página principal de AdminCES
    public static void accesoAdminces(IBrowser browser) {
        browser.interaction().navigateTo(URL_HOME);
        browser.find().id("pass").write(CONTRASENA_ADMINCES);
        browser.find().xpath("//button[contains(.,'Ingresar')]").click();
    }

    public static void iniciarSesionAdministrador(IBrowser browser, String email, String contrasena) {
        browser.find().xpath("//span[text()='Iniciar sesión']").click();
        browser.find().css("input[placeholder='Email']").write(email);
        browser.find().css("input[placeholder='Contraseña']").write(contrasena);
        browser.find().xpath("//button[contains(.,'Iniciar Sesión')]").click();
        browser.wait("//button[contains(@class,'swal2-confirm')]").xpath();
        browser.find().xpath("//button[contains(@class,'swal2-confirm')]").click();
    }

    public static void crearCuentaAdministrador(IBrowser browser, String nombre, String apellido,
                                                String email, String contrasena, String pais) {
        browser.find().xpath("//div[text()='Registrarse']").click();
        browser.find().css("input[placeholder='Nombre']").write(nombre);
        browser.find().css("input[placeholder='Apellido']").write(apellido);
        browser.find().css("input[placeholder='Email']").write(email);
        browser.find().css("input[placeholder='Contraseña']").write(contrasena);
        browser.find().css("input[placeholder='Repetir contraseña']").write(contrasena);
        browser.find().css("input[placeholder='Pais nacimiento']").write(pais);
        browser.find().xpath("//button[contains(.,'Registrarse')]").click();
        browser.wait("//button[contains(@class,'swal2-confirm')]").xpath();
        browser.find().xpath("//button[contains(@class,'swal2-confirm')]").click();
    }

    public static void crearCuentaTester(IBrowser browser, String nombre, String apellido,
                                         String email, String pais, String contrasena) {
        browser.find().xpath("//*[contains(text(),'Crear usuario')]").click();
        browser.find().css("input[placeholder='Nombre']").write(nombre);
        browser.find().css("input[placeholder='Apellido']").write(apellido);
        browser.find().css("input[placeholder='Email']").write(email);
        browser.find().css("select[name='inputCountry']").selectValue("Uruguay");
        browser.find().css("input[placeholder='Contraseña por defecto']").write(contrasena);
        browser.find().xpath("//*[contains(text(),'Tester Junior')]/preceding-sibling::input[@type='radio']").click();
        browser.find().xpath("//button[contains(.,'Crear cuenta')]").click();
        browser.wait("//button[contains(@class,'swal2-confirm')]").xpath();
        browser.find().xpath("//button[contains(@class,'swal2-confirm')]").click();
    }
}