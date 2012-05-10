package Methods;

public class CG
{
    private static double[][] H = new double[][]
    {
        {2 * 1.1250, 2 * 0.6593, 2 * 0.1134},
        {2 * 0.6593, 2 * 1.06, -2 * 0.5038},
        {2 * 0.1134, -2 * 0.5038, 2 * 0.8151}
    };

    static public double Calculate(double[] x)
    {
        int eqn = x.length;
        double y = 0, _y = 0;
        double[] h = new double[eqn];
        double[] x_tmp = new double[eqn];
        
        for(int i = 0; i < eqn; i++)
            h[i] = - Functions.calculateDFFunctions[i].calculateFunction(x[0], x[1], x[2], 1);

        for(;;)
        {

            double alpha = getAlpha(x, h);
            for(int i = 0; i < 3; i++)
                x_tmp[i] = x[i] + alpha * h[i];
            double beta = getBeta(x, x_tmp);

            for(int i = 0; i < 3; i++)
            {
                x[i] = x_tmp[i];
                h[i] = -Functions.calculateDFFunctions[i].calculateFunction(x_tmp[0], x_tmp[1], x_tmp[2], 1) + h[i] * beta;
            }

            _y = Functions.F(x[0], x[1], x[2]);
            if(Math.abs(y - _y) < Math.pow(10.0, -10.0))
                break;
            else
                y = _y;
        }
        System.out.println("x1 = " + x[0] + "; x2 = "+ x[1] + "; x3 = " + x[2]);
        System.out.println(_y);
        return _y;
    }

    static private double getAlpha(double[] x, double[] h)
    {
        int eqn = x.length;
        double dF = 0, temp = 0;
        double numerator = 0, denominator = 0;

        for(int i = 0; i < eqn; i++)
        {
            dF = Functions.calculateDFFunctions[i].calculateFunction(x[0], x[1], x[2], 1);
            temp = 0;
            for(int j = 0; j < eqn; j++)
                temp += H[i][j] * h[i];
            numerator += dF * h[i];
            denominator += temp * h[i];
        }
        
        return -numerator / denominator;
    }

    static private double getBeta(double[] x1, double[] x2)
    {
        int eqn = x1.length;
        double numerator = 0, denominator = 0;
        for(int i = 0; i < eqn; i++)
        {
            numerator += Math.pow(Functions.calculateDFFunctions[i].calculateFunction(x2[0], x2[1], x2[2], 1), 2);
            denominator += Math.pow(Functions.calculateDFFunctions[i].calculateFunction(x1[0], x1[1], x1[2], 1), 2);
        }
        return numerator / denominator;
    }

}
