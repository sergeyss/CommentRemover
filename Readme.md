# CommentRemover

CommentRemover is a source code comment removing library for Java&trade; 7 and above.<br><br>
It also supports JavaScript , HTML , CSS , Properties , JSP and XML Comments.

# Requirements CommentRemover

Projects that include CommentRemover need to target Java 1.7 at minimum.

# Installation - Maven
In your `pom.xml`, you must add **Repository** and **Dependency** for **CommentRemover**. 

```xml
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
	
	<dependency>
    	    <groupId>com.github.ertugrulcetin</groupId>
    	    <artifactId>CommentRemover</artifactId>
    	    <version>v1.0</version>
    </dependency>
    	
```

# Standalone

CommentRemover does _not_  depend on any libraries, you can easily add it as standalone .jar to your classpath.


# Usage

~~~~~ java

public class Test {
    
 public static void main(String[] args) {
        
 //root dir is: /Users/user/JavaProject/MyProject
    
 CommentRemover commentRemover = new CommentRemover.CommentRemoverBuilder()
                .removeJava(true) //Remove Java file Comments....
                .removeJavaScript(true) //Remove JavaScript file Comments....
                .removeJSP(true) ..
                .removeTodos(false) // Do Not Touch Todos (leave them alone)
                .removeSingleLines(true) //Remove single line type comments
                .removeMultiLines(true) //Remove multiple type comments
                .startInternalPath("") // leave it empty string when you want to start to root dir
                .setExcludePackages(new String[]{"src.main.java.app.pattern"}) // rootDir/src/main/java/app/pattern skip this directory
                .build();
        }
}



~~~~~