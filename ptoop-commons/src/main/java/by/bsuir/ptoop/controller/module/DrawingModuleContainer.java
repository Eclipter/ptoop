package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.drawer.DrawerChain;
import by.bsuir.ptoop.controller.editor.EditorChain;
import by.bsuir.ptoop.model.FigureList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;

public class DrawingModuleContainer {

    private Menu menu;
    private DrawerChain drawerChain;
    private FigureList figureList;
    private EditorChain editorChain;
    private GraphicsContext context;

    public DrawingModuleContainer(Menu menu, DrawerChain drawerChain, EditorChain editorChain, GraphicsContext context) {
        this.menu = menu;
        this.drawerChain = drawerChain;
        this.editorChain = editorChain;
        this.figureList = new FigureList();
        this.context = context;
    }

    public void addModule(DrawingModule module)
    {
        menu.getItems().add(module.getMenuItem());
        module.setFigures(figureList);
        module.setDrawerChain(drawerChain);
        module.setEditorChain(editorChain);

        module.currentDrawer().ifPresent(drawer -> {
            drawerChain.addDrawer(drawer);
            drawer.setGraphicsContext(context);
            editorChain.addEditor(module.getEditor());
        });
    }

    public FigureList getFigureList() {
        return figureList;
    }
}
