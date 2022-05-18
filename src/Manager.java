public class Manager {
    int rate = 1000;
    int hoursWorked;
    int allowance;
    String natureOfWork;

    Manager(String natureOfWork, int hoursWorked) {
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

        return grossPay;

    }
}
