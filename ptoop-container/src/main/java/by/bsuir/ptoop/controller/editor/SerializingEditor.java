package by.bsuir.ptoop.controller.editor;

import by.bsuir.ptoop.controller.dialog.AbstractDialog;
import by.bsuir.ptoop.controller.dialog.SerializingDialog;
import by.bsuir.ptoop.model.Figure;

public class SerializingEditor extends AbstractEditor {

    @Override
    public boolean supports(Figure figure) {
        return false;
    }

    @Override
    public AbstractDialog<?> newDialog() {
        return new SerializingDialog();
    }

    @Override
    public AbstractDialog<Figure> newDialog(Figure figure) {
        throw new UnsupportedOperationException("Editor does not support editing figures");
    }
}
