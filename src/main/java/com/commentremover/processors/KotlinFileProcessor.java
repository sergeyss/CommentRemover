package com.commentremover.processors;

import com.commentremover.app.CommentRemover;

public class KotlinFileProcessor extends JavaFileProcessor {

    public KotlinFileProcessor(CommentRemover commentRemover) {
        super(commentRemover);
    }
}
