# Cajero Automático Simulado

Este proyecto es una simulación simple de un cajero automático. El programa permite al usuario realizar operaciones bancarias básicas como consultar saldo, depositar dinero y retirar dinero a través de una interfaz de consola.

## Equipo:
Raquel Espinosa Roque

## Características

- Ingreso del número de cuenta y NIP.
- Verificación de credenciales.
- Consulta de saldo.
- Depósito de fondos.
- Retiro de fondos.
- Mensajes de error para fondos insuficientes o datos de entrada inválidos.
- Opción para salir del programa o intentar la autenticación nuevamente.

## Uso de Herencia

La herencia se utiliza en este proyecto para crear una jerarquía de clases de transacciones. La clase Transaccion es la clase base abstracta de la que heredan todas las transacciones específicas:

- ConsultaSaldo: Hereda de Transaccion y sobrescribe el método ejecutar() para mostrar el saldo actual.
- Deposito: Hereda de Transaccion y sobrescribe el método ejecutar() para aumentar el saldo de la cuenta.
- Retiro: Hereda de Transaccion y sobrescribe el método ejecutar() para disminuir el saldo de la cuenta, con validación de saldo.

## Métodos y Implementación

### Clase Cuenta

- getSaldo(): Devuelve el saldo actual.
- depositar(double cantidad): Aumenta el saldo de la cuenta y valida que el monto sea positivo.
- retirar(double cantidad): Disminuye el saldo de la cuenta y valida que haya suficientes fondos.

### Clase Transaccion (abstracta)

- ejecutar(): Método abstracto que debe ser implementado por las subclases para realizar la transacción específica.

### Clase ConsultaSaldo

- ejecutar(): Implementación que muestra el saldo de la cuenta asociada.

### Clase Deposito

- ejecutar(): Implementación que deposita una cantidad de dinero en la cuenta asociada.

### Clase Retiro

- ejecutar(): Implementación que retira una cantidad de dinero si hay suficientes fondos.

## Main

El método main maneja el flujo de interacción con el usuario, autenticación y procesamiento de las transacciones seleccionadas por el usuario.

Para más detalles sobre la implementación, revise el código fuente en este repositorio.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, envíe un pull request o abra un issue para sugerir cambios o mejoras.
