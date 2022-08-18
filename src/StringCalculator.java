import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private final NombreParser numberParser = new NombreParser();

    int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        return adding(numbers);
    }

    private int adding(String numbers) {
        List<Integer> numbersSplit = numberParser.fromStringToNumber(numbers);
        checkNombresNegatifs(numbersSplit);
        return numbersSplit.stream().filter(n -> n <= 1000).reduce(0, (a, b) -> a + b);
    }

    private void checkNombresNegatifs(List<Integer> numbersSplit) {
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        for (Integer integer : numbersSplit) {
            if (integer < 0) negativeNumbers.add(integer);
        }
        if (negativeNumbers.size() > 0) throw new NegativesNumbersException("erreur nombre négatifs: " +
                ConcatNombres.concatNb(negativeNumbers));

    }

    class NegativesNumbersException extends IllegalArgumentException {
        NegativesNumbersException(String message) {
            super(message);
        }
    }

}