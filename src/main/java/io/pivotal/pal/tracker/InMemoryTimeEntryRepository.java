package io.pivotal.pal.tracker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> inMemoryTimeEntryMap = new HashMap<>();
    private long id = 0;

    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(++id);
        inMemoryTimeEntryMap.put(id, timeEntry);
        return timeEntry;
    }

    public TimeEntry find(long id) {
        return inMemoryTimeEntryMap.get(id);
    }

    public List<TimeEntry> list() {
        return inMemoryTimeEntryMap.values().stream().collect(Collectors.toList());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (find(id) != null) {
            timeEntry.setId(id);
            inMemoryTimeEntryMap.put(id, timeEntry);
            return timeEntry;
        } else {
            return null;
        }
    }

    public void delete(long id) {
        inMemoryTimeEntryMap.remove(id);
    }
}
