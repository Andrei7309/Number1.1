import services.TextService;
import services.impl.TextServiceImpl;


public class Main {
    public static void main(String[] args) {
        TextServiceImpl textService = new TextService();
        textService.countAndFrequencySymbol();
    }
}