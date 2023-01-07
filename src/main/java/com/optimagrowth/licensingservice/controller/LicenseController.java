package com.optimagrowth.licensingservice.controller;

import com.optimagrowth.licensingservice.model.License;
import com.optimagrowth.licensingservice.service.LicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping(value = "v1/organization/{organizationId}/license")
@RequiredArgsConstructor
public class LicenseController {

    private final LicenseService licenseService;

    @RequestMapping(value = "/{licenseId}", method = RequestMethod.GET)
    public ResponseEntity<License> getLicense(
            @PathVariable("organizationId") String organizationId,
            @PathVariable("licenseId") String licenseId) {

        License license = licenseService.getLicense(licenseId, organizationId);

        return ResponseEntity.ok(license);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createLicense(
            @PathVariable("organizationId") String organizationId,
            @RequestBody License request,
            @RequestHeader(value = "Accept-language", required = false) Locale locale) {

        return ResponseEntity.ok(licenseService.createLicense(request, organizationId, locale));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<String> updateLicense(
            @PathVariable("organizationId") String organizationId,
            @RequestBody License request,
            @RequestHeader(value = "Accept-language", required = false) Locale locale) {

        return ResponseEntity.ok(licenseService.updateLicense(request, organizationId, locale));
    }

    @RequestMapping(value = "/{licenseId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteLicense(
            @PathVariable("organizationId") String organizationId,
            @PathVariable("licenseId") String licenseId,
            @RequestHeader(value = "Accept-language", required = false) Locale locale) {

        return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId, locale));
    }

}
