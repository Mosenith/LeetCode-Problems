package fppQuiz;

public class Main {
    String managerInfo = (new Employee("Joe", 200000) {
        double bonus; {
            bonus = .05;
        }

        int computeSalaryWithBonus() {
            return (int) ((1+bonus) * getSalary());
        }

        @Override
        public String toString() {
            return "name : " + getName() + "\n"
                    + " base salary : " + getSalary() + "\n"
                    + " bonus : " + bonus + "\n"
                    + " actual salary : " + computeSalaryWithBonus();
        }
    }).toString();

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.managerInfo + "\n\n");
    }
}
