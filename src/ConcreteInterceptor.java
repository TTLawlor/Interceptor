public class ConcreteInterceptor implements Interceptor {

    @Override
    public String interceptFrequentRenterPoints(ContextObject co) {
        return co.getCustomerName() + " rented " 
        + co.getMovieDetails() 
        +" for £" + co.getPrice();
    }

    @Override
    public String interceptRentalAdd(ContextObject co) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
