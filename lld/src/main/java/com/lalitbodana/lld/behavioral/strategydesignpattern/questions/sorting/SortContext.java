package com.lalitbodana.lld.behavioral.strategydesignpattern.questions.sorting;

public class SortContext {
    private SortingStrategy strategy;

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeSort(int[] numbers) {
        strategy.sort(numbers);
    }
}
