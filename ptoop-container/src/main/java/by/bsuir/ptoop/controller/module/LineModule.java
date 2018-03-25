package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.AbstractDrawer;
import by.bsuir.ptoop.controller.LineDrawer;
import by.bsuir.ptoop.controller.editor.AbstractEditor;
import by.bsuir.ptoop.controller.editor.LineEditor;
import by.bsuir.ptoop.model.Figure;

import java.util.Optional;

public class LineModule extends DrawingModule {

    private static final String MENU_TEXT = "Draw Line";

    public LineModule() {
        super(MENU_TEXT);

        menuItem.setOnAction(event ->
                getEditor().newDialog().showAndWait().ifPresent(result -> draw((Figure) result)));
    }

    @Override
    public AbstractEditor getEditor() {
        return new LineEditor();
    }

    @Override
    public Optional<AbstractDrawer> currentDrawer() {
        return Optional.of(new LineDrawer());
    }
}
