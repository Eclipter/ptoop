package by.bsuir.ptoop.controller;

import by.bsuir.ptoop.model.Figure;
import javafx.scene.canvas.GraphicsContext;

public class DrawerChain {

    private AbstractDrawer rootDrawer;
    private AbstractDrawer lastDrawer;

    public DrawerChain() {
    }

    public DrawerChain(AbstractDrawer rootDrawer) {
        this.rootDrawer = rootDrawer;
        this.lastDrawer = rootDrawer;
    }

    public void addDrawer(AbstractDrawer drawer)
    {
        if(rootDrawer == null)
        {
            this.rootDrawer = drawer;
            this.lastDrawer = drawer;
        }
        lastDrawer.setNextDrawer(drawer);
        lastDrawer = drawer;
    }

    public void draw(Figure figure)
    {
        rootDrawer.draw(figure);
    }

    public void initGraphicContexts(GraphicsContext context)
    {
        AbstractDrawer drawer = rootDrawer;
        while(drawer != null)
        {
            drawer.setGraphicsContext(context);
            drawer = drawer.getNextDrawer();
        }
    }
}
