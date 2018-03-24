package by.bsuir.ptoop.controller;

import by.bsuir.ptoop.model.Figure;

public class DrawerChain {

    private AbstractDrawer rootDrawer;
    private AbstractDrawer lastDrawer;

    public DrawerChain(AbstractDrawer rootDrawer) {
        this.rootDrawer = rootDrawer;
        this.lastDrawer = rootDrawer;
    }

    public void addDrawer(AbstractDrawer drawer)
    {
        lastDrawer.setNextDrawer(drawer);
        lastDrawer = drawer;
    }

    public void draw(Figure figure)
    {
        rootDrawer.draw(figure);
    }
}
