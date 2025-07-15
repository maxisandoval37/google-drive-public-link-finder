package ar.dev.maxisandoval.googledrivepubliclinkfinder.util;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Component
@Slf4j
public class DriveLinkWriter {

    private static final String FILE_PATH = "valid_links.txt";

    public synchronized void writeValidLink(String url) {
        try (FileWriter fw = new FileWriter(FILE_PATH, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            out.println(url);
        } catch (IOException e) {
            log.error("Error al escribir en archivo: " + e.getMessage());
        }
    }
}