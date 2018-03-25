package by.bsuir.ptoop.controller.dialog;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public abstract class AbstractDialog<T> extends Dialog<T> {

    private ButtonType confirmButton;

    public ButtonType getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(ButtonType confirmButton) {
        this.confirmButton = confirmButton;
    }
}
