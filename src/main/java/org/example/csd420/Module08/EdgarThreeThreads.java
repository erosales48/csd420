package org.example.csd420.Module08;

/* Edgar D Rosales
   19 September 2024
   CSD420-J318 Advanced Java Programming (2247-DD)

   Module 8 Assignment:
   1. Create a class tittled <your first name>ThreeThreads.
      - In this class, you are to use three threads to output three types of characters to a text area for display.
        - In the first thread, you are to output random letter characters such as a, b, c, d ...
        - In the second thread, you are to output random number digits such as  0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        - In the third thread, you are to output random characters such as !, @, #, $, %, &, *
      - Display a minimum of 10,000 oe each three sets.
 */
public class EdgarThreeThreads {


    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            if (i % 60 == 0) {
                System.out.println();
            } else {
                if (i % 5 == 0) {
                    System.out.print(" ");
                }
            }
            Thread symbolThread = new Thread(() -> System.out.print(getRandomSymbol()));
            Thread charThread = new Thread(() -> System.out.print(getRandomChar()));
            Thread digitThread = new Thread(() -> System.out.print(getRandomDigit()));

            symbolThread.start();
            charThread.start();
            digitThread.start();

            try {
                symbolThread.join();
                charThread.join();
                digitThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Function to select random alpha char
    private static char getRandomChar() {
        String charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int index = (int) (Math.random() * charArray.length());
        return charArray.charAt(index);
    }

    // Function to select random symbol char
    private static char getRandomSymbol() {
        String symbolArray = "!@#$%&*";
        int index = (int) (Math.random() * symbolArray.length());
        return symbolArray.charAt(index);
    }

    // Function to select random digit
    private static char getRandomDigit() {
        String digitArray = "0123456789";
        int index = (int) (Math.random() * digitArray.length());
        return digitArray.charAt(index);
    }
}