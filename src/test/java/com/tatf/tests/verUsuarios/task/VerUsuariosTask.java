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

    public String obtenerNombre(String email) {
        return viewUsers.obtenerNombre(email);
    }

    public String obtenerApellido(String email) {
        return viewUsers.obtenerApellido(email);
    }

    public String obtenerPais(String email) {
        return viewUsers.obtenerPais(email);
    }

    public String obtenerPerfil(String email) {
        return viewUsers.obtenerPerfil(email);
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
}
