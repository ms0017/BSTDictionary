//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Dictionary tests
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
/**
 * @author Sheriff
 *
 */
public class DictionaryTests {
  /**
   * @return boolean value checks if isEmpty method operates appropriately
   */
  public static boolean testIsEmpty() {
    // as instance of a dictionary bts
    DictionaryBST d1 = new DictionaryBST();
    // boolean to be returned
    return (d1.isEmpty());
  }

  /**
   * @return boolean value checks if height method operates appropriately
   */
  public static boolean testHeight() {
    // an instance of a dictionary bts
    DictionaryBST d1 = new DictionaryBST();
    // checking if height is zero is an empty bts
    if (d1.height() == 0) {
      // boolean to be returned
      return true;
    }
    // boolean to be returned
    return false;
  }

  /**
   * @return boolean value checks if size method operates appropriately
   */
  public static boolean testSize() {
    // an instance of a dictionary bts
    DictionaryBST d1 = new DictionaryBST();
    // checking if size is zero is an empty bts
    if (d1.size() == 0) {
      // boolean to be returned
      return true;
    }
    // boolean to be returned
    return false;
  }

  /**
   * @return boolean value checks if constructor method operates appropriately
   */
  public static boolean testConstructor() {
    // adding a new dictoinary word
    DictionaryWord d1 = new DictionaryWord("hey", "kiddo, I need a 40!!!");
    // checking output
    if (d1.getMeaning().equals("kiddo, I need a 40!!!")) {
      // boolean to be returned
      return true;
    }
    // boolean to be returned
    return false;
  }

  /**
   * @return boolean value checks if to string method operates appropriately
   */
  public static boolean testToString() {
    DictionaryWord d1 = new DictionaryWord("hey", "kiddo, I need a 40!!!");
    if (d1.toString().equals("hey: kiddo, I need a 40!!!")) {
      // boolean to be returned
      return true;
    }
    // boolean to be returned
    return false;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // checking is empty
    if (testIsEmpty()) {
      // print values
      System.out.println("testIsEmpty passed");
    } else {
      System.out.println("testIsEmpty failed");
    }
    // calling test height to check value
    if (testHeight()) {
      // print values
      System.out.println("testHeight passed");
    } else {
      System.out.println("testHeight failed");
    }
    // calling test size to check value
    if (testSize()) {
      // print values
      System.out.println("testSize passed");
    } else {
      System.out.println("testSize failed");
    }
    // calling test constructor to check value
    if (testConstructor()) {
      // print values
      System.out.println("testConstructor passed");
    } else {
      System.out.println("testConstructor failed");
    }
    // calling test to string to check value
    if (testToString()) {
      // print values
      System.out.println("testToString passed");
    } else {
      System.out.println("testToString failed");
    }
  }

}
