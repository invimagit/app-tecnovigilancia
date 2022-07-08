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
import co.gov.invima.entidad.TecnoEvaluacionCasoTemp;
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
public interface TecnoEvaluacionCasoTempFacadeLocal 
{
    //*******************************************************************
    //*******************************************************************
    //*******************************************************************
    public void create(TecnoEvaluacionCasoTemp tecnoReporteCero);
    //*******************************************************************
    //*******************************************************************
    public void edit(TecnoEvaluacionCasoTemp tecnoReporteCero);
    //*******************************************************************
    //*******************************************************************
    public void remove(TecnoEvaluacionCasoTemp tecnoReporteCero);
    //*******************************************************************
    //*******************************************************************
    public TecnoEvaluacionCasoTemp find(Object id);
    //*******************************************************************
    //*******************************************************************
    public List<TecnoEvaluacionCasoTemp> findAll();
    //*******************************************************************
    //*******************************************************************
}
/*************************************************************************/
/*************************************************************************/
/*************************************************************************/
/*************************************************************************/
/*************************************************************************/
/*************************************************************************/
