package server;

import domain.Query;
import jdk.swing.interop.SwingInterOpUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.net.http.HttpClient;

public class QueryHandler extends Thread {
    private Query requeteSurHTTPClient;

    public QueryHandler(Query requeteSrHTTPClient) {
        this.requeteSurHTTPClient = requeteSrHTTPClient;
    }

    //
    @Override
    public void run() {
        //non necessaire : super.run();
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {//Pourquoi créer un objet CloseableClient? obligation de la dependance QuickStart
            if (this.requeteSurHTTPClient.getTypeQuery() == Query.QueryMethod.GET) {
                Thread.sleep(10000); //Endormir le thread pour comprendre le multiThreading
                HttpGet httpGet = new HttpGet(this.requeteSurHTTPClient.getUrlRequete());
                try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
                    System.out.println(response1.getCode() + " " + response1.getReasonPhrase()); // renvoie le status code
                    HttpEntity entity1 = response1.getEntity();// Contient le corps de la réponse
                    //EntityUtils.toString(entity1) renvoie une String et pour pouvoir renvoyer cette string
                    //dans stdout j'utilise sout
                    System.out.println(EntityUtils.toString(entity1)); //Renvoie le corps de la reponse
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
                } else if (this.requeteSurHTTPClient.getTypeQuery() == Query.QueryMethod.POST) {
                System.out.println("Requete POST non gérer à ce stade");
            }
        } catch (IOException | InterruptedException e) {
        e.printStackTrace();
        }

    }
}
