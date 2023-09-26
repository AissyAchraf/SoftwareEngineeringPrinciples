public class ObserverImpl2 implements Observer {
    private double counter = 0;
    @Override
    public void update(Observable obs) {
        int state = ((ObservableImpl) obs).getState();
        if(state%2==0) counter++;
        System.out.println("------------Observer Impl2-----------------");
        System.out.println("New Update state = "+state);
        System.out.println("The result is "+((state%2==0)?"Pair":"Impair"));
        System.out.println("The counter is "+counter);
        System.out.println("-------------------------------------------");
    }
}
