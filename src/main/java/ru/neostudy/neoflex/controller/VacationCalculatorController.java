package ru.neostudy.neoflex.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neostudy.neoflex.model.VacationRequest;
import ru.neostudy.neoflex.service.VacationCalculatorService;

import java.time.LocalDate;

@RestController
public class VacationCalculatorController {

    @Autowired
    private VacationCalculatorService calculatorService;

    @GetMapping("/calculate")
    public double calculateVacationPay(@RequestParam double averageSalary,
                                       @RequestParam int vacationDays,
                                       @RequestParam(required = false) String startDate) {
        VacationRequest request = new VacationRequest();
        request.setAverageSalary(averageSalary);
        request.setVacationDays(vacationDays);

        if (startDate != null) {
            request.setStartDate(LocalDate.parse(startDate));
        }

        return calculatorService.calculateVacationPay(request);
    }
}
