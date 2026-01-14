import java.util.Scanner;

/**
 * HUB CENTRALE DI STUDIO PER IL PROGETTO JAVAdallaBasi
 *
 * Questo è l'unico file che devi eseguire.
 * Da qui puoi lanciare tutti gli esempi pratici suddivisi per modulo di studio.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=============================================");
            System.out.println("   MENU PRINCIPALE - JAVAdallaBasi");
            System.out.println("=============================================");
            System.out.println("SCEGLI UN MODULO DI STUDIO:");
            System.out.println("1. Fondamenti del Linguaggio");
            System.out.println("2. Programmazione a Oggetti (OOP)");
            System.out.println("3. API Core di Java");
            System.out.println("4. Programmazione Funzionale e Moderna");
            System.out.println("5. I/O, Eccezioni e Localizzazione");
            System.out.println("6. Concorrenza e Argomenti Avanzati");
            System.out.println("\nSTRUMENTI ED EXTRA:");
            System.out.println("7. Avvia il Simulatore d'Esame");
            System.out.println("8. Laboratorio sui Tipi Primitivi");
            System.out.println("0. Esci dal programma");
            System.out.println("=============================================");
            System.out.print("Inserisci la tua scelta: ");

            String scelta = scanner.nextLine();

            switch (scelta) {
                case "1":
                    menuModulo1(scanner);
                    break;
                // Aggiungeremo gli altri casi man mano che riorganizziamo
                case "7":
                    // Esempio di come lanceremo gli altri main
                    // _strumenti_di_studio.SimulatoreEsame.MainSimulatoreEsame.main(new String[0]);
                    System.out.println("\n[INFO] Sposta prima il package del simulatore...");
                    break;
                case "8":
                    // _strumenti_di_studio.TipiPrimitivi.MainTipiPrimitivi.main(new String[0]);
                     System.out.println("\n[INFO] Sposta prima il package dei tipi primitivi...");
                    break;
                case "0":
                    System.out.println("Buono studio! A presto.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }

    private static void menuModulo1(Scanner scanner) {
        System.out.println("\n--- MODULO 1: FONDAMENTI ---");
        // Aggiungeremo qui le opzioni per lanciare gli esempi del Modulo 1
        System.out.println("Work in progress...");
    }
}
