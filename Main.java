public class Main {
    public static void main(String[] args) {
        DataSet dataSet = new DataSet();
        double[] x1Data = dataSet.getX1Data();
        double[] x2Data = dataSet.getX2Data();
        double[] yData = dataSet.getYData();

        int dataSize = dataSet.getSize();

        // Crear la matriz de datos X
        double[][] dataMatrix = new double[dataSize][3]; // Ahora tiene tres columnas
        for (int i = 0; i < dataSize; i++) {
            dataMatrix[i][0] = 1.0; // Beta0 es el coeficiente constante
            dataMatrix[i][1] = x1Data[i];
            dataMatrix[i][2] = x2Data[i];
        }

        MultipleLinearRegression regression = new MultipleLinearRegression(dataMatrix, yData);
        regression.fit(); // Realizar la regresión lineal múltiple

        double[] coefficients = regression.getCoefficients();
        /*System.out.println("Coeficientes de la regresión:");
        System.out.println("Beta0: " + coefficients[0]);
        System.out.println("Beta1: " + coefficients[1]);
        System.out.println("Beta2: " + coefficients[2]);*/
        System.out.println("\nEcuación de regresión lineal múltiple:");
        System.out.println("\nY = " + coefficients[0] + " + " + coefficients[1] + "(X1) + " + coefficients[2] + "(X2).");

        // Puedes hacer predicciones aquí, por ejemplo:
        Predicts.performPredictions(regression);
    }
}
