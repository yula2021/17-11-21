package org.itstep;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Vocabulary {
    public static void main(String[] args) {
        int count = ('z' - 'a') + 1;
        System.out.println(count);
        LinkedList<String> vocabulary = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/date/Vocabulary.txt"))) {
            String s;
            do {
                s = br.readLine();
                if (s != null) vocabulary.add(s);
            }
            while (s != null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(vocabulary.size());
        Collections.sort(vocabulary);
        //Collections.reverse(vocabulary);
        for (String s : vocabulary) System.out.println(s);
//1. Вывести первые 10 слов
        ListIterator<String> it = vocabulary.listIterator(0);
        int i = 0;
        while (it.hasNext() && i < 10) {
            System.out.print(it.next() + " ");
            i++;

        }
        System.out.println();
        //2. Вывести последние 10 слов
        i = 0;
        it = vocabulary.listIterator(vocabulary.size());

        while (it.hasPrevious() && i < 10) {
            System.out.print(it.previous() + " ");
            i++;
        }
        System.out.println();
        //Сколько букв в самом длинном слове
        int max = 0;
        it = vocabulary.listIterator(0);
        String s;
        while (it.hasNext()) {
            s = it.next();
        if (s.length() > max) max = s.length();
    }
    System.out.println(max);
        System.out.println();

//3. Сколько слов однобуквенных, двухбуквенных и т.д.
    int[] hist = new int[max];
        it = vocabulary.listIterator(0);

        while (it.hasNext()) {
            s = it.next();
            hist[s.length()-1]++;
        }
        for (i=0; i<max; i++)
            System.out.printf("Letters: %d, words: %d%n",i+1, hist[i]);
        System.out.println();

        //4. Вывести все слова - палиндромы
        it = vocabulary.listIterator(0);
        while (it.hasNext()) {
            s = it.next();
            if (s.equals(new StringBuilder(s).reverse().toString()))
            System.out.println(s);
            }
        System.out.println();
        //5. Вывести все слова - анаграммы
        it = vocabulary.listIterator(0);
        while (it.hasNext()) {
            s = it.next();

        }
    }
}
