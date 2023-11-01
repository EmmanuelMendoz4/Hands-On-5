public class DiscrethsMaths {
    public static double mean(double[] data) {      // Calcular media
        double sum = 0;
        for (double value : data) {
            sum += value;
        }
        return sum / data.length;
    }

    public static double sum(double[] data) {       // Calcular sumas
        double total = 0;
        for (double value : data) {
            total += value;
        }
        return total;
    }
}
