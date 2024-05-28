import java.util.*;

class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 5, 8, 2, 6, 3, 7, 9, 1, 4);
        System.out.println("Números originais: " + numeros);

        List<Integer> numerosOrdenadosInsertion = new ArrayList<>(numeros);
        Collections.sort(numerosOrdenadosInsertion);

        List<Integer> numerosOrdenadosQuick = new ArrayList<>(numeros);
        quickSort(numerosOrdenadosQuick, 0, numerosOrdenadosQuick.size() - 1);

        System.out.println("Ordenado com Insertion Sort: " + numerosOrdenadosInsertion);
        System.out.println("Ordenado com Quick Sort: " + numerosOrdenadosQuick);
    }

    private static void quickSort(List<Integer> nums, int baixo, int alto) {
        if (baixo < alto) {
            int pi = partition(nums, baixo, alto);
            quickSort(nums, baixo, pi - 1);
            quickSort(nums, pi + 1, alto);
        }
    }

    private static int partition(List<Integer> nums, int baixo, int alto) {
        int pivo = nums.get(alto);
        int i = baixo - 1;
        for (int j = baixo; j < alto; j++) {
            if (nums.get(j) <= pivo) {
                i++;
                Collections.swap(nums, i, j);
            }
        }
        Collections.swap(nums, i + 1, alto);
        return i + 1;
    }
}