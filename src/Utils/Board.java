package Utils;

public class Board {
  private static String[][] table = new String[3][3];

  public Board() {
    initializer();
  }

  public void initializer() {
    int count = 1;
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        getTable()[i][j] = String.valueOf(count++);
  }

  public String[][] getTable() {
    return table;
  }
}
