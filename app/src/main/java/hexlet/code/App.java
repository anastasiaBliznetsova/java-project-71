package hexlet.code;
//import com.fasterxml.jackson.core.type.TypeReference;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
//import java.math.BigInteger;
//import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.security.MessageDigest;
//import java.util.Map;
import java.util.concurrent.Callable;
//import com.fasterxml.jackson.databind.ObjectMapper;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<Integer> {
    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate(file, file2));
        return 0;
    }
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    Path path = Paths.get("src/main/java/hexlet/code/files/filepath1.json").toAbsolutePath().normalize();
    private File file = new File(String.valueOf(path));
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    Path path2 = Paths.get("src/main/java/hexlet/code/files/filepath2.json").toAbsolutePath().normalize();
    private File file2 = new File(String.valueOf(path2));
    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]")
    private String format;
    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean versionInfoRequested;
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    boolean usageHelpRequested;
}
