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
        setTable(String.valueOf(count++), i, j);
  }

  public String[][] getTable() {
    return table;
  }

  public static void setTable(String count, int i, int j) {
    table[i][j] = count;
  }
}
