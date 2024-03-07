package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
    private String codigo;
    private int tarifa;
    private boolean usado;
    private Cliente cliente;
    private Vuelo vuelo;

    //Constructor
    public Tiquete(String codigo, Vuelo vuelo, Cliente cliente, int tarifa) {
        this.codigo = codigo;
        this.vuelo = vuelo;
        this.cliente = cliente;
        this.tarifa = tarifa;
        this.usado = false;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void marcarComoUsado() {
        usado = true;
    }

    public boolean esUsado() {
        return usado;
    }
}
