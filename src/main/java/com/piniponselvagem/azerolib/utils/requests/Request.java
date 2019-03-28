package com.piniponselvagem.azerolib.utils.requests;

import java.io.IOException;

public interface Request {
    Iterable<String> getLines(String url) throws IOException;
}
