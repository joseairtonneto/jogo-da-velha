package Utils;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
  private static int draw = 0;
  private static boolean end = false;
  private Board board = new Board();

  public Game() {
    begins();
  }

  public void begins() {
    Scanner scan = new Scanner(System.in);
    ArrayList<Player> players = new ArrayList<Player>();
    Menu.initial(scan);
    Menu.clearScreen();
    if (end == true) {
      System.out.println("Obrigado por jogar. :)");
      return;
    }
    players.add(new Player(scan));
    Menu.clearScreen();
    players.add(new Player(scan, players.get(0).getIsX()));
    Menu.clearScreen();
    whoStarts(players);
    while (end != true) {
      if (players.get(0).getStart()) {
        oneBegins(scan, players);
      } else {
        twoBegins(scan, players);
      }
    }
    begins();
    scan.close();
  }

  public static int getDraw() {
    return draw;
  }

  public static Boolean getEnd() {
    return end;
  }

  public static void setEnd(Boolean end) {
    Game.end = end;
  }

  public void whoStarts(ArrayList<Player> players) {
    Random generator = new Random();
    Boolean start = generator.nextBoolean();
    if (start) {
      players.get(0).setStarter();
    } else {
      players.get(1).setStarter();
    }
  }

  public Boolean playX(String chosenPosition) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        boolean positionIsAvailable = chosenPosition.equals(board.getTable()[i][j]);

        if (positionIsAvailable) {
          board.getTable()[i][j] = "X";
          return true;
        }
      }
    }
    System.out.println("Posição ocupada!");
    return false;
  }

  public Boolean playO(String chosenPosition) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        boolean availablePosition = chosenPosition.equals(board.getTable()[i][j]);

        if (availablePosition) {
          board.getTable()[i][j] = "O";
          return true;
        }
      }
    }
    System.out.println("Posição ocupada!");
    return true;
  }

  public void verifier(ArrayList<Player> players, Scanner scan) {
    int winnerIsX = 0;
    int winnerIsO = 0;
    // Lines
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        Boolean positionEqualToX = board.getTable()[i][j].equals("X");
        Boolean positionEqualToO = board.getTable()[i][j].equals("O");

        if (positionEqualToX) {
          winnerIsX++;

          Boolean xMadeALine = winnerIsX == 3;

          if (xMadeALine) {
            if (players.get(0).getIsX()) {
              System.out.println(players.get(0).getName() + " Ganhou!!");
              Menu.pressEnterToContinue(scan);
              players.get(0).setWins();
              board.initializer();
              return;
            } else if (players.get(1).getIsX()) {
              System.out.println(players.get(1).getName() + " Ganhou!!");
              players.get(1).setWins();
              Menu.pressEnterToContinue(scan);
              board.initializer();
              return;
            }
          }
        } else if (positionEqualToO) {
          winnerIsO++;

          Boolean oMadeALine = winnerIsO == 3;

          if (oMadeALine) {
            if (!players.get(0).getIsX()) {
              System.out.println(players.get(0).getName() + " Ganhou!!");
              players.get(0).setWins();
              Menu.pressEnterToContinue(scan);
              board.initializer();
              return;
            } else if (!players.get(1).getIsX()) {
              System.out.println(players.get(1).getName() + " Ganhou!!");
              players.get(1).setWins();
              Menu.pressEnterToContinue(scan);
              board.initializer();
              return;
            }
          }
        }
      }
      winnerIsX = 0;
      winnerIsO = 0;
    }
    // Columns
    for (int j = 0; j < 3; j++) {
      for (int i = 0; i < 3; i++) {
        Boolean positionEqualToX = board.getTable()[i][j].equals("X");
        Boolean positionEqualToO = board.getTable()[i][j].equals("O");

        if (positionEqualToX) {
          winnerIsX++;

          Boolean xMadeAColumn = winnerIsX == 3;

          if (xMadeAColumn) {
            if (players.get(0).getIsX()) {
              System.out.println(players.get(0).getName() + " Ganhou!!");
              Menu.pressEnterToContinue(scan);
              players.get(0).setWins();
              board.initializer();
              return;
            } else if (players.get(1).getIsX()) {
              System.out.println(players.get(1).getName() + " Ganhou!!");
              players.get(1).setWins();
              Menu.pressEnterToContinue(scan);
              board.initializer();
              return;
            }
          }
        } else if (positionEqualToO) {
          winnerIsO++;

          Boolean oMadeAColumn = winnerIsO == 3;

          if (oMadeAColumn) {
            if (!players.get(0).getIsX()) {
              System.out.println(players.get(0).getName() + " Ganhou!!");
              Menu.pressEnterToContinue(scan);
              players.get(0).setWins();
              board.initializer();
              return;
            } else if (!players.get(1).getIsX()) {
              System.out.println(players.get(1).getName() + " Ganhou!!");
              players.get(1).setWins();
              Menu.pressEnterToContinue(scan);
              board.initializer();
              return;
            }
          }
        }
      }
      winnerIsX = 0;
      winnerIsO = 0;
    }
    // Primary Diagonal
    for (int i = 0, j = i; i < 3; i++, j++) {
      Boolean positionEqualToX = board.getTable()[i][j].equals("X");
      Boolean positionEqualToO = board.getTable()[i][j].equals("O");

      if (positionEqualToX) {
        winnerIsX++;

        Boolean xMadeAPrimaryDiagonal = winnerIsX == 3;

        if (xMadeAPrimaryDiagonal) {
          if (players.get(0).getIsX()) {
            System.out.println(players.get(0).getName() + " Ganhou!!");
            Menu.pressEnterToContinue(scan);
            players.get(0).setWins();
            board.initializer();
            return;
          } else if (players.get(1).getIsX()) {
            System.out.println(players.get(1).getName() + " Ganhou!!");
            players.get(1).setWins();
            Menu.pressEnterToContinue(scan);
            board.initializer();
            return;
          }
        }
      } else if (positionEqualToO) {
        winnerIsO++;

        Boolean oMadeAPrimaryDiagonal = winnerIsO == 3;

        if (oMadeAPrimaryDiagonal) {
          if (!players.get(0).getIsX()) {
            System.out.println(players.get(0).getName() + " Ganhou!!");
            Menu.pressEnterToContinue(scan);
            players.get(0).setWins();
            board.initializer();
            return;
          } else if (!players.get(1).getIsX()) {
            System.out.println(players.get(1).getName() + " Ganhou!!");
            players.get(1).setWins();
            Menu.pressEnterToContinue(scan);
            board.initializer();
            return;
          }
        }
      }
    }
    winnerIsX = 0;
    winnerIsO = 0;
    // Secondary Diagonal
    for (int i = 0, j = 2; i < 3; i++, j--) {
      Boolean positionEqualToX = board.getTable()[i][j].equals("X");
      Boolean positionEqualToO = board.getTable()[i][j].equals("O");

      if (positionEqualToX) {
        winnerIsX++;

        Boolean xMadeASecondaryDiagonal = winnerIsX == 3;

        if (xMadeASecondaryDiagonal) {
          if (players.get(0).getIsX()) {
            System.out.println(players.get(0).getName() + " Ganhou!!");
            Menu.pressEnterToContinue(scan);
            players.get(0).setWins();
            board.initializer();
            return;
          } else if (players.get(1).getIsX()) {
            System.out.println(players.get(1).getName() + " Ganhou!!");
            players.get(1).setWins();
            Menu.pressEnterToContinue(scan);
            board.initializer();
            return;
          }
        }
      } else if (positionEqualToO) {
        winnerIsO++;

        Boolean oMadeASecondaryDiagonal = winnerIsO == 3;

        if (oMadeASecondaryDiagonal) {
          if (!players.get(0).getIsX()) {
            System.out.println(players.get(0).getName() + " Ganhou!!");
            Menu.pressEnterToContinue(scan);
            players.get(0).setWins();
            board.initializer();
            return;
          } else if (!players.get(1).getIsX()) {
            System.out.println(players.get(1).getName() + " Ganhou!!");
            players.get(1).setWins();
            Menu.pressEnterToContinue(scan);
            board.initializer();
            return;
          }
        }
      }
    }
    if (allPlaced()) {
      Game.draw++;
      System.out.println("Empatou!!");
      Menu.pressEnterToContinue(scan);
      board.initializer();
    }
  }

  public Boolean allPlaced() {
    int count = 1;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        Boolean itsNotTheStandard = !board.getTable()[i][j].equals(String.valueOf(count));
        if (itsNotTheStandard) {
          count++;
        } else {
          return false;
        }
      }
    }
    return true;
  }

  public void oneBegins(Scanner scan, ArrayList<Player> players) {
    Boolean returns = false;
    verifier(players, scan);
    Menu.scoreBoard(players);
    printBoard();
    returns = !putMarking(scan, players.get(0));
    if (returns)
      return;

    Menu.clearScreen();

    verifier(players, scan);
    Menu.scoreBoard(players);
    printBoard();
    returns = !putMarking(scan, players.get(1));
    if (returns)
      return;
    Menu.clearScreen();
  }

  public void twoBegins(Scanner scan, ArrayList<Player> players) {
    Boolean returns = false;
    verifier(players, scan);
    Menu.scoreBoard(players);
    printBoard();
    returns = !putMarking(scan, players.get(1));
    if (returns)
      return;

    Menu.clearScreen();

    verifier(players, scan);
    Menu.scoreBoard(players);
    printBoard();
    returns = !putMarking(scan, players.get(0));
    if (returns)
      return;
    Menu.clearScreen();
  }

  public Boolean putMarking(Scanner scan, Player player) {
    Boolean move = false;
    do {
      System.out.println(player.getName() + " sua vez!");

      String chosenPosition = scan.nextLine();
      chosenPosition = chosenPosition.replaceAll("[^a-zA-Z0-9]", "");

      Boolean wantToRestart = chosenPosition.equals("reiniciar") || chosenPosition.equals("Reiniciar")
          || chosenPosition.equals("REINICIAR");
      Boolean wannaGoOut = chosenPosition.equals("sair") || chosenPosition.equals("Sair")
          || chosenPosition.equals("SAIR");

      Boolean chosenPositionIsANumber = chosenPosition.matches("[0-9]*");

      if (wantToRestart) {
        board.initializer();
        return false;
      } else if (wannaGoOut) {
        Game.end = true;
        return false;
      }

      if (chosenPositionIsANumber) {
        Boolean BiggerThanNineOrSmallerThenOne = Integer.parseInt(chosenPosition) > 9
            || Integer.parseInt(chosenPosition) < 1;

        if (BiggerThanNineOrSmallerThenOne)
          System.out.println("Posição invalida");
        else if (player.getIsX())
          move = playX(chosenPosition);
        else if (!player.getIsX())
          move = playO(chosenPosition);
      } else
        System.out.println("Posição invalida");
    } while (!move);
    return move;
  }

  public void printBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (j == 0) {
          System.out.print(board.getTable()[i][j]);
        } else {
          System.out.print(" | " + board.getTable()[i][j]);
        }
      }
      System.out.println();
    }
    System.out.println();
  }
}
