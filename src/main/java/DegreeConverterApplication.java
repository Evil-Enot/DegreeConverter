import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DegreeConverterApplication {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your command according to the format: -(Initial unit of measure) numbers -(Final unit of measure):");

        String line = reader.readLine();
        while (!line.equals("-stop")) {
            String[] parts = line.split(" ");

            if (parts.length < 2 || checkParameters(parts.length - 1, parts)) {
                System.out.println("Error: Insufficient parameters");
            } else {
                ArrayList<Integer> numbers = new ArrayList<>();
                int count = 1;

                while (checkParameters(count, parts)) {
                    numbers.add(Integer.valueOf(parts[count++]));
                }

                if (numbers.isEmpty()) {
                    System.out.println("Error: Insufficient parameters");
                } else {
                    switch (parts[0].toLowerCase()) {
                        case "-f":
                            convertFromFahrenheit(numbers, parts[count]);
                            break;
                        case "-c":
                            convertFromCelsius(numbers, parts[count]);
                            break;
                        case "-k":
                            convertFromKelvin(numbers, parts[count]);
                            break;
                        default:
                            System.out.println("Error: Incorrect parameter");
                    }
                }
            }
            line = reader.readLine();
        }
    }

    private static boolean checkParameters(int i, String[] parts) {
        return !parts[i].toLowerCase().equals("-k") && !parts[i].toLowerCase().equals("-f") && !parts[i].toLowerCase().equals("-c");
    }

    private static void convertFromKelvin(ArrayList<Integer> numbers, String lastParameter) {

    }

    private static void convertFromCelsius(ArrayList<Integer> numbers, String lastParameter) {

    }

    private static void convertFromFahrenheit(ArrayList<Integer> numbers, String lastParameter) {

    }
}
