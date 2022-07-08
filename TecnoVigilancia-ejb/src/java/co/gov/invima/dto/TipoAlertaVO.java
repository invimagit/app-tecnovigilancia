
package co.gov.invima.dto;
/**
 * Clase que mapea la tabla tecno_tipoalertas
 * @author GRUPO ASD
 */
public class TipoAlertaVO {
    
    private String cdg_tipoalertas;
    private String descripcion;

    public String getCdg_tipoalertas() {
        return cdg_tipoalertas;
    }

    public void setCdg_tipoalertas(String cdg_tipoalertas) {
        this.cdg_tipoalertas = cdg_tipoalertas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
