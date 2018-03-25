package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.drawer.AbstractDrawer;
import by.bsuir.ptoop.controller.drawer.CircleDrawer;
import by.bsuir.ptoop.controller.editor.AbstractEditor;
import by.bsuir.ptoop.controller.editor.CircleEditor;
import by.bsuir.ptoop.model.Figure;

import java.util.Optional;

public class CircleModule extends DrawingModule {

    private static final String MENU_TEXT = "Draw Circle";

    public CircleModule() {
        super(MENU_TEXT);

        menuItem.setOnAction(event ->
                getEditor().newDialog().showAndWait().ifPresent(result -> draw((Figure) result)));
    }

    @Override
    public AbstractEditor getEditor() {
        return new CircleEditor();
    }

    @Override
    public Optional<AbstractDrawer> currentDrawer() {
        return Optional.of(new CircleDrawer());
    }
}
