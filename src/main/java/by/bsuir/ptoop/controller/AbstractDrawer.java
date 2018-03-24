package by.bsuir.ptoop.controller;

import by.bsuir.ptoop.model.Figure;

public abstract class AbstractDrawer
{
    private AbstractDrawer nextDrawer;

    public abstract boolean supports(Figure figure);

    public void draw(Figure figure)
    {
        if(!supports(figure))
        {
            nextDrawer.draw(figure);
        }
        else
        {
            drawFigure(figure);
        }
    }

    public abstract void drawFigure(Figure figure);

    public AbstractDrawer getNextDrawer() {
        return nextDrawer;
    }

    public void setNextDrawer(AbstractDrawer nextDrawer) {
        this.nextDrawer = nextDrawer;
    }
}
