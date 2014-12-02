package com.serli.tp.io;

import com.google.common.base.Preconditions;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CountInputStream extends FilterInputStream {
    protected CountInputStream(InputStream in) {
        super(in);
    }

    private int count = 0;

    @Override
    public int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            count++;
        }
        return read;
    }

    @Override
    public int read(byte[] b) throws IOException {
        int read = super.read(b);
        if(read != -1){
            count += read;
        }
        return read;
    }


    public int getCount() {
        return count;
    }
}
