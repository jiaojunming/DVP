package func;
import static func.DVP.*;

/**
 * Created by daojia on 2017-9-7.
 * polyval 多项式拟合
 * polyvalC 复数多项式拟合
 * polyvalList 多元多项式拟合
 * polyvalCList 复数多元多项式拟合
 * angle 复数atan2
 * fix 接近0的整数
 * fixList 对序列做fix
 * fra 分帧
 * zcro 过零率
 */
public class Matlab {
    public static double polyval(double[] p,double x){
        double re=0;
        for(int i=0;i<p.length;i++){
            re = re+p[i]*Math.pow(x,p.length-1-i);
        }
        return re;
    }
    public static Complex polyvalC(double[] p,Complex x){
        Complex re = new Complex(0,0);
        for(int i=0;i<p.length;i++){
            Complex a = x.power(p.length-1-i);
            re = re.plus(a.timesR(p[i]));
        }
        return re;
    }

    public static double[] polyvalList(double[] p,double[] x){
        double[] re = new double[x.length];
        for(int i=0;i<x.length;i++){
            re[i]=polyval(p, x[i]);
        }
        return re;
    }
    public static Complex[] polyvalCList(double[] p,Complex[] x){
        Complex[] re = new Complex[x.length];
        for(int i=0;i<x.length;i++){
            re[i]=polyvalC(p, x[i]);
        }
        return re;
    }
    public static double[] angle(Complex[] x){
        double[] re = new double[x.length];
        for(int i=0;i<x.length;i++){
            re[i]=Math.atan2(x[i].getImag(),x[i].getReal());
        }
        return re;
    }
    public static int fix(double x){
        int r = 0;
        if(x>=0){
            r = (int)Math.floor(x);
        }else{
            r = (int)Math.ceil(x);
        }
        return r;
    }
    public static int[] fixLisst(double[] x){
        int[] r = new int[x.length];
        for(int i=0;i<x.length;i++){
            r[i]=fix(x[i]);
        }
        return r;
    }
    public static double[][] fra(int len,int inc,double[] z){
        int fh =fix((z.length-len)*1.0/inc+1);
        System.out.println(fh);
        double[][] f = zerosM(fh,len);
        int i=0;
        int n=0;
        while(i<fh){
            int j=0;
            while(j<len){
                f[i][j]=z[n];
                j=j+1;
                n=n+1;
            }
            n = n-len+inc;
            i=i+1;
        }
        return f;
    }
    public static double[] zcro(double[][] x){
        double[] f = zeros(x.length);
        for(int i=0;i<x.length;i++){
            for(int j=0;j<x[0].length-1;j++){
                if(x[i][j]*x[i][j+1]<0){
                    f[i]=f[i]+1;
                }
            }
        }
        return f;
    }
    public static void main(String[] args){
        //Complex[] a = polyvalCList(new double[]{2.0, 1.0}, new Complex[]{new Complex(1, 1),new Complex(2,3)});
        //System.out.println(a[0].toString()+" "+a[1].toString());
        System.out.println(fix(0));
    }
}
