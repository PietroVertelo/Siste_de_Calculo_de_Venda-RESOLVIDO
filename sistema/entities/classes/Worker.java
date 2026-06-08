package sistema.entities.classes;

import sistema.entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Departament departament;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double income(Integer year, Integer month) {
        double soma = baseSalary;
        Calendar calendar = Calendar.getInstance();
        for (HourContract contrato : contracts) {
            calendar.setTime(contrato.getDate());
            int calendar_year = calendar.get(Calendar.YEAR);
            int calendar_month = calendar.get(Calendar.MONTH);
            if (year == calendar_year && month == calendar_month) {
                soma += contrato.totalValue();
            }
        }
        return soma;
    }
}
