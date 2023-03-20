package pixformer.common.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Utilities for files.
 */
public final class FileUtils {

    private FileUtils() {

    }

    /**
     * Copies the content of an input stream directory to a file on the filesystem.
     * @param inputDir resource path to the directory within the JAR executable
     * @param outputDir output directory file to copy the resource to
     * @return whether the operation was successful
     */
    public static boolean copyDirectory(final String inputDir, final File outputDir) {
        final InputStream dirInputStream = FileUtils.class.getResourceAsStream(inputDir);
        if (dirInputStream == null) {
            throw new IllegalStateException("Cannot read internal data");
        }

        if (!outputDir.exists() && !outputDir.mkdirs()) {
            throw new IllegalStateException("Cannot create path");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(dirInputStream, Charset.defaultCharset()))) {
            while (reader.ready()) {
                final String name = reader.readLine();
                if (name == null) {
                    continue;
                }

                final File outputFile = new File(outputDir, name);
                if (!outputFile.exists()) {
                    final InputStream levelInputStream = FileUtils.class.getResourceAsStream(inputDir + "/" + name);
                    if (levelInputStream != null) {
                        Files.copy(levelInputStream, outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }
            return true;
        } catch (final IOException e) {
            return false;
        }
    }

    /**
     * @param file file to get the name of
     * @return name of the file without the extension
     */
    public static String getNameWithoutExtension(final File file) {
        return file.getName().substring(0, file.getName().lastIndexOf('.'));
    }
}
