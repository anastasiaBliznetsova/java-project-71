package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")

class App implements Callable<Integer> {
    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate(fileName1, fileName2, format));
        return 0;
    }

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String fileName1;
    @Parameters(paramLabel = "filepath2", description = "path to first file")
    private String fileName2;
    @Option(names = {"-f", "--format"},
            description = "output format: stylish, plain, json, no-format [default: ${DEFAULT-VALUE}]",
            defaultValue = "stylish")
    private String format;
    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    private boolean versionInfoRequested;
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private boolean usageHelpRequested;
}
