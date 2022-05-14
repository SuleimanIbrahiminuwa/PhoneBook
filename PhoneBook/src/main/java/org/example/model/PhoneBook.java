package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    Scanner scan;
    List<String> numbers;

    // PhoneBook Method
    public PhoneBook(Scanner scan, List<String> numbers) {
        this.scan = scan;
        this.numbers = numbers;
    }

    // TASK TO perform when the program is first executed
    public void task() {
        boolean cont = true;
        do {
            //Ask user for input on which task they want to do
            System.out.println("Please Pick A Task: \n 1:Add Contact \n 2:Search a Number \n 3:Exit");
            String choice = scan.nextLine(); //read input
            //check user input and continue accordingly
            switch (choice) {
                case "1":
                    AddNumber(); //run AddNumber Method
                    cont = false;
                    break;
                case "2":
                    CallNumber(); //Run CallNumber method
                    cont = false;
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    System.exit(0); //Terminate Program
                    cont = false;
                    break;
                default:
                    System.err.println("Invalid");
            }
        }while(cont);
    }


    // Search a Number save on the array list
    public void CallNumber() {
        boolean cont = true;
        //create Keypad
        do try {
            String[][] keys = {
                    {" ", "1", " ", "2", " ", "3"},
                    {" ", "4", " ", "5", " ", "6"},
                    {" ", "7", " ", "8", " ", "9"},
                    {" ", " ", " ", "0", " ", " "}
            };
            //print keypad
            printPhoneBook(keys);
            //ask user for key number
            System.out.println("Pick 1 to search Number");
            String phoneNum = null; // should not be initialized as "", otherwise dialing message would be displayed even if choice is invalid.

            if (scan.hasNextInt()) {
                int choice = Integer.parseInt(scan.nextLine()); //convert string to int
                if (choice >= 0 && choice <= 9) {
                    phoneNum = "Number: " + numbers.get((choice + 9) % 10) + " "+ "Name: " + numbers.get(1);
                } else {
                    System.err.println("Does Not Exist");
                    continue;
                }
            }

            //if number exists, search number
            if (phoneNum != null) {
                System.out.println("Searching " + phoneNum + "....");
                cont = false;
            }
            //or say no number exists
            else {
                System.out.println("There is No Number At This Location");
                break;
            }
            //ask user tasks again
            task();
        } catch (IndexOutOfBoundsException e) { //catch possible errors
            System.err.println("There is No Number At This Location");
            //ask for tasks again
            task();
        }while(cont);
    }

    // Adding Number to the array List
    public void AddNumber() {

        boolean cont = true; //initialize boolean for loop
        do try{
            System.out.print("Please Enter The Number You Wish To Save Under Speed Dial: ");
            if(scan.hasNextLong()) {
                long input = Long.parseLong((scan.nextLine().trim().strip()));
                if ((input >= 100) && (input <= 9999_999_9999l)) {
                    // Add the next number to the ArrayList
                    numbers.add(String.valueOf(input));
                }else if((input < 1000) || (input > 9999_999_999l)){
                    System.out.println("Invalid Entry");
                    continue;
                }
            }
            System.out.print("Please Enter Contact Name: ");
            if(scan.hasNext()){
                String input2 = scan.nextLine().trim().strip();
                if(input2.length() > 4 || input2.length()< 15){
                    numbers.add(input2);
                } else if(input2.length()<4 || input2.length()>15){
                    System.out.println("Invalid Name");
                    continue;
                }

            }
            else if (scan.hasNextLine()) {
                scan.nextLine();
                System.out.println("Invalid Entry");
                continue;
            }

            System.out.print("Would you like to add another? Yes or No: ");
            String answer = scan.nextLine().toLowerCase(); //take input and convert to lowercase
            if (answer.equals("yes")){
                continue; //if they want to continue, allow it
            }else if (answer.equals("no")) { //if not, print arraylist and exit loop
                print();
                cont = false;
            }else if(answer.equals("")){
                System.out.println("Invalid Entry");
            }else{
                System.out.println("Invalid");
            }

        }catch(NumberFormatException e){

        }while(cont);

        //ask user tasks again
        task();

    }

    // Print Array List
    public static void printPhoneBook(String[][] keys){
        // Loop to print array
        for(String[] row : keys){
            for(String s : row){
                System.out.print(s);
            }
            System.out.println();
        }
    }

    // Print Number and Contact Added On the PhoneBook
    public void print(){
        //loop to print array numbers
        for(int i = 0; i< numbers.size(); i++){
            System.out.println((i+1) + ") " + numbers.get(i));
        }

    }

}
