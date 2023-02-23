package movieRentalSys;
import java.util.ArrayList;
import java.util.List;

import movieRentalSys.Interceptor.ContextObject;
import movieRentalSys.Interceptor.Dispatcher;

public class Customer {

    private String _name;
    private List<Rental> _rentals = new ArrayList<Rental>();
    private Dispatcher dispatcher;

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);

        // Creating a context object passing the current rental and this customer object
        ContextObject contextObject = new ContextObject(arg, this);
        // Calling the dispatcher passing the context object for the concrete interceptor
        dispatcher.dispatchRentalAdd(contextObject);
    }

    public String getName() {
        return _name;
    }

    public void setDispatcher(Dispatcher d){
        this.dispatcher = d;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each: _rentals) {
            
            // show figures for each rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";

        return result;
    }

    public String htmlStatement() {
        String result = "<H1>Rental Record for <EM>" + getName() + "</EM></H1><P>\n";
        

        for (Rental each: _rentals) {
            // Creating a context object passing the current rental and this customer object
            ContextObject contextObject = new ContextObject(each, this);
            // Calling the dispatcher passing the context object for the concrete interceptor
            dispatcher.dispatchFrequentRenterPoints(contextObject);
            // show figures for each rental
            result += "\t" + each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
        }

        // add footer lines
        result += "<P>Amount owed is <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "You earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";

        return result;
    }

    private double getTotalCharge(){

        double result = 0;
       
        for (Rental each: _rentals) {
        result += each.getCharge();
        }
        return result;
    } 

    private double getTotalFrequentRenterPoints(){

        double result = 0;
       
        for (Rental each: _rentals) {
        result += each.getFrequentRenterPoints();
        }
        return result;
    } 

}