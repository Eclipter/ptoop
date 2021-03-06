package by.bsuir.ptoop.controller.editor;

import by.bsuir.ptoop.controller.dialog.AbstractDialog;
import by.bsuir.ptoop.controller.dialog.DearchivingDialog;
import by.bsuir.ptoop.model.Figure;

public class DearchivingEditor extends AbstractEditor {

    @Override
    public boolean supports(Figure figure) {
        return false;
    }

    @Override
    public AbstractDialog<?> newDialog() {
        return new DearchivingDialog();
    }

    @Override
    public AbstractDialog<Figure> newDialog(Figure figure) {
        throw new UnsupportedOperationException("Editor does not support editing figures");
    }
}
