/**
 * Clase que representa una transacción de depósito en una cuenta bancaria.
 * Extiende de la clase Transaccion.
 */
public class Deposito extends Transaccion {

    /**
     * Construye una nueva transacción de depósito con la cuenta y el monto especificados.
     *
     * @param cuenta La cuenta bancaria en la que se realizará el depósito.
     * @param monto  El monto de dinero a depositar en la cuenta.
     */
    public Deposito(Cuenta cuenta, double monto) {
        super(cuenta, monto);
    }

    /**
     * Ejecuta la transacción de depósito. Si el monto es negativo o cero, se lanza una excepción.
     *
     * @throws IllegalArgumentException Si el monto del depósito es menor o igual a cero.
     */
    @Override
    public void ejecutar() throws Exception {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto del depósito debe ser positivo.");
        }
        cuenta.depositar(monto);
        System.out.println("Depósito realizado con éxito. Monto depositado: $" + monto);
    }

    /**
     * Devuelve una representación en cadena de la transacción de depósito, incluyendo la CLABE de la cuenta
     * y el monto depositado.
     *
     * @return Una cadena que representa la transacción de depósito.
     */
    @Override
    public String toString() {
        return "Deposito{" +
                "cuentaClabe='" + cuenta.getClabe() + '\'' +
                ", monto=" + monto +
                '}';
    }
}
