package movieRentalSys.Interceptor;
import java.util.Vector;

public class Dispatcher { 
    Vector<ILoggerInterceptor> interceptors;
  
    public Dispatcher() {
        interceptors = new Vector<>();
    }

    // register a concrete interceptor
    public void attachInterceptor(ILoggerInterceptor i){
        interceptors.addElement(i);
    }

    // unregister a concrete interceptor
    public void detachInterceptor(ILoggerInterceptor i){
        interceptors.removeElement(i);
    }

    public void dispatchRentalAdd(ContextObject co){
        //interate through all interceptors and call
        for(ILoggerInterceptor i: interceptors){
            i.interceptRentalAdd(co);
        }
    }

    public void dispatchFrequentRenterPoints(ContextObject co){
        //interate through all interceptors and call
        for(ILoggerInterceptor i: interceptors){
            i.interceptFrequentRenterPoints(co);
        }
    }
    
}
