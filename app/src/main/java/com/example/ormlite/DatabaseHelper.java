package com.example.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;


import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.File;
import java.util.List;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static SQLiteDatabase myDataBase;
    public static final String DB_NAME = "employee1.db";
    private static final int DB_VERSION = 1;
    private final static String databasefolder = "Karthik";
    private final static String databasepath = filestorepath(databasefolder) + File.separator + DB_NAME;
    UpdateBuilder<OrmDatabaseModel, Integer> updateBuilder;
    DeleteBuilder<OrmDatabaseModel, Integer> deleteBuilder;
    OrmDatabaseModel ormDatabaseModel;
    private Dao<OrmDatabaseModel, Integer> dao;
    DatabaseHelper databaseHelper;


    public DatabaseHelper(Context context) {
        super(context, databasepath, null, DB_VERSION);
    }


    //Create the table by using OrmDatabase
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            //This is used for  Creating a table
            TableUtils.createTable(connectionSource, OrmDatabaseModel.class);


            ormDatabaseModel = new OrmDatabaseModel();


        } catch (Exception ex) {
            throw new RuntimeException();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        //This is used for drop the table
        try {
            TableUtils.dropTable(connectionSource, OrmDatabaseModel.class, true);
            onCreate(myDataBase, connectionSource);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }


    public Dao.CreateOrUpdateStatus createOrUpdate(OrmDatabaseModel ormDatabaseModel) throws java.sql.SQLException {
        Dao<OrmDatabaseModel, ?> dao = (Dao<OrmDatabaseModel, ?>) getDao(ormDatabaseModel.getClass());
        return dao.createOrUpdate(ormDatabaseModel);
    }


    public static String filestorepath(String value) {
        File folder = new File(Environment.getExternalStorageDirectory() +
                File.separator + value);
        return folder.toString();
    }

    //This is used for the Inserting the Data to Table
    public Dao<OrmDatabaseModel, Integer> getDateTimeDao() throws java.sql.SQLException {
        if (dao == null) {
            dao = getDao(OrmDatabaseModel.class);
        }
        return dao;
    }


    //This is used for Fetch the Data from Table
    public List getData(Class clazz) throws java.sql.SQLException {
        Dao dao = getDao(OrmDatabaseModel.class);
        return dao.queryForAll();
    }


    public void UpdateRecord() throws java.sql.SQLException {

        dao = getDao(OrmDatabaseModel.class);
        updateBuilder = dao.updateBuilder();

        updateBuilder.updateColumnValue("ADD1", "JAYANAGAR");
        updateBuilder.where().eq("id", 1);
        updateBuilder.update();

        updateBuilder.updateColumnValue("ADD1", "Jalahalli cross");
        updateBuilder.where().eq("id", 2);
        updateBuilder.update();


        updateBuilder.updateColumnValue("ADD1", "Bhagya Nagar");
        updateBuilder.where().eq("id", 3);
        updateBuilder.update();


        updateBuilder.updateColumnValue("ADD1", "Santhosh  Nagar");
        updateBuilder.where().eq("id", 4);
        updateBuilder.update();


        updateBuilder.updateColumnValue("ADD1", "Balaji Nagar");
        updateBuilder.where().eq("id", 5);
        updateBuilder.update();


    }


    //This is used for the delete the records in the table
    public void deleteData() throws java.sql.SQLException {

        dao = getDao(OrmDatabaseModel.class);
        deleteBuilder = dao.deleteBuilder();
        deleteBuilder.where().eq("id", 1);
        deleteBuilder.delete();

        deleteBuilder.where().eq("id",2);
        deleteBuilder.delete();

        deleteBuilder.where().eq("id",3);
        deleteBuilder.delete();

        deleteBuilder.where().eq("id",4);
        deleteBuilder.delete();


        deleteBuilder.where().eq("id",5);
        deleteBuilder.delete();

        deleteBuilder.where().eq("id",6);
        deleteBuilder.delete();

        deleteBuilder.where().eq("id",7);
        deleteBuilder.delete();

        deleteBuilder.where().eq("id",8);
        deleteBuilder.delete();

        deleteBuilder.where().eq("id",9);
        deleteBuilder.delete();

    }


}


