import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DegreeConverterApplication {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println();
        System.out.println("Enter your command according to the format: -(Initial unit of measure) numbers -(Final unit of measure):");

        String line = reader.readLine();
        degreeConverter(line);
    }

    private static void degreeConverter(String line) throws IOException {
        while (!line.equals("-stop")) {
            String[] parts = line.split(" ");

            if (parts.length < 2 || checkParameters(parts.length - 1, parts)) {
                System.out.println("Error: Insufficient parameters");
            } else {
                ArrayList<Double> numbers = new ArrayList<>();
                int count = 1;

                while (checkParameters(count, parts)) {
                    numbers.add(Double.valueOf(parts[count++]));
                }

                ArrayList<String> parametersForOutput = new ArrayList<>();
                while (count < parts.length) {
                    parametersForOutput.add(parts[count++]);
                }

                ArrayList<String> results = new ArrayList<>();

                if (numbers.isEmpty()) {
                    System.out.println("Error: Insufficient parameters");
                } else {
                    System.out.println();
                    switch (parts[0].toLowerCase()) {
                        case "-f":
                            results = convertFromFahrenheit(numbers, parametersForOutput);
                            printResult(results);
                            break;
                        case "-c":
                            results = convertFromCelsius(numbers, parametersForOutput);
                            printResult(results);
                            break;
                        case "-k":
                            results = convertFromKelvin(numbers, parametersForOutput);
                            printResult(results);
                            break;
                        default:
                            System.out.println("Error: Incorrect parameter");
                    }
                }
            }
            System.out.println("Enter new command or -stop");
            line = reader.readLine();
        }
    }

    private static void printResult(ArrayList<String> results) {
        for (String line : results) {
            System.out.println(line.trim());
        }
        System.out.println();
    }

    public static boolean checkParameters(int i, String[] parts) {
        return !parts[i].equalsIgnoreCase("-k") && !parts[i].equalsIgnoreCase("-f") && !parts[i].equalsIgnoreCase("-c");
    }

    public static ArrayList<String> convertFromKelvin(ArrayList<Double> numbers, ArrayList<String> lastParameter) {
        ArrayList<String> result = new ArrayList<>();
        for (String parameter : lastParameter) {
            switch (parameter.toLowerCase()) {
                case "-c":
                    for (double degrees : numbers) {
                        result.add("Result: " + String.format("%.2f", degrees - 273.15) + "°C");
                    }
                    break;
                case "-f":
                    for (double degrees : numbers) {
                        result.add("Result: " + String.format("%.2f", degrees * 1.8 - 459.67) + "°F");
                    }
                    break;
                case "-k":
                    for (double degrees : numbers) {
                        result.add("I don't understand why you need this, but the result is: " + degrees + "°K");
                    }
                    break;
            }
        }
        return result;
    }

    public static ArrayList<String> convertFromCelsius(ArrayList<Double> numbers, ArrayList<String> lastParameter) {
        ArrayList<String> result = new ArrayList<>();
        for (String parameter : lastParameter) {
            switch (parameter.toLowerCase()) {
                case "-k":
                    for (double degrees : numbers) {
                        result.add("Result: " + String.format("%.2f", degrees + 273.15) + "°K");
                    }
                    break;
                case "-f":
                    for (double degrees : numbers) {
                        result.add("Result: " + String.format("%.2f", degrees * 1.8 + 32) + "°F");
                    }
                    break;
                case "-c":
                    for (double degrees : numbers) {
                        result.add("I don't understand why you need this, but the result is: " + degrees + "°C");
                    }
                    break;
            }
        }
        return result;
    }

    public static ArrayList<String> convertFromFahrenheit(ArrayList<Double> numbers, ArrayList<String> lastParameter) {
        ArrayList<String> result = new ArrayList<>();
        for (String parameter : lastParameter) {
            switch (parameter.toLowerCase()) {
                case "-c":
                    for (double degrees : numbers) {
                        result.add("Result: " + String.format("%.2f", (degrees - 32) / 1.8) + "°C");
                    }
                    break;
                case "-k":
                    for (double degrees : numbers) {
                        result.add("Result: " + String.format("%.2f", (degrees + 459.67) / 1.8) + "°K");
                    }
                    break;
                case "-f":
                    for (Double degrees : numbers) {
                        result.add("I don't understand why you need this, but the result is: " + degrees + "°F");
                    }
                    break;
            }
        }
        return result;
    }
}
