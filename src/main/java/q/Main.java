package q;

public class Main {
    static ProceedsTotal proceedsTotal = new ProceedsTotal();

    public static void main(String[] args) throws InterruptedException {
        int[] proceeds1;
        int[] proceeds2;
        int[] proceeds3;
        proceeds1 = proceeds();
        proceeds2 = proceeds();
        proceeds3 = proceeds();
        Runnable r = new Shop1(proceeds1);
        Runnable q = new Shop2(proceeds2);
        Runnable w = new Shop3(proceeds3);
        ThreadGroup mainGroup = new ThreadGroup("main group");
        Thread shop1 = new Thread(mainGroup, r, "Магазин 1");
        Thread shop2 = new Thread(mainGroup, q, "Магазин 2");
        Thread shop3 = new Thread(mainGroup, w, "Магазин 3");
        shop1.start();
        shop2.start();
        shop3.start();
        shop1.join();
        shop2.join();
        shop3.join();
        System.out.println("Выручка по трем магазинам: " + proceedsTotal.getCurrent() + " рублей");
    }

    public static int[] proceeds() {
        int i = Math.toIntExact(Math.round(Math.random() * 100));      //генерим количество покупок в магазине max 100
        int[] arrays;
        arrays = new int[i];
        i--;
        while (i >= 0) {
            arrays[i] = Math.toIntExact(Math.round(Math.random() * 10000));    //генерим стоимость отдельной покупки max 10000руб. Таким образом выручка не более 1 000 000 т.е. int хватит
            i--;
        }
        return arrays;
    }
}
