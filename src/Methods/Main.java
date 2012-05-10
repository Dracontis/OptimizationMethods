package Methods;

/**
 * Created by IntelliJ IDEA.
 * User: Sony
 * Date: 30.04.12
 * Time: 18:50
 * To change this template use File | Settings | File Templates.
 */
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Вычислено для эпислон равной 10 ^ -10.");
        System.out.println("Метод наискорейшего спуска: ");
        FastestDowning.Calculate(new double[]{1,1,1});
        System.out.println("Метод Ньютона: ");
        Newton.Calculate(new double[]{1,1,1});
        System.out.println("Метод сопряженных градиентов: ");
        CG.Calculate(new double[]{1,1,1});
    }
}
