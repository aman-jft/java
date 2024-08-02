package org.util.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Test {
    private static final ZoneId zone = ZoneId.of("Asia/Kolkata");
    public static void main(String[] args) {
//        final String secretKey = "7061737323313233";
//        String originalString = "sEc5KNicBNMs3kCJYR9xuIXIYyqNFkbDyXOHXQngjNI=";
//        String decryptedString = Encryption.encrypt(originalString, secretKey);
//        System.out.println(decryptedString);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.ENGLISH);
        System.out.println(LocalDateTime.now().atZone(zone).format(formatter));

        DateTimeFormatter formatterNew = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

        // Parse the string into a LocalDateTime object using the formatter


//        LocalDateTime localDateTime = LocalDateTime.parse("2024-05-14T18:48:27", formatterNew);
        System.out.println(LocalDateTime.now().atZone(zone).format(formatterNew));
    }
}
