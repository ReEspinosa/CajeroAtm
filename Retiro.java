public class Retiro extends Transaccion {

    public Retiro(Cuenta cuenta, double monto) {
        super(cuenta, monto);
    }

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

    @Override
    public String toString() {
        return "Retiro{" +
                "cuentaClabe='" + cuenta.getClabe() + '\'' +
                ", monto=" + monto +
                '}';
    }
}