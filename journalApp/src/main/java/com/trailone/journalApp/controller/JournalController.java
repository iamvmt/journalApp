package com.trailone.journalApp.controller;
import com.trailone.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Collection;




@RestController
@RequestMapping("api/v1/journal")
public class JournalController {
    /**
     * @return
     */
    
    // Assuming you have a Map or List to store journal entries
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
    
    @PostMapping("/post")
    public JournalEntry createEntry(@RequestBody JournalEntry entry) {
        // Assign a new ID if not present
        if (entry.getId() == null || entry.getId() == 0L) {
            long newId = journalEntries.size() + 1;
            entry.setId(newId);
        }
        
        // Save the entry to the collection
        journalEntries.put(entry.getId(), entry);
        
        // Return the created entry
        return entry;
    }
    
    // Fixed: Use PathVariable with proper mapping
    @GetMapping("/id/{id}")
    public JournalEntry getEntryById(@PathVariable long id) {
        JournalEntry entry = journalEntries.get(id);
        if (entry == null) {
            throw new RuntimeException("Journal entry not found with id: " + id);
        }
        return entry;
    }
    
    // Alternative: Get entry by request parameter
    @GetMapping("/search")
    public JournalEntry getEntryByParam(@RequestParam long id) {
        JournalEntry entry = journalEntries.get(id);
        if (entry == null) {
            throw new RuntimeException("Journal entry not found with id: " + id);
        }
        return entry;
    }
    
    // Optional: Get all entries for testing
    @GetMapping()
    public Collection<JournalEntry> getAllEntries() {
        return journalEntries.values();
    }
}