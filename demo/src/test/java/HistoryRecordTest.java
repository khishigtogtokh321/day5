import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistoryRecordTest {

    @Test
    void testAddAndListHistory() {
        HistoryRecord.addRecord(new HistoryRecord(
            HistoryRecord.ActionType.ADD,
            LocalDateTime.now(),
            "Бат",
            "Keyboard",
            "K001",
            10));

        HistoryRecord.addRecord(new HistoryRecord(
            HistoryRecord.ActionType.GET,
            LocalDateTime.now(),
            "Сараа",
            "Keyboard",
            "K001",
            5));

        // Хоёр бичлэг байгаа эсэхийг шалгана
        assertEquals(2, HistoryRecord.getAllRecords().size());
    }
}
