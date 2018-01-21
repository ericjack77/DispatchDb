package com.example.eric.dispatchdb;

/**
 * Created by Eric on 2018/1/21.
 */

public class Employee
{

    public int id;
    public String name;
    public String position;
    public String tel;


    public String username;
    public String password;
    Employee(int id,String name,String position,String tel,String username,String password)
    {
        this.id=id;this.name=name;this.position=position;this.tel=tel;this.username=username;this.password=password;
    }

}

