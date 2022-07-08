
package co.gov.invima.dto;

/**
 * Clase que mapea la tabla CausaVO
 * @author GRUPO ASD
 */
public class CausaVO {
    
    private int cdg_causa;
    private String termino_ea;
    private String descripcion_ea;
    private boolean seleccionado=false;

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    

    public int getCdg_causa() {
        return cdg_causa;
    }

    public void setCdg_causa(int cdg_causa) {
        this.cdg_causa = cdg_causa;
    }

    public String getTermino_ea() {
        return termino_ea;
    }

    public void setTermino_ea(String termino_ea) {
        this.termino_ea = termino_ea;
    }

    public String getDescripcion_ea() {
        return descripcion_ea;
    }

    public void setDescripcion_ea(String descripcion_ea) {
        this.descripcion_ea = descripcion_ea;
    }
    
    
}
