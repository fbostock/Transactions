package transactions.omswriters;

import com.google.common.base.Joiner;
import transactions.DecoratedTransaction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class OMSFileWriter {

    private final File file;
    private final String delimiter;

    public OMSFileWriter(File file, String delimiter) {
        this.file = file;
        this.delimiter = delimiter;
    }

    public abstract void write(DecoratedTransaction transaction) throws IOException;


    protected void write(List<Object> contents) throws IOException {
        write(contents, true);
    }

    protected void write(List<?> contents, boolean append) throws IOException {
        write(contents, append, true);
    }

    protected void write(List<?> contents, boolean append, boolean newline) throws IOException {
        String toWrite = Joiner.on(delimiter).join(contents);
        try (FileWriter writer = new FileWriter(file, append)) {
            writer.write(toWrite + (newline ? System.lineSeparator() : ""));
        } catch (IOException e) {
            System.out.println("Failed to write contents:" + toWrite);
            throw e;
        }
    }

    protected void writeHeaders(List<String> headers) throws IOException {
        write(headers, false);
    }
}
