package movieRentalSys.test;

import movieRentalSys.*;
import movieRentalSys.Interceptor.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class RentalAddTest {

    Dispatcher dispatcher;
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


    @Before
    public void preTest() {
        // Creating the concrete interceptor 
        ConcreteLoggerInterceptor concInterceptor = new ConcreteLoggerInterceptor();
        // Initialising the dispatcher
        dispatcher = new Dispatcher();
        // Attaching the concrete interceptor to the dispatcher
        dispatcher.attachInterceptor(concInterceptor);
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testRentalAddIntercept() {

        Customer customer = new Customer("Luke");
        // Attaching the dispatcher to the customer
        customer.setDispatcher(dispatcher);

        Movie movie1 = new Movie("Puss in Boots", 1);
        Rental rental1 = new Rental(movie1, 7);

        // Calling the interception point
        customer.addRental(rental1);

        String result = "Luke rented Puss in Boots for £21.0 and 7.0 days";

        assertEquals(result, outputStream.toString().trim());

    }
}
