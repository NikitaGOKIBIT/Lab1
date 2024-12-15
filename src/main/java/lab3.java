import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;

class Lab3 { // Клас Lab3 замість Main

    // Метод для обчислення функції
    public static double calculateFunction(double x) {
        return Math.sin(x) + Math.cos(x); // sin(x) + cos(x)
    }

    public static void main(String[] args) throws Exception {
        // Параметри обчислення
        double start = 0; // Початок діапазону
        double end = 2 * Math.PI; // Кінець діапазону
        double step = 0.1; // Крок
        int numberOfThreads = 4; // Кількість потоків

        // Використання ExecutorService для багатопоточності
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        List<Future<String>> results = new ArrayList<>();

        // Розподіл обчислень між потоками
        for (double x = start; x <= end; x += step) {
            final double currentX = x;
            Callable<String> task = () -> {
                double result = calculateFunction(currentX);
                return String.format("f(%.2f) = %.4f", currentX, result);
            };
            results.add(executor.submit(task));
        }

        // Отримання результатів
        for (Future<String> future : results) {
            System.out.println(future.get());
        }

        // Завершення роботи ExecutorService
        executor.shutdown();
    }
}
