// if interceptor wants info, it can only get what the contextobject has 
// - can have multiple context objects for interception points
public class ContextObject {
    private Movie movie;
	private Customer customer;

	public ContextObject(Movie m, Customer c) {
        this.movie = m;
        this.customer = c;
    }
 
	public String getMovieDetails() {
		return movie.getTitle();
    }
		
	public String getCustomerName() {
        return customer.getName();
    }

	public int getPrice() {
        return movie.getPriceCode();
    }
}
