package prueba;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EntornosFactorizar {

	// RADHAMES: 1era refactorizacion, separando responsabilidad de calcular base
	// total
	private double calcularBaseTotal(double precioBase, int cantidad) {
		return precioBase * cantidad;
	}

	// RADHAMES: 2da refactorizacion, separando responsabilidad de descuentos
	// basicos

	private double calcularDescuentosBasicos(double total, double descuento, boolean tieneTarjetaFidelidad,
			double saldoTarjeta) {

		if (descuento > 0) {
			total -= total * (descuento / 100);
		}

		if (tieneTarjetaFidelidad && saldoTarjeta > 0) {
			total -= saldoTarjeta;
		}
		return total;

	}

	// RADHAMES: 4ta refactorizacion, separar responsabilidad de aplicacion de
	// impuesto

	private double aplicarImpuestos(double total, double impuestos) {
		return total + (total * (impuestos / 100));
	}

	// RADHAMES: 5ta refactorizacion, promociones especiales
	private double promocionesEspeciales(double total, boolean esOfertaEspecial, boolean esNavidad,
			boolean esMiembroVip) {
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

	public double calculaDato(double precioBase, int cantidad, double descuento, double impuestos,
			boolean tieneTarjetaFidelidad, double saldoTarjeta, boolean esOfertaEspecial, boolean esNavidad,
			boolean esMiembroVip, String metodoPago, boolean aplicarCuotas, int cuota, boolean esEnvioGratis,
			double precioEnvio, String tipoProducto, String categoriaProducto, String codigoCupon, Usuario usuario) {

		double total = calcularBaseTotal(precioBase, cantidad);

		// RADHAMES: 3era refactorizacion, no estaba retornando un valor, se asigno a la
		// variable total para que se actualice su valor al metodo aplicado
		total = calcularDescuentosBasicos(total, descuento, tieneTarjetaFidelidad, saldoTarjeta);

		total = aplicarImpuestos(total, impuestos);

		total = promocionesEspeciales(total, esOfertaEspecial, esNavidad, esMiembroVip);

		total = metodoPago(metodoPago, total);

		total = aplicarCuotas(aplicarCuotas, cuota, total);

		total = aplicarEnvio(esEnvioGratis, precioEnvio, total);

		if (codigoCupon != null && !codigoCupon.isEmpty()) {
			total = aplicarCuponDescuento(total, codigoCupon);
		}

		if (!validarProducto(tipoProducto, categoriaProducto)) {
			throw new IllegalArgumentException("El producto no es válido para esta compra.");
		}

		if (usuario != null) {
			total = aplicarDescuentoPorUsuario(usuario, total);
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
	//PABLO Se mejora metodo aplicar cuotas añadiendo un mapa para mejora la legibilidad,
	// y complejidad del codigo al eliminar condicionales
	// multiples
	private double aplicarCuotas(boolean aplicarCuotas, int cuota, double total) {
	    if (aplicarCuotas) {
	        Map<Integer, Double> factores = Map.of(
	            3, 1.1,
	            6, 1.2,
	            12, 1.3
	        );

	        total *= factores.getOrDefault(cuota, 1.0);
	    }
	    return total;
	}

	private double aplicarEnvio(boolean esEnvioGratis, double precioEnvio, double total) {

		return esEnvioGratis ? total : total + precioEnvio;
	}

	// se mejora la legibilidad, y complejidad del codigo al eliminar condicionales
	// multiples
	private double metodoPago(final String metodoPago, double total) {
		final Map<String, Double> multiplicadores = Map.of("TarjetaCredito", 1.05, "PayPal", 1.02);

		return total * multiplicadores.getOrDefault(metodoPago, 1.0);
	}

	// AITOR: imito al método "metodoPago" para mejorar legibilidad, reducir los
	// condicionales y facilitar la modificacion.
	private double aplicarCuponDescuento(double total, final String codigoCupon) {
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
		if (usuario.isEmpleado())
			return 0.7;
		if (usuario.isMiembroGold())
			return 0.85;
		if (usuario.isMiembroSilver())
			return 0.9;
		return 1.0;
	}

	private double aplicarDescuentoPorUsuario(final Usuario usuario, final double total) {
		return total * calcularDescuento(usuario);
	}

}