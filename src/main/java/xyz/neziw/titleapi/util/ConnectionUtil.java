package xyz.neziw.titleapi.util;

import lombok.Getter;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ConnectionUtil {

    @Getter
    private String output;

    public ConnectionUtil(String url) {
        try {
            URLConnection connection = (new URL(url)).openConnection();
            connection.setRequestProperty("User-Agent", "TitleAPI");
            connection.setDoOutput(true);
            Scanner scanner = new Scanner(connection.getInputStream());
            if(scanner.hasNext()) {
                this.output = scanner.nextLine();
            } else {
                this.output = null;
            }
        } catch (IOException exception) {
            exception.printStackTrace();
            this.output = null;
        }
    }
}
