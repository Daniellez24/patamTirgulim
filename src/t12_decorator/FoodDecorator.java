package t12_decorator;

/**
 * Why do we need this class?
 * This class simply calling f.method, look useless BUT:
 * For any one will extend FoodDecorator he will not have to override those methods
 * Tomato for example does not affect both the price and the calories
 */
public class FoodDecorator implements Food {
    // this class implements Food, and also contains Food
    Food f;

    public FoodDecorator(Food f) {
        this.f = f;
    }

    /**
     * We override these methods and only activating the
     * parent methods
     */

    @Override
    public int getCalories() {
        return f.getCalories();
    }

    @Override
    public int getPrice() {
        return f.getPrice();
    }
}
