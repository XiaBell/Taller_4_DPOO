package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
    List<Tiquete> tiquetesSinUsar;
    List<Tiquete> tiquetesUsados;

    //constructor
    public Cliente() {
    }
    //generate get tipo cliente
    public abstract String getTipoCliente();
    //generate getIdentificador
    
    public abstract String getIdentificador();
    //generate agregarTiquete non abstract

    public void agregarTiquete(Tiquete tiquete) {
        tiquetesSinUsar.add(tiquete);
    }
    //generate calcularValorTotalTiquetes non abstract
    public int calcularValorTotalTiquetes() {
        int total = 0;
        for (Tiquete tiquete : tiquetesSinUsar) {
            total += tiquete.getTarifa();
        }
        return total;
    }
    //generate usarTiquetes non abstract
    public void usarTiquetes(Vuelo vuelo) {
        for (Tiquete tiquete : tiquetesSinUsar) {
            if (tiquete.getVuelo().equals(vuelo)) {
                tiquete.marcarComoUsado();
                tiquetesUsados.add(tiquete);
                tiquetesSinUsar.remove(tiquete);
            }
        }
    }
}
