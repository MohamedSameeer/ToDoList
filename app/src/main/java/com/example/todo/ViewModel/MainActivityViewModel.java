package com.example.todo.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.todo.Model.Item;
import com.example.todo.Model.Repository;
import com.example.todo.Model.RepositoryImp1;
import com.example.todo.TodoAdapter;

import java.util.List;


public class MainActivityViewModel extends ViewModel {

    private LiveData<List<Item>> listLiveData;

    public LiveData<List<Item>> getListLiveData(){

        if(listLiveData==null){
            Log.e("eeeeeeeeeeeeee","eeeeeeeeeeeeeeeeee");
            listLiveData = new MutableLiveData<List<Item>>();
            loadItemsFromRepository();
        }
        return listLiveData;
    }

    private void loadItemsFromRepository() {
        Log.e("eeeeeeeeeeeeee","eeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");

        listLiveData = RepositoryImp1.getInstance().getItems();
    }
}
