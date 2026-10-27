package rw.ba.kigali_barber.barber.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import rw.ba.kigali_barber.barber.dto.AssignHairStylesRequest;
import rw.ba.kigali_barber.barber.service.BarberHairStyleService;
import rw.ba.kigali_barber.common.response.ApiResponse;
import rw.ba.kigali_barber.hairstyle.dto.HairStyleResponse;

@RestController
@Tag(name = "Barber Hair Styles")
@RequestMapping("/api/barbers/{barberId}/hair-styles")
public class BarberHairStyleController {
    private final BarberHairStyleService barberHairStyleService;

    public BarberHairStyleController(BarberHairStyleService barberHairStyleService) {
        this.barberHairStyleService = barberHairStyleService;
    }

    @GetMapping
    public ApiResponse<List<HairStyleResponse>> getHairStyles(@PathVariable UUID barberId) {
        return new ApiResponse<>(true, "Barber hair styles retrieved successfully",
                barberHairStyleService.getHairStyles(barberId));
    }

    @PutMapping
    public ApiResponse<List<HairStyleResponse>> replaceHairStyles(@PathVariable UUID barberId,
            @Valid @RequestBody AssignHairStylesRequest request) {
        return new ApiResponse<>(true, "Barber hair styles updated successfully",
                barberHairStyleService.replaceHairStyles(barberId, request.hairStyleIds()));
    }

    @DeleteMapping("/{hairStyleId}")
    public ApiResponse<Void> removeHairStyle(@PathVariable UUID barberId, @PathVariable UUID hairStyleId) {
        barberHairStyleService.removeHairStyle(barberId, hairStyleId);
        return new ApiResponse<>(true, "Hair style removed from barber successfully", null);
    }
}
