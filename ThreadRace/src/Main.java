import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i =1 ; i <= 10000; i++) {
            numbers.add(i);
        }

        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        ArrayList<Processor> threads = new ArrayList<>();

        for (int i = 0; i<4; i++) {
            List<Integer> subList = numbers.subList(i*2500, (i+1)*2500);
            Processor thread = new Processor(subList,evenNumbers,oddNumbers);
            threads.add(thread);
            thread.start();
        }

        for (Processor thread : threads) {
            thread.join();
        }

        System.out.println("Even numbers: " + evenNumbers.size());
        System.out.println("Odd numbers: " + oddNumbers.size());


    }
}