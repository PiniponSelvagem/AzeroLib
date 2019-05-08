package com.piniponselvagem.azerolib.utils.requests;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HttpRequest extends BaseRequest {

    private int count;

    @Override
    protected InputStream openStream(String url) throws IOException {
        System.out.println("HTTP request: "+ ++count);
        return new URL(url).openStream();
    }
}
