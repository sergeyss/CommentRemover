package com.commentremover.app;

import com.commentremover.exception.CommentRemoverException;
import com.commentremover.processors.*;
import com.commentremover.utility.CommentUtility;

import java.io.IOException;

final class FileProcessRouter {


    private final CommentRemover commentRemover;
    private String currentFilePath;

    private JavaFileProcessor javaFileProcessor;
    private JavaScriptFileProcessor javaScriptFileProcessor;
    private KotlinFileProcessor kotlinFileProcessor;
    private PropertyFileProcessor propertyFileProcessor;
    private JSPFileProcessor jspFileProcessor;
    private CSSFileProcessor cssFileProcessor;
    private HTMLFileProcessor htmlFileProcessor;
    private XMLFileProcessor xmlFileProcessor;


    protected FileProcessRouter(CommentRemover commentRemover) {
        this.commentRemover = commentRemover;
        initProcessors(commentRemover);
    }

    private void initProcessors(CommentRemover commentRemover) {

        if (commentRemover.isRemoveJava()) {
            javaFileProcessor = new JavaFileProcessor(commentRemover);
        }

        if (commentRemover.isRemoveKotlin()) {
            kotlinFileProcessor = new KotlinFileProcessor(commentRemover);
        }

        if (commentRemover.isRemoveJavaScript()) {
            javaScriptFileProcessor = new JavaScriptFileProcessor(commentRemover);
        }

        if (commentRemover.isRemoveProperties()) {
            propertyFileProcessor = new PropertyFileProcessor(commentRemover);
        }

        if (commentRemover.isRemoveJSP()) {
            jspFileProcessor = new JSPFileProcessor(commentRemover);
        }

        if (commentRemover.isRemoveCSS()) {
            cssFileProcessor = new CSSFileProcessor(commentRemover);
        }

        if (commentRemover.isRemoveHTML()) {
            htmlFileProcessor = new HTMLFileProcessor(commentRemover);
        }

        if (commentRemover.isRemoveXML()) {
            xmlFileProcessor = new XMLFileProcessor(commentRemover);
        }
    }

    protected void setCurrentFilePath(String currentFilePath) {
        this.currentFilePath = currentFilePath;
    }

    protected void removeComments() throws IOException, CommentRemoverException {

        String fileExtension = CommentUtility.getExtension(currentFilePath);

        switch (fileExtension) {

            case "java":
                if (commentRemover.isRemoveJava()) {
                    javaFileProcessor.setCurrentFilePath(currentFilePath);
                    javaFileProcessor.replaceCommentsWithBlanks();
                }
                break;

            case "js":
                if (commentRemover.isRemoveJavaScript()) {
                    javaScriptFileProcessor.setCurrentFilePath(currentFilePath);
                    javaScriptFileProcessor.replaceCommentsWithBlanks();
                }
                break;

            case "kt":
                if (commentRemover.isRemoveKotlin()) {
                    kotlinFileProcessor.setCurrentFilePath(currentFilePath);
                    kotlinFileProcessor.replaceCommentsWithBlanks();
                }
                break;

            case "properties":
                if (commentRemover.isRemoveProperties()) {
                    propertyFileProcessor.setCurrentFilePath(currentFilePath);
                    propertyFileProcessor.replaceCommentsWithBlanks();
                }
                break;

            case "jsp":
                if (commentRemover.isRemoveJSP()) {
                    jspFileProcessor.setCurrentFilePath(currentFilePath);
                    jspFileProcessor.replaceCommentsWithBlanks();
                }
                break;

            case "css":
                if (commentRemover.isRemoveCSS()) {
                    cssFileProcessor.setCurrentFilePath(currentFilePath);
                    cssFileProcessor.replaceCommentsWithBlanks();
                }
                break;

            case "html":
                if (commentRemover.isRemoveHTML()) {
                    htmlFileProcessor.setCurrentFilePath(currentFilePath);
                    htmlFileProcessor.replaceCommentsWithBlanks();
                }
                break;

            case "xml":
                if (commentRemover.isRemoveXML()) {
                    xmlFileProcessor.setCurrentFilePath(currentFilePath);
                    xmlFileProcessor.replaceCommentsWithBlanks();
                }
                break;
        }
    }
}
