package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.AbstractDrawer;
import by.bsuir.ptoop.controller.RoundRectangleDrawer;
import by.bsuir.ptoop.controller.editor.AbstractEditor;
import by.bsuir.ptoop.controller.editor.RoundRectangleEditor;
import by.bsuir.ptoop.model.Figure;

import java.util.Optional;

public class RoundRectangleModule extends DrawingModule {

    private static final String MENU_TEXT = "Draw Round Rectangle";

    public RoundRectangleModule() {
        super(MENU_TEXT);

        menuItem.setOnAction(event -> {
            getEditor().newDialog().showAndWait().ifPresent(result -> draw((Figure) result));
        });
    }

    @Override
    public AbstractEditor getEditor() {
        return new RoundRectangleEditor();
    }

    @Override
    public Optional<AbstractDrawer> currentDrawer() {
        return Optional.of(new RoundRectangleDrawer());
    }
}
