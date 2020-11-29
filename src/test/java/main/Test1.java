package main;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class Test1 {
    @Mock
    private PrintFile printFile;

    @Before
    public void setUp() {
        printFile = new PrintFile("testDir");
        MockitoAnnotations.initMocks(printFile);
    }

    @Test
    public void testCreateFile() {
        assertTrue(printFile.createFile("test1.txt"));
    }

    @Test
    public void testAppendToFile() {
        assertTrue(printFile.appendToFile("test1.txt",
                "This is something to append.\n"));
    }

    @Test
    public void testGetFileSize() {
        assertTrue(printFile.getFileSize("test1.txt") > 0);
    }

    @Test
    public void testDeleteFile() {
        assertTrue(printFile.deleteFile("test1.txt"));
    }

    @Test
    public void unitTest1() {
        PrintFile p = mock(PrintFile.class);
        when(p.getFileSize(anyString()))
                .thenReturn(10L)
                .thenReturn(1000L)
                .thenReturn(53760L)
                .thenReturn(1310720L);
        assertEquals("10字节", printFile.sizeToStr(p.getFileSize("1.txt")));
        assertEquals("1000字节", printFile.sizeToStr(p.getFileSize("2.txt")));
        assertEquals("52.5KB", printFile.sizeToStr(p.getFileSize("3.txt")));
        assertEquals("1.25MB", printFile.sizeToStr(p.getFileSize("4.txt")));
        verify(p, times(4)).getFileSize(anyString());
    }

}
