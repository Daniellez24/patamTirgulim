package t13_flyweight_builder;

import java.util.HashMap;

public class CharacterFlyweightFactory {
    /**
     * This design pattern checks if:
     * given object A -> if he already exists return a reference
     * Else create new one
     */
    HashMap<String, Character> map;

    public CharacterFlyweightFactory() {
        map = new HashMap<>();
    }

    //Given key -> check if there is already existing object
    public Character get(String key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }

        Character c = new Character(key);
        map.put(key, c);
        return c;

    }

    public CharacterBuilder get(Character c) {
        return new CharacterBuilder(c);
    }
}
