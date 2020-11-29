package main;

import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class UnitTest {

    @Test
    public void baseTest() {
        MockitoAnnotations.initMocks(PrintFile.class);


        List<String> mockedList = mock(List.class);

        mockedList.add("one");
        mockedList.clear();
        verify(mockedList).add("one");
        verify(mockedList).clear();


        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(0).getClass());

        //following throws runtime exception
        try {
            System.out.println(mockedList.get(1));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
        verify(mockedList, times(2)).get(0);
    }

}
