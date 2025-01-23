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
    //Players Array List
    List<Players> players = new ArrayList<>();


    try {
      reader = new BufferedReader(new FileReader(file));
      while((line = reader.readLine()) != null) {
        
        String[] row = line.split(",");
        //adds new player to the list
        players.add(new Players(row[1], Integer.parseInt(row[2])));
        //output and formatting for original high scores
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
      //Adding new player to updated high scores list
      Players newPlayer = new Players("RJD",7688902);
      players.add(newPlayer);
      //Sorts players in descending order based on high score
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

      //outputs updated high scores
      System.out.println("\nNew High Scores: ");
      int rank = 1;
      for (Players player : players) {
        //formatting for new scores data
        System.out.printf("\n#%-10d %-10s %-10d", rank, player.getInitials(), player.getScore());
        rank++;
      }


   
  }//End of main
}//End of CreateFile