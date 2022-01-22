package t12_decorator;

public class Tomato extends FoodDecorator{
    public Tomato(Food f) {
        super(f);
    }

    @Override
    public int getPrice() {
        return f.getPrice() + 5;
    }
}
