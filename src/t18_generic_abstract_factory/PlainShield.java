package t18_generic_abstract_factory;

public class PlainShield implements Shield{
    @Override
    public void defend() {
        System.out.println("Plain Shield");
    }
}
