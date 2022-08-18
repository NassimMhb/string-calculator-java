import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NombreParser {

    private String delimiter;

    public NombreParser() {
        delimiter = "[,\n]";
    }

    private String[] splitDelimitation(String numbers) {
        if (personnalisationDelimiteur(numbers)) {
            return numbers
                    .substring(numbers.indexOf("\n") + 1)
                    .split(extractionDelimiteur(numbers));
        }
        return numbers.split(delimiter);
    }

    private boolean personnalisationDelimiteur(String numbers) {
        return numbers.startsWith("/");
    }

    List<Integer> fromStringToNumber(String numbers) {
        return Arrays
                .stream(splitDelimitation(numbers))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String extractionDelimiteur(String input) {
        String escapedInput;
        int START_OF_SUBSTRING = input.indexOf("\n");

        escapedInput = input
                .substring(0, START_OF_SUBSTRING)
                .replace("//", "")
                .replace("[", "")
                .replace("]", "");
        return "\\Q" + escapedInput + "\\E";
    }
}