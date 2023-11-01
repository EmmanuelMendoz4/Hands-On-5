public class MultipleLinearRegression {
    private double[] coefficients; // Coeficientes de la regresión
    private double[][] dataMatrix; // Matriz de datos
    private double[] targetVector; // Vector de resultados

    public MultipleLinearRegression(double[][] dataMatrix, double[] targetVector) {
        this.dataMatrix = dataMatrix;
        this.targetVector = targetVector;
        this.coefficients = new double[dataMatrix[0].length];
    }

    public void fit() {
        // Calcula X^T (transpuesta de la matriz X)
        double[][] transposedMatrix = LinearAlgebra.transpose(dataMatrix);

        // Calcula X^TX
        double[][] XTX = LinearAlgebra.multiply(transposedMatrix, dataMatrix);

        // Calcula la inversa de X^TX (implementar este método)
        double[][] inverseXTX = LinearAlgebra.inverse(XTX);

        // Calcula X^Ty
        double[] XTY = LinearAlgebra.multiply(transposedMatrix, targetVector);

        // Calcula los coeficientes \hat{\beta}
        coefficients = LinearAlgebra.multiply(inverseXTX, XTY);
    }

    public double predict(double[] input) {
        // Realiza la predicción utilizando los coeficientes
        double prediction = 0.0;
        for (int i = 0; i < coefficients.length; i++) {
            prediction += coefficients[i] * input[i];
        }
        return prediction;
    }

    public double[] getCoefficients() {
        return coefficients;
    }
}
