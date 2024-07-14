package abcde.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Operating {

    public static void io(){
        var file = new File("/Users/marian/selectcomp.txt");
        System.out.println("Absolute path: "+ file.getAbsolutePath());
        System.out.println("Is directory: " + file.isDirectory());
        System.out.println("Parent Path: " + file.getParent());
        if(file.isFile()) {
            System.out.println("Size :"+ file.length());
            System.out.println("Last modified: "+ file.lastModified());
        } else {

        }
    }

    public static void nio() throws IOException {
        var path = Path.of("/Users/marian/selectcomp.txt");
        if(Files.exists(path)){
            System.out.println("Absolute path: "+ path.toAbsolutePath());
            System.out.println("Is directory: " + Files.isDirectory(path));
            System.out.println("Parent Path: "+ path.getParent());
            System.out.println("The path name is: "+ path);
            for (int i = 0; i < path.getNameCount(); i++) {
                System.out.println(" Element "+i+" is: "+ path.getName(i));
            }
            //Printing the current working directory as a Path object
            System.out.println("realPath: "+ Paths.get(".").toRealPath());
            if(Files.isRegularFile(path)){
                System.out.println("Size: "+ Files.size(path));
                System.out.println("Last modified: "+ Files.getLastModifiedTime(path));
            } else {
                try(Stream<Path> stream = Files.list(path)){
                    stream.forEach(p -> System.out.println(" "+ p.getName(0)));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        nio();
        Path path = Paths.get("selectcomp.txt");
        boolean exists = Files.exists(path, LinkOption.NOFOLLOW_LINKS);
        // Files.createDirectory(Path.of("/Users/marian/javadir"));
       // Files.createDirectories(Path.of("/Users/marian/javadir/pasture/green"));
        copyPath(Path.of("/Users/marian/selectcomp.txt"), Path.of("/Users/marian/javadir"));
        var file = Path.of("/Users/marian/javadir/selectcomp.txt");
        System.out.println(file.toAbsolutePath());

        System.out.println(Files.mismatch(
                file,
                Path.of("/Users/marian/otherfile.txt")
        ));
    }

    public static void copyPath(Path source, Path target){
            if(Files.isDirectory(source))
                try(Stream<Path> s = Files.list(source)){

                    s.forEach(p -> copyPath(p, target.resolve(p.getFileName())));
                } catch (IOException e) {
                    System.out.println(e);
                }
    }
}
