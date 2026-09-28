package com.tatf.tests.modal.pom;

import com.tatf.core.browser.IBrowser;

//Modal de confirmación para rutilizar, aparece muchas veces en acciones del sitio.

public class ModalPO {
    private final IBrowser browser;

    private final String confirmButton = "//button[contains(@class,'swal2-confirm')]";

    public ModalPO(IBrowser browser) {
        this.browser = browser;
    }

    public void confirmar() {
        browser.wait(confirmButton).xpath();
        browser.find().xpath(confirmButton).click();
    }
}
