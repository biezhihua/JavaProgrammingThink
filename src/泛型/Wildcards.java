package 泛型;


/**
 * Created by biezhihua on 16-6-18.
 */
public class Wildcards {

    //Raw argument

    static void rawArgs(Holder holder, Object arg) {
//        holder.setValue(arg); // Warning

//        holder.setValue(new Wildcards());

//        Can't do this : don't have any 'T'
//        T t = holder.getValue();

        Object object = holder.getValue();

    }

    static void unboundedArg(Holder<?> holder, Object arg) {
//        holder.setValue(arg); // Error

//        holder.setValue(new Wildcaj = ords());

//        T t = holder.getValue();

        Object obj = holder.getValue();

    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.getValue();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.setValue(arg);
        T t = holder.getValue();
        return t;
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
//        holder.setValue(arg);
        T t = holder.getValue();
        return t;
    }

    static <T> void wildSuperType(Holder<? super T> holder, T arg) {
        holder.setValue(arg);
//        T t =holder.getValue();
        Object object = holder.getValue();

    }

    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        raw = new Holder();

        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<Long>();

        Holder<? extends Long> bounded = new Holder<Long>();

        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        Object r1 = exact1(raw);

        Long r2 = exact1(qualified);

        Object o = exact1(unbounded);

        Long aLong = exact1(bounded);

        Long aLong1 = exact2(raw, lng);

        Long aLong2 = exact2(qualified, lng);

//        exact2(unbounded, lng);

//        exact2(bounded, lng);

        Long aLong3 = wildSubtype(raw, lng);

        Long aLong4 = wildSubtype(qualified, lng);

        Object o1 = wildSubtype(unbounded, lng);

        Long aLong5 = wildSubtype(bounded, lng);

        wildSuperType(raw, lng);

        wildSuperType(qualified, lng);

//        wildSuperType(unbounded, lng);

//        wildSuperType(bounded, lng);

    }



}
