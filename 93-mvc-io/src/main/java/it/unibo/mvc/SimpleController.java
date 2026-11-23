package it.unibo.mvc;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Collections;
/**
 * A simple implementation of the {@link Controller} interface.
 */
public final class SimpleController implements Controller {
    private String currentString;
    private final List<String> historyList = new ArrayList<>();//it can't be setted in the constructor

    @Override
    public void setNextStringToPrint(String nextString) {
        this.currentString = Objects.requireNonNull(nextString);
    }

    @Override
    public String getNextStringToPrint() {
        return this.currentString;
    }

    @Override
    public List<String> getPrintedStringsHistory() {
        return Collections.unmodifiableList(this.historyList);
    }

    @Override
    public void printCurrentString() {
        if(this.currentString == null) {
            throw new IllegalStateException("There is no string set");
        }
        historyList.add(currentString);
        IO.println(currentString);
    }
}
