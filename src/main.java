import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        System.out.println("Lütfen satır sayısını giriniz");
        int row = input.nextInt();
        System.out.println("Lütfen sütun sayısını giriniz");
        int column = input.nextInt();

        MineSweeper mine=new MineSweeper();

        mine.min_length(row,column);

    }
}
