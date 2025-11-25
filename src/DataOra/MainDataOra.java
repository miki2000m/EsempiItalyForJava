package DataOra;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class MainDataOra {
    public static void main(String[] args) {

        //creo una variabile LocalDate con la data di oggi
        LocalDate dataNow = LocalDate.now();
        System.out.println("oggi è: "+dataNow);

        //creo una variabile LocalTime con l'orario di oggi
        LocalTime timeNow = LocalTime.now();
        System.out.println("sono le: "+timeNow);

        //Creo una variabile LocalDataTime con la data e l'ora in cui sono
        LocalDateTime dateTimeNow = LocalDateTime.now();
        System.out.println("\ntempo e data: "+dateTimeNow);


        //Formattazione ----------------------
        System.out.println("\nTempo e Data Formattati");

        DateTimeFormatter formatDay = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Oggi è: "+formatDay.format(dateTimeNow));
        DateTimeFormatter formatHour = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("Sono le: "+formatHour.format(dateTimeNow));


    }
}
