package t13_flyweight_builder;

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

        System.out.println(doc[10][5] == doc[13][2]); // true

        //WE fix it by using the builder pattern
        doc[13][2] = f.get(doc[13][2]).setSize(4).setColor("blue").build(f);

        // == checks references
        System.out.println(doc[10][5] == doc[13][2]); // false
        System.out.println(doc[10][5].getSize()); // 3

        for (int i = 0; i < doc.length; i++) {
            for (int j = 0; j < doc[i].length; j++) {
                if(doc[i][j]!=null)
                    doc[i][j].paint(i,j);
            }
        }
    }
}
