import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();
        Random rand = new Random();
        HashSet<Integer> valores = new HashSet<>();

        while (valores.size() < 10000) {
            int num = rand.nextInt(10000);
            if (valores.add(num+1)) {
                if (valores.size() % 2 == 0) {
                    lista.insereListaFim(num+1);
                } else {
                    lista.insereListaInicio(num+1);
                }
            }
        }
        /*
        //Numeros repetidos
        for (int i = 0; i < 50; i++) {
            int num = rand.nextInt(100);
            if (i % 2 == 0)
                lista.InsereListaFim(num);
            else lista.InsereListaInicio(num);
        }*/

        long tini = System.currentTimeMillis();
        //lista.insercaoDireta(); //ok
        //lista.insercaoBinaria(); //ok
        //lista.selecaoDireta(); //ok
        //lista.bubleSort(); //ok
        //lista.shakeSort(); //ok
        //lista.shellSort(); //ok
        //lista.heapSort(); //ok
        //lista.quickSortSemPivo(); //ok
        //lista.quickComPivo(); //ok
        //lista.mergeSort(); //ok
        //lista.countingSort(); //ok
        //lista.bucketSort(); //ok
        //lista.radixSort();
        //lista.combSort(); //ok
        //lista.gnomeSort(); //ok
        long tfim = System.currentTimeMillis();
        System.out.println("Tempo: " + (tini-tfim) + "ms");
        lista.exibirLista();
    }
}
