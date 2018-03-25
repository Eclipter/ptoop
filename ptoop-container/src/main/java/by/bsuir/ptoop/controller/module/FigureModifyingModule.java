package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.dialog.FiguresModifyingDialog;
import by.bsuir.ptoop.controller.drawer.AbstractDrawer;
import by.bsuir.ptoop.controller.editor.AbstractEditor;
import by.bsuir.ptoop.controller.editor.FigureModifyingEditor;
import javafx.scene.canvas.GraphicsContext;

import java.util.Optional;

public class FigureModifyingModule extends DrawingModule {

    private static final String MENU_TEXT = "Modify Figures";

    public FigureModifyingModule(GraphicsContext graphicsContext) {
        super(MENU_TEXT);

        menuItem.setOnAction(event ->
        {
            new FiguresModifyingDialog(editorChain, figures).showAndWait();
            redrawFigures(graphicsContext);
        });
    }

    private void redrawFigures(GraphicsContext context)
    {
        context.clearRect(0, 0, context.getCanvas().getWidth(), context.getCanvas().getHeight());
        figures.forEach(drawerChain::draw);
    }

    @Override
    public AbstractEditor getEditor() {
        return new FigureModifyingEditor();
    }

    @Override
    public Optional<AbstractDrawer> currentDrawer() {
        return Optional.empty();
    }
}
