public class Employee {
    int rate = 300;
    int hoursWorked;
    int allowance;
    String natureOfWork;

    Employee(String natureOfWork, int hoursWorked) {
        this.natureOfWork = natureOfWork;
        this.hoursWorked = hoursWorked;
    }

    public int grossPay() {
        if (natureOfWork == "field") {
            this.allowance = 1000;
        } else {
            this.allowance = 0;
        }

        int grossPay = rate * hoursWorked + allowance;

        System.out.println(grossPay);

        return grossPay;

    }
}
