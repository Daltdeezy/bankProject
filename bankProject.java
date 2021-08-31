import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class bankProject {
    static double savingsTotal = 200.00;

    public static boolean cancelOrContinue() { //Method used to check if user wants to cancel input or continue
        Scanner selection = new Scanner(System.in);
        String input = new String(selection.next()); //sets the string 'input' to the text entered by user
        if (input.contains("c")) { //check if the string input has the character c in it (Not as specific as I would like)
            return true;
        } else {
            return false;
        }
    }

    public static void option1() { //deposit method
        boolean selection;
        double depositAmount;
        int i = 0;

        System.out.println("You plan to make a deposit. Press 'x' to cancel or press 'c' to continue.");
        selection = cancelOrContinue();

        do {
            if (selection == false) {
                System.out.println("You will be returned to the menu.\n\n");
                initialText();
            } else {
                while (true) {
                    try {
                        System.out.println("How much would you like to deposit?");
                        Scanner checkDeposit = new Scanner(System.in);
                        depositAmount = checkDeposit.nextDouble();
                        savingsTotal += depositAmount;
                        System.out.println("Your new total is $" + savingsTotal + "!");
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Please input a valid number.");
                    }
                }
                i++;
            }
        } while (selection != false && i < 1);
        System.out.println("Thank you for banking with us and have a nice day!");
    }

    public static void option2() {
        boolean selection;
        double withdrawalAmount;
        int i = 0;

        System.out.println("You plan to make a withdrawal. Press 'x' to cancel or press 'c' to continue.");
        selection = cancelOrContinue();

        do {
            if (selection == false) {
                System.out.println("You will be returned to the menu.\n\n");
                initialText();
            } else {
                while (true) {
                    try {
                        System.out.println("How much would you like to withdrawal?");
                        Scanner checkWithdrawal = new Scanner(System.in);
                        withdrawalAmount = checkWithdrawal.nextDouble();
                        savingsTotal -= withdrawalAmount;
                        System.out.println("Your new total is $" + savingsTotal + "!");
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Please input a valid number.");
                    }
                }
                i++;
            }
        } while (selection != false && i < 1);
        System.out.println("Thank you for banking with us and have a nice day!");
    }

    public static void option3() {
        System.out.println("Your savings total is $" + savingsTotal + "!\nThank you and have a nice day!");
    }

    public static void initialText() {
        int x;
        while (true) {
            try {
                Scanner checkOption = new Scanner(System.in);
                System.out.println("What would you like to do today?\nType 1 to make a deposit\tType 2 to make a withdrawl\tType 3 to display your savings total");
                x = checkOption.nextInt();//Checks if user input is an int
                if (x == 1) {
                    option1();
                    break;
                } else if (x == 2) {
                    option2();
                    break;
                } else if (x == 3) {
                    option3();
                    break;
                }
                break;
            }catch(InputMismatchException e){
                System.out.println("please input a valid number when prompted.\n");
            }
        }
    }

    public static void main(String[] args) {
            initialText();
        }

    }

