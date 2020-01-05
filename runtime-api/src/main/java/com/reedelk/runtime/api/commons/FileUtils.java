package com.reedelk.runtime.api.commons;

import com.reedelk.runtime.api.exception.ESBException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Scanner;

import static com.reedelk.runtime.api.commons.Preconditions.checkNotNull;
import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;

public class FileUtils {

    private FileUtils() {
    }

    public static class ReadFromURL {

        public static String asString(URL url) {
            try (Scanner scanner = new Scanner(url.openStream(), UTF_8.toString())) {
                scanner.useDelimiter("\\A");
                return scanner.hasNext() ? scanner.next() : StringUtils.EMPTY;
            } catch (IOException exception) {
                throw new ESBException(format("String from URL=[%s] could not be read.", url.getPath()), exception);
            }
        }
    }

    public static boolean hasExtension(Path path, String suffix) {
        String fileName = path.getFileName().toString();
        String extension = getExtension(fileName);
        return suffix.equals(extension);
    }

    public static String getExtension(String filename) {
        if (filename == null) {
            return null;
        } else {
            int index = indexOfExtension(filename);
            return index == -1 ? StringUtils.EMPTY : filename.substring(index + 1);
        }
    }

    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        } else {
            int extensionPos = filename.lastIndexOf(46);
            int lastSeparator = indexOfLastSeparator(filename);
            return lastSeparator > extensionPos ? -1 : extensionPos;
        }
    }

    public static boolean exists(String file) {
        checkNotNull(file, "file");
        return new File(file).exists();
    }

    private static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        } else {
            return filename.lastIndexOf(File.separatorChar);
        }
    }
}