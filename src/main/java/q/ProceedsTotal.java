package q;

import java.util.concurrent.atomic.AtomicInteger;

public class ProceedsTotal {
    AtomicInteger money = new AtomicInteger(0);

    public void transfer(int diff) {
        System.out.printf("%s выручка %d рублей\n", Thread.currentThread().getName(), diff);
        int result = money.addAndGet(diff);
    }

    public int getCurrent() {
        return money.get();
    }
}

