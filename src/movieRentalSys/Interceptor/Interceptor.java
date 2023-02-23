package movieRentalSys.Interceptor;
public interface Interceptor {
    // list all interception points
    /* The Interception points are not related and should be in seperate classes,
     however in the lab JJ said that it is sufficient for this project to just have one */ 
    void interceptRentalAdd(ContextObject co);
    void interceptFrequentRenterPoints(ContextObject co);
}
