package by.bsuir.ptoop.controller.editor;

import by.bsuir.ptoop.controller.dialog.AbstractDialog;
import by.bsuir.ptoop.model.Figure;

public class FigureModifyingEditor extends AbstractEditor {

    @Override
    public boolean supports(Figure figure) {
        return false;
    }

    @Override
    public AbstractDialog<?> newDialog() {
        throw new UnsupportedOperationException("Editor does not support creating empty dialogues");
    }

    @Override
    public AbstractDialog<Figure> newDialog(Figure figure) {
        throw new UnsupportedOperationException("Editor does not support editing figures");
    }
}
