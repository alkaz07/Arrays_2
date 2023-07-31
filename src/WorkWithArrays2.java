
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WorkWithArrays2 {
    //1) сгенерировать массив заданной длины из случайных чисел от 0 до 99

    //2) найти номер минимального элемента в массиве
    //3) найти разность между максимальным и минимальным элементами
    //4) найти среднее арифметическое элементов массива
    //5) найти номер элемента, значение которого равно x
    //6) найти, сколько раз в массиве встречается число x
    //7) отфильтровать массив, сделав новый массив, содержащий элементы исходного массива,
    //   значения которых в интервале от p до q
     //8) найти значение элемента массива, максимально близкое к числу x


    public static void main(String[] args) {
        int dlina = 12;
        //1
        int[] mas = generateRandomArray(dlina);
        outputArray(mas);
        //
        System.out.println("номер мин элемента " + getMinNum(mas));
        //3
        System.out.println("диапазон значений " + getValueRange(mas));
        //5
        System.out.println("введите x");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println("число x первый раз встретилось в " + findPositionX(mas, x));
        //7
        System.out.println("введите p и q");
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        int[] fmas = filterArray(mas, p, q);
        outputArray(fmas);

        //8
        System.out.println("введите x");
        x = scanner.nextInt();
        System.out.println("ближайшее к x " + findNearestToX(mas, x));

        //Arrays.sort(mas);
        bubbleSort(mas);
        outputArray(mas);
    }

    //ввести массив произвольной длины
    static int[] inputArray() {
        System.out.println("какой длины массив изволите?");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int massiv[] = new int[size];   // выделяем в куче место под size целых чисел
        // и присваиваем адрес начальной ячейки в ссылочную
        // переменную massiv
        System.out.println("Вводите элементы массива");
        for (int i = 0; i < size; i++) {
            massiv[i] = scanner.nextInt();
        }
        return massiv;
    }

    static void outputArray(int massiv[]) {
        System.out.print("Массив: ");
        for (int i = 0; i < massiv.length; i++) {
            System.out.print(" " + massiv[i]);
        }
        System.out.println(";");
    }

    static int[] generateRandomArray(int len) {
        int massiv[] = new int[len];
        Random generator1 = new Random();
        for (int i = 0; i < massiv.length; i++) {
            massiv[i] = generator1.nextInt(0, 100);
        }
        return massiv;
    }

    static int getMinNum(int massiv[]) {
        int imin = 0;
        for (int i = 1; i < massiv.length; i++) {
            if (massiv[i] < massiv[imin])
                imin = i;
        }
        return imin;
    }

    static int getValueRange(int[] massiv)  //диапазон значений в массиве
    {
        int minVal = massiv[getMinNum(massiv)];
        int maxVal = getMax(massiv);
        return maxVal - minVal;
    }

    static int getMax(int[] massiv) {
        int maxVal = massiv[0];
        for (int i = 1; i < massiv.length; i++) {
            if (maxVal < massiv[i])
                maxVal = massiv[i];
        }
        return maxVal;
    }

    static int findPositionX(int[] mas, int x) {
        // int num = -1;
        for (int i = 0; i < mas.length; i++) {
            if (x == mas[i]) {
               /* num = i;
                break;*/
                return i;
            }
        }
        return -1;
    }

    static int[] filterArray(int[] source, int p, int q) {
        if (p > q) {    //поменять местами
            int t = p;
            p = q;
            q = t;
        }//теперь уж точно p<=q
        int counter =0;
        for (int i = 0; i < source.length ; i++) {
            if(source[i] >=p && source[i] <=q)
                counter++;
        }
        int result[] = new int[counter];
        for (int i = 0, j=0; i < source.length ; i++) {
            if (source[i] >= p && source[i] <= q)
            {
                result[j] = source[i];
                j++;
            }
        }
        return result;
    }

    static int findNearestToX(int[] mas, int x){
        //цикл, в котором вычитается x - значение из массива, и разница сравнивается
        //с запомненным значением
        int result = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if ( Math.abs( x - mas[i]) < Math.abs(x - result) )
                result = mas[i];
        }
        return result;
    }
    static void bubbleSort(int[] mas)
    {
        for (int i = 0; i < mas.length -1; i++) {
            for (int j = 0; j <mas.length - i - 1; j++) {
                if(mas[j] > mas[j+1])
                {
                    int t = mas[j];
                    mas[j] = mas[j+1];
                    mas[j+1] = t;
                }
            }
        }
    }
}