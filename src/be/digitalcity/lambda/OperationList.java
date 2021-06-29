package be.digitalcity.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OperationList {

    public static void main(String[] args) {
        execute();
    }

    private static final List<Double> data = Arrays.asList(1D,2D,3D,4D,5D,6D,7D,8D,9D);


    public static void execute() {
        Optional <Double> result = data.stream()
                .limit(5)
                .filter(item -> item % 2 ==0)
                .map(item -> Math.pow(item,3))
                .reduce((item1, item2) -> item1+item2);

        if (result.isPresent()) System.out.println(result.get());
    }
}
