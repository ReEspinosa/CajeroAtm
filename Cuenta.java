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
    public Cuenta(String clabe, double saldoInicial) {
        this.clabe = clabe;
        this.saldo = saldoInicial; // Saldo inicial como especificado
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
     * @param monto La cantidad de dinero a depositar.
     * @throws IllegalArgumentException si la cantidad es menor o igual a cero.
     */
    public void depositar(double monto) throws IllegalArgumentException {
        if (monto <= 0) {
            throw new IllegalArgumentException("La cantidad a depositar debe ser positiva.");
        }
        saldo += monto;
    }

    /**
     * Retira una cantidad de dinero de la cuenta. Si la cantidad es negativa o
     * mayor al saldo actual, se lanza una excepción.
     *
     * @param monto La cantidad de dinero a retirar.
     * @throws IllegalArgumentException si la cantidad es menor o igual a cero o si excede el saldo actual.
     */
    public void retirar(double monto) throws Exception {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        }
        if (monto > this.saldo) {
            throw new Exception("Fondos insuficientes para realizar el retiro.");
        }
        saldo -= monto;
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