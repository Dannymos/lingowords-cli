package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Word;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class WordSubmissionService {

    private String url;

    private HttpClient httpClient;

    public WordSubmissionService() {
        this.url = "http://localhost/word";
        this.httpClient = HttpClientBuilder.create().build();
    }

    public void submitWord(Word word) {
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-type", "application/json");
            ObjectMapper mapper = new ObjectMapper();

            String jsonString = mapper.writeValueAsString(word);
            StringEntity jsonStringEntity = new StringEntity(jsonString);

            httpPost.setEntity(jsonStringEntity);
            HttpResponse response = httpClient.execute(httpPost);

            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Error occurred when sending: " + word.getText());
        }

    }
}
