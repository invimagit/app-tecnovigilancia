
package co.gov.invima.dto;

/**
 * Clase que mapea la tabla tecno_profesion
 * @author GRUPO ASD
 */
public class ProfesionVO {
    
    private int codigo;
    private String descripcion;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
