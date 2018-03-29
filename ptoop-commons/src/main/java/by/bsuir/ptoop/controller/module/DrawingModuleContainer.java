package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.drawer.DrawerChain;
import by.bsuir.ptoop.controller.editor.EditorChain;
import by.bsuir.ptoop.model.FigureList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;

/**
 * Global container for all app's functionality modules and necessary resources
 */
public class DrawingModuleContainer {

    private Menu menu;
    private DrawerChain drawerChain;
    private FigureList figureList;
    private EditorChain editorChain;
    private GraphicsContext context;

    public DrawingModuleContainer(Menu menu, DrawerChain drawerChain, EditorChain editorChain,
                                  FigureList figureList, GraphicsContext context) {
        this.menu = menu;
        this.drawerChain = drawerChain;
        this.editorChain = editorChain;
        this.figureList = figureList;
        this.context = context;
    }

    /**
     * Adds a functionality module to the container:
     * Adds a menu item to global menu
     * Provides editor chain, drawer chain and global figures list to modules
     * If a module has a drawer (module supports drawing figures), graphics context is provided and
     * module drawer and editor are added to chains
     */
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
