package rw.ba.kigali_barber.barber;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import rw.ba.kigali_barber.barber.dto.BarberRequestDto;
import rw.ba.kigali_barber.common.response.ApiResponse;

@RestController
@Tag(name = "Barbers")
@RequestMapping("/api/barbers")
public class BarberController {
    private final BarberService barberService;

    public BarberController(BarberService barberService) {
        this.barberService = barberService;
    }

    @PostMapping
    public ApiResponse<String> create(@RequestBody BarberRequestDto request) {
        return new ApiResponse<>(true, "success", barberService.create(request));
    }

    @GetMapping
    public ApiResponse<List<BarberEntity>> getAll() {
        return new ApiResponse<List<BarberEntity>>(true, "barbers get successfully", barberService.getAll(null));
    }
}
