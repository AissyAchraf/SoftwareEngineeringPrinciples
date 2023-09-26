package Decorateurs;

import Boissons.Boisson;

public class Chocolat extends AbstractDecorator{

    public Chocolat(Boisson boisson) {
        super(boisson);
    }

    @Override
    public double cout() {
        return 2+boisson.cout();
    }

    @Override
    public String getDescription() {
        return boisson.getDescription()+", au chocolat";
    }
}
