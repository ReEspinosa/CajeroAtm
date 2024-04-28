public class Deposito extends Transaccion {

    public Deposito(Cuenta cuenta, double monto) {
        super(cuenta, monto);
    }

    @Override
    public void ejecutar() throws Exception {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto del depósito debe ser positivo.");
        }
        cuenta.depositar(monto);
        System.out.println("Depósito realizado con éxito. Monto depositado: $" + monto);
    }

    @Override
    public String toString() {
        return "Deposito{" +
                "cuentaClabe='" + cuenta.getClabe() + '\'' +
                ", monto=" + monto +
                '}';
    }
}
