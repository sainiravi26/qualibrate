package com.ravi.assignment.qualibrate.service;

import java.util.List;

public class PageResult<T> {

    private List<T> items;

    public PageResult(List<T> items) {

        this.items = items;
    }

    public List<T> getItems() {

        return items;
    }

    public void setItems(List<T> items) {

        this.items = items;
    }
}
