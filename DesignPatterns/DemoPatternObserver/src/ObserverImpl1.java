public class ObserverImpl1 implements Observer{
    @Override
    public void update(Observable obs) {
        int state = ((ObservableImpl) obs).getState();
        double result = state*state+9;
        System.out.println("------------Observer Impl1-----------------");
        System.out.println("New Update state = "+state);
        System.out.println("The result is "+result);
        System.out.println("-------------------------------------------");
    }
}
