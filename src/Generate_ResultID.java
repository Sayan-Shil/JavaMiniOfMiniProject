import java.util.Random;
import java.util.function.Supplier;

public class Generate_ResultID {
    public static Supplier<String> generateresultID = ()-> {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder resultID = new StringBuilder();
        Random random = new Random();

        // Generate a 10-character random string
        for (int i = 0; i < 10; i++) {
            resultID.append(characters.charAt(random.nextInt(characters.length())));
        }
        return resultID.toString();



    };
}
