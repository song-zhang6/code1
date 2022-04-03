import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Mood m=Mood.getInstance();
        Constructor<Mood> constructor=Mood.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        Mood mm=constructor.newInstance();
        System.out.println("singleton : " + m);
        System.out.println("singletonByReflect : " + mm);
    }
}


