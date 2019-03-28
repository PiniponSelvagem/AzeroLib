package com.piniponselvagem.azerolib.utils.requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRequest implements Request {

    @Override
    final public Iterable<String> getLines(String url) throws IOException {
        List<String> lines = new ArrayList<>();

        try(InputStream is = openStream(url)) {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }

    protected abstract InputStream openStream(String url) throws IOException;
}
