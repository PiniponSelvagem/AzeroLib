package com.piniponselvagem.azerolib.utils.requests;

import java.io.IOException;
import java.io.InputStream;

public class ResourceRequest extends BaseRequest {

    @Override
    protected InputStream openStream(String path) throws IOException {
        return ClassLoader.getSystemResource(path).openStream();
    }
}
