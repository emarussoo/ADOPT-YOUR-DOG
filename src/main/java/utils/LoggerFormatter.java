package utils;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LoggerFormatter extends Formatter {
    @Override
    public synchronized String format(LogRecord record) {
        return record.getMessage() + "\n";
    }
}
