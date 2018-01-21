package com.example.eric.dispatchdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance(); //建立連結


        myRef = database.getReference("message");  //建立key
        myRef.setValue("Hello, World!");   //傳value


        ArrayList<Crane> cranes = new ArrayList<>();
        cranes.add(new Crane(1,"JJJ-293","25T","27M"));
        cranes.add(new Crane(2,"FFF-788","45T","35M"));
        cranes.add(new Crane(3,"JDK-888","30T","40M"));
        cranes.add(new Crane(4,"SSS-333","45T","60M"));
        cranes.add(new Crane(5,"SGG-456","60T","85M"));
        cranes.add(new Crane(6,"FGH-747","120T","75M"));
        cranes.add(new Crane(7,"HKD-634","250T","80M"));

        Gson gson = new Gson();
        String cranedata = gson.toJson(cranes);

        myRef = database.getReference("craneList");  //建立key
        myRef.setValue(cranedata);   //傳value

        ArrayList<Employee> employees =new ArrayList<>();
        employees.add(new Employee(1,"邱柏銘","助手","0977165804","F123456789","820630"));
        employees.add(new Employee(2,"將大寶","司機","0963210258","F987654321","852014"));
        employees.add(new Employee(3,"將小寶","助手","0965510258","F982354321","845014"));
        employees.add(new Employee(4,"將阿財","司機","0663210258","F987645321","852052"));
        employees.add(new Employee(5,"將萬得","司機","0963225258","F987524321","852524"));
        employees.add(new Employee(6,"阿祿仔","司機","0962525258","M987545321","852144"));
        employees.add(new Employee(7,"劉阿喜","助手","0963212258","U127524321","852524"));

        String employeeList = gson.toJson(employees);
        myRef = database.getReference("employeeList");
        myRef.setValue(employeeList);



    }

    public  void clickEmployee(View v)
    {
        myRef = database.getReference("employeeList");  //指定要抓哪個Refrefrence
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                String value = dataSnapshot.getValue(String.class);
                Log.d("firebase", "Value is: " + value);

//                Gson gson =new Gson();
//                ArrayList<String> mydata =gson.fromJson(value,new TypeToken<ArrayList>(){}.getType());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("firebase", "Failed to read value.", error.toException());
            }
        });



    }

    public  void clickCar(View v)
    {
        myRef = database.getReference("craneList");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                String value = dataSnapshot.getValue(String.class);
                Log.d("firebase", "Value is: " + value);

//                Gson gson =new Gson();
//                ArrayList<String> mydata =gson.fromJson(value,new TypeToken<ArrayList>(){}.getType());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("firebase", "Failed to read value.", error.toException());
            }
        });
    }


}
