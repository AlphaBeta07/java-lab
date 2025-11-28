// In directory mymath/Trig.java
package mymath;
public class Trig {
    private double angleDeg;
    public Trig(double angleDeg){ this.angleDeg = angleDeg; }
    private double toRad(){ return Math.toRadians(angleDeg); }
    public double sin(){ return Math.sin(toRad()); }
    public double cos(){ return Math.cos(toRad()); }
    public double tan(){ return Math.tan(toRad()); }
    public double sec(){ return 1.0 / cos(); }
    public double cosec(){ return 1.0 / sin(); }
    public double cot(){ return 1.0 / tan(); }
}

// mymath/Arithmetic.java
package mymath;
public class Arithmetic {
    public float add(float a,float b){ return a+b; }
    public float sub(float a,float b){ return a-b; }
    public float mul(float a,float b){ return a*b; }
    public float div(float a,float b){ return a/b; }
}

// mymath/Stat.java
package mymath;
public class Stat {
    public int min(int[] a){ int m=a[0]; for(int v:a) if(v<m) m=v; return m; }
    public int max(int[] a){ int m=a[0]; for(int v:a) if(v>m) m=v; return m; }
    public int count(int[] a){ return a.length; }
    public int sum(int[] a){ int s=0; for(int v:a) s+=v; return s; }
    public double avg(int[] a){ return sum(a)/(double)count(a); }
}

// PackDemo.java (outside mymath package)
import mymath.Trig;
import mymath.Arithmetic;
import mymath.Stat;

public class PackDemo {
    public static void main(String[] args) {
        Trig t = new Trig(30);
        System.out.println("sin(30) = " + t.sin());
        Arithmetic ar = new Arithmetic();
        System.out.println("add = " + ar.add(2.5f, 3.0f));
        Stat s = new Stat();
        int[] arr = {1,2,3,4,5};
        System.out.println("avg = " + s.avg(arr));
    }
}
