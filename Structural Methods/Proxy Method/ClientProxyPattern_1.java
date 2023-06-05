import java.io.*;
import java.time.LocalDateTime;

interface CustomerServiceDatabase {
    public Customer getCustomerDetails(String custId);
}

class CustomerService implements CustomerServiceDatabase {
    public Customer getCustomerDetails(String custId) {
        // readaing a file
        FileReader fr;
        try {
            fr = new FileReader("customerinfo.txt");
            BufferedReader bf = new BufferedReader(fr);
            while (bf.ready()) {
                String readData = bf.readLine();
                String[] data = readData.split(" ");
                Customer c = new Customer(data[0], data[1], data[2], data[3]);
                if (c.custId.equals(custId)) {
                    return c;
                }
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Customer {
    String custId, custName, custEmail, custCity;

    public Customer(String custId, String custName, String custEmail, String custCity) {
        this.custId = custId;
        this.custName = custName;
        this.custEmail = custEmail;
        this.custCity = custCity;
    }

    public String toString() {
        return "Customer [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", custCity="
                + custCity + "]";
    }
}

class CustomerServiceProxy implements CustomerServiceDatabase {
    User connectedUser;
    CustomerService cs = new CustomerService();

    public CustomerServiceProxy(User u) {
        this.connectedUser = u;
    }

    public Customer getCustomerDetails(String custId) {
        if (connectedUser.role.equals("ADMIN") && connectedUser.passWd.equals("123")) {
            Customer c = cs.getCustomerDetails(custId);
            log("logCustomerDatabase.log", "OK", "FETCH", connectedUser, "read details of " + custId + "\n");
            return c;
        }
        // write user info to logCustomerDatabase.txt

        // If user role is "Admin" then forward the request

        // Else message
        System.out.println("Access is denied");
        log("logCustomerDatabase.log", "ERROR", "FETCH", connectedUser, "read details of " + custId + "\n");
        return null;
    }

    public void log(String filename, String status, String method, User user, String data) {
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(filename, true));
            String str = status + " " + LocalDateTime.now().toString() + " " + method + " " + user.Id + " "
                    + user.username + " " + user.role + " : " + data;
            fw.append(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class User {
    String username, role, Id, passWd;

    public User(String Id, String username, String role, String passWd) {
        this.Id = Id;
        this.username = username;
        this.role = role;
        this.passWd = passWd;
    }
}

class ClientProxyPattern_1 {
    public static void main(String[] args) {

        User u1 = new User("User001", "Bhavya", "ADMIN", "123");

        CustomerServiceDatabase csd = new CustomerServiceProxy(u1);
        Customer c1 = csd.getCustomerDetails("CU102");
        Customer c2 = csd.getCustomerDetails("CU104");

        System.out.println(c1);
        System.out.println(c2);

        User u2 = new User("User002", "Smit", "User", "555");
        CustomerServiceDatabase csd2 = new CustomerServiceProxy(u2);

        Customer c3 = csd2.getCustomerDetails("CU103");
        System.out.println(c3);
    }
}