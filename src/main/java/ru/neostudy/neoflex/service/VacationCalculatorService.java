package ru.neostudy.neoflex.service;

import org.springframework.stereotype.Service;
import ru.neostudy.neoflex.model.VacationRequest;
import ru.neostudy.neoflex.util.DateUtil;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class VacationCalculatorService {

    public double calculateVacationPay(VacationRequest request) {
        double averageSalary = request.getAverageSalary();
        int vacationDays = request.getVacationDays();

        if (request.getStartDate() != null) {
            vacationDays = calculateWorkingDays(request.getStartDate(), vacationDays);
        }
        // вычисление отпускных
        double vacationPay = averageSalary / 29.3 * vacationDays;

        // округление до 2 знаков после запятой
        double roundedVacationPay = Math.round(vacationPay * 100.0) / 100.0;

        return roundedVacationPay;
    }

    private int calculateWorkingDays(LocalDate startDate, int vacationDays) {
        int workingDays = 0;
        LocalDate currentDate = startDate;

        while (workingDays < vacationDays) {
            if (DateUtil.isWorkingDay(currentDate)) {
                workingDays++;
            }
            currentDate = currentDate.plus(1, ChronoUnit.DAYS);
        }

        return workingDays;
    }
}
