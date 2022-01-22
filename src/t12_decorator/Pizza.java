package t12_decorator;

public class Pizza implements Food{
    @Override
    public int getCalories() {
        return 266;
    }

    @Override
    public int getPrice() {
        return 50;
    }
}
