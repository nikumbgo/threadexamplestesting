package threadtest.printwiththreethreads;

import java.util.stream.IntStream;

public class BaseClass {

    int counter = 1;

    public static void main(String[] args) {
        BaseClass m = new BaseClass();
        IntStream.range(0, 10).forEach((i) -> {
            ResourceClass tp = new ResourceClass((i + 1), m);
            tp.start();

        });

    }

}
