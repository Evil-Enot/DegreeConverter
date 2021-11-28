import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DegreeConverterApplication {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Enter your command according to the format: -(Initial unit of measure) numbers -(Final unit of measure):");

        String line = reader.readLine();
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
            System.out.println();
            System.out.println("Enter new command or -stop");
            line = reader.readLine();
        }
    }

    private static boolean checkParameters(int i, String[] parts) {
        return !parts[i].toLowerCase().equals("-k") && !parts[i].toLowerCase().equals("-f") && !parts[i].toLowerCase().equals("-c");
    }

    private static void convertFromKelvin(ArrayList<Double> numbers, String lastParameter) {
        switch (lastParameter.toLowerCase()) {
            case "-c":
                for (double degrees : numbers) {
                    String result = String.format("%.2f", degrees - 273.15);
                    System.out.println("Your input: " + degrees + "°K");
                    System.out.println("Result: " + result + "°C");
                }
                break;
            case "-f":
                for (double degrees : numbers) {
                    String result = String.format("%.2f", degrees * 1.8 - 459.67);
                    System.out.println("Your input: " + degrees + "°K");
                    System.out.println("Result: " + result + "°F");
                }
                break;
            case "-k":
                for (double degrees : numbers) {
                    System.out.println("Your input: " + degrees + "°K");
                    System.out.println("I don't understand why you need this, but the result is: " + degrees + "°K");
                }
                break;
        }
    }

    private static void convertFromCelsius(ArrayList<Double> numbers, String lastParameter) {
        switch (lastParameter.toLowerCase()) {
            case "-k":
                for (double degrees : numbers) {
                    String result = String.format("%.2f", degrees + 273.15);
                    System.out.println("Your input: " + degrees + "°C");
                    System.out.println("Result: " + result + "°K");
                }
                break;
            case "-f":
                for (double degrees : numbers) {
                    String result = String.format("%.2f", degrees * 1.8 + 32);
                    System.out.println("Your input: " + degrees + "°C");
                    System.out.println("Result: " + result + "°F");
                }
                break;
            case "-c":
                for (double degrees : numbers) {
                    System.out.println("Your input: " + degrees + "°C");
                    System.out.println("I don't understand why you need this, but the result is: " + degrees + "°C");
                }
                break;
        }
    }

    private static void convertFromFahrenheit(ArrayList<Double> numbers, String lastParameter) {
        switch (lastParameter.toLowerCase()) {
            case "-c":
                for (double degrees : numbers) {
                    String result = String.format("%.2f", (degrees - 32) / 1.8);
                    System.out.println("Your input: " + degrees + "°F");
                    System.out.println("Result: " + result + "°C");
                }
                break;
            case "-k":
                for (double degrees : numbers) {
                    String result = String.format("%.2f", (degrees + 459.67) / 1.8);
                    System.out.println("Your input: " + degrees + "°F");
                    System.out.println("Result: " + result + "°K");
                }
                break;
            case "-f":
                for (Double degrees : numbers) {
                    System.out.println("Your input: " + degrees + "°F");
                    System.out.println("I don't understand why you need this, but the result is: " + degrees + "°F");
                }
                break;
        }
    }
}
