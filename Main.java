import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean accesoConcedido = false;

        // Suponiendo que estos son los datos válidos para la demostración
        String numeroCuentaValido = "1234567890";
        String nipValido = "1234";

        System.out.println("Bienvenido al Cajero Automático");

        while (!accesoConcedido) {
            System.out.print("Por favor, ingrese su número de cuenta o 'salir' para salir: ");
            String numeroCuenta = scanner.nextLine();

            // Permitir al usuario salir si así lo desea
            if(numeroCuenta.equalsIgnoreCase("salir")) {
                System.out.println("Operación cancelada. Vuelva pronto.");
                return;
            }

            System.out.print("Ingrese su NIP: ");
            String nip = scanner.nextLine();

            // Verificar el número de cuenta y NIP
            if (numeroCuenta.equals(numeroCuentaValido) && nip.equals(nipValido)) {
                accesoConcedido = true;
                System.out.println("Acceso concedido.");
            } else {
                System.out.println("Número de cuenta o NIP incorrecto. Inténtelo de nuevo.");
            }
        }

        // Crear cuenta con un saldo inicial de $2000 y el número de cuenta ingresado
        Cuenta cuenta = new Cuenta(numeroCuentaValido); // Usar el número de cuenta válido definido previamente
        int opcion;

        do {
            // Mostrar el menú de opciones
            System.out.println("\nPor favor elige una opción:");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depositar Dinero");
            System.out.println("3. Retirar Dinero");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            // Procesar la opción seleccionada
            // El resto del código para procesar las opciones del menú sigue aquí...
            // Asegúrate de manejar la entrada del usuario y las posibles excepciones
            // como se mostró en ejemplos anteriores.

        } while (opcion != 4);

        scanner.close();
    }
}
