import com.commentremover.app.CommentProcessor;
import com.commentremover.app.CommentRemover;

import java.io.File;

public class Main {

    private static String DEFAULT_PATH = "./";

    public static void main(String[] args) throws Exception {

        String externalPath = DEFAULT_PATH;
        if (args.length > 0) {
            File path = new File(args[0]);
            if (path.exists() && path.isDirectory())
                externalPath = args[0];
        }



        CommentRemover commentRemover = new CommentRemover.CommentRemoverBuilder()
                .removeJava(true) 
                .removeJavaScript(true) 
                .removeKotlin(true)
                .removeProperties(true)
                .removeCSS(true)
                .removeXML(true)
                .removeHTML(true)
                .removeJSP(true) 
                .removeTodos(true) 
                .removeSingleLines(true) 
                .removeMultiLines(true) 
                .preserveJavaClassHeaders(false) 
                .preserveCopyRightHeaders(false) 
                .startExternalPath(externalPath)

                .build();

        CommentProcessor commentProcessor = new CommentProcessor(commentRemover);
        commentProcessor.start();

        removeTestFolders();
    }

    private static void removeTestFolders() {

    }
}
