package t18_generic_abstract_factory;

public class PlainSword implements Sword{
    @Override
    public void slash() {
        System.out.println("Plain Sword slash");
    }
}
