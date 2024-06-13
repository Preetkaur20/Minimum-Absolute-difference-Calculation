import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static void closestNumbers(List<Integer> numbers) {
        // Sort the numbers list
        Collections.sort(numbers);
        
        // Find the minimum absolute difference
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < numbers.size(); i++) {
            int diff = numbers.get(i) - numbers.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        
        // Find and print all pairs with the minimum difference
        for (int i = 1; i < numbers.size(); i++) {
            int diff = numbers.get(i) - numbers.get(i - 1);
            if (diff == minDiff) {
                System.out.println(numbers.get(i - 1) + " " + numbers.get(i));
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> numbers = IntStream.range(0, numbersCount)
            .mapToObj(i -> {
                try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        Result.closestNumbers(numbers);

        bufferedReader.close();
    }
}
