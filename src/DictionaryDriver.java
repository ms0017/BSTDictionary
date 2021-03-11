//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: dictionary driver
// Files: 
// Course: CS 300, spring, and 2019
//
// Author: Sheriff Issaka
// Email: issaka@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DictionaryDriver {

  public static void main(String[] args) {
    DictionaryBST d1 = new DictionaryBST();
    Scanner scnr = new Scanner(System.in);
    String[] s1;
    String output = "=========================== Dictionary ============================\r\n"
        + "Enter one of the following options:\r\n"
        + "[A <word> <meaning>] to add a new word and its definition in the dictionary\r\n"
        + "[L <word>] to search a word in the dictionary and display its definition\r\n"
        + "[G] to print all the words in the dictionary in sorted order\r\n"
        + "[S] to get the count of all words in the dictionary\r\n"
        + "[H] to get the height of this dictionary implemented as a binary search tree\r\n"
        + "[Q] to quit the program\r\n"
        + "======================================================================\r\n" + "\r\n"
        + "Please enter your command:";
    while (true) {
      System.out.println(output);
      String str = scnr.nextLine().toLowerCase();
      s1 = str.trim().split("\\s+", 3);
      switch (s1[0]) {
        case "a":
          if (s1.length != 3) {
            System.out.println("Syntax Error for [A <word> <meaning>] command line." );
            break;
          }
          d1.addWord(s1[1], s1[2]);
          break;
        case "l":
          if (s1.length != 2) {
            System.out.println("WARNING: Syntax Error");
            break;
            }
          try {
          System.out.println( s1[1] + ": "+ d1.lookup(s1[1]));
          }catch(NoSuchElementException e) {
        System.out.println(e.getMessage());
          }
          break;
        case "g":
          if (s1.length != 1) {
            System.out.println("WARNING: Syntax Error");
            break;
          }
          if(d1.getAllWords().size() == 0) {
            System.out.println("Dictionary is empty.");
          }else {
            String subs = d1.getAllWords().toString();
          System.out.println(subs.substring(1, subs.length()-1));
          }
          break;
        case "s":
          if (s1.length != 1) {
            System.out.println("WARNING: Syntax Error");
            break;
          }
          System.out.println(d1.size());
          break;
        case "h":
          if (s1.length != 1) {
            System.out.println("WARNING: Syntax Error");
            break;
          }
          System.out.println(d1.height());
          break;
        case "q":
          System.out
              .println("============================== END ===================================");
          return;
          default:
            System.out.println("WARNING: Unrecognized command.");
      }
      System.out.println();

    }
  }

}
