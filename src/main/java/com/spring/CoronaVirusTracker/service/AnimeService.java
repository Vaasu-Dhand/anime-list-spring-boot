package com.spring.CoronaVirusTracker.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;
import sun.net.www.http.HttpClient;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service    // Creates a Spring Service
public class AnimeService {
    private static final String URL = "https://raw.githubusercontent.com/nestor94/animender/master/data/anime.csv";

    // Apache dep HTTP Client Code
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet(URL);
    CloseableHttpResponse response;

    @PostConstruct  // Spring will execute the method annotated with this as soon as the Class in instantiated
    public void fetchData() throws IOException {
        try {
            response = httpclient.execute(httpGet);
            System.out.println(response.getStatusLine());
            HttpEntity entity1 = response.getEntity();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            response.close();
        }

    }
}
