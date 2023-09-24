public class Context {

    private IStrategy strategy;

    public Context() {
        this.strategy = new DefaultStrategyImpl();
    }
    public void process() {
        System.out.println("Démarage de la fonction process ...\n");
        strategy.appliquerStrategy();
        System.out.println("Fin de la fonction process!\n");
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }
}
