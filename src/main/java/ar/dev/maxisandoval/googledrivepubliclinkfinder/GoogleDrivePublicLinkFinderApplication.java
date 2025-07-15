package ar.dev.maxisandoval.googledrivepubliclinkfinder;

import ar.dev.maxisandoval.googledrivepubliclinkfinder.service.DriveLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class GoogleDrivePublicLinkFinderApplication implements CommandLineRunner {

    private final DriveLinkService driveLinkService;

    public static void main(String[] args) {
        SpringApplication.run(GoogleDrivePublicLinkFinderApplication.class, args);
    }

    @Override
    public void run(String... args) {
        driveLinkService.startLinkSearchLoop();
    }

}