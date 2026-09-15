package mx.unam.aragon;

public class Registro {
    private String ip;
    private String pais;
    private String fechayHora;
    private String actividad;

    public Registro(String ip, String pais, String fechayHora, String actividad) {
        this.ip = ip;
        this.pais = pais;
        this.fechayHora = fechayHora;
        this.actividad = actividad;
    }
    public String getIp(){
        return ip;
    }
    public String getPais() {
        return pais;
    }
    public String getFechayHora(){
        return fechayHora;
    }
    public String getActividad(){
        return actividad;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "ip='" + ip + '\'' +
                ", pais='" + pais + '\'' +
                ", fechayHora='" + fechayHora + '\'' +
                ", actividad='" + actividad + '\'' +
                '}';
    }
}
