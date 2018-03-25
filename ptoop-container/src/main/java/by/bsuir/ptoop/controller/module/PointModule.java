package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.AbstractDrawer;
import by.bsuir.ptoop.controller.PointDrawer;
import by.bsuir.ptoop.controller.editor.AbstractEditor;
import by.bsuir.ptoop.controller.editor.PointEditor;
import by.bsuir.ptoop.model.Figure;

import java.util.Optional;

public class PointModule extends DrawingModule {

    private static final String MENU_TEXT = "Draw Point";

    public PointModule() {
        super(MENU_TEXT);

        menuItem.setOnAction(event ->
                getEditor().newDialog().showAndWait().ifPresent(result -> draw((Figure) result)));
    }

    @Override
    public AbstractEditor getEditor() {
        return new PointEditor();
    }

    @Override
    public Optional<AbstractDrawer> currentDrawer() {
        return Optional.of(new PointDrawer());
    }
}
