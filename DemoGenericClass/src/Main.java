import generics.MaPile;

public class Main {
    public static void main(String[] args) {

        MaPile<Integer> maPile = new MaPile<>();

        System.out.println("===================================");
        System.out.println("est ma pile vide ? :"+maPile.estVide());
        System.out.println("===================================");

        System.out.println("============ Taille ===============");
        System.out.println(maPile.taille());

        for(int i = 0; i<10; i++) {
            maPile.empiler(i);
        }

        System.out.println("========== L'affichage ============");

        for (Integer e : maPile.getValues()) {
            System.out.println(e);
        }
        System.out.println("===================================");

        System.out.println("========== Suppression ============");
        maPile.depiler();
        for (Integer e : maPile.getValues()) {
            System.out.println(e);
        }
        System.out.println("===================================");

        System.out.println("============ Taille ===============");
        System.out.println(maPile.taille());
        System.out.println("===================================");


        System.out.println("est ma pile vide ? :"+maPile.estVide());
        System.out.println("===================================");

        System.out.println("============ Vidage ... ===========");
        maPile.vider();
        System.out.println("===================================");

        System.out.println("============ Taille ===============");
        System.out.println(maPile.taille());
        System.out.println("===================================");

    }
}