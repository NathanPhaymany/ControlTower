/* Assignment 2 - Control Tower */
/* Class name - must be "Assignment2" in order to run */
import java.util.Scanner;
import assignment2.Airplane;

public class Assignment2
{
  public static void main(String[] args)
  {
    Airplane[] a = new Airplane[3];
    a[0] = new Airplane();
    a[1] = new Airplane("AAA02", 15.8, 128, 30000);
    
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the details of the third airplane (call-sign, distance, bearing and altitude):");
    String cs = scan.nextLine();
    double dist = scan.nextDouble();
    int dir = scan.nextInt();
    int alt = scan.nextInt();
    
    a[2] = new Airplane(cs.toUpperCase(), dist, dir, alt);
    
    System.out.println("\nInitial Positions:");
    for (int i = 0; i < 3; i++){
      System.out.println("\"Airplane " + (i+1) + "\": " + a[i]);
    }
    
    System.out.println("\nInitial Distances:");
    printDist(a[0], 1, a[1], 2);
    printDist(a[0], 1, a[2], 3);
    printDist(a[1], 2, a[2], 3);
    
    System.out.println("\nInitial Height Differences:");
    altDiff(a[0], 1, a[1], 2);
    altDiff(a[0], 1, a[2], 3);
    altDiff(a[1], 2, a[2], 3);
    
    a[0].gainAlt();
    a[0].gainAlt();
    a[0].gainAlt();
    a[1].loseAlt();
    a[1].loseAlt();
    a[2].loseAlt();
    a[2].loseAlt();
    a[2].loseAlt();
    a[2].loseAlt();
    
    a[0].move(a[1].distTo(a[2]), 65);
    a[1].move(8.0, 135);
    a[2].move(5.0, 55);
    
    System.out.println("\nNew Positions:");
    for (int i = 0; i < 3; i++){
      System.out.println("\"Airplane " + (i+1) + "\": " + a[i]);
    }
    
    System.out.println("\nNew Distances:");
    printDist(a[0], 1, a[1], 2);
    printDist(a[0], 1, a[2], 3);
    printDist(a[1], 2, a[2], 3);
    
    System.out.println("\nNew Height Differences:");
    altDiff(a[0], 1, a[1], 2);
    altDiff(a[0], 1, a[2], 3);
    altDiff(a[1], 2, a[2], 3);

  }
  public static void printDist(Airplane a1, int a1Num, Airplane a2, int a2Num) {
    System.out.println("The distance between Airplane " + a1Num + " and Airplane " + a2Num + " is " + a1.distTo(a2) + " miles.");
  }
  public static void altDiff(Airplane a1, int a1Num, Airplane a2, int a2Num) {
    System.out.println("The difference in height between Airplane " + a1Num + " and Airplane " + a2Num + " is " + Math.abs(a1.getAlt() - a2.getAlt()) + " feet.");
  }
}
