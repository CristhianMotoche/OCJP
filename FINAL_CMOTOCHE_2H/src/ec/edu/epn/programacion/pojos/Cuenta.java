package ec.edu.epn.programacion.pojos;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class Cuenta {
    private String numeroCta;
    private double saldoInicial;
    private double saldoActual;
    private String nombreCliente;

    public Cuenta() {
    }

    public Cuenta(String numeroCta, double saldoInicial, double saldoActual) {
        this.numeroCta = numeroCta;
        this.saldoInicial = saldoInicial;
        this.saldoActual = saldoActual;
    }

    public Cuenta(String numeroCta, double saldoInicial, double saldoActual, String nombreCliente) {
        this.numeroCta = numeroCta;
        this.saldoInicial = saldoInicial;
        this.saldoActual = saldoActual;
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroCta() {
        return numeroCta;
    }

    public void setNumeroCta(String numeroCta) {
        this.numeroCta = numeroCta;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public String getNombreCliente() {
        return this.nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public String toString() {
        return this.numeroCta;
    }
}
