# FileExplorer
## Daily Java Project for: 5/11/2020

### Description:
Simple implementation of a file explorer. Can display the files and folders within a directory or the contents of a readable file.

### Daily Java Projects
I'm creating a small Java project each day to help me learn Java. These aren't rigorously tested, but instead exist just so I can get a better understanding of some portion of Java.

### Points of Interest

+ I think I've been overusing methods that print things, instead I should just return the string and let the user print it if they want.
+ Got better at throwing exceptions for errors
+ Noticed you seem to need a constructor even if it's not accepting arguments or doing anything 

### Using `FileExplorer`

+ Example: Showing the contents of this directory and displaying the contents of `README.md`

```
public class Parent {
    public static void main(String args[]) {
        FileExplorer fileExp = new FileExplorer();
        try {
            fileExp.setFile(".");
            System.out.println(fileExp.getContainedFiles());

            fileExp.setFile("./README.md");
            System.out.println(fileExp.getFileContents());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```

### Documentation

+ `FileExplorer()`
    + Constructor that doesn't accept any inputs
+ `public void setFile(String address) throws NullPointerException, IllegalAccessException`
    + Sets the address of the file or directory to be read
+ ` public File getFile()`
    + Returns the File object being used
+ `public String getContainedFiles()`
    + Returns the names of the files contained in the given directory in a list.
+ `public String getFileContents() throws IllegalArgumentException, FileNotFoundException`
    + Returns the contents of the given file, line by line
+ `agnosticGetContents() throws IllegalArgumentException, FileNotFoundException, IllegalAccessException`
    + Runs either .getFileContents() or .getContainedFiles() based on whether .getFile() returns a directory or file