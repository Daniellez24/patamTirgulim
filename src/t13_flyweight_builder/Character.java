package t13_flyweight_builder;

public class Character {
    //int row, col; ---/** not good! we would need an Object for EVERY cell in the matrix doc[][]
    // we want to receive these as parameters(to the paint() method, for example)*/
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
