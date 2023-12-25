package model; /**
 * class In
 */
import java.util.*;
public class In
{
    private static Scanner in = new Scanner(System.in);
    public static String nextLine()
    {
        return in.nextLine();
    }

    public static char nextChar()
    {
        return in.nextLine().charAt(0);
    }

    public static char nextUpperChar()
    {
        return in.nextLine().toUpperCase().charAt(0);
    }

    public static int nextInt()
    {
        int i = in.nextInt();
        in.nextLine();
        return i;
    }

    public static double nextDouble()
    {
        double d = in.nextDouble();
        in.nextLine();
        return d;
    }

    public static int readInt(String message)
    {
        System.out.print("Please enter " + message + ": ");
        return In.nextInt();
    }

    public static double readDouble(String message)
    {
        System.out.print("Please enter " + message + ": ");
        return In.nextDouble();
    }

    public static String readName(String message)
    {
        System.out.print("Please enter " + message + " ");
        return In.nextLine();
    }
}
