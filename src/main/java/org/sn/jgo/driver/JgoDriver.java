package org.sn.jgo.driver;

import java.util.logging.Logger;

public final class JgoDriver {
    private final static Logger logger = Logger.getLogger("Jgo");
    public static void main(String[] args) {
        if(args !=null && args.length >0){
            logger.info("arguments received"+ args[0]);
        }
    }
}
