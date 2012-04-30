package Methods;

/**
 * Created by IntelliJ IDEA.
 * User: Sony
 * Date: 30.04.12
 * Time: 22:49
 * To change this template use File | Settings | File Templates.
 */
public class Newton
{
    /**
     * Calculate minimum with Newton's formula
     * @param x First approximation
     * @return Final result of equation, where minimum is
     */
    static double Calculate(double[] x)
    {
        int eqn = x.length;
        double y = 0, _y = 0;
        double[] new_x = new double[eqn];

        for(;;)
        {
            // calculate Newton's formula
            for(int i = 0; i < eqn; i++)
                new_x[i] = x[i] - Functions.calculateDFFunctions[i].calculateFunction(x[0], x[1], x[2], 1)
                                / Functions.calculateDDFFunctions[i].calculateFunction();
            // replace old X's with new one
            for(int i = 0; i < eqn; i++)
                x[i] = new_x[i];

            // print variables and result with them
            _y = Functions.F(x[0], x[1], x[2]);
            System.out.println("x0 = " + x[0] + "; x2 = "+ x[1] + "; x3 = " + x[2]);
            System.out.println(_y);

            // check condition of loop
            if(Math.abs(y - _y) < Math.pow(10.0, -4.0))
                break;
            else
                y = _y;
        }
        return _y;
    }
}
