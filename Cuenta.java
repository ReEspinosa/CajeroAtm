public class Cuenta {
    private String clabe;
    private double saldo;

    // Constructor que inicializa la clabe y el saldo inicial
    public Cuenta(String clabe) {
        this.clabe = clabe;
        this.saldo = 2000; // Saldo inicial como especificado
    }

    // Método para obtener el saldo de la cuenta
    public double getSaldo() {
        return saldo;
    }

    // Método para obtener la clabe de la cuenta
    public String getClabe() {
        return clabe;
    }

    // Método para depositar dinero en la cuenta
    public void depositar(double cantidad) throws IllegalArgumentException {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a depositar debe ser positiva.");
        }
        saldo += cantidad;
    }

    // Método para retirar dinero de la cuenta
    public void retirar(double cantidad) throws IllegalArgumentException {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a retirar debe ser positiva.");
        }
        if (cantidad > saldo) {
            throw new IllegalArgumentException("Fondos insuficientes para realizar el retiro.");
        }
        saldo -= cantidad;
    }

    // Método toString para representar la cuenta como una cadena de texto
    @Override
    public String toString() {
        return "Cuenta{" +
                "clabe='" + clabe + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}