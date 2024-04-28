public abstract class Transaccion {
    protected Cuenta cuenta; // Cuenta asociada a la transacción
    protected double monto;  // Monto involucrado en la transacción (si aplica)

    // Constructor que inicializa la cuenta y el monto para cada transacción
    public Transaccion(Cuenta cuenta, double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    // Método abstracto que deberá ser implementado por cada tipo de transacción
    public abstract void ejecutar() throws Exception;

    // Método para obtener detalles de la transacción, útil para logs o confirmaciones
    @Override
    public String toString() {
        return "Transaccion{" +
                "cuentaClabe='" + cuenta.getClabe() + '\'' +
                ", monto=" + monto +
                '}';
    }
}
