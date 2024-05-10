import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase Main crea una interfaz de usuario gráfica para simular operaciones en un cajero automático.
 * Permite a los usuarios iniciar sesión, consultar saldo, depositar y retirar dinero.
 */
public class Main {
    // Constantes para las credenciales válidas de inicio de sesión
    private static final String NUMERO_CUENTA_VALIDO = "1234567890";
    private static final String NIP_VALIDO = "1234";
    // Componentes de la interfaz gráfica de usuario
    private static JFrame frame;
    private static JTextField cuentaTextField;
    private static JPasswordField nipField;
    private static JButton loginButton, exitButton, saldoButton, depositarButton, retirarButton;
    private static JLabel messageLabel, balanceLabel;
    // Referencia a la cuenta bancaria una vez que el usuario inicia sesión
    private static CuentaBancaria cuenta;

    /**
     * El punto de entrada del programa. Configura y muestra la interfaz gráfica de usuario.
     *
     * @param args Los argumentos de la línea de comandos no se utilizan aquí.
     */
    public static void main(String[] args) {
        // Configuración inicial de la interfaz gráfica
        frame = new JFrame("Cajero Automático");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Etiqueta para mensajes
        messageLabel = new JLabel("Bienvenido al Cajero Automático");
        frame.add(messageLabel);

        // Campo de texto para número de cuenta
        cuentaTextField = new JTextField(20);
        frame.add(cuentaTextField);

        // Campo de texto para NIP
        nipField = new JPasswordField(20);
        frame.add(nipField);

        // Botón para iniciar sesión
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validateLogin();
            }
        });
        frame.add(loginButton);

        // Botón para salir
        exitButton = new JButton("Salir");
        exitButton.addActionListener(e -> System.exit(0));
        frame.add(exitButton);

        // Botones para transacciones
        saldoButton = new JButton("Consultar Saldo");
        saldoButton.addActionListener(e -> consultarSaldo());
        frame.add(saldoButton);

        depositarButton = new JButton("Depositar Dinero");
        depositarButton.addActionListener(e -> depositarDinero());
        frame.add(depositarButton);

        retirarButton = new JButton("Retirar Dinero");
        retirarButton.addActionListener(e -> retirarDinero());
        frame.add(retirarButton);

        // Etiqueta para mostrar el saldo
        balanceLabel = new JLabel("Saldo: $0.00");
        frame.add(balanceLabel);

        // Configurar visibilidad inicial de componentes
        setTransactionButtonsVisible(false);
        balanceLabel.setVisible(false);

        frame.setVisible(true);
    }

    /**
     * Valida el número de cuenta y NIP ingresados contra las credenciales válidas.
     * Si el inicio de sesión es exitoso, actualiza la interfaz gráfica para mostrar las opciones de transacciones.
     */
    private static void validateLogin() {
        String cuenta = cuentaTextField.getText();
        String nip = new String(nipField.getPassword());
        if (cuenta.equals(NUMERO_CUENTA_VALIDO) && nip.equals(NIP_VALIDO)) {
            messageLabel.setText("Acceso concedido.");
            Main.cuenta = new CuentaBancaria(NUMERO_CUENTA_VALIDO, 2000); // Inicializa la cuenta
            setTransactionButtonsVisible(true);
            balanceLabel.setVisible(true);
            balanceLabel.setText("Saldo: $" + Main.cuenta.getSaldo());
        } else {
            messageLabel.setText("Número de cuenta o NIP incorrecto.");
        }
    }

    /**
     * Actualiza la visibilidad de los botones de transacción y la etiqueta de saldo en la interfaz gráfica.
     *
     * @param visible Si es {@code true}, hace visibles los botones de transacciones y la etiqueta de saldo.
     */
    private static void setTransactionButtonsVisible(boolean visible) {
        saldoButton.setVisible(visible);
        depositarButton.setVisible(visible);
        retirarButton.setVisible(visible);
        balanceLabel.setVisible(visible);
    }

    /**
     * Consulta y muestra el saldo actual de la cuenta en la interfaz gráfica.
     */
    private static void consultarSaldo() {
        balanceLabel.setText("Saldo: $" + cuenta.getSaldo());
    }

    /**
     * Solicita al usuario una cantidad para depositar y actualiza el saldo de la cuenta.
     */
    private static void depositarDinero() {
        String monto = JOptionPane.showInputDialog(frame, "Ingrese la cantidad a depositar:");
        try {
            double amount = Double.parseDouble(monto);
            cuenta.depositar(amount);
            balanceLabel.setText("Saldo: $" + cuenta.getSaldo());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Por favor ingrese un número válido.");
        }
    }

    /**
     * Solicita al usuario una cantidad para retirar y actualiza el saldo de la cuenta si es posible.
     * Si no hay suficientes fondos, muestra un mensaje de error.
     */
    private static void retirarDinero() {
        String montoStr = JOptionPane.showInputDialog(frame, "Ingrese la cantidad a retirar:");
        if (montoStr != null && !montoStr.isEmpty()) {
            try {
                double monto = Double.parseDouble(montoStr);
                if (cuenta.getSaldo() >= monto) {
                    cuenta.retirar(monto);
                    balanceLabel.setText("Saldo: $" + cuenta.getSaldo());
                } else {
                    JOptionPane.showMessageDialog(frame, "Lo sentimos, el saldo de su cuenta es insuficiente para completar esta transacción. Por favor, ingrese una cantidad menor.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor ingrese un número válido.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        }
    }
}

/**
 * Clase que representa una cuenta bancaria con operaciones básicas como depositar y retirar dinero.
 */
class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;

    /**
     * Constructor para crear una cuenta bancaria con un número de cuenta y saldo inicial.
     *
     * @param numeroCuenta El número de la cuenta bancaria.
     * @param saldoInicial El saldo inicial de la cuenta bancaria.
     */
    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    /**
     * Método para depositar dinero en la cuenta bancaria.
     *
     * @param monto El monto a depositar.
     */
    public void depositar(double monto) {
        saldo += monto;
    }

    /**
     * Método para retirar dinero de la cuenta bancaria.
     *
     * @param monto El monto a retirar.
     */
    public void retirar(double monto) {
        saldo -= monto;
    }

    /**
     * Método para obtener el saldo actual de la cuenta bancaria.
     *
     * @return El saldo actual.
     */
    public double getSaldo() {
        return saldo;
    }

}
