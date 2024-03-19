// A generic interface example.
// 
// A Min/Max interface.
interface MinMax<T extends Comparable<T>> {
    T min();

    T max();
}

// Now, implement MinMax
class MyClass<T extends Comparable<T>> implements MinMax<T> {
    T[] vals;

    MyClass(T[] o) {
        vals = o;
    }

    // Return the minimum value in vals.
    public T min() {
        T v = vals[0];

        for (int i = 1; i < vals.length; i++) {
            if (vals[i].compareTo(v) < 0) {
                v = vals[i];
            }
        }

        return v;
    }

    // Return the maximum value in vals.
    public T max() {
        T v = vals[0];

        for (int i = 1; i < vals.length; i++) {
            if (vals[i].compareTo(v) > o) {
                v = vals[i];
            }
        }
    }
}

class GenIFDemo {
    public static void main(String[] args) {
        Integer[] inums = { 3, 6, 2, 8, 6 };
        Character[] chs = { 'b', 'r', 'p', 'w' };

        MyClass<Integer> iClass = new MyClass<Integer>(inums);
        MyClass<Character> cClass = new MyClass<Character>(chs);

        int minInt = iClass.min();
        int maxInt = iClass.max();

        char minChar = cClass.min();
        char maxChar = cClass.max();

        System.out.println("Max value in inums is " + maxInt);
        System.out.println("Min value in inums is " + minInt);

        System.out.println("Max character in chs is " + maxChar);
        System.out.println("Min character in chs is " + minChar);
    }
}