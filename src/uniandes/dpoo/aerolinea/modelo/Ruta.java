package uniandes.dpoo.aerolinea.modelo;

public class Ruta {
    private String horaSalida;
    private String horaLlegada;
    private String codigoRuta;
    private Aeropuerto destino;
    private Aeropuerto origen;

    public Ruta(String codigoRuta, Aeropuerto origen, Aeropuerto destino, String horaSalida, String horaLlegada) {
        this.codigoRuta = codigoRuta;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    //getCodigoRuta String
    public String getCodigoRuta() {
        return codigoRuta;
    }
    //getOrigenAeropuerto
    public Aeropuerto getOrigen() {
        return origen;
    }
    //getDestinoAeropuerto
    public Aeropuerto getDestino() {
        return destino;
    }
    //getHoraSalida String
    public String getHoraSalida() {
        return horaSalida;
    }
    //getHoraLlegada String
    public String getHoraLlegada() {
        return horaLlegada;
    }
    //getDuracion int
    public int getDuracion() {
        String[] horaSalidaArray = this.horaSalida.split(":");
        String[] horaLlegadaArray = this.horaLlegada.split(":");
        int horaSalidaInt = Integer.parseInt(horaSalidaArray[0]);
        int horaLlegadaInt = Integer.parseInt(horaLlegadaArray[0]);
        int minutoSalidaInt = Integer.parseInt(horaSalidaArray[1]);
        int minutoLlegadaInt = Integer.parseInt(horaLlegadaArray[1]);
        return (horaLlegadaInt - horaSalidaInt) * 60 + (minutoLlegadaInt - minutoSalidaInt);
    }
    /**
     * Dada una cadena con una hora y minutos, retorna los minutos.
     * 
     * Por ejemplo, para la cadena '715' retorna 15.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de minutos entre 0 y 59
     */
    public static int getMinutos( String horaCompleta )
    {
        return Integer.parseInt( horaCompleta ) % 100;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna las horas.
     * 
     * Por ejemplo, para la cadena '715' retorna 7.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de horas entre 0 y 23
     */
    public static int getHoras( String horaCompleta )
    {
        return Integer.parseInt( horaCompleta ) / 100;
    }
}
