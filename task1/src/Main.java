// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(convert(1));
        System.out.println(fitCalc(41, 3));
        System.out.println(containers(3, 4, 2));
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));
        System.out.println(ternaryEvolution(8, 4));
        System.out.println(ternaryEvolution(1, 11));
        System.out.println(ternaryEvolution(5, 9));
        System.out.println(howManyItems(22, 1.4f, 2));
        System.out.println(factorial(4));
        System.out.println(gcd(52, 8));
        System.out.println(ticketSaller(24, 950));
        System.out.println(tables(31, 20));
    }

    public static float convert(int x) {
        float gallon = 3.785F;
        return x * gallon;
    }

    public static int fitCalc(int x, int y) {
        return x * y;
    }

    public static int containers(int x, int y, int z) {
        return x * 20 + y * 50 + z * 100;
    }

    public static String triangleType(int x, int y, int z) {
        if (x == y & x == z & x == y) {
            return "Равносторонний";
        } else if (x + y < z || x + z < y || y + z < x) {
            return "Не существует";
        } else if (x == y || x == z || y == z) {
            return "Равнобедренный";
        } else {
            return "Разносторонний";
        }
    }

    public static int ternaryEvolution(int x, int y) {
        return x > y ? x : y;
    }

    public static int howManyItems(int x, float y, float z) {
        int cover = (int) (x / ((y+z)*2));
        return cover;
    }

    public static int factorial(int x) {
        int f = 1;
        for (int i = 1; i <= x; i++) {
            f = f * i;
        }
        return f;
    }

    public static int gcd(int x, int y) {
        int mx = x > y ? x : y;
        int result = 0;
        for (int i = mx; i > 0; i--) {
            if (x % i == 0 && y % i == 0) {
                result = i;
                System.out.println(x);
                break;
            } else {
                ;
            }
        }
        return result;
    }

    public static int ticketSaller(int x, int y) {
        int c = 28;
        return ((x * y) - (x * y / 100 * c));
    }

    public static float tables(int x, int y) {
        float res = 0;
        res = (x - (y * 2)) / 2;
        if (res < 0){
            res = 0;
        }
        else if (res % 10 != 0) {
            res += 0.5;
        }
        return res;
    }
}