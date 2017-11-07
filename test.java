/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;
       //package com.mkyong.time;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author JUSTE
 */
public class test {
  // public static void main(String args[]){

    public static void main(String[] args) throws InterruptedException {

        long lStartTime = System.currentTimeMillis()/60/60/60;

        calculation();

        long lEndTime = System.currentTimeMillis()/60/60/60;

        long output = (lEndTime - lStartTime);

            System.out.println("Elapsed time in milliseconds: " + output);
        

        //System.out.println("Elapsed time in milliseconds: " + output);

    }

    private static void calculation() throws InterruptedException {

        //Sleep 2 seconds
        TimeUnit.MINUTES.sleep(1);
        //TimeUnit.MINUTES.toString();

    }
}
//    String[][] x=new String[1][];
//    x[0][0]="Fred";
    //System.out.println("name is :"+ x[0][0]);
