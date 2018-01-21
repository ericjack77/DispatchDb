package com.example.eric.dispatchdb;

/**
 * Created by Eric on 2018/1/21.
 */

public class Crane
{
    public int id;
    public String name;
    public String maxLift;
    public String maxHeight;

    public Crane(int id,String name,String maxLift,String maxHeight)
    {
        this.id=id;this.name=name;this.maxHeight=maxHeight;this.maxLift=maxLift;
    }
}
