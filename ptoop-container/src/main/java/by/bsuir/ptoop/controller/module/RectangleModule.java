package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.AbstractDrawer;
import by.bsuir.ptoop.controller.RectangleDrawer;
import by.bsuir.ptoop.controller.editor.AbstractEditor;
import by.bsuir.ptoop.controller.editor.RectangleEditor;
import by.bsuir.ptoop.model.Figure;

import java.util.Optional;

public class RectangleModule extends DrawingModule {

    private static final String MENU_TEXT = "Draw Rectangle";

    public RectangleModule() {
        super(MENU_TEXT);

        menuItem.setOnAction(event ->
                getEditor().newDialog().showAndWait().ifPresent(result -> draw((Figure) result)));
    }

    @Override
    public AbstractEditor getEditor() {
        return new RectangleEditor();
    }

    @Override
    public Optional<AbstractDrawer> currentDrawer() {
        return Optional.of(new RectangleDrawer());
    }
}
