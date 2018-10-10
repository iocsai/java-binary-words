/**
 * Challenge: write a program that takes an input either a word or numbers 
 * If it is a word, print it, and find the list of numbers that corresponds to 
 * the word. A=1 B=2 ... z=26 so for the word Act the output would be 1320, 
 * a=1 c=3 t=20. The program should also take that number, convert it to binary
 * and print that as well.If the input was numbers, then it just converts that
 * number to binary. 
 * For the word: Act 
 * Output:  Act 
 *          1320 
 *          10100101000
 */
package binarywords;

import java.util.Scanner;

public class BinaryWords {
    
    private final String word;
    private final String number;
    private final String binary;

    public BinaryWords(String word) {
        this.word = word.split(" ")[0];
        this.number = numberize();
        this.binary = binarize();
    }
    
    public static void main(String[] args) {
        BinaryWords bw = new BinaryWords(input());
        System.out.println(bw.toString());
    }
    
    private static String input() {
        System.out.println("Input a word.");
        try (Scanner sc = new Scanner(System.in)) {
            return sc.nextLine();
        }
    }

    private String numberize() {
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            char c = word.toLowerCase().charAt(i);
            result += Character.isDigit(c) ? (c - 48) : (c - 96);
        }
        return result;
    }
    
    private String binarize() {
        String num = this.number;
        String result = "";
        while (!num.equals("")) {
            int lastNum = Integer.parseInt(num.substring(num.length() - 1)) % 2;
            result = lastNum + result;
            num = half(num);
        }
        return result;
    }

    private String half(String num) {
        String trans = "0";
        String result = "";
        for (int i = 0; i < num.length(); i++) {
            int parse = Integer.parseInt(trans + num.substring(i, i + 1));
            result += (parse / 2);
            trans = parse % 2 + "";
        }
        return result.startsWith("0") ? result.substring(1) : result;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s", word, number, binary);
    }
}