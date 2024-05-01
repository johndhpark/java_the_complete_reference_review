// Demonstrate instance of operator
class A {
    int i, j;
}

class B {
    int i, j;
}

class C extends A {
    int k;
}

class D extends A {
    int k;
}

class InstanceOf {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        if (a instanceof A) {
            System.out.println("a is an instance of A");
        }

        if (b instanceof B) {
            System.out.println("b is an instance of B");
        }

        if (c instanceof C) {
            System.out.println("c is an cast to A");
        }

        if (a instanceof C) {
            System.out.println();
        }
    }
}