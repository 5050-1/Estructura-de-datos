package fes.aragon.unam;

public class Empleado {
    private int numTrabajador;
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private int horasExtra;
    private float sueldoBase;
    private int anoIngreso;

    public Empleado(int numTrabajador, String nombre, String apellidoMaterno, String apellidoPaterno, int horasExtra, float sueldoBase, int anoIngreso) {
        this.numTrabajador = numTrabajador;
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.horasExtra = horasExtra;
        this.sueldoBase = sueldoBase;
        this.anoIngreso = anoIngreso;
    }

    public float calcularSueldo() {
        float pagoHoraExtra = horasExtra * 276.5f;
        int antiguedad = 2026 - anoIngreso;
        float prestacionAntiguedad = sueldoBase * (0.03f * antiguedad);
        return sueldoBase + pagoHoraExtra + prestacionAntiguedad;
    }

    public int getAnoIngreso() {
        return anoIngreso;
    }

    @Override
    public String toString() {
        return "# Empleado: {" +
                "numTrabajador=" + numTrabajador +
                ", nombre='" + nombre + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", SueldoTotal= " + calcularSueldo();
    }
}
