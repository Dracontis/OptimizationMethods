package Methods;

class Functions{
    // Original function
    static double F(double x1, double x2, double x3)
    {
        double fx = 1.1250 * Math.pow(x1, 2) + 2 * 0.6593 * x1 * x2 + 2 * 0.1134 * x1 * x3
                + 1.06 * Math.pow(x2, 2) - 2 * 0.5038 * x2 * x3
                + 0.8151 * Math.pow(x3, 2)
                - 2 * 0.8562 * x1
                - 2 * 0.4845 * x2
                - 2 * 0.3488 * x3;
        return fx;
    }

    // First differential
    static double dFx1(double x1, double x2, double x3, double l)
    {
        double fx =
                2 * 1.1250 * x1 + 2 * 0.6593 * x2 + 2 * 0.1134 * x3
                - 2 * 0.8562 * l;
        return fx;
    }

    static double dFx2(double x1, double x2, double x3, double l)
    {
        double fx =
                2 * 0.6593 * x1
                + 2 * 1.06 * x2 - 2 * 0.5038 * x3
                - 2 * 0.4845 * l;
        return fx;
    }

    static double dFx3(double x1, double x2, double x3, double l)
    {
        double fx =
                2 * 0.1134 * x1
                - 2 * 0.5038 * x2
                + 2 * 0.8151 * x3
                - 2 * 0.3488 * l;
        return fx;
    }

    // Second differential
    static double ddFx1()
    {
        return 2 * 1.1250;
    }

    static double ddFx2()
    {
        return 2 * 1.06;
    }

    static double ddFx3()
    {
        return 2 * 0.8151;
    }

    // Interfaces for arrays of functions
    interface FunctionDF
    {
        double calculateFunction(double x1, double x2, double x3, double l);
    }
    interface FunctionDDF
    {
        double calculateFunction();
    }

    public static FunctionDF[] calculateDFFunctions = new FunctionDF[]
            {
                    new FunctionDF()
                    {
                        @Override
                        public double calculateFunction(double x1, double x2, double x3, double l)
                        {
                            return dFx1(x1, x2, x3, l);
                        }
                    },
                    new FunctionDF()
                    {
                        @Override
                        public double calculateFunction(double x1, double x2, double x3, double l)
                        {
                            return dFx2(x1, x2, x3, l);
                        }
                    },
                    new FunctionDF()
                    {
                        @Override
                        public double calculateFunction(double x1, double x2, double x3, double l)
                        {
                            return dFx3(x1, x2, x3, l);
                        }
                    },
            };
    public static FunctionDDF[] calculateDDFFunctions = new FunctionDDF[]
            {
                    new FunctionDDF()
                    {
                        @Override
                        public double calculateFunction()
                        {
                            return ddFx1();
                        }
                    },
                    new FunctionDDF()
                    {
                        @Override
                        public double calculateFunction()
                        {
                            return ddFx2();
                        }
                    },
                    new FunctionDDF()
                    {
                        @Override
                        public double calculateFunction()
                        {
                            return ddFx3();
                        }
                    },
            };
}
