/**
 * Esta clase representa una transacción de consulta de saldo. Extiende de la clase
 * Transaccion. La consulta de saldo no requiere de un monto para la transacción,
 * por eso se inicializa con cero en el constructor de la superclase.
 */
public class ConsultaSaldo extends Transaccion {

    /**
     * Construye una nueva transacción de consulta de saldo asociada con la cuenta proporcionada.
     *
     * @param cuenta La cuenta a la que está vinculada la transacción de consulta de saldo.
     */
    public ConsultaSaldo(Cuenta cuenta) {
        // Llamamos al constructor de la clase base con monto 0 ya que no afecta el saldo
        super(cuenta, 0);
    }

    /**
     * Ejecuta la transacción de consulta de saldo, imprimiendo el saldo actual de la cuenta.
     */
    @Override
    public void ejecutar() {
        // Simplemente imprime el saldo actual de la cuenta
        System.out.println("Consulta de saldo realizada. Saldo actual: $" + cuenta.getSaldo());
    }

    /**
     * Devuelve una representación en cadena de la transacción de consulta de saldo.
     *
     * @return Una cadena que representa la transacción de consulta de saldo con la CLABE de la cuenta.
     */
    @Override
    public String toString() {
        return "ConsultaSaldo{" +
                "cuentaClabe='" + cuenta.getClabe() + '\'' +
                // No mostramos monto ya que no es relevante para esta operación
                '}';
    }
}