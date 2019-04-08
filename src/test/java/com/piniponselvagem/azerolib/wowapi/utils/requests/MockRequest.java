package com.piniponselvagem.azerolib.wowapi.utils.requests;

import com.piniponselvagem.azerolib.utils.requests.BaseRequest;

import java.io.*;
import java.net.URL;

public class MockRequest extends BaseRequest {
    private int count = 0;

    @Override
    protected InputStream openStream(String url) throws IOException {
        return getContentFromFileOrDownloadFrom(url);
    }



    private InputStream getContentFromFileOrDownloadFrom(String url) throws IOException {
        final String fileName = convertUrlToFilename(url);
        final String dir = System.getProperty("user.dir")+"\\mock_files\\";

        File file = new File(dir+fileName);
        if (file.exists()) {
            System.out.println("Mock requesting..." + ++count);
            System.out.println("   > Reading file from: " + dir+fileName);
            return new FileInputStream(new File(dir+fileName));
        }

        InputStream in = new URL(url).openStream();
        saveToFile(in, dir, fileName);

        System.out.println("Requesting..." + ++count);
        System.out.println("   > File downloaded to: " + dir+fileName);

        return new FileInputStream(dir+fileName);
    }

    private void saveToFile(InputStream in, String dir, String fileName) throws IOException {
        new File(dir).mkdirs();     //DO NOT DELETE THIS LINE, create directory if dosent exist
        OutputStream out = new FileOutputStream(new File(dir+fileName));

        int read;
        byte[] bytes = new byte[1024];

        while ((read = in.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
    }

    private String convertUrlToFilename(String url) {
        String formattedUrl = url
                .replace("http://", "")
                .replace("https://", "")
                .replace("www", "")
                .replace("/", "")
                .replace("-", "")
                .replace("?", "")
                .replace("&", "")
                .replace("=", "")
                .replace(",", "")
                .replace(".", "");
        
        formattedUrl = formattedUrl
                .substring(0, formattedUrl.lastIndexOf("access"))
                .concat(".json");

        return formattedUrl.substring(0, Math.min(formattedUrl.length(), 100));
    }
}
