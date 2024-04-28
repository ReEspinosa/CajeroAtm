public class ConsultaSaldo extends Transaccion {

    public ConsultaSaldo(Cuenta cuenta) {
        // Llamamos al constructor de la clase base con monto 0 ya que no afecta el saldo
        super(cuenta, 0);
    }

    @Override
    public void ejecutar() {
        // Simplemente imprime el saldo actual de la cuenta
        System.out.println("Consulta de saldo realizada. Saldo actual: $" + cuenta.getSaldo());
    }

    @Override
    public String toString() {
        return "ConsultaSaldo{" +
                "cuentaClabe='" + cuenta.getClabe() + '\'' +
                // No mostramos monto ya que no es relevante para esta operación
                '}';
    }
}