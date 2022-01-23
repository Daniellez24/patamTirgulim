package t13_flyweight;

/**
 * This class is a little different from normal builder
 * Better go and check the builder pattern
 */
public class CharacterBuilder {
    char letter;
    String font;
    String color;
    int size;

    public CharacterBuilder(Character c) {
        letter = c.letter;
        font = c.font;
        color = c.color;
        size = c.size;
    }

    /**We are returning the same object so we can use the same methods
     * in this way --> setLetter("A").setFont().....*/
    public CharacterBuilder setLetter(char letter) {
        this.letter = letter;
        return this;
    }

    public CharacterBuilder setFont(String font) {
        this.font = font;
        return this;

    }

    public CharacterBuilder setColor(String color) {
        this.color = color;
        return this;

    }

    public CharacterBuilder setSize(int size) {
        this.size = size;
        return this;
    }

    /** */
    public Character build(CharacterFlyweightFactory f) {
        return f.get(letter + "," + font + "," + color + "," + size);
    }
}
