package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReaderUtil {

    public List<HashMap<String, String>> getJasontoMap(String filepath) throws IOException {

       String jsondatafile = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();

        List<HashMap<String,String>> data = mapper.readValue(jsondatafile, new TypeReference<List<HashMap<String, String>>>() {
        });

        return data;
    }
}
