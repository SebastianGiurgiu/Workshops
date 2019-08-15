package ro.axonsoft.internship.impl;

import java.io.IOException;
import java.util.List;

public interface Writer {
    /**
     * Writes the result information for each student
     */
    void writeResult(final List<SearchResult> results) throws IOException;

}
