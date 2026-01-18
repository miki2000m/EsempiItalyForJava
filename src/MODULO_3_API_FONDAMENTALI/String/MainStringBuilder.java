package MODULO_3_API_FONDAMENTALI.String;

public class MainStringBuilder {
    public static void main(String[] args) {
        // Esempi pratici e commentati delle principali API di StringBuilder

        // Costruttore vuoto -> capacity di default (16)
        StringBuilder sb = new StringBuilder();
        System.out.println("\nStringBuilder sb = new StringBuilder();");
        System.out.println("sb.capacity() -> " + sb.capacity());

        // append -> aggiunge contenuti (metodo muta l'oggetto)
        sb.append("Mario");
        System.out.println("\nsb.append(\"Mario\") -> " + sb.toString());

        // chaining di append
        sb.append(' ').append("Rossi").append(", ").append(30);
        System.out.println("sb.append(...).append(...) chaining -> " + sb.toString());

        // length e charAt
        System.out.println("\nsb.length() -> " + sb.length());
        System.out.println("sb.charAt(0) -> " + sb.charAt(0));

        // setCharAt -> modifica un carattere in posizione index
        sb.setCharAt(0, 'm');
        System.out.println("\nsb.setCharAt(0,'m') -> " + sb.toString());

        // insert -> inserisce una stringa in una posizione
        sb.insert(5, " INS");
        System.out.println("\nsb.insert(5, \" INS\") -> " + sb.toString());

        // replace -> sostituisce il contenuto tra start (incluso) ed end (escluso)
        sb.replace(5, 9, "X");
        System.out.println("\nsb.replace(5,9, \"X\") -> " + sb.toString());

        // delete -> rimuove il contenuto tra start (incluso) ed end (escluso)
        sb.delete(5, 6);
        System.out.println("\nsb.delete(5,6) -> " + sb.toString());

        // reverse -> inverte i caratteri
        sb.reverse();
        System.out.println("\nsb.reverse() -> " + sb.toString());
        sb.reverse(); // torno all'ordine originale
        System.out.println("sb.reverse() di nuovo -> " + sb.toString());

        // toString -> ottieni una String immutabile dal StringBuilder
        String result = sb.toString();
        System.out.println("\nConvertito in String con toString(): " + result);

        // capacity e ensureCapacity
        System.out.println("\nsb.capacity() -> " + sb.capacity());
        sb.ensureCapacity(100);
        System.out.println("dopo sb.ensureCapacity(100) -> capacity = " + sb.capacity());

        // dimostrazione mutabilità: String vs StringBuilder
        String s = "Hello";
        StringBuilder sb2 = new StringBuilder(s);
        sb2.append(" World");
        System.out.println("\nConfronto mutabilità:");
        System.out.println("String originale (immutabile): " + s);
        System.out.println("StringBuilder dopo append (mutabile): " + sb2.toString());

        // nota su thread-safety (non dimostrata qui): StringBuilder NON è thread-safe,
        // StringBuffer è la controparte sincronizzata se servisse thread-safety.

        // esempio breve di setCharAt e accesso a char
        System.out.println("\nEsempio setCharAt e charAt:");
        System.out.println("sb2 prima -> " + sb2.toString());
        sb2.setCharAt(0, 'h');
        System.out.println("sb2 dopo setCharAt(0,'h') -> " + sb2.toString());
        System.out.println("sb2.charAt(0) -> " + sb2.charAt(0));

        // conclusione breve
        System.out.println("\nFine esempi StringBuilder. Per dettagli vedi Riepilogo_StringBuilder.txt");
    }
}
