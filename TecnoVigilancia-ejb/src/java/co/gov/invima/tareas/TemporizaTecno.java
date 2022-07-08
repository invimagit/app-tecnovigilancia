/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.tareas;

import co.gov.invima.dao.TecnoAreasFacadeLocal;
import co.gov.invima.entidad.TecnoAreas;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import org.apache.log4j.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

/**
 *
 * @author mgualdrond
 */
@Stateless
public class TemporizaTecno implements TemporizaTecnoLocal {

    private static final Logger logEJBTecno = Logger.getLogger(TemporizaTecno.class.getName()); 
    @EJB
    private TecnoAreasFacadeLocal tecnoAreasDAO;
    
    /** Injección del TimerService */  
    @Resource TimerService timerService;  
      
    /** Hora de ejecución: 23 horas */  
    private static final int START_HOUR = 8;  
  
    /** Minutos de ejecución: 0 minutos */  
    private static final int START_MINUTES = 0;  
      
    /** Segundos de ejecución: 00  */  
    private static final int START_SECONDS = 0;  
      
    /** Intervalo de la ejecución: 1440 = 24 horas */  
    private static final int INTERVAL_IN_MINUTES = 1;  
      
    /** 
     * Levanta el servicio  
     */  
    @Override
    public void startUpTimer() {  
  
        //logEJBTecno.info("startUpTimer - alarm scheduler service is active.");  
          
        shutDownTimer();  
          
        Calendar initialExpiration = Calendar.getInstance();  
        initialExpiration.set(Calendar.HOUR_OF_DAY, START_HOUR );  
        initialExpiration.set(Calendar.MINUTE, START_MINUTES);  
        initialExpiration.set(Calendar.SECOND, START_SECONDS);  
          
        long intervalDuration = new Integer(INTERVAL_IN_MINUTES).longValue()*60*1000;  
          
        //logEJBTecno.info("startUpTimer - create new timer service at \""+initialExpiration.getTime()+"\", with \""+intervalDuration+"\" interval in milis.");  
        timerService.createTimer(initialExpiration.getTime(),intervalDuration,null);  
          
    }  
      
    /** 
     * Para el servicio  
     */  
    @Override
    public void shutDownTimer() {  
        Collection<Timer> timers = timerService.getTimers();  
        //logEJBTecno.info("shutDownTimer - existing timers? " + timers);  
        if (timers != null)  
        {  
            for (Timer t : timers) {
                t.cancel();
                //logEJBTecno.info("shutDownTimer - timer \""+t+"\" canceled.");
            }  
        }  
    }  
      
    /** 
     *  método callback que se invocará al terminar el intervalo definido 
     * @param timer
     */  
    @Timeout  
    public void execute(Timer timer)  
    {  
        //logEJBTecno.info("executing - " + timer.getInfo());  
          
        // TODO: implementar la lógica del proceso de alarmas.
        List<TecnoAreas> areas = tecnoAreasDAO.findAll();
    }  
}
