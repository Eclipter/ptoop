package by.bsuir.ptoop.controller.editor;

import by.bsuir.ptoop.model.Figure;

import java.util.Optional;

/**
 * Useful chain container class used only for finding appropriate dialog for figures and providing a dialog
 */
public class EditorChain {

    private AbstractEditor rootEditor;
    private AbstractEditor lastEditor;

    public EditorChain() {
    }

    public EditorChain(AbstractEditor rootEditor) {
        this.rootEditor = rootEditor;
        this.lastEditor = rootEditor;
    }

    public void addEditor(AbstractEditor editor)
    {
        if(rootEditor == null)
        {
            this.rootEditor = editor;
            this.lastEditor = editor;
        }
        else
        {
            lastEditor.setNextEditor(editor);
            lastEditor = editor;
        }
    }

    public Optional<Figure> editFigure(Figure figure)
    {
        return rootEditor.editFigure(figure);
    }
}
