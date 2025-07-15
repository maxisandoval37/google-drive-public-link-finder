package ar.dev.maxisandoval.googledrivepubliclinkfinder.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
@RequiredArgsConstructor
@Slf4j
public class DriveLinkChecker {

    private final DriveLinkWriter driveLinkWriter;

    public void checkLink(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            int status = connection.getResponseCode();

            if (status == 200) {
                driveLinkWriter.writeValidLink(url);
                log.info("✅ Valid URL: " + url);
            } else {
                log.info("❌ Invalid URL: " + url + " (status: " + status + ")");
            }

            connection.disconnect();
        } catch (IOException e) {
            log.warn("Error: " + url + " - " + e.getMessage());
        }
    }
}