import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Lista lista_random = new Lista();
        Lista lista_ordenada = new Lista();
        Lista lista_reversa = new Lista();
        Lista copia = new Lista();

        Random rand = new Random();
        HashSet<Integer> valores = new HashSet<>();
        while (valores.size() < 64) {
            int num = rand.nextInt(64);
            if (valores.add(num+1))
                lista_random.insereListaFim(num+1);
        }
        for (int i = 1; i <= 64; i++) {
            lista_ordenada.insereListaFim(i);
            lista_reversa.insereListaInicio(i);
        }

        //Inserção Direta
        copia.clonaLista(lista_ordenada);
        long tini = System.currentTimeMillis();
        copia.insercaoDireta();
        long tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Inserção direta ordenada");

        copia.clonaLista(lista_reversa);
        tini = System.currentTimeMillis();
        copia.insercaoDireta();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Inserção direta reversa");

        copia.clonaLista(lista_random);
        tini = System.currentTimeMillis();
        copia.insercaoDireta();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Inserção direta random");

        //Inserção Binária
        copia.clonaLista(lista_ordenada);
        tini = System.currentTimeMillis();
        copia.insercaoBinaria();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Inserção binária ordenada");

        copia.clonaLista(lista_reversa);
        tini = System.currentTimeMillis();
        copia.insercaoBinaria();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Inserção binária reversa");

        copia.clonaLista(lista_random);
        tini = System.currentTimeMillis();
        copia.insercaoBinaria();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Inserção binária random");

        //Seleção direta
        copia.clonaLista(lista_ordenada);
        tini = System.currentTimeMillis();
        copia.selecaoDireta();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Seleção direta ordenada");

        copia.clonaLista(lista_reversa);
        tini = System.currentTimeMillis();
        copia.selecaoDireta();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Seleção direta reversa");

        copia.clonaLista(lista_random);
        tini = System.currentTimeMillis();
        copia.selecaoDireta();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Seleção direta random");

        //Bolha
        copia.clonaLista(lista_ordenada);
        tini = System.currentTimeMillis();
        copia.bubleSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Bolha ordenada");

        copia.clonaLista(lista_reversa);
        tini = System.currentTimeMillis();
        copia.bubleSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Bolha reversa");

        copia.clonaLista(lista_random);
        tini = System.currentTimeMillis();
        copia.bubleSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Bolha random");

        //Shake
        copia.clonaLista(lista_ordenada);
        tini = System.currentTimeMillis();
        copia.shakeSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Shake ordenada");

        copia.clonaLista(lista_reversa);
        tini = System.currentTimeMillis();
        copia.shakeSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Shake reversa");

        copia.clonaLista(lista_random);
        tini = System.currentTimeMillis();
        copia.shakeSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Shake random");

        //Shell
        copia.clonaLista(lista_ordenada);
        tini = System.currentTimeMillis();
        copia.shellSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Shell ordenada");

        copia.clonaLista(lista_reversa);
        tini = System.currentTimeMillis();
        copia.shellSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Shell reversa");

        copia.clonaLista(lista_random);
        tini = System.currentTimeMillis();
        copia.shellSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Shell random");

        //Heap
        copia.clonaLista(lista_ordenada);
        tini = System.currentTimeMillis();
        copia.heapSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Heap ordenada");

        copia.clonaLista(lista_reversa);
        tini = System.currentTimeMillis();
        copia.heapSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Heap reversa");

        copia.clonaLista(lista_random);
        tini = System.currentTimeMillis();
        copia.heapSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Heap random");

        //Quick sem pivo
        copia.clonaLista(lista_ordenada);
        tini = System.currentTimeMillis();
        copia.quickSortSemPivo();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Quick sem pivo ordenada");

        copia.clonaLista(lista_reversa);
        tini = System.currentTimeMillis();
        copia.quickSortSemPivo();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Quick sem pivo reversa");

        copia.clonaLista(lista_random);
        tini = System.currentTimeMillis();
        copia.quickSortSemPivo();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Quick sem pivo random");

        //Quick com pivo
        copia.clonaLista(lista_ordenada);
        tini = System.currentTimeMillis();
        copia.quickComPivo();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Quick com pivo ordenada");

        copia.clonaLista(lista_reversa);
        tini = System.currentTimeMillis();
        copia.quickComPivo();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Quick com pivo reversa");

        copia.clonaLista(lista_random);
        tini = System.currentTimeMillis();
        copia.quickComPivo();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Quick com pivo random");

        //Merge 1
        copia.clonaLista(lista_ordenada);
        tini = System.currentTimeMillis();
        copia.mergeSort_1();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Merge 1 ordenada");

        copia.clonaLista(lista_reversa);
        tini = System.currentTimeMillis();
        copia.mergeSort_1();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Merge 1 reversa");

        copia.clonaLista(lista_random);
        tini = System.currentTimeMillis();
        copia.mergeSort_1();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Merge 1 random");

        //Merge 2
        copia.clonaLista(lista_ordenada);
        tini = System.currentTimeMillis();
        copia.mergeSort_2();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Merge 2 ordenada");

        copia.clonaLista(lista_reversa);
        tini = System.currentTimeMillis();
        copia.mergeSort_2();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Merge 2 reversa");

        copia.clonaLista(lista_random);
        tini = System.currentTimeMillis();
        copia.mergeSort_2();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Merge 2 random");

        //Counting
        copia.clonaLista(lista_ordenada);
        tini = System.currentTimeMillis();
        copia.countingSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Counting ordenada");

        copia.clonaLista(lista_reversa);
        tini = System.currentTimeMillis();
        copia.countingSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Counting reversa");

        copia.clonaLista(lista_random);
        tini = System.currentTimeMillis();
        copia.countingSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Counting random");

        //Bucket
        copia.clonaLista(lista_ordenada);
        tini = System.currentTimeMillis();
        copia.bucketSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Counting ordenada");

        copia.clonaLista(lista_reversa);
        tini = System.currentTimeMillis();
        copia.bucketSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Counting reversa");

        copia.clonaLista(lista_random);
        tini = System.currentTimeMillis();
        copia.bucketSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Counting random");

        //Radix
        copia.clonaLista(lista_ordenada);
        tini = System.currentTimeMillis();
        copia.radixSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Radix ordenada");

        copia.clonaLista(lista_reversa);
        tini = System.currentTimeMillis();
        copia.radixSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Radix reversa");

        copia.clonaLista(lista_random);
        tini = System.currentTimeMillis();
        copia.radixSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Radix random");

        //Comb
        copia.clonaLista(lista_ordenada);
        tini = System.currentTimeMillis();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Comb ordenada");

        copia.clonaLista(lista_reversa);
        tini = System.currentTimeMillis();
        copia.combSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Comb reversa");

        copia.clonaLista(lista_random);
        tini = System.currentTimeMillis();
        copia.combSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Comb random");

        //Gnome
        copia.clonaLista(lista_ordenada);
        tini = System.currentTimeMillis();
        copia.gnomeSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Gnome ordenada");

        copia.clonaLista(lista_reversa);
        tini = System.currentTimeMillis();
        copia.gnomeSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Gnome reversa");

        copia.clonaLista(lista_random);
        tini = System.currentTimeMillis();
        copia.gnomeSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Gnome random");

        //Tim
        copia.clonaLista(lista_ordenada);
        tini = System.currentTimeMillis();
        copia.timSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Tim ordenada");

        copia.clonaLista(lista_reversa);
        tini = System.currentTimeMillis();
        copia.timSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Tim reversa");

        copia.clonaLista(lista_random);
        tini = System.currentTimeMillis();
        copia.timSort();
        tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tfim-tini) + "ms");
        copia.validaOrdenacao("Tim random");
    }
}
