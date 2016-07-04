package 容器的深入研究_17._11_实用方法;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * Created by biezhihua on 16-7-4.
 */
public class References {

    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<>();


    public static void checkQueue() {
        Reference<? extends VeryBig> inq = rq.poll();
        if (inq != null) {
            System.out.println("IN queue :" + inq.get());
        }
    }

    public static void main(String[] args) {

    }

}

class VeryBig {

    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;

    public VeryBig(String ident) {
        this.ident = ident;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("VeryBig.finalize " + ident);
    }
}

