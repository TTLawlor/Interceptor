package movieRentalSys.test;

import movieRentalSys.*;
import movieRentalSys.Interceptor.*;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class FrequentRenterPointsTest {

    Dispatcher dispatcher;


    @Before
    public void preTest() {
        // Creating the concrete interceptor 
        ConcreteLoggerInterceptor concInterceptor = new ConcreteLoggerInterceptor();
        // Initialising the dispatcher
        dispatcher = new Dispatcher();
        // Attaching the concrete interceptor to the dispatcher
        dispatcher.attachInterceptor(concInterceptor);
    }

    @Test
    public void testRenterPointsIntercept() throws IOException {

        Customer customer = new Customer("Luke");
        // Attaching the dispatcher to the customer
        customer.setDispatcher(dispatcher);

        Movie movie1 = new Movie("Puss in Boots", 1);
        Rental rental1 = new Rental(movie1, 7);

        customer.addRental(rental1);

        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Calling the interception point
        customer.htmlStatement();
        String result = "You earned 2.0 frequent renter points from renting Puss in Boots";

        assertEquals(result, outputStream.toString().trim());

    }
}
