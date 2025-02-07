package com.example.sortalgs;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortVisualizer extends Application {

    // Standard arraystørrelse for de fleste algoritmer
    private static final int ARRAY_SIZE = 100;
    // Mindre arraystørrelse for Bogosort (da algoritmen er ekstremt ineffektiv)
    private static final int BOGO_ARRAY_SIZE = 7;
    //Hastighed som programmet opdatere i milis
    private static final int SORTING_SPEED = 25;

    private int[] array;
    // Listen indeholder SortStep-objekter med array-tilstand og de indekser, der skal fremhæves.
    private List<SortStep> steps;

    // Hjælpeklasse til at gemme et trin i sorteringen
    private static class SortStep {
        int[] array;
        int[] highlightIndices; // Indekser, der skal fremhæves (fx med rød farve)

        SortStep(int[] array, int... highlightIndices) {
            this.array = array;
            this.highlightIndices = highlightIndices;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        // Opret brugerflade
        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(800, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.setCenter(canvas);

        // ComboBox med alle 10 sorteringsalgoritmer
        ComboBox<String> algorithmCombo = new ComboBox<>(FXCollections.observableArrayList(
                "Bubble Sort", "Selection Sort", "Insertion Sort", "Quick Sort",
                "Merge Sort", "Heap Sort", "Bogosort", "Cocktail Sort", "Shell Sort", "Comb Sort"
        ));
        algorithmCombo.getSelectionModel().selectFirst();

        Button startButton = new Button("Start");
        HBox topBar = new HBox(10, algorithmCombo, startButton);
        topBar.setPadding(new Insets(10));
        root.setTop(topBar);

        // Ved opstart genereres et standard array og vises
        generateRandomArray(ARRAY_SIZE);
        drawArray(gc, new SortStep(array.clone()));

        startButton.setOnAction(e -> {
            String algorithm = algorithmCombo.getSelectionModel().getSelectedItem();
            // Hvis vi bruger Bogosort, benyt et mindre array
            if ("Bogosort".equals(algorithm)) {
                generateRandomArray(BOGO_ARRAY_SIZE);
            } else {
                generateRandomArray(ARRAY_SIZE);
            }
            drawArray(gc, new SortStep(array.clone()));

            // Vælg sorteringsalgoritme baseret på brugerens valg
            switch (algorithm) {
                case "Bubble Sort":
                    steps = bubbleSortSteps(array);
                    break;
                case "Selection Sort":
                    steps = selectionSortSteps(array);
                    break;
                case "Insertion Sort":
                    steps = insertionSortSteps(array);
                    break;
                case "Quick Sort":
                    steps = quickSortSteps(array);
                    break;
                case "Merge Sort":
                    steps = mergeSortSteps(array);
                    break;
                case "Heap Sort":
                    steps = heapSortSteps(array);
                    break;
                case "Bogosort":
                    steps = bogoSortSteps(array);
                    break;
                case "Cocktail Sort":
                    steps = cocktailSortSteps(array);
                    break;
                case "Shell Sort":
                    steps = shellSortSteps(array);
                    break;
                case "Comb Sort":
                    steps = combSortSteps(array);
                    break;
                default:
                    steps = new ArrayList<>();
            }
            animateSorting(gc, steps);
        });

        Scene scene = new Scene(root, 800, 450);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sorteringsvisualisering med JavaFX");
        primaryStage.show();
    }

    // Generer et tilfældigt array med den angivne størrelse
    private void generateRandomArray(int size) {
        array = new int[size];
        Random rand = new Random();
        int canvasHeight = 400;
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(canvasHeight - 20) + 10; // Minimum 10 pixels højt
        }
    }

    // Tegn arrayet som lodrette søjler. De indeks, der skal fremhæves, tegnes med rød farve.
    private void drawArray(GraphicsContext gc, SortStep step) {
        gc.clearRect(0, 0, 800, 400);
        double barWidth = 800.0 / step.array.length;
        List<Integer> highlighted = new ArrayList<>();
        if (step.highlightIndices != null) {
            for (int idx : step.highlightIndices) {
                highlighted.add(idx);
            }
        }
        for (int i = 0; i < step.array.length; i++) {
            double x = i * barWidth;
            double y = 400 - step.array[i];
            gc.setFill(highlighted.contains(i) ? Color.RED : Color.DARKCYAN);
            gc.fillRect(x, y, barWidth - 2, step.array[i]);
        }
    }

    // Animer sorteringen ved at bruge en Timeline, hvor hvert trin vises med et fast interval.
    private void animateSorting(GraphicsContext gc, List<SortStep> steps) {
        if (steps == null || steps.isEmpty()) return;
        Timeline timeline = new Timeline();
        Duration frameDuration = Duration.millis(SORTING_SPEED);
        for (int i = 0; i < steps.size(); i++) {
            SortStep step = steps.get(i);
            KeyFrame kf = new KeyFrame(frameDuration.multiply(i), event -> drawArray(gc, step));
            timeline.getKeyFrames().add(kf);
        }
        timeline.play();
    }


    // Bubble Sort
    private List<SortStep> bubbleSortSteps(int[] original) {
        int[] arr = original.clone();
        List<SortStep> steps = new ArrayList<>();
        steps.add(new SortStep(arr.clone()));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    steps.add(new SortStep(arr.clone(), j, j + 1));
                }
            }
        }
        return steps;
    }

    // Selection Sort
    private List<SortStep> selectionSortSteps(int[] original) {
        int[] arr = original.clone();
        List<SortStep> steps = new ArrayList<>();
        steps.add(new SortStep(arr.clone()));
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
                steps.add(new SortStep(arr.clone(), i, minIndex));
            }
        }
        return steps;
    }

    // Insertion Sort
    private List<SortStep> insertionSortSteps(int[] original) {
        int[] arr = original.clone();
        List<SortStep> steps = new ArrayList<>();
        steps.add(new SortStep(arr.clone()));
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            steps.add(new SortStep(arr.clone(), i));
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                steps.add(new SortStep(arr.clone(), j + 1, j + 2));
            }
            arr[j + 1] = key;
            steps.add(new SortStep(arr.clone(), j + 1));
        }
        return steps;
    }

    // Quick Sort
    private List<SortStep> quickSortSteps(int[] original) {
        int[] arr = original.clone();
        List<SortStep> steps = new ArrayList<>();
        steps.add(new SortStep(arr.clone()));
        quickSort(arr, 0, arr.length - 1, steps);
        return steps;
    }

    private void quickSort(int[] arr, int low, int high, List<SortStep> steps) {
        if (low < high) {
            int pi = partition(arr, low, high, steps);
            quickSort(arr, low, pi - 1, steps);
            quickSort(arr, pi + 1, high, steps);
        }
    }

    private int partition(int[] arr, int low, int high, List<SortStep> steps) {
        int pivot = arr[high];
        int i = low - 1;
        steps.add(new SortStep(arr.clone(), high));
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
                steps.add(new SortStep(arr.clone(), i, j));
            }
        }
        swap(arr, i + 1, high);
        steps.add(new SortStep(arr.clone(), i + 1, high));
        return i + 1;
    }

    // Merge Sort
    private List<SortStep> mergeSortSteps(int[] original) {
        int[] arr = original.clone();
        List<SortStep> steps = new ArrayList<>();
        steps.add(new SortStep(arr.clone()));
        mergeSort(arr, 0, arr.length - 1, steps);
        return steps;
    }

    private void mergeSort(int[] arr, int left, int right, List<SortStep> steps) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, steps);
            mergeSort(arr, mid + 1, right, steps);
            merge(arr, left, mid, right, steps);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, List<SortStep> steps) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                steps.add(new SortStep(arr.clone(), k));
                i++;
            } else {
                arr[k] = R[j];
                steps.add(new SortStep(arr.clone(), k));
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            steps.add(new SortStep(arr.clone(), k));
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            steps.add(new SortStep(arr.clone(), k));
            j++;
            k++;
        }
    }

    // Heap Sort
    private List<SortStep> heapSortSteps(int[] original) {
        int[] arr = original.clone();
        List<SortStep> steps = new ArrayList<>();
        steps.add(new SortStep(arr.clone()));
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, steps);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            steps.add(new SortStep(arr.clone(), 0, i));
            heapify(arr, i, 0, steps);
        }
        return steps;
    }

    private void heapify(int[] arr, int heapSize, int rootIndex, List<SortStep> steps) {
        int largest = rootIndex;
        int left = 2 * rootIndex + 1;
        int right = 2 * rootIndex + 2;

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != rootIndex) {
            swap(arr, rootIndex, largest);
            steps.add(new SortStep(arr.clone(), rootIndex, largest));
            heapify(arr, heapSize, largest, steps);
        }
    }


    // Bogosort – ekstremt ineffektiv; kører på et lille array (BOGO_ARRAY_SIZE)
    private List<SortStep> bogoSortSteps(int[] original) {
        int[] arr = original.clone();
        List<SortStep> steps = new ArrayList<>();
        steps.add(new SortStep(arr.clone()));
        int attempts = 0;
        // Sikkerhedsforanstaltning: begræns antal forsøg for at undgå en uendelig løkke
        while (!isSorted(arr) && attempts < 10000) {
            shuffle(arr);
            steps.add(new SortStep(arr.clone()));
            attempts++;
        }
        return steps;
    }

    // Cocktail Sort – en bidirektionel variant af Bubble Sort
    private List<SortStep> cocktailSortSteps(int[] original) {
        int[] arr = original.clone();
        List<SortStep> steps = new ArrayList<>();
        steps.add(new SortStep(arr.clone()));
        boolean swapped = true;
        int start = 0;
        int end = arr.length - 1;
        while (swapped) {
            swapped = false;
            for (int i = start; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                    steps.add(new SortStep(arr.clone(), i, i + 1));
                }
            }
            if (!swapped)
                break;
            swapped = false;
            end--;
            for (int i = end; i > start; i--) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                    swapped = true;
                    steps.add(new SortStep(arr.clone(), i - 1, i));
                }
            }
            start++;
        }
        return steps;
    }

    // Shell Sort – benytter et faldende gap for at sortere "sub-arrays"
    private List<SortStep> shellSortSteps(int[] original) {
        int[] arr = original.clone();
        List<SortStep> steps = new ArrayList<>();
        steps.add(new SortStep(arr.clone()));
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    steps.add(new SortStep(arr.clone(), j, j - gap));
                    j -= gap;
                }
                arr[j] = temp;
                steps.add(new SortStep(arr.clone(), j));
            }
        }
        return steps;
    }

    // Comb Sort – en forbedring af Bubble Sort, der bruger et faldende gap
    private List<SortStep> combSortSteps(int[] original) {
        int[] arr = original.clone();
        List<SortStep> steps = new ArrayList<>();
        steps.add(new SortStep(arr.clone()));
        int gap = arr.length;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = (int) (gap / 1.3);
            if (gap < 1)
                gap = 1;
            swapped = false;
            for (int i = 0; i + gap < arr.length; i++) {
                if (arr[i] > arr[i + gap]) {
                    swap(arr, i, i + gap);
                    swapped = true;
                    steps.add(new SortStep(arr.clone(), i, i + gap));
                }
            }
        }
        return steps;
    }

    // Hjælpe-metode: tjek om arrayet er sorteret (stigende orden)
    private boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i])
                return false;
        }
        return true;
    }

    // Hjælpe-metode: stokastisk blanding af arrayet
    private void shuffle(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = rand.nextInt(arr.length);
            swap(arr, i, randomIndex);
        }
    }

    // Hjælpe-metode til at bytte to elementer i arrayet
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
