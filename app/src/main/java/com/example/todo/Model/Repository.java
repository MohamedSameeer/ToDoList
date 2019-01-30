package com.example.todo.Model;

import android.arch.lifecycle.LiveData;

import java.util.List;

public interface Repository {

    void addItem(Item item);
    void deleteItem(Item item);
    LiveData<List<Item>> getItems();
}
