package by.bsuir.ptoop.controller.editor;

import by.bsuir.ptoop.controller.dialog.AbstractDialog;
import by.bsuir.ptoop.model.Figure;

public abstract class AbstractEditor {

    private AbstractEditor nextEditor;

    public abstract boolean supports(Figure figure);

    public abstract AbstractDialog<?> newDialog();

    public abstract AbstractDialog<Figure> newDialog(Figure figure);

    public Figure editFigure(Figure figure)
    {
        if(supports(figure))
        {
            return newDialog(figure).showAndWait().orElse(null);
        }
        else
        {
            return nextEditor.editFigure(figure);
        }
    }

    public void setNextEditor(AbstractEditor nextEditor) {
        this.nextEditor = nextEditor;
    }
}
