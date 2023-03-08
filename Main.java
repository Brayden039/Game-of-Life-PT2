class Main 
{
  public static void main(String[] args) 
  {
    Board b1 = new Board();
    b1.printGrid();
    b1.startingPos();
    b1.printGrid();
    System.out.println(b1.active(0,0));
    System.out.println(b1.active(1,1));
    System.out.println(b1.inactive(1,2));
    System.out.println(b1.inactive(2,2));
    
  }
}