package t18_generic_abstract_factory;

public class Test {

    public static void main(String[] args) {
        GAFactory f = new GAFactory("src/t18_generic_abstract_factory/starwarsArmory.txt");
        // "Sword" is the key to the map, and we get a lightsaber object as the Sword s
        // (in this case, because we got the starwarsArmory.txt in the constructor of the GAFactory)
        Sword s  = f.get("Sword");
        s.slash();
        Shield sh = f.get("Shield"); // "Shield" is the key to the map
        sh.defend();
    }
}
