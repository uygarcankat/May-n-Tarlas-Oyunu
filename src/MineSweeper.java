import java.util.Arrays;
import java.util.Scanner;

public class MineSweeper {

    static boolean min_length(int row, int column) {

        Scanner input = new Scanner(System.in);
        String[][] matrix = new String[row][column];
        int index=0;
        int n = row * column;
        int mine_number = n / 4;


        System.out.println("Mayın Tarlası oyununa hoşgeldiniz :) ");

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++)
                {
                    matrix[i][j]="-";
                }
            }


        for (int i = 0; i < mine_number; i++) {

            int mine_row = (int) (Math.random() * row);
            int mine_column = (int) (Math.random() * column);

            matrix[mine_row][mine_column] = "*";
        }

        for(String[] a : matrix){
            for(String b : a){

                System.out.print(b + "  ");
            }
            System.out.println();
        }


        do {
            System.out.println("Lütfen satır için bir nokta seçin");
            int choose_row = input.nextInt();
            System.out.println("Lütfen sütun sayısını giriniz");
            int choose_column = input.nextInt();
            index++;
            int sum = 0;


            if (choose_row < 0 || choose_row > row || choose_column < 0 || choose_column > column) {


                System.out.println("Hatalı giriş yaptınız");
                return min_length(row,column);


            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (matrix[i][j].equals("*") && matrix[i][j].equals(matrix[choose_row][choose_column])) {

                        System.out.println("Eyvah mayına bastınız!");
                         return false;
                    }
                    else {

                        int length = (int) Math.sqrt(Math.pow((choose_row - i), 2) + Math.pow((choose_column - j), 2));


                        if (length == 1) {
                            if (matrix[i][j].equals("*")) {
                                sum++;
                            }
                        }
                    }
                }
            }

            matrix[choose_row][choose_column] = String.valueOf(sum);

            for(String[] a : matrix){
                for(String b : a){

                    System.out.print(b + "  ");
                }
                System.out.println();
            }
        }

        while (n- mine_number > index );

        return true;
}

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Lütfen satır sayısını giriniz");
        int row = input.nextInt();
        System.out.println("Lütfen sütun sayısını giriniz");
        int column = input.nextInt();



        if( min_length(row,column)){

            System.out.println(" Tebrikler Kazandınız! :)");

        }

        else{
            System.out.println(" Kaybettiniz :( ");
        }
    }
}
