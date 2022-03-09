import com.commentremover.app.CommentProcessor;
import com.commentremover.app.CommentRemover;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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
                //.setExcludePackages(new String[]{"src.main.java.model"}) // Refers to /Users/user/Projects/MyOtherProject/src/main/java/model and skips this directory.
                .build();

        CommentProcessor commentProcessor = new CommentProcessor(commentRemover);
        //commentProcessor.start();

        removeTestFolders(externalPath);
    }

    private static void removeTestFolders(String path) throws IOException {
        Files.walk(new File(path).toPath())
                .filter(file -> file.toFile().isDirectory() && file.getFileName().toString().equals("test"))
                .forEach(file -> {
                    try {
                        deleteRecursively(file.toFile());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    private static void deleteRecursively(File file) throws IOException {
        File[] files = file.listFiles();
        if (file.isDirectory() && files != null && files.length > 0) {
            for (File fileInDirectory : files)
                deleteRecursively(fileInDirectory);
            file.delete();
        } else
            file.delete();
    }
}
