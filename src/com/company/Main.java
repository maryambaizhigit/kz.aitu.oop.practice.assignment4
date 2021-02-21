package com.company;

//import the paths to the classes
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.CostRepository;
import com.company.repositories.TopRepository;
import com.company.repositories.MiddleRepository;
import com.company.repositories.LowRepository;
import com.company.repositories.interfaces.ICostRepository;
import com.company.repositories.interfaces.ITopRepository;
import com.company.repositories.interfaces.IMiddleRepository;
import com.company.repositories.interfaces.ILowRepository;

public class Main {
    public static void main(String[] args) {
        // specify which DB and Repository to use
        // changing DB should not affect to whole code
        IDB db = new PostgresDB();
        ITopRepository repo = new TopRepository(db);
        IMiddleRepository repo2 = new MiddleRepository(db);
        ILowRepository repo1 = new LowRepository(db);
        ICostRepository repo3 = new CostRepository(db);

        MyApplication app = new MyApplication(repo, repo2, repo1, repo3);
        app.start();
    }
}