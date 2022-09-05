import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestTask {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        String path = "http://numbersapi.com/" + randomNumber + "/trivia";
        URL url = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String responce = bufferedReader.readLine();
        System.out.println(responce);

        char[] chars = responce.toCharArray();

        Map<String, Integer> result = new HashMap<>();
        for (char c: chars) {
            String character = "\'"+ c + "\'";
            if (result.containsKey(character)) {
                Integer count = result.get(character);
                result.put(character, count + 1);
            } else {
                result.put(character, 1);
            }
        }
        System.out.println(result);
    }
}
