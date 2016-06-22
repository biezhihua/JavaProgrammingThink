package 类型信息_14;

/**
 * Created by biezhihua on 16-6-22.
 */
public class SimpleProxyDemo {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("biezhihua");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }

}

class RealObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("RealObject.doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("RealObject.somethingElse");
    }
}

class SimpleProxy implements Interface {

    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy.doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy.somethingElse");
        proxied.somethingElse(arg);
    }
}
