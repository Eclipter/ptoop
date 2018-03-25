package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.AbstractDrawer;
import by.bsuir.ptoop.controller.EllipseDrawer;
import by.bsuir.ptoop.controller.editor.AbstractEditor;
import by.bsuir.ptoop.controller.editor.EllipseEditor;
import by.bsuir.ptoop.model.Figure;

import java.util.Optional;

public class EllipseModule extends DrawingModule {

    private static final String MENU_TEXT = "Draw Ellipse";

    public EllipseModule() {
        super(MENU_TEXT);

        menuItem.setOnAction(event ->
                getEditor().newDialog().showAndWait().ifPresent(result -> draw((Figure) result)));
    }

    @Override
    public AbstractEditor getEditor() {
        return new EllipseEditor();
    }

    @Override
    public Optional<AbstractDrawer> currentDrawer() {
        return Optional.of(new EllipseDrawer());
    }
}
