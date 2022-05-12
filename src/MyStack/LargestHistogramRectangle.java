package MyStack;

public class LargestHistogramRectangle extends IOM {

    static boolean isPerfectSquare(int x, int y) {
        double sq1 = x * x * 1.0f;
        double sq2 = y * y * 1.0f;
        double ans = Math.sqrt(sq1 + sq2);
        if (ans - Math.floor(ans) > 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = get_Int();
        int x = get_Int();
        int y = get_Int();
        if (x == 0 && y == 0) {
            print(0);
        } else if (isPerfectSquare(x, y)) {
            print(1);
        } else {
            print(2);
        }
    }
}
