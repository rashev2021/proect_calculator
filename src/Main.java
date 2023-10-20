import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String result;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выраждение:");
        String input = scanner.nextLine();

        result = calculate(input);
        System.out.println("Результат: " + result);
    }

    public static String calculate(String input){

        String symbol;
        String[] parts;

        if (input.contains("+")) {
            parts = input.split("\\+");
            symbol = "+";

        } else if (input.contains("-")) {
            parts = input.split("-");
            symbol = "-";

        } else if (input.contains("*")) {
            parts = input.split("\\*");
            symbol = "*";

        } else if (input.contains("\\")) {
            parts = input.split("\\\\");
            symbol = "/";

        } else {
            return "Введен неверный оператор";
        }

        int plusCount = 1;

        for (char ch : input.toCharArray()) {
            if (ch == symbol.charAt(0)) {
                plusCount++;
            }
        }

        if (plusCount > 2) {
            System.out.println("Неверный пример");
        } else {
            int result = 0;
            String num1String = parts[0].trim();
            String num2String = parts[1].trim();
            int num1 = Integer.parseInt(num1String);
            int num2 = Integer.parseInt(num2String);

            if (num1 > 10 || num2 > 10) {
                return "Числа должны быть меньше или равны 10";
            } else {
                switch (symbol){
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if(num2 == 0) {
                            return "Нельзя делить на 0";
                        } else {
                            result = num1 / num2;
                        }
                        break;
                    default:
                        break;
                }
                return String.valueOf(result);
            }
        }
        return "Лишний " + symbol + " в примере";
    }
}