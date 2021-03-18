package ru.itis.conferences.services.impl;

import org.springframework.stereotype.Service;
import ru.itis.conferences.models.Feedback;
import ru.itis.conferences.services.TelegramService;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

@Service
public class TelegramServiceImpl implements TelegramService {

    @Override
    public void sendMessageForFeedback(Feedback feedback){
        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
        String apiToken = "1228560165:AAGTUrCaDrVyW-d7OXM1tWhkfJ8IUC4uF4c";
        String chatId = "@feedback_for_BulSchool";
        String text = feedback.toString();
        urlString = String.format(urlString, apiToken, chatId, text);
        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            StringBuilder sb = new StringBuilder();
            InputStream is = new BufferedInputStream(conn.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
