package Proxy;

public class Proxy {
    public static void main(String[] args) throws Exception {
        /*DatabaseExecuter nonAdminUser = new DatabaseExecuterProxy("NonAdmin","NonAdmin@123");
        nonAdminUser.executeDatabase("delete");*/

        DatabaseExecuter adminUser = new DatabaseExecuterProxy("Admin","Admin@123");
        adminUser.executeDatabase("delete");
    }
}

interface DatabaseExecuter {
    public void executeDatabase(String query) throws Exception;
}

class DatabaseExecuterImpl implements DatabaseExecuter {

    @Override
    public void executeDatabase(String query) throws Exception {
        System.out.println("Going to execute query " + query);
    }
}

class DatabaseExecuterProxy implements DatabaseExecuter {

    boolean ifAdmin;
    DatabaseExecuterImpl databaseExecuter;

    public DatabaseExecuterProxy(String name, String password) {
        if (name.equals("Admin") && password.equals("Admin@123")) {
            ifAdmin = true;
            databaseExecuter = new DatabaseExecuterImpl();
        }
    }

    @Override
    public void executeDatabase(String query) throws Exception {
        if (ifAdmin) {
            databaseExecuter.executeDatabase(query);
        } else {
            if(query.equals("delete")){
                throw new Exception("Delete not allowed for non-admin user");
            } else {
                databaseExecuter.executeDatabase(query);
            }
        }
    }
}
