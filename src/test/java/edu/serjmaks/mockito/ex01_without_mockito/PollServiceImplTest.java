package edu.serjmaks.mockito.ex01_without_mockito;

import org.junit.jupiter.api.Test;

import edu.serjmaks.mockito.ex01_without_mockito.Poll;
import edu.serjmaks.mockito.ex01_without_mockito.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PollServiceImplTest {

    @Test
    void getById_ShouldReturnPoll() {
        PollServiceImpl pollServiceImpl = new PollServiceImpl(new DaoMock());
        long id = 1L;
        Poll expected = new Poll(1L, "name", "description");
        Poll actual = pollServiceImpl.getById(id);
        assertEquals(expected, actual);
    }

    @Test
    public void getByIdThrowsException() {
        PollServiceImpl pollServiceImpl = new PollServiceImpl(new DaoMock());
        long id = 2L;
        assertThrows(NotFoundException.class, () -> pollServiceImpl.getById(id));
    }
}
