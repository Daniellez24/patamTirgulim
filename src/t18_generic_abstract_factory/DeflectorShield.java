package t18_generic_abstract_factory;

public class DeflectorShield implements Shield{
    @Override
    public void defend() {
        System.out.println("Deflector Shield");
    }
}
