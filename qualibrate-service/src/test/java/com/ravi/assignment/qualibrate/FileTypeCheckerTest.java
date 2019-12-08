package com.ravi.assignment.qualibrate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.ravi.assignment.qualibrate.configuration.ModuleConfig;
import com.ravi.assignment.qualibrate.service.FileTypeChecker;
import com.ravi.assignment.qualibrate.service.InvalidFileTypeException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FileTypeCheckerTest {

    private ModuleConfig moduleConfig = new ModuleConfig();
    private FileTypeChecker fileTypeChecker = moduleConfig.getFileTypeChecker(moduleConfig.getMimetypesFileTypeMap());

    @Test
    public void test_get_mime_type_allowed_file_type_png() {

        String mimeType = fileTypeChecker.getMimeType("file.PNG");

        assertThat("png is allowed file type, should return the mime type", mimeType, is("image/png"));
    }

    @Test
    public void test_get_mime_type_allowed_file_type_pdf() {

        String mimeType = fileTypeChecker.getMimeType("file.pdf");

        assertThat("png is allowed file type, should return the mime type", mimeType, is("application/pdf"));
    }

    @Test
    public void test_get_mime_type_allowed_file_type_jpeg() {

        String mimeType = fileTypeChecker.getMimeType("file.jpeg");

        assertThat("png is allowed file type, should return the mime type", mimeType, is("image/jpeg"));
    }

    @Test
    public void test_get_mime_type_allowed_file_type_gif() {

        String mimeType = fileTypeChecker.getMimeType("file.gif");

        assertThat("png is allowed file type, should return the mime type", mimeType, is("image/gif"));
    }

    @Test
    public void test_get_mime_type_allowed_file_type_text() {

        String mimeType = fileTypeChecker.getMimeType("file.text");

        assertThat("png is allowed file type, should return the mime type", mimeType, is("text/plain"));
    }

    @Test
    public void test_get_mime_type_not_allowed_file_type() {

        Assertions.assertThrows(InvalidFileTypeException.class, () -> {
            fileTypeChecker.getMimeType("file.json");
        });
    }
}
