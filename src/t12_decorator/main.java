package t12_decorator;

public class main {
    /**
     * This design pattern allow us to add behavior to objects without affecting
     * other objects (instances) from the same class*/

    public static void main(String[] args) {
        //This is how we decorate things, pizza with onions and tomato
        /**BUT - it is the same as writing  Food f = new Onion(new Tomato(new Pizza()));
         * There is no order between the wrapping objects of food
         * This Design patter is good when the order or wrapping doesn't matter
         * */
        Food f =  new Tomato(new Onion(new Pizza()));

        System.out.println("This food got   " +  f.getCalories() + " Calories");
        System.out.println("Price   " +  f.getPrice());

    }
}
