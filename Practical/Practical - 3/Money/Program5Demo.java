import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Program5Demo {

    public static void main(String[] args) {

        BigDecimal a = new BigDecimal("2.0");

        BigDecimal b = new BigDecimal("2.00");

        System.out.println("equals: " + a.equals(b));

        System.out.println(
            "compareTo==0: " + (a.compareTo(b) == 0)
        );

        Set<BigDecimal> hash =
            new HashSet<>(List.of(a, b));

        Set<BigDecimal> tree =
            new TreeSet<>(List.of(a, b));

        System.out.println("HashSet size: " + hash.size());

        System.out.println("TreeSet size: " + tree.size());

        System.out.println(new BigDecimal(0.1));

        System.out.println(BigDecimal.valueOf(0.1));
    }
}
