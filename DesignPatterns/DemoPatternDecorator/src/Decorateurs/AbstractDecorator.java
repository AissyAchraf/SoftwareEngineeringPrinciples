package Decorateurs;

import Boissons.Boisson;

public abstract class AbstractDecorator extends Boisson{

    protected Boisson boisson;

    public AbstractDecorator(Boisson boisson) {
        super();
        this.boisson = boisson;
    }

    public abstract String getDescription();

}
