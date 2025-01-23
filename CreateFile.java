import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateFile {
  public static void main(String[] args) {

    String file = "highScores.csv";
    BufferedReader reader = null;
    String line = "";

    List<Players> players = new ArrayList<>();


    try {
      reader = new BufferedReader(new FileReader(file));
      while((line = reader.readLine()) != null) {
        
        String[] row = line.split(",");

        players.add(new Players(row[1], Integer.parseInt(row[2])));

        for(String index : row) {
          System.out.printf("%-10s", index);
        }
        System.out.println();
      }
    }
    catch(IOException e) {
      e.printStackTrace();
    }
    finally {
      if (reader != null) {
        try {
          reader.close();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }
      }

      Players newPlayer = new Players("RJD",7688902);
      players.add(newPlayer);

      for (int i = 0; i < players.size() - 1; i++) {
        for (int j = i + 1; j < players.size(); j++) {
          if (players.get(i).getScore() < players.get(j).getScore()) {
            Players temp = players.get(i);
            players.set(i, players.get(j));
            players.set(j, temp);
          }
        }
      }
      //Drops lowest score
      players.remove(players.size() - 1);

      System.out.println("\nNew High Scores: ");
      for (Players player : players) {
        System.out.printf("\n%-10s %-10s", player.getInitials(), player.getScore());
      }


   
  }//End of main
}//End of CreateFile