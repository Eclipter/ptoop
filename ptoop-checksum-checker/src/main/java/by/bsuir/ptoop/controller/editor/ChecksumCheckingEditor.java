package by.bsuir.ptoop.controller.editor;

import by.bsuir.ptoop.controller.dialog.AbstractDialog;
import by.bsuir.ptoop.model.Figure;

public class ChecksumCheckingEditor extends AbstractEditor {

    @Override
    public boolean supports(Figure figure) {
        return false;
    }

    @Override
    public AbstractDialog<?> newDialog() {
        throw new UnsupportedOperationException("Editor does not supports dialogues");
    }

    @Override
    public AbstractDialog<Figure> newDialog(Figure figure) {
        throw new UnsupportedOperationException("Editor does not supports modifying figures");
    }
}
