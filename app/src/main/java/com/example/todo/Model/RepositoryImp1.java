package com.example.todo.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.os.AsyncTask;
import android.util.Log;

import com.example.todo.MyApp;

import java.util.List;

public class RepositoryImp1 implements Repository {

    private static RepositoryImp1 repository=new RepositoryImp1();
    private ItemDatabase itemDatabase;
    private final int ADD_ITEM=0;
    private final int DELETE_ITEM=1;
    private final int GET_ITEMS=2;

    private RepositoryImp1 (){

        itemDatabase= Room.databaseBuilder(MyApp.getAppContext(),ItemDatabase.class,"ItemDatabase").build();
    }

    public static Repository getInstance(){
        return repository;
    }

    @Override
    public void addItem(Item item) {
        new Operation(item,ADD_ITEM).execute();
    }

    @Override
    public void deleteItem(Item item) {
        new Operation(item,DELETE_ITEM).execute();
    }

    @Override
    public LiveData<List<Item>> getItems() {
        //Operation operation=new Operation(GET_ITEMS);
        //return operation.AllItems;
        return itemDatabase.itemDao().getItems();
    }


     class Operation extends AsyncTask<Void,Void,Void> {

        Item item;
        int operation;
        LiveData<List <Item>>AllItems;

        public Operation(Item item, int operation) {
            this.item = item;
            this.operation = operation;
        }

        public Operation(int operation){

            this.operation = operation;
        }
        @Override
        protected Void doInBackground(Void... voids) {

            if(operation==ADD_ITEM)
            {
                Log.e("RepositortImp1","addDone");
                itemDatabase.itemDao().insert(item);
            }
            else if(operation==DELETE_ITEM){
                itemDatabase.itemDao().Delete(item);
            }
            else
            {
                AllItems=itemDatabase.itemDao().getItems();
            }


            return null;
        }
    }
}
