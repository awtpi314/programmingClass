import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("3.0");
        BigDecimal b = new BigDecimal("2.0");
        System.out.println(a.divide(b, RoundingMode.HALF_EVEN).toString());
    }
}
