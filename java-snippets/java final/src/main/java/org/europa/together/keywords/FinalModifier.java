package org.europa.together.keywords;

public class FinalModifier {

    public void foo() {
        Dimension dimension = new Dimension(5, 6);
        System.out.println("init " + dimension.toString() + "\n");

        meth01(dimension);
        System.out.println("step 1 " + dimension.toString() + "\n");

        meth02(dimension);
        System.out.println("step 2 " + dimension.toString() + "\n");

        meth03(dimension);
        System.out.println("\nfinal " + dimension.toString());
    }

    public void meth01(final Dimension dimesion) {

//        dimesion = new Dimension(0, 0);
        System.out.println("meth01 " + dimesion.toString());
    }

    public void meth02(final Dimension dimesion) {
        dimesion.setX(9);
        dimesion.setY(3);
        System.out.println("meth02 " + dimesion.toString());
    }

    public void meth03(final Dimension dimesion) {
        dimesion.setX(4);
        dimesion.setY(2);
        System.out.println("meth03 " + dimesion.toString());
    }
}
