package org.europa.choco;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;

public class Application {

    public static void main(String[] args) {

        String[] colors = {"red", "green", "blue"};
        Model model = new Model("Map Color Problem");

        //Variables
        IntVar top = model.intVar("top", 0, 2);
        IntVar down = model.intVar("down", 0, 2);
        IntVar left = model.intVar("left", 0, 2);
        IntVar right = model.intVar("right", 0, 2);
        IntVar center = model.intVar("center", 0, 2);

        //Constraints
        center.eq(top).not().post();
        center.eq(down).not().post();
        center.eq(left).not().post();
        center.eq(right).not().post();

        top.eq(left).not().post();
        top.eq(right).not().post();

        down.eq(left).not().post();
        down.eq(right).not().post();

        Solution solution = model.getSolver().findSolution();
        if (solution != null) {
            System.out.println(solution.toString());

            //formatet output
            System.out.println(center.getName() + " is " + colors[center.getValue()]);
            System.out.println(top.getName() + " is " + colors[top.getValue()]);
            System.out.println(right.getName() + " is " + colors[right.getValue()]);
            System.out.println(down.getName() + " is " + colors[down.getValue()]);
            System.out.println(left.getName() + " is " + colors[left.getValue()]);

        } else {
            System.out.println("No solution found.");
        }
    }
}
