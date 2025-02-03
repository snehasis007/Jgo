package org.sn.jgo.ast;

import java.util.List
        ;

public final class JgoParser {

    public static void parseEntry(String source){
        int parseCnt = 0;
        char[] tokens = source.toCharArray();
        source.chars().filter(p-> p!='\n').forEach(ch->{
            System.out.print((char)ch);
        });
//        while (true){
//
//        }

    }
}
