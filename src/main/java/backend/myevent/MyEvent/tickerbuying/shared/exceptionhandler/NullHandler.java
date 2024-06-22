package backend.myevent.MyEvent.tickerbuying.shared.exceptionhandler;

public class NullHandler {
    public static String handleNullString(String str) {
        return str != null ? str : "null";
    }
}
