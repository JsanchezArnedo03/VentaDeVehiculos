package entidades;


import java.sql.Date;

/*
1. Reporte de los vehículos comprados en un rango de fecha
2. Reporte de los vehículos vendidos en un rango de fecha (general y por agente)
3. Reporte de ganancia por ventas de los vehículos usados
4. Reporte de la marca de vehículo que mas se compra y vende.*/
public class IdeasDeinformes {

    private int id;
    private Date FechaDeCompra;
    private Date FechaDeVenta;
    private String documentoVendedor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaDeCompra() {
        return FechaDeCompra;
    }

    public void setFechaDeCompra(Date FechaDeCompra) {
        this.FechaDeCompra = FechaDeCompra;
    }

    public Date getFechaDeVenta() {
        return FechaDeVenta;
    }

    public void setFechaDeVenta(Date FechaDeVenta) {
        this.FechaDeVenta = FechaDeVenta;
    }

    public String getDocumentoVendedor() {
        return documentoVendedor;
    }

    public void setDocumentoVendedor(String documentoVendedor) {
        this.documentoVendedor = documentoVendedor;
    }

}
