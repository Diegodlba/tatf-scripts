package com.tatf.tests.verUsuarios.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.tests.modal.pom.ModalPO;
import com.tatf.tests.verUsuarios.pom.VerUsuariosPO;

//Clase que contiene las acciones para eliminar el usuario de tipo testr
public class VerUsuariosTask {
    private final VerUsuariosPO viewUsers;
    private final ModalPO modal;

    public VerUsuariosTask(IBrowser browser) {
        this.viewUsers = new VerUsuariosPO(browser);
        this.modal = new ModalPO(browser);
    }

    public void abrirListadoYEsperarFila(String email) {
        viewUsers.abrirListado();
        viewUsers.esperarFila(email);
    }

    public void eliminarUsuarioYConfirmar(String email) {
        viewUsers.abrirListado();
        viewUsers.esperarFila(email);
        viewUsers.eliminarUsuario(email);
        modal.confirmar();
        modal.confirmar();
    }

    public boolean usuarioExiste(String email) {
        viewUsers.abrirListado();
        return viewUsers.existeUsuario(email);
    }

    public void verificarDatosUsuario(String email, String nombre, String apellido,
                                      String pais, String perfil) {
        IVerify.create().verify(nombre, viewUsers.obtenerNombre(email),
                "El nombre no coincide con lo ingresado");
        IVerify.create().verify(apellido, viewUsers.obtenerApellido(email),
                "El apellido no coincide con lo ingresado");
        IVerify.create().verify(pais, viewUsers.obtenerPais(email),
                "El país no coincide con lo ingresado");
        IVerify.create().verify(perfil, viewUsers.obtenerPerfil(email),
                "El perfil del usuario creado no es el esperado");
    }
}
