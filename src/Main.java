import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        Numbers n = new Numbers();
        File f = new File("da.txt");
        FileWriter ft = new FileWriter("da.txt");
        for (int i = 10; i > 1; i--) {
            String s = n.Counter(i);
            System.out.println(s);
            ft.write(s);
            ft.append('\n');
            ft.flush();
        }
        System.out.println("Выполнил: Приловский Антон Сергеевич");
    }
}

class Numbers {
    int N;
    BigInteger firstMnojitel;
    BigInteger secondMnojitel;
    BigInteger chislitel;
    BigInteger znamenatel;

    public static BigInteger getFactorial(int f) {
        if (f <= 1) {
            return BigInteger.valueOf(1);
        }
        else {
            return BigInteger.valueOf(f).multiply(getFactorial(f - 1));
        }
    }
    String Counter(int N) {
        firstMnojitel = (BigInteger.valueOf((long)Math.pow(2,10)));
        firstMnojitel = firstMnojitel.multiply(BigInteger.valueOf(24));
        firstMnojitel = firstMnojitel.multiply(getFactorial(12));
        firstMnojitel = firstMnojitel.pow(N%2);
        secondMnojitel = getFactorial(24);
        secondMnojitel = secondMnojitel.pow((int)(Math.floor((Math.pow(N, 2)-2*N)*(0.25))));
        secondMnojitel = secondMnojitel.multiply(BigInteger.valueOf((long) Math.pow(3, 6)));
        secondMnojitel = secondMnojitel.multiply(getFactorial(7));
        chislitel = firstMnojitel.multiply(secondMnojitel);
        znamenatel = getFactorial(4);
        znamenatel = znamenatel.pow((int)(6*Math.floor((Math.pow((N-2), 2)/4))));

        String s = new String();
        s = "Для кубика размерности " + N + " x "+ N + " x " + N + " число комбинаций = "
                + chislitel.divide(znamenatel).toString();
//        System.out.printf("Для кубика размерности %d x %d x %d число комбинаций = %d\n",
//                N, N, N, chislitel.divide(znamenatel));
        return s;

    }
}
