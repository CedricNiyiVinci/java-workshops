import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import server.ProxyServer;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ProxyServer p = new ProxyServer();

        p.startServer();

    }
}

