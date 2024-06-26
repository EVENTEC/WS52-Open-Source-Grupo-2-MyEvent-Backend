package backend.myevent.MyEvent.shared.exceptionhandler;

public class NullHandler {
    public static String handleNullString(String str) {
        return str != null ? str : "null";
    }
}
