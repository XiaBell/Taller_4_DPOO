package uniandes.dpoo.aerolinea.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.tarifas.CalculadoraTarifas;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas  {

    
    protected final int COSTO_POR_KM_NATURAL = 600;
    protected final int COSTO_POR_KM_CORPORATIVO = 800;
    protected final double DESCUENTO_PEQ = 0.02;
    protected final double DESCUENTO_MEDIANAS = 0.1;
    protected final double DESCUENTO_GRANDES = 0.2;

    protected Cliente cliente = super.cliente;
    protected Vuelo vuelo = super.vuelo;


    public int calcularCostoBase(Vuelo vuelo){
        int distancia = calcularDistanciaVuelo(vuelo.getRuta());
        int costoBase = 0;
        if (cliente.getTipoCliente().equals("Natural")){
            costoBase = distancia * COSTO_POR_KM_NATURAL;
        }
        else if (cliente.getTipoCliente().equals("Corporativo")){
            costoBase = distancia * COSTO_POR_KM_CORPORATIVO;
        }
        return costoBase;
    }

    public double calcularPorcentajeDescuento(Vuelo vuelo){

        double porcentaje = 0;
        if (cliente.getTipoCliente().equals("Frecuente")){
            porcentaje = 0.1;
        }
        return porcentaje;
    }


    public int calcularCostoBase(Vuelo vuelo, Cliente cliente ){

        int distancia = calcularDistanciaVuelo(vuelo.getRuta());
        int costoBase = 0;
        if (cliente.getTipoCliente().equals("Natural")){
            costoBase = distancia * COSTO_POR_KM_NATURAL;
        }
        else if (cliente.getTipoCliente().equals("Corporativo")){
            costoBase = distancia * COSTO_POR_KM_CORPORATIVO;
        }
        return costoBase;
    }

    public double calcularPorcentajeDescuento(Vuelo vuelo, Cliente cliente){

        double porcentaje = 0;
        if (cliente.getTipoCliente().equals("Frecuente")){
            porcentaje = 0.1;
        }
        return porcentaje;
    }
}
