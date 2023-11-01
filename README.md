# Aplicaciones del Cálculo Diferencial al ML (MLR)
## Hands-On 5.
### Instrucciones:
- Dado el **DataSet 50 Startups** & **17 Chemical Experiments**, calcular los valores óptimos para los Parámetros del modelo Predictivo (Coeficientes de Regresión):
    - 1. Variables endógena: **PROFIT**.
    - 2. Variables exógenas: **Administration**, **R&D Spend** & **Marketing Spend**.
- Simular el comportamiento de las Startups - en el Computador - reañizando predicciones del **PROFIT** en función a diversos valores para las variables **Administration**, **R&D Spend** & **Marketing Spend**. 
- Para ello utilizamos la fórmula: 
$$ \hat{\beta} = (X^TX)^{-1}X^Ty $$
### Inputs:
- 50 Startup DataSet & 17 Chemical Experiments Data Set
- Los DataSet estarán predefinidos a través de un constructor de clase.
- No se capturan datos.
### Outputs:
- Imprimir: 
    - Ecuación de Regresión Múltiple sustituyendo los valores de los parámetros del modelo y los nombres de las variables:
    $$\hat{Y} = \beta_1(X_1) + \beta_2(X_2)$$
    - Al menos cinco predicciones en función a valores conocidos y desconocidos de las variables exógenas.

### Diagrama UML:
```plantuml
@startuml
class  DataSet{
    -double[] x1
    -double[] x2
    -double[] y
    +getX1Data(): double[]
    +getX2Data(): double[]
    +getYData(): double[] 
    +getSize(): int
}

class LinearAlgebra{
    +static double[][] transpose(matrix: double[][])
    +static double[][] multiply(a: double[][], b: double[][])
    +static double[] multiply(a: double[][], b: double[])
    +static double[][] inverse(matrix: double[][])
}

class MultipleLinearRegression {
    -double[] coefficients
    -double[][] dataMatrix
    -double[] targetVector
    +MultipleLinearRegression(dataMatrix: double[][], targetVector: double[])
    +void fit()
    +double predict(input: double[])
    +double[] getCoefficients()
}

class DiscrethsMaths {
    +static double mean(data: double[])
    +static double sum(data: double[])
}

class Predicts {
    +static void performPredictions(regression: MultipleLinearRegression)
}
@enduml