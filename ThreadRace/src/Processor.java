import java.util.ArrayList;
import java.util.List;

public class Processor extends Thread{

        private List<Integer> numbers;
        private ArrayList<Integer> evenNumbers;
        private ArrayList<Integer> oddNumbers;

    public Processor(List<Integer> numbers, ArrayList<Integer> evenNumbers, ArrayList<Integer> oddNumbers) {
        this.numbers = numbers;
        this.evenNumbers = evenNumbers;
        this.oddNumbers = oddNumbers;
    }

    @Override
    public void run() {
        for (int number : numbers) {
            if (number % 2 == 0) {
                synchronized (evenNumbers) {
                    evenNumbers.add(number);
                }
            } else {
                synchronized (oddNumbers) {
                    oddNumbers.add(number);
                }
            }
        }
    }
}
