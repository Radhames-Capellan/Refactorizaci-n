package prueba;

public class Compra {
	private double precioBase;
	private int cantidad;
	private double descuento;
	private double impuestos;
	private boolean tTarjFidelidad;
	private double saldoTarjeta;
	private boolean esOfertaEspecial;
	private boolean esNavidad;
	private boolean esMiembroVip;
	private String metodoPago;
	private boolean aplicarCuotas;
	private int cuota;
	private boolean esEnvioGratis;
	private double precioEnvio;
	private String tipoProducto;
	private String categoriaProducto;
	private String codigoCupon;
	private Usuario usuario;

	public Compra(final double precioBase, final int cantidad, final double descuento, final double impuestos,
			final boolean tTarjFidelidad, final double saldoTarjeta, final boolean esOfertaEspecial,
			final boolean esNavidad, final boolean esMiembroVip, final String metodoPago, final boolean aplicarCuotas,
			final int cuota, final boolean esEnvioGratis, final double precioEnvio, final String tipoProducto,
			final String categoriaProducto, final String codigoCupon, final Usuario usuario) {
		super();
		this.precioBase = precioBase;
		this.cantidad = cantidad;
		this.descuento = descuento;
		this.impuestos = impuestos;
		this.tTarjFidelidad = tTarjFidelidad;
		this.saldoTarjeta = saldoTarjeta;
		this.esOfertaEspecial = esOfertaEspecial;
		this.esNavidad = esNavidad;
		this.esMiembroVip = esMiembroVip;
		this.metodoPago = metodoPago;
		this.aplicarCuotas = aplicarCuotas;
		this.cuota = cuota;
		this.esEnvioGratis = esEnvioGratis;
		this.precioEnvio = precioEnvio;
		this.tipoProducto = tipoProducto;
		this.categoriaProducto = categoriaProducto;
		this.codigoCupon = codigoCupon;
		this.usuario = usuario;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}

	public boolean istTarjFidelidad() {
		return tTarjFidelidad;
	}

	public void settTarjFidelidad(boolean tTarjFidelidad) {
		this.tTarjFidelidad = tTarjFidelidad;
	}

	public double getSaldoTarjeta() {
		return saldoTarjeta;
	}

	public void setSaldoTarjeta(double saldoTarjeta) {
		this.saldoTarjeta = saldoTarjeta;
	}

	public boolean isEsOfertaEspecial() {
		return esOfertaEspecial;
	}

	public void setEsOfertaEspecial(boolean esOfertaEspecial) {
		this.esOfertaEspecial = esOfertaEspecial;
	}

	public boolean isEsNavidad() {
		return esNavidad;
	}

	public void setEsNavidad(boolean esNavidad) {
		this.esNavidad = esNavidad;
	}

	public boolean isEsMiembroVip() {
		return esMiembroVip;
	}

	public void setEsMiembroVip(boolean esMiembroVip) {
		this.esMiembroVip = esMiembroVip;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public boolean isAplicarCuotas() {
		return aplicarCuotas;
	}

	public void setAplicarCuotas(boolean aplicarCuotas) {
		this.aplicarCuotas = aplicarCuotas;
	}

	public int getCuota() {
		return cuota;
	}

	public void setCuota(int cuota) {
		this.cuota = cuota;
	}

	public boolean isEsEnvioGratis() {
		return esEnvioGratis;
	}

	public void setEsEnvioGratis(boolean esEnvioGratis) {
		this.esEnvioGratis = esEnvioGratis;
	}

	public double getPrecioEnvio() {
		return precioEnvio;
	}

	public void setPrecioEnvio(double precioEnvio) {
		this.precioEnvio = precioEnvio;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	public String getCodigoCupon() {
		return codigoCupon;
	}

	public void setCodigoCupon(String codigoCupon) {
		this.codigoCupon = codigoCupon;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
