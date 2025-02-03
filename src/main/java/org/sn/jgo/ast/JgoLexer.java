package org.sn.jgo.ast;

public class JgoLexer {
    public static int NAME = 2;
    public static int COMMA = 3;
    public static int LBRACK = 4;
    public static int RBRACK = 5;
    public static final char EOF = (char)-1; // represent end of file char
    public static final int EOF_TYPE = 1;
    public static String[] tokenNames =
            { "n/a", "<EOF>", "NAME", "COMMA", "LBRACK", "RBRACK" };


    String input; // input string
    int p = 0;    // index into input of current character
    char c;       // current character
    public String getTokenName(int x) { return tokenNames[x]; }


    boolean isLETTER() { return c>='a'&&c<='z' || c>='A'&&c<='Z'; }

    public Token nextToken() {
        while ( c!=EOF ) {
            switch ( c ) {
                case ' ': case '\t': case '\n': case '\r': WS(); continue;
                case ',' : consume(); return new Token(COMMA, ",");
                case '[' : consume(); return new Token(LBRACK , "[");
                case ']' : consume(); return new Token(RBRACK, "]");
                default:
                    if ( isLETTER() ) return NAME();
                    throw new Error("invalid character: "+c);
            }
        }
        return new Token(EOF_TYPE,"<EOF>");
    }

    /** NAME : ('a'..'z'|'A'..'Z')+; // NAME is sequence of >=1 letter */
    Token NAME() {
        StringBuilder buf = new StringBuilder();
        do { buf.append(c); consume(); } while ( isLETTER() );
        return new Token(NAME, buf.toString());
    }

    /** WS : (' '|'\t'|'\n'|'\r')* ; // ignore any whitespace */
    void WS() {
        while ( c==' ' || c=='\t' || c=='\n' || c=='\r' ) consume();
    }

    public JgoLexer(String input) {
        this.input = input;
        c = input.charAt(p); // prime lookahead
    }

    /** Move one character; detect "end of file" */
    public void consume() {
        p++;
        if ( p >= input.length() ) c = EOF;
        else c = input.charAt(p);
    }
    /** Ensure x is next character on the input stream */
    public void match(char x) {
        if ( c == x) consume();
        else throw new Error("expecting "+x+"; found "+c);
    }


}
