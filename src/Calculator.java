import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] source = userInput.split("");
        char operator = 0;
        int indexOfOperator = 0;
        for (int i = 0; i < source.length; i++) {
            switch (source[i]) {
                case "+":
                    operator = '+';
                    indexOfOperator = i;
                    break;
                case "-":
                    operator = '-';
                    indexOfOperator = i;
                    break;
                case "*":
                    operator = '*';
                    indexOfOperator = i;
                    break;
                case "/":
                    operator = '/';
                    indexOfOperator = i;
                    break;
            }
        }

        String num1 = getNumber1(source, indexOfOperator);
        String num2 = getNumber2(source, indexOfOperator);
        int result;

        if (source.length == 3 && areLatinNumbers(userInput)) {
            int a = Integer.parseInt(source[0]);
            int b = Integer.parseInt(source[2]);
            result = calculated(a, operator, b);
            System.out.println(result);
        } else if (areRoman(num1) && areRoman(num2)) {
            int romanNum1 = romanToNumber(num1);
            int romanNum2 = romanToNumber(num2);
            result = calculated(romanNum1, operator, romanNum2);
            String romanResult = numberToRom(result);
            System.out.println(romanResult);
        }
    }

    private static String numberToRom(int number) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};
        for (int i = 0; i < roman.length - 1; i++) {
            if (number == i) {
                return roman[i];
            }
        }
        return "null";//исключение
    }

    private static int calculated(int a, char operator, int b) {
        int result = 0;
        switch (operator) {
            case '+': {
                result = a + b;
                break;
            }
            case '-': {
                result = a - b;
                break;
            }
            case '*': {
                result = a * b;
                break;
            }
            case '/': {
                result = a / b;
                break;
            }
            default: {
                //исключение
            }
        }
        return result;
    }

    private static int romanToNumber(final String num1) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};
        for (int i = 0; i < roman.length - 1; i++) {
            if (num1.equals(roman[i])) {
                return i;
            }
        }
        return 0;//исключение
    }

    private static boolean areRoman(String num) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};
        for (String s : roman) {
            if (num.equals(s)) {
                return true;
            }
        }
        return false;
    }

    private static boolean areLatinNumbers(String array) {
        char a = array.charAt(0);
        char b = array.charAt(2);
        return '0' < a && a <= '9' && '0' < b && b <= '9';
    }

    private static String getNumber2(String[] array, int index) {
        StringBuilder num2 = new StringBuilder();
        for (int i = index + 1; i < array.length; i++) {
            num2.append(array[i]);
        }
        return num2.toString();
    }

    private static String getNumber1(String[] array, int index) {
        StringBuilder num1 = new StringBuilder();
        for (int i = 0; i < index; i++) {
            num1.append(array[i]);
        }
        return num1.toString();
    }
}