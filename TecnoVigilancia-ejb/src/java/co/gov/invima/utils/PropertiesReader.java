package co.gov.invima.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Clase que permite administrar el contenido de un archivo <code>.properties</code>.
 */
public class PropertiesReader
{

    private Locale locale = null;
    private String propertiesFile = null;
    private ResourceBundle resourceBundle = null;

    public PropertiesReader (String propertiesFile, Locale locale)
    {
        this.setLocale (locale);
        this.setPropertiesFile (propertiesFile);
        this.setResourceBundle ( ResourceBundle.getBundle(this.getPropertiesFile(), this.getLocale()) );
    }
    
    public PropertiesReader (String propertiesFile)
    {
        this (propertiesFile, Locale.getDefault());
    }
    
    public PropertiesReader ()
    {}
    
    public void setLocale (Locale locale)
    {
        this.locale = locale;    
    }
    
    public Locale getLocale ()
    {
        return this.locale;    
    }
    
    public void setPropertiesFile (String propertiesFile)
    {
        this.propertiesFile = propertiesFile;    
    }
    
    public String getPropertiesFile ()
    {
        return this.propertiesFile;    
    }
    
    public void setResourceBundle (ResourceBundle resourceBundle)
    {
        this.resourceBundle = resourceBundle;    
    }
    
    public ResourceBundle getResourceBundle ()
    {
        return this.resourceBundle;    
    }
    
    public String getProperty (String propertyName)
    {
        String propertyValue = this.getResourceBundle().getString(propertyName);
        return propertyValue;
    }
    



}
