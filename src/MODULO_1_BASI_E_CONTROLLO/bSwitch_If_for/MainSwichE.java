package MODULO_1_BASI_E_CONTROLLO.bSwitch_If_for;

public class MainSwichE {
    public static void main(String[] args) {
        String day="Monday";

        System.out.println("enhanced switches");
        //enhanced switches (Best)
        switch(day){
            case "Monday" -> System.out.println("Monday");
            case "Tuesday" -> System.out.println("Tuesday");
            case "Wednesday" -> System.out.println("Wednesday");
            case "Thursday" -> System.out.println("Thursday");
            case "Friday" -> System.out.println("Friday");
            case "Saturday" -> System.out.println("Saturday");
            case "Sunday" -> System.out.println("Sunday");
            default -> System.out.println("day didn't exist");
        }

        System.out.println();

        System.out.println("\nswitch case");
        //switch case (to match)
        switch (day){
            case "Monday" :{
                System.out.println("Monday");
                break;
            }
            case "Tuesday" :{
                System.out.println("Tuesday");
                break;
            }
            case "Wednesday" :{
                System.out.println("Wednesday");
                break;
            }
            case "Thursday" :{
                System.out.println("Thursday");
                break;
            }
            case "Friday" :{
                System.out.println("Friday");
                break;
            }
            case "Saturday" :{
                System.out.println("Saturday");
                break;
            }
            case "Sunday" : {
                System.out.println("Sunday");
                break;
            }
            default :{
                System.out.println("day didn't exist");
            }
        }
    }
}
