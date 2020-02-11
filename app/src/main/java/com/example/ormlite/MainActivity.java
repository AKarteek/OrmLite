package com.example.ormlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.UpdateBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static SQLiteDatabase myDataBase;
    DatabaseHelper databaseHelper;
    OrmDatabaseModel ormDatabaseModel;
    EditText add1, name, readdate, rrno;
    Button insert, get, delete, update;
    List<OrmDatabaseModel> ormDatabaseModelList;
    List<OrmDatabaseModel> fetchlist;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    UpdateBuilder<OrmDatabaseModel, Integer> updateBuilder;
    /*private Dao<OrmDatabaseModel, Integer> dao;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ormDatabaseModelList = new ArrayList<>();
        fetchlist = new ArrayList<>();


        add1 = findViewById(R.id.et_add1);
        name = findViewById(R.id.et_name);
        readdate = findViewById(R.id.et_readdate);
        rrno = findViewById(R.id.et_rrno);
        insert = findViewById(R.id.bt_insert);
        get = findViewById(R.id.bt_select);
        delete = findViewById(R.id.bt_delete);
        update = findViewById(R.id.bt_update);
        insert.setOnClickListener(this);








        //This is used for the Fetch the data from Database Table
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    /* ormDatabaseModelList.get(0);*/
                    ormDatabaseModelList = databaseHelper.getData(OrmDatabaseModel.class);
                    //This is used for the RecyclerView for displaying the Data...
                    recyclerView = findViewById(R.id.ormlist);
                    userAdapter = new UserAdapter(ormDatabaseModelList);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(userAdapter);
                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                }


                //Toast.makeText(getApplicationContext(), String.valueOf(db.getUsersCount()), Toast.LENGTH_LONG).show();
            }
        });

        ormDatabaseModel = new OrmDatabaseModel();


        databaseHelper = new DatabaseHelper(MainActivity.this);


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {

                    databaseHelper.deleteData();

                }catch(java.sql.SQLException e){
                    e.printStackTrace();
                }


                //Toast.makeText(getApplicationContext(), String.valueOf(db.getUsersCount()), Toast.LENGTH_LONG).show();
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                   /* updateBuilder = dao.updateBuilder();*/
                    databaseHelper.UpdateRecord();

                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                }

                //Toast.makeText(getApplicationContext(), String.valueOf(db.getUsersCount()), Toast.LENGTH_LONG).show();
            }
        });


    }


    @Override
    public void onClick(View v) {

        ormDatabaseModel.setADD1(add1.getText().toString());
        ormDatabaseModel.setNAME(name.getText().toString());
        ormDatabaseModel.setREADDATE(readdate.getText().toString());
        ormDatabaseModel.setRRNO(rrno.getText().toString());

        insertData(ormDatabaseModel);


               //Here,adding the data to arraylist then insert into database
        /*ormDatabaseModelList.add(ormDatabaseModel);
        ormDatabaseModelList.get(0);
*/


    }


    //This is used for inserting the data to OrmDatabase and called below method......
    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }


    //This is useful for inserting the data to database like OrmLite
    private void insertData(OrmDatabaseModel ormData) {
        /* OrmDatabaseModel ormData = ormDatabaseModelList.get*//*(0);*/
        try {
            final Dao<OrmDatabaseModel, Integer> disconDao = getHelper().getDateTimeDao();
            disconDao.create(ormData);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }


}
