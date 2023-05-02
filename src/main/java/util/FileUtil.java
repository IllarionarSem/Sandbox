package util;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Log4j2
public class FileUtil {
    public String fileToString(String filePath) {
        String fileContent = null;
        try {
            fileContent = FileUtils.readFileToString(
                    new File(filePath),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error("error while reading data file");
        }
        return fileContent;
    }
}
