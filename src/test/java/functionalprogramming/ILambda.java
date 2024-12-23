package functionalprogramming;

public interface ILambda {

    public abstract void print();

    public default void print1() {
        System.out.println("I am inside interface");
    }
}
