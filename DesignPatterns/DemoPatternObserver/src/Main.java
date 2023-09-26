public class Main {
    public static void main(String[] args) {

        ObservableImpl observable = new ObservableImpl();
        Observer observer1 = new ObserverImpl1();
        Observer observer2 = new ObserverImpl2();
        Observer observer3 = new ObserverImpl1();

        observable.addObserver(observer1);
        observable.setState(15);
        observable.setState(9);
        observable.setState(10);
        observable.addObserver(observer2);
        observable.setState(3);
    }
}