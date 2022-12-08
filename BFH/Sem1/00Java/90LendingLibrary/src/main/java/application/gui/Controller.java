package application.gui;

import java.util.List;

import application.CatalogLookup;

public class Controller {
    protected int nr;
    private CatalogLookup lookup;
    private List<Pane> panes;

    public Controller(CatalogLookup lookup) {
        this.lookup = lookup;
    }

    public List<Pane> getPanes() {
        return this.panes;
    }

}
