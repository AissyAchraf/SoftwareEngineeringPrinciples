import Boissons.Boisson;
import Boissons.Espresso;
import Decorateurs.Caramel;
import Decorateurs.Chocolat;

public class Main {
    public static void main(String[] args) {
        Boisson boisson = new Espresso();
        System.out.println("------------------------");
        System.out.println(boisson.getDescription());
        System.out.println(boisson.cout());
        System.out.println("------------------------");
        boisson = new Chocolat(boisson);
        System.out.println("------------------------");
        System.out.println(boisson.getDescription());
        System.out.println(boisson.cout());
        System.out.println("------------------------");
        boisson = new Caramel(boisson);
        System.out.println("------------------------");
        System.out.println(boisson.getDescription());
        System.out.println(boisson.cout());
        System.out.println("------------------------");
        boisson = new Chocolat(boisson);
        System.out.println("------------------------");
        System.out.println(boisson.getDescription());
        System.out.println(boisson.cout());
        System.out.println("------------------------");
        boisson = new Chocolat(boisson);
        System.out.println("------------------------");
        System.out.println(boisson.getDescription());
        System.out.println(boisson.cout());
        System.out.println("------------------------");
    }
}