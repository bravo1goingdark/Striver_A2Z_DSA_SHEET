public class power {
    public double myPow(double x, int n) {
        double res = pow(x, Math.abs(n));
        return n >= 0 ? res : 1 / res ;
    }
    public double pow(double base , int power){
        if (base == 0) {
            return 0;
        }
        if (power == 0) {
            return 1;
        }
        double res = pow(base * base, power / 2);
        return power % 2 != 0 ? base * res : res;
    }
}