
package mx.com.devmoy.peliculas.excepciones;

import javax.annotation.processing.Messager;

public class AccesoADatosEx  extends Exception{
    
    public AccesoADatosEx(String mensaje){
        super(mensaje);
    }
}
