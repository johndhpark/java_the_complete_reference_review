// Implements a "growable" stack
class DynStack implements IntStack {
    private int[] stck;
    private int tos;

    // allocate and initialize stack
    DynStack(int size) {
        stck = new int[size];
        tos = -1;
    }

    // Push an item onto the stack
    public void push(int item) {
        // if stack is full, allocate a larger stack
        if (tos == stck.length - 1) {
            int[] tmp = new int[stck.length * 2]; // double size
            for (int i = 0; i < stck.length; i++) {
                tmp[i] = stck[i];
            }
            stck = tmp;
        }

        stck[++tos] = item;
    }

    // Pop an item from the stack
    public int pop() {
        if (tos < 0) {
            System.out.println("Stack underflow");
            return 0;
        } else {
            return stck[tos--];
        }
    }
}

class IFTest2 {
    public static void main(String[] args) {
        DynStack mystack1 = new DynStack(5);
        DynStack mysStack2 = new DynStack(8);

        // these loops cuase each stack to grow
        for (int i = 0; i < 12; i++) {
            mystack1.push(i);
        }

        for (int i = 0; i < 20; i++) {
            mysStack2.push(i);
        }

        System.out.println("Stack in mystack1:");

        for (int i = 0; i < 12; i++) {
            System.out.println(mystack1.pop());
        }

        System.out.println("Stack in mystack2:");
        for (int i = 0; i < 20; i++) {
            System.out.println(mysStack2.pop());
        }
    }
}