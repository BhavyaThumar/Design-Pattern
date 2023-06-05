import java.util.*;

public class interview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Industry Automobile = new Industry("Auto MobileIndustry");

        Applicant[] applicants = new Applicant[] 
        {
                new Applicant("Bhavya", "Automobile", new ContactDetails("RJT", 123123, 9)),
                new Applicant("Tej", "Automobile", new ContactDetails("Rasd", 123, 56))
        };

        Automobile.addaplicants(new ArrayList<Applicant>(Arrays.asList(applicants)));

        System.out.println(Automobile);

        Industry CSE = new Industry("CSE");
        
        applicants = new Applicant[] 
        {
                new Applicant("Denil", "CSE", new ContactDetails("RJT", 123123, 9)),
                new Applicant("RDX", "CSE", new ContactDetails("Rasd", 34445, 6))
        };

        CSE.addaplicants(new ArrayList<Applicant>(Arrays.asList(applicants)));

        System.out.println(CSE);
    }

}

class Applicant {
    protected String name, field;
    protected ContactDetails contactDetails;

    Applicant(String name, String field, ContactDetails contactDetails) {
        this.name = name;
        this.field = field;
        this.contactDetails = contactDetails;
    }

    @Override
    public String toString() {
        return "Applicant name=" + name + ", field=" + field + "," + contactDetails + "\n";
    }

}

class ContactDetails {
    Scanner sc = new Scanner(System.in);
    protected String address;
    protected int exp;
    protected long phone;

    ContactDetails(String address, long phone, int exp) {
        this.address = address;
        this.phone = phone;
        this.exp = exp;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getaddress() {
        return address;
    }

    public void setphone(long phone) {
        this.phone = phone;
    }

    public long getphone() {
        return phone;
    }

    public void setexp(int exp) {
        this.exp = exp;
    }

    public int getexp(int exp) {
        return exp;
    }

    @Override
    public String toString() {
        return "ContactDetails" + ", address=" + address + ", exp=" + exp + ", phone=" + phone + "\t";
    }
}

class Industry {
    protected String Industryname;
    protected ArrayList<Applicant> applicants;

    Industry(String Industryname) {
        this.Industryname = Industryname;
        this.applicants = new ArrayList<Applicant>();
    }

    Industry(String Industryname, ArrayList<Applicant> applicants) {
        this.Industryname = Industryname;
        this.applicants = applicants;
    }

    public String getIndustryname(String Industryname) {
        return Industryname;
    }

    public void addaplicants(ArrayList<Applicant> applicants) {
        this.applicants.addAll(applicants);
    }

    @Override
    public String toString() {
        return "Industryname=" + Industryname + "," + applicants;
    }

}
