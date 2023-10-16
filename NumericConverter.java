import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import java.util.Scanner;

public class NumericConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número Decimal: ");
        int numDecimal = scanner.nextInt();

        System.out.println("Número decimal = " + numDecimal);
        System.out.println("Número binário = " + decimalToBinary(numDecimal));
        System.out.println("Número hexadecimal = " + decimalToHexadecimal(numDecimal));
    }
    @Contract(pure = true)
    private static @NotNull String decimalToBinary(int numDecimal) {
        if (numDecimal == 0) {
            return "0";
        } else if (numDecimal == 1) {
            return "1";
        } else {
            int rest = numDecimal % 2;
            int quotient = numDecimal / 2;
            return decimalToBinary(quotient) + rest;
        }
    }
    private static @NotNull String decimalToHexadecimal(int numDecimal) {
        if (numDecimal == 0) {
            return "0";
        } else {
            int rest = numDecimal % 16;
            int quotient = numDecimal / 16;
            char digitHexadecimal = (rest < 10) ? (char) (rest + '0') : (char) (rest - 10 + 'A');
            if (quotient == 0) {
                return String.valueOf(digitHexadecimal);
            } else {
                return decimalToHexadecimal(quotient) + digitHexadecimal;
            }
        }
    }
}