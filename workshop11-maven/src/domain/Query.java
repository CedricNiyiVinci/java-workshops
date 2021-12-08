package domain;

public interface Query {


    QueryMethod getTypeQuery();

    String getUrlRequete();

    public enum QueryMethod{

        POST, GET;

    }

}
