package ec.edu.epn.programacion.pojos;

/**
 * POJO Banco, para realizar las transacciones.
 * @author Javier Utreras
 */
public class Banco {
    /**
     * Metodo que permite reducir el saldo de una cuenta
     * @param cuenta Cuenta a la que se va a despositar
     * @param monto Cantidad de dinero que se va a retirar
     */
    public void realizarRetiro(Cuenta cuenta, double monto){
        if (!(cuenta.getSaldoActual() - monto < 0.0)) {
            cuenta.setSaldoActual(cuenta.getSaldoActual() - monto);
        }
    }
    /**
     * Metodo que permite aumentar el saldo de una cuenta
     * @param cuenta Cuenta a la que se va a despositar
     * @param monto Cantidad de dinero que se va a depositar
     */
    public void realizarDeposito(Cuenta cuenta, double monto){
        cuenta.setSaldoActual(cuenta.getSaldoActual() + monto);
    }
}
