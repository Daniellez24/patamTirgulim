package t12_decorator;

public class Onion extends FoodDecorator{

    /**Food decorator didnt had any default constructor
     * so every class thet extends FoodDecorator need to
     * give it a Food object (hence the "super(f)")*/


    public Onion(Food f) {
        super(f);
    }

    //This is not an actually to do, it is only here for attention
    //TODO !!!!IMPORTANT!!!! - f is referring to the f from FoodDecorator !!!!IMPORTANT!!!!
    @Override
    public int getCalories() {
        return f.getCalories() +  30;
    }

    @Override
    public int getPrice() {
        return f.getPrice() + 3;
    }
}
