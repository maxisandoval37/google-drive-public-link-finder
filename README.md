# 📁 Google Drive Public Link Finder

This **Spring Boot** project generates random Google Drive folder URLs, checks if they are publicly accessible, and stores valid ones in a `valid_links.txt` file.

## Features

- Random generation of Google Drive folder IDs.
- Automatic validation using `HttpURLConnection`.
- Multithreaded execution for high performance.
- Valid link storage in plain text file.

## Technologies Used

- Java 17
- Spring Boot 3.x
- SLF4J
- Lombok
- ExecutorService (multithreading)

## 📂 Project Structure

```
src/
└── main/
    ├── java/ar/dev/maxisandoval/googledrivepubliclinkfinder/
    │   ├── DriveLinkFinderApplication.java         # Main entry point
    │   ├── service/DriveLinkService.java           # Executes multiple threads
    │   └── util/
    │       ├── DriveLinkGenerator.java             # Generates random IDs
    │       ├── DriveLinkChecker.java               # Validates URLs
    │       └── DriveLinkWriter.java                # Saves valid links to file
```

## Example Output

```
❌ Invalid URL: https://drive.google.com/drive/folders/1Jhadkg5xhn.... (status: 404)
✅ Valid URL: https://drive.google.com/drive/folders/2Jbadkq9xmn....
```

## Notes

- The project runs infinitely with `THREAD_COUNT` threads.
- You can adjust `THREAD_COUNT` in `DriveLinkService`.
- If Google starts blocking requests, consider rotating User-Agent, using a proxy, or rate limiting.

## Additional Information
For any further information or inquiries, feel free to contact: <maxisandoval98@gmail.com>

Thank you very much! 🦔

<hr>
