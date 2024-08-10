package org.sn.jgo.driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public final class JgoDriver {
    private final static Logger logger = Logger.getLogger("Jgo");
    public static void main(String[] args) {
//        if(args !=null && args.length >0){
//            logger.info("arguments received"+ args[0]);
//
//        }
        try{
            readSourceFiles("./sourcefiles");
        }catch (IOException e){

        }
    }

    private static void readSourceFiles(String path) throws IOException{
        Path srcs = Path.of(path);
        //logger.info(srcs.toString());
        Files.walk(srcs).filter(Files::isRegularFile).distinct().forEach((Path p)->{
            try{
                if( p.toFile().getName().endsWith(".jgo")){
                    BufferedReader fs = Files.newBufferedReader(p);
                    //List<String> sourceBuilder = new ArrayList<>();
                    StringBuilder source = new StringBuilder();
                    fs.lines().forEach((String s)->{
                       //String[] st= s.split(JgoDriverConstants.whitespace_charclass);
                        source.append(s);
                        source.append('\n');
                       // sourceBuilder.addAll(Arrays.asList(st));
//                        Arrays.asList(st).forEach((String sd)->{
//                            logger.info(sd);
//                        });

                    });
                }

            } catch (Exception e) {

            }
        });
    }
}
