package t12_decorator;

public class Hamburger implements Food{
    @Override
    public int getCalories() {
        return 294;
    }

    @Override
    public int getPrice() {
        return 45;
    }
}
