/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import co.gov.invima.entidad.TecnoPacienteTemp;
import java.util.List;
import javax.ejb.Local;
/*************************************************************************/
/*************************************************************************/
/*************************************************************************/
/**
 *
 * @author Jaime Alberto Gutiérrez Mejía
 */
/*************************************************************************/
/*************************************************************************/
/*************************************************************************/
/*************************************************************************/
/*************************************************************************/
/*************************************************************************/
@Local
public interface TecnoPacienteTempFacadeLocal 
{
    //*******************************************************************
    //*******************************************************************
    //*******************************************************************
    public void create(TecnoPacienteTemp tecnoReporteCero);
    //*******************************************************************
    //*******************************************************************
    public void edit(TecnoPacienteTemp tecnoReporteCero);
    //*******************************************************************
    //*******************************************************************
    public void remove(TecnoPacienteTemp tecnoReporteCero);
    //*******************************************************************
    //*******************************************************************
    public TecnoPacienteTemp find(Object id);
    //*******************************************************************
    //*******************************************************************
    public List<TecnoPacienteTemp> findAll();
    //*******************************************************************
    //*******************************************************************
}
/*************************************************************************/
/*************************************************************************/
/*************************************************************************/
/*************************************************************************/
/*************************************************************************/
/*************************************************************************/
