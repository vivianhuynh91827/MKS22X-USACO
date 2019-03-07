import java.util.*;
import java.io.*;

public class USACO {
  public static int bronze(String filename) throws FileNotFoundException {
    File f = new File(filename);
    Scanner in = new Scanner(f);
    int[] firstLine = new int[4]; //R, C, E, N
    String cur = "";
    int curInd = 0;
    while (curInd < 4) {
      cur = in.next();
      firstLine[curInd] = Integer.parseInt(cur);
      curInd++;
    }
    int[][] field = new int[firstLine[0]][firstLine[1]];
    int[][] directions = new int[firstLine[3]][3];
    // String test = "";
    for (int r = 0; r < firstLine[0]; r++) {
      for (int c = 0; c < firstLine[1]; c++) {
        field[r][c] = Integer.parseInt(in.next());
        // test += field[r][c] + " ";
      }
      // test+= "\n";
    }
    for (int n = 0; n < directions.length; n++) {
      directions[n][0]=Integer.parseInt(in.next());
      directions[n][1]=Integer.parseInt(in.next());
      directions[n][2]=Integer.parseInt(in.next());
    }
    // String test = "";
    // for (int i = 0; i < directions.length; i ++) {
    //   test += directions[i][0] + " " + directions[i][1] + " " + directions[i][2] + "\n";
    // }
    // System.out.println(test);

    for (int i = 0 ; i < directions.length; i++) {
      stomp(field, directions[i][0], directions[i][1], directions[i][2]);
    }

    // String testField = "";
    // for (int r = 0; r < field.length; r++) {
    //   for (int c = 0; c < field[0].length; c++) {
    //     testField += field[r][c] + " ";
    //   }
    //   testField += "\n";
    // }
    // System.out.println(testField);
    int sum = 0;
    for (int r = 0; r < field.length; r ++) {
      for (int c = 0; c < field[0].length; c++) {
        field[r][c] = firstLine[2] - field[r][c];
        if (field[r][c] <= 0) field[r][c] = 0;
        sum += field[r][c];
      }
    }
    return sum * 72 * 72;
  }

  private static void stomp(int[][] field, int row, int col, int depth) {
    int[][] grid = new int[3][3];
    int highest = 0;
    for (int r = 0; r < 3; r ++) {
      for (int c = 0; c < 3; c++) {
        grid[r][c] = field[row+r-1][col+c-1];
        if (grid[r][c] > highest) highest = grid[r][c];
      }
    }
    int lowest = highest - depth;
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        if (grid[r][c] > lowest) grid[r][c] = lowest;
        field[row+r-1][col+c-1] = grid[r][c];
      }
    }
  }

  public static int silver(String filename) throws FileNotFoundException {
    return 0;
  }

  public static void main(String[] args) {
    try {
      System.out.println(bronze("makelake.2.in"));
    }
    catch (FileNotFoundException e) {}
  }

}
