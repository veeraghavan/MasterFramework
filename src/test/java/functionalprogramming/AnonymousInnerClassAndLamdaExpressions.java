package functionalprogramming;

public class AnonymousInnerClassAndLamdaExpressions {

    public static void main(String[] args) {
        ILambda obj = new ILamdaImpl();
        obj.print();
        obj.print1();
        System.out.println("****** End of normal implementation ******");
        System.out.println();

        ILambda obj1 = new ILambda() {
            @Override
            public void print() {
                System.out.println("I am inside anonymous inner class");
            }

            @Override
            public void print1() {
                System.out.println("I am inside anonymous inner class despite being declared in interface");
            }
        };
        obj1.print();
        obj1.print1();
        System.out.println("****** End of anonymous inner class ******");
        System.out.println();

        ILambda obj2 = () -> System.out.println("I am a lamda expression");
        obj2.print();
        obj2.print1();
        System.out.println("****** End of lamda expression ******");
        System.out.println();
    }
}
