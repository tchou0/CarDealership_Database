package com.yearup.dealership;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static Dealership dealership = new Dealership();

    public static void main(String[] args) {

        dealership.mainMenu();

    }

}
