package domain;

class QueryImpl implements Query {

    private String urlRequete;
    private QueryMethod typeQuery;

    public QueryImpl(String urlRequete, QueryMethod typeQuery) {
        this.urlRequete = urlRequete;
        this.typeQuery = typeQuery;
    }

    public String getUrlRequete() {
        return urlRequete;
    }

    public QueryMethod getTypeQuery() {
        return typeQuery;
    }
}
