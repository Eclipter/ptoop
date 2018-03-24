package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.DrawerChain;
import by.bsuir.ptoop.model.FigureList;
import javafx.scene.control.Menu;

public class DrawingModuleContainer {

    private Menu menu;
    private DrawerChain drawerChain;
    private FigureList figureList;

    public DrawingModuleContainer(Menu menu, DrawerChain drawerChain) {
        this.menu = menu;
        this.drawerChain = drawerChain;
        this.figureList = new FigureList();
    }

    public void addModule(DrawingModule module)
    {
        menu.getItems().add(module.getMenuItem());
        module.setFigures(figureList);
        module.getDrawer().ifPresent(drawerChain::addDrawer);
        module.setDrawerChain(drawerChain);
    }

    public FigureList getFigureList() {
        return figureList;
    }
}
