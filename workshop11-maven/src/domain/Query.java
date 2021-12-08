package domain;

public class Query {

    private String urlRequete;
    private QueryMethod typeQuery;

    public Query(String urlRequete, QueryMethod typeQuery) {
        this.urlRequete = urlRequete;
        this.typeQuery = typeQuery;
    }

    public enum QueryMethod{

        POST, GET;

    }

    public String getUrlRequete() {
        return urlRequete;
    }

    public QueryMethod getTypeQuery() {
        return typeQuery;
    }
}
