package ar.dev.maxisandoval.googledrivepubliclinkfinder.service;

import ar.dev.maxisandoval.googledrivepubliclinkfinder.util.DriveLinkChecker;
import ar.dev.maxisandoval.googledrivepubliclinkfinder.util.DriveLinkGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class DriveLinkService {

    private final DriveLinkGenerator generator;
    private final DriveLinkChecker checker;
    private static final int THREAD_COUNT = 20;

    public void startLinkSearchLoop() {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            executor.submit(() -> {
                while (true) {
                    String id = generator.generateRandomId(33);
                    String url = "https://drive.google.com/drive/folders/" + id;
                    checker.checkLink(url, id);
                }
            });
        }
    }
}