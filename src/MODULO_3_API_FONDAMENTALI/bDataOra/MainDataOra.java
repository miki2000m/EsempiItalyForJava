package MODULO_3_API_FONDAMENTALI.bDataOra;

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


        //Come trovare la differenza da una data/ora rispetto ad adesso
        int anno=2000;
        int mese=12;
        int giorno=12;

        int annoNow=dataNow.getYear();
        int meseNow=dataNow.getMonthValue();
        int giornoNow=dataNow.getDayOfMonth();

        LocalDate before=LocalDate.of(anno,mese,giorno);
        LocalDate nowDate=LocalDate.of(annoNow,meseNow,giornoNow);

        //fa la differenza tra le due date quindi tra la data di adesso e quella specificata con before
        //Questo metodo di Period permette di avere come proprietà 2 LocalDate
        //Period.between(LocalDate start,LocalDate end)
        Period period=Period.between(before,nowDate);
        System.out.printf("\n\nCi sono %d anni di differenza tra il %d e il %d",period.getYears(),before.getYear(),nowDate.getYear());
    }
}
