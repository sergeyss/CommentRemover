import com.commentremover.app.CommentProcessor;
import com.commentremover.app.CommentRemover;
import com.commentremover.exception.CommentRemoverException;

public class Main {
    public static void main(String[] args) throws CommentRemoverException {

        // example for externalPath

        CommentRemover commentRemover = new CommentRemover.CommentRemoverBuilder()
                .removeJava(true) // Remove Java file Comments....
                .removeJavaScript(true) // Remove JavaScript file Comments....
                .removeKotlin(true)
                .removeProperties(true)
                .removeCSS(true)
                .removeXML(true)
                .removeHTML(true)
                .removeJSP(true) // etc..
                .removeTodos(true) // Remove todos
                .removeSingleLines(true) // Do not remove single line type comments
                .removeMultiLines(true) // Remove multiple type comments
                .preserveJavaClassHeaders(false) // Preserves class header comment
                .preserveCopyRightHeaders(false) // Preserves copyright comment
                .startExternalPath("/Users/vlad/IdeaProjects/crs-system")// Give it full path for external directories
                //.setExcludePackages(new String[]{"src.main.java.model"}) // Refers to /Users/user/Projects/MyOtherProject/src/main/java/model and skips this directory.
                .build();

        CommentProcessor commentProcessor = new CommentProcessor(commentRemover);
        commentProcessor.start();
    }
}
