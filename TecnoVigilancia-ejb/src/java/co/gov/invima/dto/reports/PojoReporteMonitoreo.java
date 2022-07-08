/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.dto.reports;

import java.io.Serializable;

/**
 *
 * @author jgutierrezme
 */
public class PojoReporteMonitoreo implements Serializable
{
    //****************************************************************
    //****************************************************************
    //****************************************************************
    private String risarh;
    private String fecha_ingreso;
    private String descripcion;
    private String fuente;
    private String detalles;
    private String aplica;
    private String nmbfuncionario;
    private String pagina_web;
    private String internet;
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    /**
     * @return the risarh
     */
    public String getRisarh() {
        return risarh;
    }

    /**
     * @param risarh the risarh to set
     */
    public void setRisarh(String risarh) {
        this.risarh = risarh;
    }

    /**
     * @return the fecha_ingreso
     */
    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    /**
     * @param fecha_ingreso the fecha_ingreso to set
     */
    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fuente
     */
    public String getFuente() {
        return fuente;
    }

    /**
     * @param fuente the fuente to set
     */
    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    /**
     * @return the detalles
     */
    public String getDetalles() {
        return detalles;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    /**
     * @return the aplica
     */
    public String getAplica() {
        return aplica;
    }

    /**
     * @param aplica the aplica to set
     */
    public void setAplica(String aplica) {
        this.aplica = aplica;
    }

    /**
     * @return the nmbfuncionario
     */
    public String getNmbfuncionario() {
        return nmbfuncionario;
    }

    /**
     * @param nmbfuncionario the nmbfuncionario to set
     */
    public void setNmbfuncionario(String nmbfuncionario) {
        this.nmbfuncionario = nmbfuncionario;
    }

    /**
     * @return the pagina_web
     */
    public String getPagina_web() {
        return pagina_web;
    }

    /**
     * @param pagina_web the pagina_web to set
     */
    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
    }

    /**
     * @return the internet
     */
    public String getInternet() {
        return internet;
    }

    /**
     * @param internet the internet to set
     */
    public void setInternet(String internet) {
        this.internet = internet;
    }
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
}
