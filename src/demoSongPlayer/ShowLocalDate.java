package demoSongPlayer;

import java.time.LocalDate;

public class ShowLocalDate {  

  public static void main(String[] args) {
    LocalDate lastDayPlayed = LocalDate.now().minusYears(10);
    LocalDate today = LocalDate.now();
    System.out.println(today.compareTo(lastDayPlayed) + " years ago");
  }
}