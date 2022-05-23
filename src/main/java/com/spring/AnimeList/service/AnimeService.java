package com.spring.AnimeList.service;

import com.spring.AnimeList.model.AnimeTitle;
import com.spring.AnimeList.utils.Utils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

@Service    // Creates a Spring Service
public class AnimeService {
    private static final String URL = "https://raw.githubusercontent.com/nestor94/animender/master/data/anime.csv";
    private List<AnimeTitle> animeList = new ArrayList<>();

    // This should sort by name
    public List<AnimeTitle> getAnimeList() {
        return animeList.subList(0, 50);
    }


    // Apache dep HTTP Client Code
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet(URL);
    CloseableHttpResponse response;

    @PostConstruct  // Spring will execute the method annotated with this as soon as the Class in instantiated
    @Scheduled(cron = "* * 1 * * *")
    public void fetchData() throws IOException {
        try {
            response = httpclient.execute(httpGet);
            List<AnimeTitle> localAnimeList = new ArrayList<>();
            // Convert InputStream to Reader type
            Reader csvReader = new InputStreamReader(response.getEntity().getContent());
            // Using Apache commons-csv to parse csv
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
            for (CSVRecord record : records) {
                AnimeTitle animeTitle = new AnimeTitle();
                try {
                animeTitle.setId(parseInt(record.get("anime_id")));
                animeTitle.setName(record.get("name"));
                animeTitle.setGenre(record.get("genre"));
                animeTitle.setType(record.get("type"));
                animeTitle.setEpisodes(parseInt(record.get("episodes")));
                animeTitle.setRating(parseFloat(record.get("rating")));
                animeTitle.setMembers(parseLong(record.get("members")));

                } catch (NumberFormatException ignored) {
                    // Swallowing error
                }
                localAnimeList.add(animeTitle);
            }
            this.animeList = localAnimeList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            response.close();
        }

    }
}
