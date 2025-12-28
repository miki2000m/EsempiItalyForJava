package ModuliJPMS.app.com.main;

// L'import di com.service.GreetingService non è più necessario
// perché ora GreetingService si trova nello stesso package.

import ModuliJPMS.service.com.service.GreetingService;

public class MainApp {
    public static void main(String[] args) {
        // Creiamo e usiamo il servizio.
        GreetingService service = new GreetingService();
        String message = service.sayHello("JPMS (in un singolo modulo)");
        System.out.println(message);

        System.out.println("\nNOTA: La struttura delle cartelle è stata semplificata per permettere la compilazione.");
        System.out.println("Per la struttura corretta di un progetto multi-modulo, fare riferimento ai file 'module-info.java.txt'.");
    }
}
