/**
 * Clase que representa una cuenta bancaria con operaciones para consultar saldo,
 * depositar y retirar dinero.
 */
public class Cuenta {
    private String clabe;
    private double saldo;

    /**
     * Constructor que inicializa la cuenta con una clabe específica y un saldo inicial.
     *
     * @param clabe La CLABE única que identifica la cuenta bancaria.
     */
    public Cuenta(String clabe) {
        this.clabe = clabe;
        this.saldo = 2000; // Saldo inicial como especificado
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     *
     * @return El saldo actual.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Obtiene la CLABE de la cuenta.
     *
     * @return La CLABE de la cuenta.
     */
    public String getClabe() {
        return clabe;
    }

    /**
     * Deposita una cantidad de dinero en la cuenta. Si la cantidad es negativa,
     * se lanza una excepción.
     *
     * @param cantidad La cantidad de dinero a depositar.
     * @throws IllegalArgumentException si la cantidad es menor o igual a cero.
     */
    public void depositar(double cantidad) throws IllegalArgumentException {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a depositar debe ser positiva.");
        }
        saldo += cantidad;
    }

    /**
     * Retira una cantidad de dinero de la cuenta. Si la cantidad es negativa o
     * mayor al saldo actual, se lanza una excepción.
     *
     * @param cantidad La cantidad de dinero a retirar.
     * @throws IllegalArgumentException si la cantidad es menor o igual a cero o si excede el saldo actual.
     */
    public void retirar(double cantidad) throws IllegalArgumentException {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a retirar debe ser positiva.");
        }
        if (cantidad > saldo) {
            throw new IllegalArgumentException("Fondos insuficientes para realizar el retiro.");
        }
        saldo -= cantidad;
    }

    /**
     * Devuelve una representación en cadena de la cuenta, incluyendo la CLABE y el saldo actual.
     *
     * @return Una cadena que representa la cuenta.
     */
    @Override
    public String toString() {
        return "Cuenta{" +
                "clabe='" + clabe + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}