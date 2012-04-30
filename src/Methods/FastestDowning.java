package Methods;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by IntelliJ IDEA.
 * User: Sony
 * Date: 30.04.12
 * Time: 1:19
 * To change this template use File | Settings | File Templates.
 */
public class FastestDowning
{
    /**
     * Calculate minimum with "Метод наискорейшего спуска"
     * @param x First approximation
     * @return 0
     */
    static public double Calculate(double[] x)
    {
        // Number of unknown variables in equation, depends on functions in Function class
        int eqn = x.length;
        double y = 0;

        // TODO: loop optimization
        for(;;)
        {
            double[][] equation_result = new double[eqn][2];
            // count delta f0
            for(int i = 0; i < eqn; i++)
                equation_result[i][0] = Functions.calculateDFFunctions[i].calculateFunction(x[0], x[1], x[2], 1);
            // count delta f'
            for(int i = 0; i < eqn; i++)
                equation_result[i][1] = Functions.calculateDFFunctions[i].calculateFunction(equation_result[0][0], equation_result[1][0], equation_result[2][0], 0);

            double[][] new_x = new double[eqn][2];

            // Store new X with lambdas
            for(int i = 0; i < eqn; i++)
            {
                new_x[i][0] = x[i];
                new_x[i][1] = equation_result[i][0];
            }

            // Find lambda
            double value = 0;
            double lambda_value = 0;
            for(int i = 0; i < eqn; i++)
            {
                value += Math.pow(equation_result[i][0], 2);
                lambda_value += equation_result[i][0] * equation_result[i][1];
            }
            double lambda = -value / lambda_value;

            //Calculate new X1, X2 and X3
            for(int i = 0; i < eqn; i++)
                x[i] = new_x[i][0] + new_x[i][1] * lambda;

            // print variables and result with them
            double _y = Functions.F(x[0], x[1], x[2]);
            System.out.println("x0 = " + x[0] + "; x2 = "+ x[1] + "; x3 = " + x[2]);
            System.out.println(_y);

            // check condition of loop
            if(Math.abs(y - _y) < Math.pow(10.0, -4.0))
                break;
            else
                y = _y;
        }

        return 0;
    }
}
