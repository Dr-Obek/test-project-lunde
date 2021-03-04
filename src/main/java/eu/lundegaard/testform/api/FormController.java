package eu.lundegaard.testform.api;

import eu.lundegaard.testform.model.ContactFormRequestDto;
import eu.lundegaard.testform.model.ContactFormResponseDto;
import eu.lundegaard.testform.model.RequestKindResponseDto;
import eu.lundegaard.testform.service.ContactFormService;
import eu.lundegaard.testform.service.RequestKindService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * This controller class exposes REST API of the application
 */
@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
@Validated
public class FormController {

    private final ContactFormService contactFormService;
    private final RequestKindService requestKindService;

    @GetMapping("/request-kinds")
    public List<RequestKindResponseDto> getRequestKinds() {
        return requestKindService.getAllRequestKinds();
    }

    @PostMapping
    public ContactFormResponseDto submitForm(@RequestBody @Valid final ContactFormRequestDto contactFormRequestDto) {
        return contactFormService.submitForm(contactFormRequestDto);
    }
}
