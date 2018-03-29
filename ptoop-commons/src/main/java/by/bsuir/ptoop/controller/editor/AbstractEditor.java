package by.bsuir.ptoop.controller.editor;

import by.bsuir.ptoop.controller.dialog.AbstractDialog;
import by.bsuir.ptoop.model.Figure;

import java.util.Optional;

/**
 * Class that maintains dialogues creation for all types of actions
 */
public abstract class AbstractEditor {

    private AbstractEditor nextEditor;

    /**
     * Indicates if this particular class supports modifying such figure
     */
    public abstract boolean supports(Figure figure);

    /**
     * Returns empty dialog for interacting with functional modules
     */
    public abstract AbstractDialog<?> newDialog();

    /**
     * Returns dialogues with figures data set up for verifying and modification
     */
    public abstract AbstractDialog<Figure> newDialog(Figure figure);

    /**
     * Passes figure to Chain Of Responsibility in order to retirieve appropriate dialog
     */
    public Optional<Figure> editFigure(Figure figure)
    {
        if(supports(figure))
        {
            return newDialog(figure).showAndWait();
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
