package services;

import services.impl.TextServiceImpl;

import java.io.IOException;

public class TextService implements TextServiceImpl {

    @Override
    public void countAndFrequencySymbol() {
        int number = (int) (Math.random() * 100);
        String url = "http://numbersapi.com/" + number + "/trivia";
        String response;
        TextProvider textProvider = new TextProvider();
        try {
            response = textProvider.textProvider(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TextUtils textUtils = new TextUtils();
        Logger logger1 = new Logger();
        logger1.print(response, textUtils.countChars(response));

    }
}
