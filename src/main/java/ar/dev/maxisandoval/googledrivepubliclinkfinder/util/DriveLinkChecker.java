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

    public void checkLink(String url, String id) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url.concat(id)).openConnection();
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            int status = connection.getResponseCode();

            if (status == 200) {
                log.info("✅ URL válida: " + url);
            } else {
                log.info("❌ URL inválida: " + url + " (status: " + status + ")");
            }

            connection.disconnect();
        } catch (IOException e) {
            log.warn("Error al verificar: " + url + " - " + e.getMessage());
        }
    }
}