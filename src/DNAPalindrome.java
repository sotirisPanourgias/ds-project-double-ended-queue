import java.util.Scanner;



public class DNAPalindrome {
    
    public static StringDoubleEndedQueueImpl CreateQ(String DNAseq){
       
        StringDoubleEndedQueueImpl s = new StringDoubleEndedQueueImpl();
        char[] charArray = DNAseq.toCharArray();
                                                                // βαζω την ακολουθια μεσα στην ουρα
        for (int i = 0; i < charArray.length; i++) {
             s.addLast(String.valueOf(charArray[i])); 
        }
        
        return s;
    }
    
        
    
    
    public static boolean isValidDNASequence(String sequence) {
        // Ελέγχουμε αν το String είναι null.
    if (sequence == null) {
        return false;
    }

    // Ελέγχουμε αν το String είναι κενό.
    if (sequence.isEmpty()) {
        return true;
    }
       
    
        // Ελέγχουμε κάθε χαρακτήρα του String για εγκυρότητα.
        for (char nucleotide : sequence.toCharArray()) {
            if (!isValidNucleotide(nucleotide)) {
                return false;
            }
        }
    
        return true;
    }
    
    private static boolean isValidNucleotide(char nucleotide) {
        // Ελέγχουμε αν ο χαρακτήρας είναι ένα από τα έγκυρα A, T, C, G (πεζά γράμματα).
        return (nucleotide == 'A' || nucleotide == 'T' || nucleotide == 'C' || nucleotide == 'G');
    }
    public static boolean isWatson( StringDoubleEndedQueueImpl q1){
        while(!q1.isEmpty()){
            
            if((q1.getFirst().equals("A") && q1.getLast().equals("T")) ||   // ελεγχουμε αν το πρωτο και το τελευταιο στοιχειο
            (q1.getFirst().equals("T") && q1.getLast().equals("A")) ||      // δεν παραβιαζει τους κανονες ωστε η ακολουθια
            (q1.getFirst().equals("C") && q1.getLast().equals("G")) ||      //  να ειναι μορφης  Watson και μετα τα αφαιρω
            (q1.getFirst().equals("G") &&q1.getLast().equals("C"))){        //  return true αν ειναι αλλιως return false
                q1.removeFirst();
                q1.removeLast();
            }else{
                return false;
                
            }
        }
       return true;
        

    }

   public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Give me a Dna sequence");
            String DNAseq=in.nextLine();                    // διαβαζω την ακολουθια dna
            while(!isValidDNASequence(DNAseq)){
                System.out.println("Give me a Dna sequence");
                DNAseq=in.nextLine();

            }
            
            
            StringDoubleEndedQueueImpl q1=CreateQ(DNAseq);
            if (isWatson(q1)) {                     //ελεγχω αν ειναι και εμφανιζω καταλληλο μηνυμα
                System.out.println(DNAseq+" is watson");
                
            }else{
                System.out.println(DNAseq+" is not watson");
            }
        }

        


    }
}