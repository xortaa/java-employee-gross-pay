public class Supervisor {
    int rate = 700;
    int hoursWorked;
    int allowance;
    String natureOfWork;

    Supervisor(String natureOfWork, int hoursWorked) {
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
