package com.piniponselvagem.azerolib.utils.requests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileRequest extends BaseRequest {

    @Override
    protected InputStream openStream(String path) throws IOException {
        return new FileInputStream(path);
    }
}
