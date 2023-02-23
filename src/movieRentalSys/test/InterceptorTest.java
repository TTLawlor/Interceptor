package movieRentalSys.test;

import movieRentalSys.*;
import movieRentalSys.Interceptor.*;

import org.junit.Test;

public class InterceptorTest {

    @Test
    public void testInterceptorPoints() {
        // Creating the concrete interceptor 
        ConcreteLoggerInterceptor concInterceptor = new ConcreteLoggerInterceptor();
        // Creating the dispatcher
        Dispatcher dispatcher = new Dispatcher();
        // Attaching the concrete interceptor to the dispatcher
        dispatcher.attachInterceptor(concInterceptor);

        Customer customer = new Customer("Luke");
        // Attaching the dispatcher to the customer
        customer.setDispatcher(dispatcher);

        Movie movie1 = new Movie("Puss in Boots", 1);
        Movie movie2 = new Movie("Moana", 2);
        Rental rental1 = new Rental(movie1, 7);
        Rental rental2 = new Rental(movie2, 4);

        // Calling the interception points
        customer.addRental(rental1);
        customer.htmlStatement();

        customer.addRental(rental2);
        customer.htmlStatement();

    }
}
