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

    public void verificarUsuarioCreado(String email, String nombreEsperado, String apellidoEsperado,
                                        String paisEsperado, String perfilEsperado) {
        viewUsers.abrirListado();
        viewUsers.esperarFila(email);

        IVerify.create().verify(nombreEsperado, viewUsers.obtenerNombre(email),
                "El nombre no coincide con lo ingresado");
        IVerify.create().verify(apellidoEsperado, viewUsers.obtenerApellido(email),
                "El apellido no coincide con lo ingresado");
        IVerify.create().verify(paisEsperado, viewUsers.obtenerPais(email),
                "El país no coincide con lo ingresado");
        IVerify.create().verify(perfilEsperado, viewUsers.obtenerPerfil(email),
                "El perfil del usuario creado no es el esperado");
    }

    public void eliminarUsuarioYConfirmar(String email) {
        viewUsers.abrirListado();
        viewUsers.esperarFila(email);
        viewUsers.eliminarUsuario(email);
        modal.confirmar();
        modal.confirmar();
    }

    public void verificarUsuarioEliminado(String email) {
        viewUsers.abrirListado();
        IVerify.create().verifyFalse(viewUsers.existeUsuario(email),
                "El usuario Tester eliminado sigue apareciendo en la lista");
    }
}
