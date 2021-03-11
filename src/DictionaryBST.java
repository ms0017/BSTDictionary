//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: dictionary bts
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
import java.util.ArrayList;
import java.util.NoSuchElementException;

// This should be the only constructor of this class.

public class DictionaryBST implements Dictionary {
  // the root for the tree to use below
  private DictionaryWord root;


  /**
   * Creates an empty dictionaryBST.
   */
  public DictionaryBST() {}


  /*
   * (non-Javadoc)
   * 
   * @see Dictionary#isEmpty()
   * 
   * @return boolean value Methods defined in the Dictionary interface
   */
  /*
   * (non-Javadoc)
   * 
   * @see Dictionary#isEmpty()
   * 
   * @return boolean value checks if the dictionary is empty
   */
  @Override
  public boolean isEmpty() {
    // returns appropriate boolean value
    return root == null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see Dictionary#addWord(java.lang.String, java.lang.String)
   * 
   * @return boolean value
   * 
   * @param word
   * 
   * @param meaning adds words to the dictionary
   */
  @Override
  public boolean addWord(String word, String meaning) {
    // creates an instance of a dictionary word
    DictionaryWord d1 = new DictionaryWord(word, meaning);
    if (root == null) {
      // if the tree is null, make the new word the root
      root = new DictionaryWord(word, meaning);
      // return appropriate boolean
      return true;
    } else {
      // calls add helper method to add the word
      return addWordHelper(d1, root);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see Dictionary#lookup(java.lang.String)
   * 
   * @param s checks the meaning of a given word
   */
  @Override
  public String lookup(String s) {
    // calls look up helper to find the meaning
    return lookupHelper(s, root);
  }

  /*
   * (non-Javadoc)
   * 
   * @see Dictionary#size()
   * 
   * @return size returns the size of the dictionary
   */
  @Override
  public int size() {
    // calls size helper to get a value to return
    return sizeHelper(root);
  }

  // Public methods not defined in the Dictionary interface
  /**
   * Computes and returns the height of this dictionaryBST, as the number of nodes from root to the
   * deepest leaf DictionaryWord node.
   * 
   * @return the height of this Binary Search Tree counting the number of DictionaryWord nodes
   */
  public int height() {
    // if it's empty,
    if (root == null) {
      // return 0
      return 0;
    } else {
      // return the height of tree
      return heightHelper(root);
    }
  }

  /**
   * Returns all the words within this dictionary sorted from A to Z
   * 
   * @return an ArrayList that contains all the words within this dictionary sorted in the ascendant
   *         order
   */
  public ArrayList<String> getAllWords() {
    // an arraylist to store all the words
    ArrayList<String> a1 = new ArrayList<>();
    // if the tree is null,
    if (root == null) {
      // return an empty array
      return a1;
    } else {
      // calls this method to get all the words inside the dictionary
      return getAllWordsHelper(root);
    }

  }
  // Recursive private helper methods
  // Each public method should make call to the recursive helper method with the
  // corresponding name

  /**
   * Recursive helper method to add newWord in the subtree rooted at node
   * 
   * @param newWordNode a new DictionaryWord to be added to this dictionaryBST
   * @param current     the current DictionaryWord that is the root of the subtree where newWord
   *                    will be inserted
   * @return true if the newWordNode is successfully added to this dictionary, false otherwise
   */
  private static boolean addWordHelper(DictionaryWord newWordNode, DictionaryWord current) {
    if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) > 0) {
      if (current.getRightChild() == null) {
        current.setRightChild(newWordNode);
      } else
        return addWordHelper(newWordNode, current.getRightChild());
    } else if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) < 0) {
      if (current.getLeftChild() == null) {
        current.setLeftChild(newWordNode);
      } else
        return addWordHelper(newWordNode, current.getLeftChild());
    } else if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) == 0) {
      return false;
    }
    return true;
  }


  /**
   * Recursive helper method to lookup a word s in the subtree rooted at current
   * 
   * @param s       String that represents a word
   * @param current pointer to the current DictionaryWord within this dictionary
   * @return the meaning of the word s if it is present in this dictionary
   * @throws NoSuchElementException if s is not found in this dictionary
   */
  private static String lookupHelper(String s, DictionaryWord current) {
    if (current == null) {
      // throws an exception if its empty
      throw new NoSuchElementException("No definition found for the word famous");
    } else if (s.compareToIgnoreCase(current.getWord()) < 0) {
      // makes recursive calls to look for meaning
      if (s == current.getWord()) {
        return current.getMeaning();
      } else
        // makes recursive calls to look for meaning on left
        return lookupHelper(s, current.getLeftChild());
    } else if (s.compareToIgnoreCase(current.getWord()) > 0) {
      if (s == current.getWord()) {
        return current.getMeaning();
      } else
        // makes recursive calls to look for meaning on right
        return lookupHelper(s, current.getRightChild());
    } else {
      // returns meaning
      return current.getMeaning();
    }
  }


  /**
   * Recursive helper method that returns the number of dictionary words stored in the subtree
   * rooted at current
   * 
   * @param current current DictionaryWord within this dictionaryBST
   * @return the size of the subtree rooted at current
   */
  private static int sizeHelper(DictionaryWord current) {
    if (current == null) {
      // returns zero if empty
      return 0;
    } else {
      // returns real size
      return (sizeHelper(current.getLeftChild()) + 1 + sizeHelper(current.getRightChild()));
    }
  }


  /**
   * Recursive helper method that computes the height of the subtree rooted at current
   * 
   * @param current pointer to the current DictionaryWord within this DictionaryBST
   * @return height of the subtree rooted at current counting the number of DictionaryWord nodes
   *         from the current node to the deepest leaf in the subtree rooted at current
   */
  private static int heightHelper(DictionaryWord current) {
    if (current == null)
      // returns 0 if empty
      return 0;
    // makes recursive calls ro get height
    int leftHeight = heightHelper(current.getLeftChild());
    int rightHeight = heightHelper(current.getRightChild());
    // returns the max hight
    return Math.max(leftHeight + 1, rightHeight + 1);
  }



  /**
   * Recursive Helper method that returns a list of all the words stored in the subtree rooted at
   * current sorted alphabetically from A to Z
   * 
   * @param current pointer to the current DictionaryWord within this dictionaryBST
   * @return an ArrayList of all the words stored in the subtree rooted at current
   */
  private static ArrayList<String> getAllWordsHelper(DictionaryWord current) {
    // storing content
    ArrayList<String> content = new ArrayList<>();
    if (current != null) {
      // adding all words to array in both left and righ children
      content.addAll(getAllWordsHelper(current.getLeftChild()));
      content.add(current.getWord());
      content.addAll(getAllWordsHelper(current.getRightChild()));
    }
    // returns content
    return content;
  }


}
