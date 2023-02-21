public interface Interceptor {
    //list all interception points
    String interceptRentalAdd(ContextObject co);
    String interceptFrequentRenterPoints(ContextObject co);
}
