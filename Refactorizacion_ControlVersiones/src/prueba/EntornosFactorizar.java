package prueba;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EntornosFactorizar {

	// RADHAMES: 1era refactorizacion, separando responsabilidad de calcular base
	// total
	private double calcularBaseTotal(final double precioBase, final int cantidad) {
		return precioBase * cantidad;
	}

	// RADHAMES: 2da refactorizacion, separando responsabilidad de descuentos
	// basicos

	private double calcularDescuentosBasicos(final double total,final double descuento,final boolean tTarjFidelidad,
			final double saldoTarjeta) {
		double resultado = total;
		if (descuento > 0) {
			resultado -= resultado * (descuento / 100);
		}

		if (tTarjFidelidad && saldoTarjeta > 0) {
			resultado -= saldoTarjeta;
		}
		return resultado;

	}

	// RADHAMES: 4ta refactorizacion, separar responsabilidad de aplicacion de
	// impuesto

	private double aplicarImpuestos(final double total, final double impuestos) {
		return total + (total * (impuestos / 100));
	}

	// RADHAMES: 5ta refactorizacion, promociones especiales
	private double promocionesEspeciales(double total, final boolean esOfertaEspecial,final boolean esNavidad,
			final boolean esMiembroVip) {
		if (esOfertaEspecial) {
			total *= 0.9;
		}

		if (esNavidad) {
			total *= 0.85;
		}

		if (esMiembroVip) {
			total *= 0.8;
		}

		return total;
	}

	public double calcularPrecioFinal(final Compra compra) {
	    double total = calcularBaseTotal(compra.getPrecioBase(), compra.getCantidad());
	    //PABLO: Refactorizacion creando clase compra
	    total = calcularDescuentosBasicos(total, compra.getDescuento(), compra.istTarjFidelidad(), compra.getSaldoTarjeta());
	    total = aplicarImpuestos(total, compra.getImpuestos());
	    total = promocionesEspeciales(total, compra.isEsOfertaEspecial(), compra.isEsNavidad(), compra.isEsMiembroVip());
	    total = metodoPago(compra.getMetodoPago(), total);
	    total = aplicarCuotas(compra.isAplicarCuotas(), compra.getCuota(), total);
	    total = aplicarEnvio(compra.isEsEnvioGratis(), compra.getPrecioEnvio(), total);

	    if (compra.getCodigoCupon() != null && !compra.getCodigoCupon().isEmpty()) {
	        total = aplicarCuponDescuento(total, compra.getCodigoCupon());
	    }

	    if (!validarProducto(compra.getTipoProducto(), compra.getCategoriaProducto())) {
	        throw new IllegalArgumentException("El producto no es válido para esta compra.");
	    }

	    if (compra.getUsuario() != null) {
	        total = aplicarDescuentoPorUsuario(compra.getUsuario(), total);
	    }

	    total = asegurarValorNegativo(total);

	    return total;
	}


	private double asegurarValorNegativo(double total) {
		if (total < 0) {
			total = 0;
		}
		return total;
	}
	//PABLO Se mejora metodo con map,mejora la legibilidad,y complejidad del codigo.
	
	private double aplicarCuotas(final boolean aplicarCuotas, final int cuota, double total) {
	    if (aplicarCuotas) {
	       final Map<Integer, Double> factores = Map.of(
	            3, 1.1,
	            6, 1.2,
	            12, 1.3
	        );

	        total *= factores.getOrDefault(cuota, 1.0);
	    }
	    return total;
	}

	private double aplicarEnvio(final boolean esEnvioGratis,final double precioEnvio,final double total) {

		return esEnvioGratis ? total : total + precioEnvio;
	}

	// se mejora la legibilidad, y complejidad del codigo al eliminar condicionales
	// multiples
	private double metodoPago(final String metodoPago, final double total) {
		final Map<String, Double> multiplicadores = Map.of("TarjetaCredito", 1.05, "PayPal", 1.02);

		return total * multiplicadores.getOrDefault(metodoPago, 1.0);
	}

	// AITOR: imito al método "metodoPago" para mejorar legibilidad, reducir los
	// condicionales y facilitar la modificacion.
	private double aplicarCuponDescuento(final double total, final String codigoCupon) {
		final Map<String, Double> cuponesDescuento = Map.of("CUPOFF", 0.8, "NAVIDAD2025", 0.75);

		return total * cuponesDescuento.getOrDefault(codigoCupon, 1.0);

	}

	private boolean validarProducto(final String tipoProducto, final String categoriaProducto) {
		// AITOR: agrupo los productos validos en un Set y compruebo si son validos.
		final Set<String> productosValidos = new HashSet<>(
				Arrays.asList("Electronico-Smartphones", "Ropa-Hombre", "Ropa-Mujer"));

		return productosValidos.contains(tipoProducto + "-" + categoriaProducto);
	}

	// separo metodo aplicar descuento y calcularlo para mejorar la legibilidad del
	// codigo y la complejidad ciclomatica
	private double calcularDescuento(final Usuario usuario) {
	    double descuento = 1.0; // Valor sin descuento
	    if (usuario.isEmpleado()) {
	        descuento = 0.7;
	    } else if (usuario.isMiembroGold()) {
	        descuento = 0.85;
	    } else if (usuario.isMiembroSilver()) {
	        descuento = 0.9;
	    }
	    return descuento;
	}

	private double aplicarDescuentoPorUsuario(final Usuario usuario, final double total) {
	    final double descuento = calcularDescuento(usuario);
	    return total * descuento;
	}


}