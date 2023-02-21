import java.util.Vector;

public class Dispatcher { 
    Vector<Interceptor> interceptors;

    // register a concrete interceptor
    public void attachInterceptor(Interceptor i){
        interceptors.addElement(i);
    }

    // unregister a concrete interceptor
    public void detachInterceptor(Interceptor i){
        interceptors.removeElement(i);
    }

    public void interceptRentalAdd(ContextObject co){
        for(Interceptor i: interceptors){
            i.interceptRentalAdd(co);
        }
    }

    public void interceptFrequentRenterPoints(ContextObject co){
        for(Interceptor i: interceptors){
            i.interceptFrequentRenterPoints(co);
        }
    }
    
}
