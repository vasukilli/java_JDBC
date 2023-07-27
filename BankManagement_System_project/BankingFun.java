package com.jdbcdemo.myApp;
import java.sql.*;
import java.sql.Statement;
import java.util.*;
public abstract class BankingFun 
{
  abstract public void insertData(Connection con);
  abstract public void readData(Connection con);
  abstract public void updateData(Connection con);
  abstract public void deleteData(Connection con);
  
}
