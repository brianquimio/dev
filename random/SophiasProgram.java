package random;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
 * Given a random number and a list of numbers,
 * Output any + - * / combinations to get to the magic number
 */

public class SophiasProgram {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        System.out.print("Enter a magic number: ");
        int magicNumber = read.nextInt();

        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<10; i++) {
            System.out.print("Enter a number: ");
            list.add(read.nextInt());
        }

        checkAllNums(list, magicNumber);

    }

    public static void validPair (List<Integer> list, int index, int magicNum) {

        int num = list.get(index);

        if(list.contains(magicNum - num) && (magicNum - num) != num) {
            System.out.println((magicNum - num) + " + " + num);
        }
        else if(list.contains(magicNum + num)) {
            System.out.println((magicNum + num) + " - " + num);
        }
        else if(list.contains(magicNum * num)) {
            System.out.println((magicNum * num) + " / " + num);
        }
        else if(list.contains(magicNum / num) && (magicNum / num) == 0){
            System.out.println((magicNum / num) + " * " + num);
        }

    }

    public static void checkAllNums (List<Integer> list, int magicNum) {

        for(int i=0; i<list.size(); i++){
            validPair(list, i, magicNum);
        }

        System.out.println("Done");
    }

}
