# Cajero Automático Simulado

Este proyecto es una simulación simple de un cajero automático. El programa permite al usuario realizar operaciones bancarias básicas como consultar saldo, depositar dinero y retirar dinero a través de una interfaz de consola.

## Equipo:
Espinosa Roque Raquel
Meza Rico Fernando
Olvera Roque Diego Emiliano


COLEGIO DE CIENCIAS Y HUMANIDADES PLANTEL VALLEJO

## Características

- Ingreso del número de cuenta y NIP para autenticación.
- Verificación de credenciales con posibilidad de reintentar o salir.
- Consulta de saldo.
- Depósito de fondos.
- Retiro de fondos con validación de saldo.
- Mensajes de error para fondos insuficientes o datos de entrada inválidos.
- Opción para salir del programa.

## Datos para Pruebas

Para el propósito de la demostración, se deben usar los siguientes datos de prueba:
- *Número de Cuenta*: 1234567890
- *NIP*: 1234

Estos datos están codificados en el sistema para el proceso de autenticación.

## Uso de Herencia

La herencia se utiliza en este proyecto para establecer una jerarquía de clases de transacciones. La clase Transaccion es una clase base abstracta que define el método ejecutar() el cual es sobreescrito por las clases derivadas para cada tipo de transacción:

- ConsultaSaldo: Hereda de Transaccion y sobrescribe ejecutar() para mostrar el saldo actual.
- Deposito: Hereda de Transaccion y sobrescribe ejecutar() para aumentar el saldo de la cuenta.
- Retiro: Hereda de Transaccion y sobrescribe ejecutar() para disminuir el saldo de la cuenta si hay fondos suficientes.

## Métodos y Implementación

### Clase Cuenta

- getSaldo(): Devuelve el saldo actual.
- depositar(double cantidad): Incrementa el saldo de la cuenta y valida que el monto sea positivo.
- retirar(double cantidad): Decrementa el saldo de la cuenta asegurando que haya suficientes fondos.

### Clase Transaccion (abstracta)

- ejecutar(): Método abstracto que las subclases concretas deben implementar.

### Clase ConsultaSaldo

- ejecutar(): Muestra el saldo actual de la cuenta asociada.

### Clase Deposito

- ejecutar(): Deposita una cantidad específica de dinero en la cuenta asociada.

### Clase Retiro

- ejecutar(): Retira una cantidad específica de dinero si el saldo lo permite.

## Main

El método main gestiona el flujo de interacción con el usuario, permitiendo la autenticación con el número de cuenta y NIP predefinidos y procesa las operaciones de cuenta seleccionadas por el usuario.

Para más detalles sobre la implementación, revise el código fuente en este repositorio.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, envíe un pull request o abra un issue para sugerir cambios o mejoras.
