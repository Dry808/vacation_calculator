package ru.neostudy.neoflex.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.neostudy.neoflex.model.VacationRequest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacationCalculatorTest {
    VacationCalculatorService calculatorService;
    @BeforeEach
    public void beforeEach() {
        calculatorService = new VacationCalculatorService();
    }


    @Test
    public void testCalculateVacationPay() {
        VacationRequest request = new VacationRequest();
        request.setAverageSalary(120000);
        request.setVacationDays(14);

        double vacationPay = calculatorService.calculateVacationPay(request);
        assertEquals(57337.88, vacationPay, 0.1);
    }

    @Test
    public void testCalculateVacationPayWithStartDate() {
        VacationRequest request = new VacationRequest();
        request.setAverageSalary(120000);
        request.setVacationDays(14);
        request.setStartDate(LocalDate.of(2023, 10, 1));

        double vacationPay = calculatorService.calculateVacationPay(request);
        assertEquals(57337.88, vacationPay, 0.1);
    }
}