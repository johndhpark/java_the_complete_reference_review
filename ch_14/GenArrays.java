// Generics and arrays.
class Gen<T extends Number> {
    T ob;

    T[] vals; // OK

    Gen(T o, T[] nums) {
        ob = o;

        // This statement is illegal.
        // vals = new T[10]; // can't create an array of T

        // But, this statement is ok.
        vals = nums; // OK to assign reference to existent array.

    }
}

class GenArrays {
    public static void main(String[] args) {
        Integer[] n = { 1, 2, 3, 4, 5 };

        Gen<Integer> iOb = new Gen<Integer>(50, n);
    }

}