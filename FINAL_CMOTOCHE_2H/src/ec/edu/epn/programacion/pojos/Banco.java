package ec.edu.epn.programacion.pojos;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class Banco {
    public void realizarRetiro(Cuenta cuenta, double monto){
        if (!(cuenta.getSaldoActual() - monto < 0.0)) {
            cuenta.setSaldoActual(cuenta.getSaldoActual() - monto);
        }
    }
    public void realizarDeposito(Cuenta cuenta, double monto){
        cuenta.setSaldoActual(cuenta.getSaldoActual() + monto);
    }
}
