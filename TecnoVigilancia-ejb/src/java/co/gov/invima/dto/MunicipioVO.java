
package co.gov.invima.dto;

/**
 * Clase que mapea la tabla municipio
 * @author GRUPO ASD
 */
public class MunicipioVO {
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    private String descripcion;
}
