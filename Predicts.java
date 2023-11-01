public class Predicts {
    public static void performPredictions(MultipleLinearRegression regression) {
        
        // Inyectamos los datos
        double[] x1Data = { 77.9, 78.4, 78.9, 79.5, 82.3};
        double[] x2Data = { 33.3, 33.5, 33.7, 33.8, 34.0};

        int startIdx = 0; // Índice inicial para las predicciones
        int numPredictions = 5; // Número de predicciones a realizar

        System.out.println("\nPredicciones:");
        for (int i = startIdx; i < startIdx + numPredictions; i++) {
            double[] input = {1.0, x1Data[i], x2Data[i]}; // Agregamos un 1.0 para beta0
            double prediction = regression.predict(input);
            System.out.println("Y = " + regression.getCoefficients()[0] + " + " + 
            regression.getCoefficients()[1] + "(" + x1Data[i] + ") + " + 
            regression.getCoefficients()[2] + "(" + x2Data[i] + ") = " 
            + prediction);
        }
    }
}
