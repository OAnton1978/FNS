package q;

public class Shop1 extends Thread {
    int[] proceeds;

    public Shop1(int[] proceeds) {
        this.proceeds = proceeds;
    }

    @Override
    public void run() {
        try {
            int countProceeds = 0;
            int i = proceeds.length - 1;
            while (i >= 0) {
                countProceeds = countProceeds + proceeds[i];
                i--;
            }
            Main.proceedsTotal.transfer(countProceeds);
        } finally {
        }
    }
}

