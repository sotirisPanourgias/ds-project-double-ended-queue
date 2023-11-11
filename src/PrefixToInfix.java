import java.util.Scanner;

public class PrefixToInfix {
    public static StringDoubleEndedQueueImpl convPrefixToInfix(String str){  // συναρτηση για να κανουμε την μετατροπη
        StringDoubleEndedQueueImpl s = new StringDoubleEndedQueueImpl();
        char[] charArray = str.toCharArray();
        String[] a = new String[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            a[i] = String.valueOf(charArray[i]);
        }

        if (a[0].equals("+") || a[0].equals("-") || a[0].equals("*") || a[0].equals("/")) { //ελεγχος αν αρχιζει με συμβολο
            System.out.println("Μη έγκυρη παράσταση.");
            return null;
        }
        
        for (int i = 0; i < a.length; i++) {
            if (a[i].matches("\\d")) { // ελεγχος αν ο χαρακτηρας ειναι ψηφιο
                s.addLast(a[i]);
            } else if (a[i].equals("+") || a[i].equals("-") || a[i].equals("*") || a[i].equals("/")) { //ελεγχος αν ο χαρακτηρας ειναι συμβολο
                String operand1 = s.removeLast();           //αν ειναι συμβολο κανουμε remove στα τελευταια 2 στοιχεια που ειναι στην ουρα
                String operand2 = s.removeLast();
                String result = "(" + operand2 + a[i] + operand1 + ")";     // φτιαχνω την σωστη μορφη
                s.addLast(result);                              //και το προσθετω στην ουρα
            }
        }
        if (s.size() == 1) {
            return s;
        } else {
            System.out.println("Μη έγκυρη παράσταση.");
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Εισαγάγετε την αριθμητική παράσταση σε προθεματική μορφή:");
        String pfe = sc.nextLine();                             // διαβαζω την αριθμιτικη παρασταση
        sc.close();
        StringDoubleEndedQueueImpl ife = convPrefixToInfix(pfe);   //μετατρεπω την παρασταση
        if (ife != null) {              // ελεγχω αν αυτο που διαβασα ειναι null
            System.out.println("infix μορφη : ");
            ife.printQueue(System.out);
        } else {
            System.out.println("Μη έγκυρη παράσταση.");
        }
    }
}
