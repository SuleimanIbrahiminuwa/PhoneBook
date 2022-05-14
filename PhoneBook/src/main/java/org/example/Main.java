package org.example;

import org.example.model.PhoneBook;

import java.util.ArrayList; //Import ArrayList
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner; //Import Scanner
public class Main {
    public static void main(String[] args) {
                final List<String> numbers = new ArrayList<>(); //Initialize new ArrayList

                Scanner scan = null;

                try {
                    scan = new Scanner(System.in);
                    PhoneBook phoneBook = new PhoneBook(scan, numbers);
                    phoneBook.task();

                }catch(InputMismatchException e){
                    System.out.println("Scanner Not Found");
                }finally{
                    if(scan != null){
                        scan.close();
                    }
                }
            }

}

