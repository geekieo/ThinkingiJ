import net.mindview.util.Print;

import java.math.BigDecimal;

/**
 * Created by Geekie on 2017/2/13 17:52.
 */
public class AccuracyLoss {
    public static void main(String[] args) {
        Double x=0.12345678901234567;
        Double x1=1.1;
        Double x2=0.1;
        Double y=x+x1+x2;
        System.out.println(y.toString());
        BigDecimal b=new BigDecimal(0.12345678901234567);
        BigDecimal b1=new BigDecimal(1.1) ;
        BigDecimal b2=new BigDecimal(0.1);
        BigDecimal z=b.add(b1).add(b2);
        System.out.print(z.toString());
    }
}
