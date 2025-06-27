package edu.wgu.d387_sample_code.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class TimeZoneController {

    @GetMapping("/presentation")
    public String[] getPresentationTimes() {
        String[] dateTimes = new String[3];

        Thread etThread = new Thread(() -> {
            String dateTime = TimeZoneConversion.convertTime("America/New_York");
            dateTimes[0] = "ET: " + dateTime;
        });

        Thread mtThread = new Thread(() -> {
            String dateTime = TimeZoneConversion.convertTime("America/Denver");
            dateTimes[1] = "MT: " + dateTime;
        });

        Thread utcThread = new Thread(() -> {
            String dateTime = TimeZoneConversion.convertTime("UTC");
            dateTimes[2] = "UTC: " + dateTime;
        });

        etThread.start();
        mtThread.start();
        utcThread.start();

        try {
            etThread.join();
            mtThread.join();
            utcThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return new String[]{"Error retrieving time zones."};
        }

        return dateTimes;
    }
}