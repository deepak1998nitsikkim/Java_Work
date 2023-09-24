import java.util.Random;

// Employee class with a parameterized constructor
class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

// CredentialService class for generating credentials
class CredentialService {
    private Employee employee;

    public CredentialService(Employee employee) {
        this.employee = employee;
    }

    // Generate an email address based on department and company
    public String generateEmailAddress(String department, String company) {
        String email = employee.getFirstName().toLowerCase() + employee.getLastName().toLowerCase() + "@" + department + "." + company + ".com";
        return email;
    }

    // Generate a random password with number, capital letter, small letter, and special character
    public String generatePassword() {
        Random rand = new Random();
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

        String password = "";
        password += uppercase.charAt(rand.nextInt(uppercase.length()));
        password += lowercase.charAt(rand.nextInt(lowercase.length()));
        password += digits.charAt(rand.nextInt(digits.length()));
        password += specialChars.charAt(rand.nextInt(specialChars.length()));

        for (int i = 0; i < 4; i++) {
            char randomChar = specialChars.charAt(rand.nextInt(specialChars.length()));
            password += randomChar;
        }

        return password;
    }

    // Display the generated credentials
    public void showCredentials(String department, String company) {
        String email = generateEmailAddress(department, company);
        String password = generatePassword();

        System.out.println("Dear " + employee.getFirstName() + ", your generated credentials are as follows:");
        System.out.println("\n\n-----Email ---> " + email);
        System.out.println("\n\n-----Password ---> " + password);
    }
}

class Main {
    public static void main(String[] args) {
        String firstName = "Deepak";
        String lastName = "Dhingan";
        String department = "Tech";
        String company = "greatlearning";

        Employee employee = new Employee(firstName, lastName);
        CredentialService credentialService = new CredentialService(employee);

        credentialService.showCredentials(department, company);
    }
}