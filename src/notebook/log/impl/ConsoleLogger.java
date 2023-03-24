package notebook.log.impl;

import java.time.LocalDateTime;

import notebook.log.Logger;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String text) {
        System.err.println(LocalDateTime.now() + ": " + text);
    }
}
