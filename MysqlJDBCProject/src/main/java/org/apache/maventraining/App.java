package org.apache.maventraining;

import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
    	ExecutableClass executableClass = new ExecutableClass();
    	executableClass.start();
    }
}
