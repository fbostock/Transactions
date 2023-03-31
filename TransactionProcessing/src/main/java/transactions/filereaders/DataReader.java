package transactions.filereaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataReader {
    protected final Map<String, Integer> headerMap = new HashMap<>();
    protected List<List<String>> data = new ArrayList<>();

    public DataReader(File file) throws IOException {
        try (FileReader reader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            List<String> lines = bufferedReader.lines().toList();
            String[] headerItems = lines.get(0).split(",");
            for (int i = 0; i < headerItems.length; i++) {
                String headerItem = headerItems[i];
                headerMap.put(headerItem, i);
            }

            for (int i = 1; i < lines.size(); i++) {
                data.add(Arrays.asList(lines.get(i).split(",")));
            }
        } catch (IOException e) {
            System.out.println("Error reading file " + file);
            throw e;
        }

    }

    public int getSize() {
        return data.size();
    }

}
