package t13_flyweight;

public class main {
    public static void main(String[] args) {
        CharacterFlyweightFactory f = new CharacterFlyweightFactory();

        Character doc[][] = new Character[100][100];
        doc[10][5] = f.get("A,David,Red,3");
        doc[13][2] = f.get("A,David,Red,3");

       /** We can`t do it, change size will change the size of every
         Object that points out to "A,David,Red,3"
        To fix this we will use builder design pattern
        doc[13][2].setSize(4);*/


        //WE fix it by using the builder pattern
        doc[13][2] = f.get(doc[13][2]).setSize(4).setColor("blue").build(f);

        System.out.println(doc[10][5] == doc[13][2]);
        System.out.println(doc[10][5].getSize());
    }
}
