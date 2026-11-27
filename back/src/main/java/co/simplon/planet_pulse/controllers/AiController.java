package co.simplon.planet_pulse.controllers;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import co.simplon.planet_pulse.dtos.IndicatorRecord;
import co.simplon.planet_pulse.services.AiService;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/connection-test")
    public String testConnection() {
        return aiService.testConnection();
    }

    @PostMapping("/report-preview")
    public String previewReport() {
        String countryName = "Pays Démo";

        IndicatorRecord indicator = new IndicatorRecord(
                2025,
                null,
                new BigDecimal("287.09"),
                new BigDecimal("17.5"),
                new BigDecimal("42.00")
        );

        if (hasNoEnvironmentalData(indicator)) {
            return "There is not enough environmental data to generate a report.";
        }

        String countryData = """
            These data are entirely fictional and used for a demonstration.
            Year: %s.
            Forest area (percentage): %s.
            Annual CO2 emissions (megatonnes): %s.
            PM2.5 exposure (µg/m³): %s.
            Renewable energy share (percentage): %s.
            Historical data and sources are not available.
            """.formatted(
                indicator.year(),
                formatValue(indicator.forestArea()),
                formatValue(indicator.co2Emissions()),
                formatValue(indicator.pm25Exposure()),
                formatValue(indicator.renewableEnergyShare())
        );

        try {
            return aiService.generateReport(countryName, countryData);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(
                    HttpStatus.SERVICE_UNAVAILABLE,
                    "The report could not be generated. Please try again later."
            );
        }
    }

    private String formatValue(BigDecimal value) {
        if (value == null) {
            return "not available";
        }

        return value.toPlainString();
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleReportError(
            ResponseStatusException exception) {

        return ResponseEntity.status(exception.getStatusCode())
                .body(new ErrorResponse(exception.getReason()));
    }

    public record ErrorResponse(String message) {

    }

    private boolean hasNoEnvironmentalData(IndicatorRecord indicator) {
        return indicator.forestArea() == null
                && indicator.co2Emissions() == null
                && indicator.pm25Exposure() == null
                && indicator.renewableEnergyShare() == null;
    }
}
