package uniandes.dpoo.aerolinea.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.tarifas.CalculadoraTarifas;


public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {
    protected final int COSTO_POR_KM = 1000;

	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        int distancia = calcularDistanciaVuelo(vuelo.getRuta());
        int costoBase = distancia * COSTO_POR_KM;
        return costoBase;
    }

	@Override
	protected double calcularPorcentajeDescuento(Vuelo vuelo) {

        double porcentaje = 0;
        if (cliente.getTipoCliente().equals("Frecuente")){
            porcentaje = 0.1;
        }
        return porcentaje;
    }
	
    public int calcularTarifa(Vuelo vuelo) {

        int costoBase = calcularCostoBase(vuelo, cliente);
        double porcentajeDescuento = calcularPorcentajeDescuento(vuelo);
        int valorImpuestos = calcularValorImpuestos(costoBase);
        int tarifa = (int) ((costoBase - (costoBase * porcentajeDescuento)) + valorImpuestos);
        return tarifa;

    }
}
