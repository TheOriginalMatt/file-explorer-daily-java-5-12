import java.io.*;
import java.util.*;
import java.lang.*;

/*
 * FileExplorer
 *
 * Description: Simple implementation of a file explorer.
 */

class FileExplorer {

    private File file;

    /*
     * FileExplorer()
     *
     * Description: Constructor that doesn't accept any inputs
     *
     * Arguments:
     *  N/A
     *
     * Returns:
     *  N/A
     */
    FileExplorer() {  }

    /*
     * setFile()
     *
     * Description: Setter function for this.file
     *
     * Arguments:
     *  String - address - a string version of the address of the file or 
     *      directory to be read
     *
     * Returns:
     *  N/A
     */
    public void setFile(String address) throws NullPointerException, IllegalAccessException {
        if (new File(address).exists()) {
            this.file = new File(address);
        } else {
            throw new IllegalArgumentException("File/Folder "+address+" does not exist");
        }
    }

    /*
     * getFile()
     *
     * Description: Getter function for this.file
     *
     * Arguments:
     *  N/A
     *
     * Returns:
     *  File - the file used by this FileExplorer
     */
    public File getFile() {
        return this.file;
    }

    /*
     * getContainedFiles()
     *
     * Description: Returns the names of the files contained in the given
     *      directory in a list. Use getFile().list() for an array of 
     *      file & subdirectory names
     *
     * Arguments:
     *  N/A
     *
     * Returns:
     *  String - Prettied list of the subfiles and subdirectories
     */
    public String getContainedFiles() {
        String contents = "";

        if(this.getFile().isDirectory()) {

            for (String file: this.getFile().list()) {
                contents += "\n- "+file;
            }

            return contents;

        } else {
            throw new IllegalArgumentException(this.getFile().toString()+" is not a directory");
        }    
    }

    /*
     * getFileContents()
     *
     * Description: Returns the contents of the given file, line by line
     *
     * Arguments:
     *  N/A
     *
     * Returns:
     *  String - contents of the given file
     */
    public String getFileContents() throws IllegalArgumentException, FileNotFoundException {
        String contents = "";
        if (this.getFile().canRead()) {
            Scanner scanner = new Scanner(this.getFile());

            while(scanner.hasNextLine()) {
                contents += scanner.nextLine() + "\n";
            }
        } else {
            throw new IllegalArgumentException("Unable to read file contents of "+this.getFile().toString());
        }

        return contents;   
    }

    /*
     * agnosticGetContents()
     *
     * Description: Runs either .getFileContents() or .getContainedFiles()
     *      based on whether this.file is a directory or file
     *
     * Arguments:
     *  N/A
     *
     * Returns:
     *  String - Prettied contents of the file or directory
     */
    public String agnosticGetContents() throws IllegalArgumentException, FileNotFoundException, IllegalAccessException {
        if (this.getFile().isDirectory()) {

            return this.getContainedFiles();

        } else if (this.getFile().isFile()) {

            return this.getFileContents();

        } else {

            throw new IllegalAccessException(this.getFile().toString()+" is neither a file nor a directory");

        }
    }
}