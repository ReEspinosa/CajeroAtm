/**
 * Clase que representa una transacción de retiro de fondos de una cuenta bancaria.
 * Extiende de la clase Transaccion.
 */
public class Retiro extends Transaccion {

    /**
     * Construye una nueva transacción de retiro con la cuenta y el monto especificados.
     *
     * @param cuenta La cuenta bancaria desde la cual se retirarán los fondos.
     * @param monto El monto de dinero a retirar de la cuenta.
     */
    public Retiro(Cuenta cuenta, double monto) {
        super(cuenta, monto);
    }

    /**
     * Ejecuta la transacción de retiro. Verifica que el monto sea positivo y que la cuenta tenga suficientes fondos.
     * Si alguna de las condiciones no se cumple, lanza una excepción.
     *
     * @throws IllegalArgumentException Si el monto de retiro es menor o igual a cero.
     * @throws Exception Si la cuenta no tiene suficientes fondos para cubrir el retiro.
     */
    @Override
    public void ejecutar() throws Exception {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto de retiro debe ser positivo.");
        }
        if (cuenta.getSaldo() >= monto) {
            cuenta.retirar(monto);
            System.out.println("Retiro realizado con éxito. Monto retirado: $" + monto);
        } else {
            throw new Exception("Fondos insuficientes para realizar el retiro.");
        }
    }

    /**
     * Devuelve una representación en cadena de la transacción de retiro, incluyendo la CLABE de la cuenta
     * y el monto retirado.
     *
     * @return Una cadena que representa la transacción de retiro.
     */
    @Override
    public String toString() {
        return "Retiro{" +
                "cuentaClabe='" + cuenta.getClabe() + '\'' +
                ", monto=" + monto +
                '}';
    }
}