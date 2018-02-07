import org.antlr.runtime.*;
import grammar.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Main {

    private void start() throws IOException {
        String input = "2 + 4";
        draculaLexer lexer = new draculaLexer(new ANTLRInputStream(new ByteArrayInputStream(input.getBytes("UTF-8"))));

    }

    public static void main(String[] args) {
        new Main().start();
    }

}
