package t13_flyweight;

public class Character {
    final char letter;
    final String font;
    final String color;
    final int size;

    public Character(String values) {
        String sp[] = values.split(",");
        letter = sp[0].charAt(0);
        font = sp[1];
        color = sp[2];
        size =  Integer.parseInt(sp[3]);
    }


    public void paint(int row, int col){
        //Paint the Character
    }

    public int getSize() {
        return size;
    }

}
