public class Application {
    public static void main(String[] args) {
        
        ConcreteInterceptor concInterceptor = new ConcreteInterceptor();
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.attachInterceptor(concInterceptor);

        Customer customer = new Customer("Luke");
        customer.setDispatcher(dispatcher);
        Movie movie1 = new Movie("Puss in Boots", 1);
        Movie movie2 = new Movie("Moana", 2);
        Rental rental1 = new Rental(movie1, 7);
        Rental rental2 = new Rental(movie2, 4);

        customer.addRental(rental1);
        customer.htmlStatement();

        customer.addRental(rental2);
        customer.htmlStatement();

    }
}
