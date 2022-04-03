import java.util.*;

class Mood{
    private String color="yellow";
    private volatile static Mood m;
    private Mood(){};
    public static Mood getInstance()
    {
        if (m == null) {
            synchronized (Mood.class) {
                if (m == null) {
                    m = new Mood();
                }
            }
        }
        return m;
    }


    public void  getcolor(){
        System.out.println(m.color);
    }


}
public class sun {
    public static void main(String[] args) {
        Mood chinamoon=Mood.getInstance();
        chinamoon.getcolor();
        Mood piaoliangmoon=Mood.getInstance();
        piaoliangmoon.getcolor();

    }
}
