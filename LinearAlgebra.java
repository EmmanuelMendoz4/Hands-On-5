public class LinearAlgebra {
    public static double[][] transpose(double[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        double[][] transpose = new double[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    public static double[][] multiply(double[][] a, double[][] b) {
        int m = a.length;
        int n = a[0].length;
        int p = b[0].length;

        if (n != b.length) {
            throw new IllegalArgumentException("No se pueden multiplicar matrices de estas dimensiones.");
        }

        double[][] result = new double[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                double sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    public static double[] multiply(double[][] a, double[] b) {
        int m = a.length;
        int n = a[0].length;

        if (n != b.length) {
            throw new IllegalArgumentException("No se pueden multiplicar matriz y vector de estas dimensiones.");
        }

        double[] result = new double[m];
        for (int i = 0; i < m; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                sum += a[i][j] * b[j];
            }
            result[i] = sum;
        }
        return result;
    }

    public static double[][] inverse(double[][] matrix) {                           // Implementar inversa de matrices
        int n = matrix.length;
        double[][] augmentedMatrix = new double[n][2 * n];

        // Crear una matriz aumentada [matrix | I]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix[i][j] = matrix[i][j];
                augmentedMatrix[i][j + n] = (i == j) ? 1 : 0;
            }
        }

        // Aplicar eliminación gaussiana para obtener la matriz identidad en el lado izquierdo
        for (int i = 0; i < n; i++) {
            // Encontrar la fila con el elemento máximo en la columna actual
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(augmentedMatrix[k][i]) > Math.abs(augmentedMatrix[maxRow][i])) {
                    maxRow = k;
                }
            }

            // Intercambiar filas
            double[] temp = augmentedMatrix[i];
            augmentedMatrix[i] = augmentedMatrix[maxRow];
            augmentedMatrix[maxRow] = temp;

            // Hacer el elemento diagonal igual a 1
            double pivot = augmentedMatrix[i][i];
            for (int j = i; j < 2 * n; j++) {
                augmentedMatrix[i][j] /= pivot;
            }

            // Eliminar elementos por debajo de la diagonal
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmentedMatrix[k][i];
                    for (int j = i; j < 2 * n; j++) {
                        augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j];
                    }
                }
            }
        }

        // Extraer la matriz inversa
        double[][] inverseMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverseMatrix[i][j] = augmentedMatrix[i][j + n];
            }
        }

        return inverseMatrix;
    }
}
