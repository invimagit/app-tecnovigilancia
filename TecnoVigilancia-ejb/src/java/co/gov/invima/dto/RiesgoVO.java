
package co.gov.invima.dto;

/**
 * Clase que mapea la tabla tecno_riesgo
 * @author GRUPO ASD
 */
public class RiesgoVO {
    private String cdg_riesgo; 
    private String descripcion;

    public String getCdg_riesgo() {
        return cdg_riesgo;
    }

    public void setCdg_riesgo(String cdg_riesgo) {
        this.cdg_riesgo = cdg_riesgo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
