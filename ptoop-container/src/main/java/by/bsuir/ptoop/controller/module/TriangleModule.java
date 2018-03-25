package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.drawer.AbstractDrawer;
import by.bsuir.ptoop.controller.drawer.TriangleDrawer;
import by.bsuir.ptoop.controller.editor.AbstractEditor;
import by.bsuir.ptoop.controller.editor.TriangleEditor;
import by.bsuir.ptoop.model.Figure;

import java.util.Optional;

public class TriangleModule extends DrawingModule {

    private static final String MENU_TEXT = "Draw Triangle";

    public TriangleModule() {
        super(MENU_TEXT);

        menuItem.setOnAction(event ->
                getEditor().newDialog().showAndWait().ifPresent(result -> draw((Figure) result)));
    }

    @Override
    public AbstractEditor getEditor() {
        return new TriangleEditor();
    }

    @Override
    public Optional<AbstractDrawer> currentDrawer() {
        return Optional.of(new TriangleDrawer());
    }
}
