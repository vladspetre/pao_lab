package ro.unibuc.info.service;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import ro.unibuc.info.logger.Logger;

public final class LogUtil {

  private LogUtil() {
  }

  public static void showLogsFromFile(Logger logger, String filePath)
  {
    try(BufferedReader br = Files.newBufferedReader(Paths.get(filePath)))
    {
      String line = "";
      while((line = br.readLine()) != null){
        logger.logInfo(line);
      }
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }
}
