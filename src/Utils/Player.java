package Utils;

import java.util.Scanner;

public class Player {
  private String name;
  private int points = 0;
  private boolean isX = false;
  private boolean start = false;

  public Player(Scanner scan) {
    System.out.println("Jogador 1 digite seu nome");
    scan.nextLine();
    String name = scan.nextLine();
    System.out.println(name + " você quer ser o x?[s - sim / n - não]");
    String answer = scan.nextLine();
    answer = answer.replaceAll("[A-MO-RT-Za-mo-rt-z0-9 !@#$%^&*()_+={};':\"\\|,.<>/?¡-ÿ]", "");
    if (answer.equals("s"))
      this.isX = true;
    this.name = name;
  }

  public Player(Scanner scan, Boolean isX) {
    System.out.println("Jogador 2 digite seu nome");
    String name = scan.nextLine();
    this.isX = !isX;
    this.name = name;
  }

  public void setWins() {
    this.points++;
  }

  public void setStarter() {
    this.start = true;
  }

  public String getName() {
    return name;
  }

  public int getPoints() {
    return points;
  }

  public Boolean getIsX() {
    return isX;
  }

  public Boolean getStart() {
    return start;
  }
}
