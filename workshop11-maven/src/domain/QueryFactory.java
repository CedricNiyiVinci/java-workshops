package domain;

public class QueryFactory {
    public QueryImpl getQuery(){
        return new QueryImpl("https://www.google.com/", Query.QueryMethod.GET);
    }
}
