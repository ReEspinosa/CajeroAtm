/**
 * Clase abstracta que representa una transacción genérica en un sistema bancario.
 * Define la estructura básica que todas las transacciones específicas deben seguir.
 */
public abstract class Transaccion {
    protected Cuenta cuenta; // Cuenta asociada a la transacción
    protected double monto;  // Monto involucrado en la transacción (si aplica)

    /**
     * Constructor que inicializa la cuenta y el monto para la transacción.
     *
     * @param cuenta La cuenta sobre la cual se realiza la transacción.
     * @param monto El monto de la transacción, si es aplicable.
     */
    public Transaccion(Cuenta cuenta, double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    /**
     * Método abstracto para ejecutar la transacción.
     * Este método debe ser implementado por las clases concretas que extienden esta clase.
     *
     * @throws Exception si la transacción no se puede completar por cualquier motivo.
     */
    public abstract void ejecutar() throws Exception;

    /**
     * Devuelve una representación en cadena de la transacción, incluyendo la CLABE de la cuenta
     * y el monto de la transacción.
     *
     * @return Una cadena que representa los detalles de la transacción.
     */
    @Override
    public String toString() {
        return "Transaccion{" +
                "cuentaClabe='" + cuenta.getClabe() + '\'' +
                ", monto=" + monto +
                '}';
    }
}
