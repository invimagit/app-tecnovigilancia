
package co.gov.invima.dto;

/**
 * Clase que mapea la tabla tecno_modalidad
 * @author GRUPO ASD
 */
public class ModalidadVO {
    private int  cdg_modalidad;
    private String  descripcion  ;

    public int getCdg_modalidad() {
        return cdg_modalidad;
    }

    public void setCdg_modalidad(int cdg_modalidad) {
        this.cdg_modalidad = cdg_modalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
