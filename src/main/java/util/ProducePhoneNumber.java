package util;
import java.util.Random;

public class ProducePhoneNumber {
    public static void producePhone(){
        String phonePrefix="171";
        String timestamp=System.currentTimeMillis()+"";
        System.out.println("timestamp:"+timestamp);
        Random random=new Random();
        int rad1=random.nextInt(10);
        int rad2=random.nextInt(10);
        String phoneEnds=rad1+""+timestamp.substring(7)+rad2+"";
        System.out.println("random:"+random);
        System.out.println("rad1:"+rad1+"");
        System.out.println("rad2:"+rad2+"");
        System.out.println("timestamp.substring:"+timestamp.substring(7));
        System.out.println(phonePrefix+phoneEnds);

    }

    public static void main(String[] args) {
        producePhone();
    }
}
