package com.lalitbodana.lld.behavioral.strategydesignpattern.questions.sorting;

import com.lalitbodana.lld.behavioral.strategydesignpattern.questions.sorting.impl.BubbleSort;
import com.lalitbodana.lld.behavioral.strategydesignpattern.questions.sorting.impl.MergeSort;
import com.lalitbodana.lld.behavioral.strategydesignpattern.questions.sorting.impl.QuickSort;

public class StrategyPatternExample {
    public static void main(String[] args) {
        SortContext context = new SortContext();

        int[] data = {5, 2, 9, 1, 7};

        // Use Bubble Sort
        context.setStrategy(new BubbleSort());
        context.executeSort(data);

        // Use Quick Sort
        context.setStrategy(new QuickSort());
        context.executeSort(data);

        // Use Merge Sort
        context.setStrategy(new MergeSort());
        context.executeSort(data);
    }
}
