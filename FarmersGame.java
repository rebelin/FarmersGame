/**
* This program allows a user to play through the Farmer's Game
* @author Rebecca Lin
* @version 1.0
*/

import java.util.Scanner;
public class FarmersGame
{
  /** This is the main function in the class that runs the game
    */
  public static void main (String[] args)
  {
    // Rules
    System.out.println("Welcome to the Farmer's Game!");
    System.out.println("The goal of the game is to move all of the characters (the farmer, wolf, sheep, and cabbage) from one bank of the river to the other.");
    System.out.println("The farmer is the only character who can row the boat, and he can only share his boat with one other character.");
    System.out.println("Be careful. If the wolf and sheep are left alone, the wolf will eat the sheep. If the sheep and cabbage are left alone, the sheep will eat the cabbage.");
    System.out.println("Have fun playing!");

    // {F, W, S, C}
    int [] rb = {1, 1, 1, 1};
    print(rb);
    while((!win(rb)) && (!lose(rb))) 
    {
      move(rb);
      print(rb);
    }
  }

  /** This function prints the status of the game (the river and its banks)
    * @param arr is an array of integers
    */
  public static void print(int [] arr)
  {
    String lb = " ";
    String rb = " ";

    if(arr[0] == 1) // Place of farmer
    {
      rb = rb + " F ";
    }
    else
    {
      lb = lb + " F ";
    }
    if(arr[1] == 0) // Place of wolf
    {
      lb = lb + " W ";
    }
    else
    {
      rb = rb + " W ";
    }
    if(arr[2] == 0) // Place of sheep
    {
      lb = lb + " S ";
    }
    else
    {
      rb = rb + " S ";
    }
    if(arr[3] == 0) // Place of cabbage
    {
      lb = lb + " C ";
    }
    else
    {
      rb = rb + " C ";
    }

    System.out.println(rb);
    System.out.println("~~~~~~~~~~~~~~");
    System.out.println("~~~~~~~~~~~~~~");
    System.out.println(lb);
  }

  /** This function determines if the user has won
    * @param arr is an array of integers being tested for win conditions
    * @return boolean that reads true if the win conditions are fulfilled and false if they are not
  */
  public static boolean win(int[] arr)
  {
    boolean win = true;
    for(int i = 0; i < arr.length; i++)
    {
      if(arr[i] == 1)
      {
        win = false;
      }
    }
    if(win == true)
    {
      System.out.println("You win! Nice job!");
    }
    return win;
  }

  /** This function determines if the user has lost
    * @param arr is an array of integers being tested for lose conditions
    * @return boolean that reads true if the lose conditions are fulfilled and false if they are not
    */
  public static boolean lose(int[] arr)
  {
    boolean lose = false;
    if(arr[1] == arr[2] && arr[1] != arr[0]) // Checking if the wolf and sheep are alone
    {
      lose = true;
      System.out.println("You lose. The wolf ate the sheep.");
    }
    else if(arr[2] == arr[3] && arr[2] != arr[0]) //Checking if the sheep and cabbage are alone
    {
      lose = true;
      System.out.println("You lose. The sheep ate the cabbage.");
    }
    return lose;
  }

  /** This function represents the user's move
    * @param arr is an array of integers that is used to represent a move (a move happens when an integer in the array changes)
    */
  public static void move(int[] arr)
  {
    boolean invalid = true;
    String input = "";

    while(invalid == true) // Checks if the user input move is valid and loops until the user input is valid
    {
      Scanner kboard = new Scanner(System.in);
      System.out.println("Who do you want to move? (F, W, S, C)");
      input = kboard.nextLine();
      boolean answer = valid(input, arr);

      if(answer == true)
      {
        invalid = false;
      }
    }

    if(arr[0] == 1) // Farmer's move
    {
      arr[0] = 0;
    }
    else
    {
      arr[0] = 1;
    }

    if(input.equals("W")) // Wolf's move
    {
      if(arr[1] == 1)
      {
        arr[1] = 0;
      }
      else
      {
        arr[1] = 1;
      }
    }
    else if(input.equals("S")) // Sheep's move
    {
      if(arr[2] == 1)
      {
        arr[2] = 0;
      }
      else
      {
        arr[2] = 1;
      }
    }
    else if(input.equals("C")) // Cabbage's move
    {
      if(arr[3] == 1)
      {
        arr[3] = 0;
      }
      else
      {
        arr[3] = 1;
      }
    }
  }

  /** This function checks if the user's move is valid
    * @param mv is a string that was inputed in the move fuction
    * @param arr is an array of integers that is used to compare array elements
    * @return boolean that reads true if the move is valid or false if a move is invalid
    */
  public static boolean valid(String mv, int [] arr)
  {
    if(mv.equals("F"))
    {
      return true;
    }
    else if(mv.equals("W") && arr[0] == arr[1])
    {
      return true;
    }
    else if(mv.equals("S") && arr[0] == arr[2])
    {
      return true;
    }
    else if(mv.equals("C") && arr[0] == arr[3])
    {
      return true;
    }
    else
    {
      System.out.println("This move is not allowed. ");
      return false;
    }
  }
}
