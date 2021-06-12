package Utils;

import java.util.ArrayList;
import java.util.Scanner;

public interface Menu {

  public static void initial(Scanner scan) {
    System.out.println("----------- JOGO DA VELHA -----------");
    System.out.println("Escolha uma das opções abaixo");
    System.out.println("1 - Jogar");
    System.out.println("2 - Regras");
    System.out.println("3 - Instruções");
    System.out.println("0 - Sair");
    int choice = scan.nextInt();
    switch (choice) {
    case 1:
      clearScreen();
      break;
    case 2:
      clearScreen();
      scan.nextLine();
      rules(scan);
      initial(scan);
      break;
    case 3:
      clearScreen();
      scan.nextLine();
      instructions(scan);
      initial(scan);
      break;
    case 0:
      Game.setEnd(true);
      break;
    default:
      System.out.println("Escolha invalida!");
      System.out.println("Tente novamente");
      initial(scan);
      break;
    }
  }

  private static void instructions(Scanner scan) {
    System.out.println("----------- INSTRUÇÕES -----------");
    System.out.println("O Primeiro jogador escolhe uma marcação, círculo (O) ou xis (X).");
    System.out.println("Quando for sua vez, você escolhe um número de 1 a 9, para colocar o sua marcação.");
    System.out.println("Para reiniciar o jogo, na sua vez digite reiniciar.");
    System.out.println("Para sair do jogo, na sua vez digite sair.");
    pressEnterToContinue(scan);
  }

  public static void rules(Scanner scan) {
    System.out.println("----------- REGRAS -----------");
    System.out.println("Dois jogadores escolhem uma marcação cada um, círculo (O) ou xis (X).");
    System.out.println("Os jogadores jogam alternadamente, uma marcação por vez, numa lacuna que esteja vazia.");
    System.out.println("Quando for sua vez, você escolhe um número de 1 a 9, para colocar o sua marcação.");
    System.out.println("O objetivo é conseguir três círculos ou três xis em linha, sendo na horizontal, vertical ou diagonal , e ao mesmo tempo, quando possível, impedir o adversário de ganhar na próxima jogada.");
    pressEnterToContinue(scan);
  }

  public static void scoreBoard(ArrayList<Player> players) {
    System.out.println(players.get(0).getName() + ": " + players.get(0).getPoints() + " | " + players.get(1).getName() + ": " + players.get(1).getPoints() + " | Empate: " + Game.getDraw());
    System.out.println();
  }

  public static void pressEnterToContinue(Scanner scan) {
    System.out.print("\nPressione ENTER para continuar...");
    scan.nextLine();
    clearScreen();
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
