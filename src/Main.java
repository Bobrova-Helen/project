import java.util.Scanner;

public class Main {
    public static int applyOperation(Operation op, int param1, int param2){
        int result = 0;
        switch (op){
            case ADD -> result = param1 + param2;
            case SUB -> result = param1 - param2;
            case MUL -> result = param1 * param2;
            case DIV -> result = param1 / param2;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] strings = input.split(" ");

        if (strings.length != 3) {
            throw new RuntimeException("Количество аргументов строки не равно 3");
        }

        String num1 = strings[0];
        String num2 = strings[2];
        String operation = strings[1];

        Operation op;
        switch (operation){
            case "+" -> op = Operation.ADD;
            case "-" -> op = Operation.SUB;
            case "*" -> op = Operation.MUL;
            case "/" -> op = Operation.DIV;
            default -> throw new RuntimeException("Недопустимая операция");
        }

        boolean isFirstNumberRoman = RomanNumber.isRomanNumber(num1);
        boolean isSecondNumberRoman = RomanNumber.isRomanNumber(num2);

        if(isFirstNumberRoman && isSecondNumberRoman){
            RomanNumber romanNum1 = new RomanNumber(num1);
            RomanNumber romanNum2 = new RomanNumber(num2);

            int n1 = romanNum1.romanToArabic();
            int n2 = romanNum2.romanToArabic();

            int result = applyOperation(op, n1, n2);

            if(result < 1){
                throw new RuntimeException("Результат работы с римскими числами меньше единицы");
            }

            String roman = RomanNumber.arabicToRoman(result);
            System.out.println(roman);
        }
        else {
            int n1 = Integer.parseInt(num1);
            int n2 = Integer.parseInt(num2);

            if(n1 < 1 || n1 > 10 || n2 < 1 || n2 > 10){
                throw new RuntimeException("Условие нарушается");
            }

            int result = applyOperation(op, n1, n2);
            System.out.println(result);
        }
    }
}
