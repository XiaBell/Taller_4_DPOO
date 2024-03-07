package uniandes.dpoo.aerolinea.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {

    public final double IMPUESTO = 0.28;
    protected Cliente cliente;
    protected Vuelo vuelo;
    
    public int calcularTarifa (Vuelo vuelo){

        int costoBase = calcularCostoBase(vuelo);
        double porcentajeDescuento = calcularPorcentajeDescuento(vuelo);
        int valorImpuestos = calcularValorImpuestos(costoBase);
        int tarifa = (int) ((costoBase - (costoBase * porcentajeDescuento)) + valorImpuestos);
        return tarifa;

    }

    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);

    protected abstract double calcularPorcentajeDescuento(Vuelo vuelo);

    protected double calcularImpuesto(Vuelo vuelo) {
        return vuelo.getRuta().getDistancia() * IMPUESTO;

    }

    protected int calcularDistanciaVuelo(Ruta ruta){
        return ruta.getDistancia();
    }

    protected int calcularValorImpuestos(int costoBase){
        return (int) (costoBase * IMPUESTO);
    }
    
    
}
