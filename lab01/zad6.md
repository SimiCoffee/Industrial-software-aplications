1. First, to create a jar file of my project, it needs to be compiled. For organizational purposes I decided to put my compiled file in the folder `bin`.

   ```bash
   javac -d bin org/Hello.java
   ```

   - `-d bin` means that the target directory is `/bin`.

2. Next, a manifest file needs to be created. I created one in the main project folder with `Main-Class: org.Hello` as its content.

3. Lastly, the jar file can be packed with the following command:

   ```bash
   jar cfm hello.jar MANIFEST.MF -C bin .
   ```

   - `c` - creates new JAR archive.
   - `f` - saves the archive as a file of the given name.
   - `m` - uses the given manifest file.
   - `-C bin .` - attaches to the archive the contents of the directory `bin`.

4. To run the `.jar` file from anywhere, all you need is this command:

   ```bash
   java -jar hello.jar
   ```
