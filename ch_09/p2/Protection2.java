package p2;

class Protection2 extends p1.Protection {
    Protection2() {
        System.out.println("derived other package constructor");

        // class or package only
        // System.out.println("n = " + n);
        //
        // class only
        // System.out.println("n_pri = " + n_pri);
    }
}