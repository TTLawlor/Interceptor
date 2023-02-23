package movieRentalSys.Interceptor;
import java.util.Vector;

public class Dispatcher { 
    Vector<Interceptor> interceptors;
  
    public Dispatcher() {
        interceptors = new Vector<>();
    }

    // register a concrete interceptor
    public void attachInterceptor(Interceptor i){
        interceptors.addElement(i);
    }

    // unregister a concrete interceptor
    public void detachInterceptor(Interceptor i){
        interceptors.removeElement(i);
    }

    public void dispatchRentalAdd(ContextObject co){
        for(Interceptor i: interceptors){
            i.interceptRentalAdd(co);
        }
    }

    public void dispatchFrequentRenterPoints(ContextObject co){
        for(Interceptor i: interceptors){
            i.interceptFrequentRenterPoints(co);
        }
    }
    
}
