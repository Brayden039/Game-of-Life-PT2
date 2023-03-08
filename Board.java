import java.util.*;
public class Board 
{
//instance vars
  private int row;
  private int col;
  private boolean[][] grid;
  
//default contstructor
  public Board() 
  {
    row = 10;
    col = 10;
    grid = new boolean[row][col];
  }
  
//overloaded constructor
  public Board(int r, int c) 
  {
    row = r;
    col = c;
    grid = new boolean[r][c];
  }
  
//print method
  public void printGrid() 
  {
    System.out.println("\n*ROWS & COLUMNS ARE NUMBERED BY THEIR INDEX.*");
    System.out.print("\n ");
    for (int i = 0; i < col; i++) 
    {
      if (i < 10) 
      {
        System.out.print(" ");
      }
      System.out.print(i + " ");
    }
    System.out.println("");
    for (int i = 0; i < row; i++) 
    {
      System.out.print(i + " ");
      if (i < 10)
      {
        System.out.print(" ");
      }
      for (int j = 0; j < col; j++) 
      {
        if(grid[i][j]) 
        {
          System.out.print("⬜ ");
        } else {
          System.out.print("🟦 ");
        }
      }
      System.out.println("");
    }
  }
  
//activates initial positions
  public void startingPos() 
  {
    Scanner key = new Scanner(System.in);
    System.out.println("\nHow many spaces would you like to activate? ");
    int num = key.nextInt();
    for (int i = 0; i < num; i++) 
    {
      System.out.println("\nWhat is the row index of the space you would like to activiate? (between indexes 0 - " + (row-1) + ")");
      int r = key.nextInt();
      System.out.println("What is the column index of the space you would like to activate? (between indexes 0 - " + (col-1) + ")");
      int c = key.nextInt();
      grid[r][c] = true;
    }
  }


  public boolean active(int r, int c)
  {
    if(grid[r][c])
    {
      return true; 
    }
    else 
    {
      int numAlive = 0;
      for (int i = r - 1; i <= r + 1; i++)
      {
        for (int j = c - 1; j <= c + 1; j++)
        {
          if ((i >= 0 && i <= row) && (j >= 0 && j <= col))
          {
            if (grid[i][j])
            {
              numAlive++;
            }
          }
        }
      }
      if (numAlive == 3)
      {
        return true;
      } 
      else
      {
        return false;
      }     
    } 
  }

  
  public boolean inactive(int r, int c)
  {
    if (!grid[r][c])
    {
      return false;
    }
    else
    {
      int numAlive = -1;
      for (int i = r - 1; i <= r + 1; i++)
      {
        for (int j = c - 1; j <= c + 1; j++)
        {
          if ((i >= 0 && i <= row) && (j >= 0 && j <= col))
          {
            if (grid[i][j])
            {
              numAlive++;
            }
          }
        }
      }
      if (numAlive < 2 || numAlive >= 4) 
      {
        return false;
      }
      return true;
     
      
    }

  }
  
  
}
    
    