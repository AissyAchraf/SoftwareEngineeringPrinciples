import java.util.Scanner;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Context ctx = new Context();
        boolean fin = false;
        Scanner scanner = new Scanner(System.in);
        while (!fin) {
            System.out.println("Donner la stratégie :");
            String strategyClassName=scanner.nextLine();
            IStrategy strategy = (IStrategy) Class.forName(strategyClassName).newInstance();
            System.out.println("----------------------");
            ctx.setStrategy(strategy);
            ctx.process();
            System.out.println("----------------------");
        }
    }
}
