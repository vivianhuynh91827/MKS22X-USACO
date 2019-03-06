import java.util.*;
import java.io.*;

public class USACO {
  public static int bronze(String filename) throws FileNotFoundException {
    File f = new File(filename);
    Scanner in = new Scanner(f);
    int[] firstLine = new int[4];
    String cur = "";
    int curInd = 0;
    while (curInd < 4){
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
    return 0;
  }

  // private static void stomp(int[][] field, )

  public static int silver(String filename) throws FileNotFoundException {
    return 0;
  }

  public static void main(String[] args) {
    try {
      bronze("makelake.1.in");
    }
    catch (FileNotFoundException e) {}
  }

}
