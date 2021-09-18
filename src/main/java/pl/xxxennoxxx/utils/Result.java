package pl.xxxennoxxx.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Result {
    private static final Result POSITIVE = new Result(true);
    private final boolean status;
    private List<String> msg;

    private Result(boolean status) {
        this.status = status;
    }

    public static Result positive() {
        return POSITIVE;
    }

    public boolean isPositive() {
        return status;
    }

    public static Result negative(String... msgs) {
        final Result result = new Result(false);
        Arrays.asList(msgs).forEach(result::addMsg);
        return result;
    }

    public boolean addMsg(String msg) {
        if (this.msg == null)
            this.msg = new ArrayList<String>();
        return this.msg.add(msg);
    }

}
