package org.example.simpletest.controllers;


import org.example.simpletest.services.HighSecureService;
import org.example.simpletest.services.LowSecureService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class SecuredController {
	
	
	private final LowSecureService lowSecureService;
	private final HighSecureService highSecureService;

	public SecuredController(final LowSecureService lowSecureService, final HighSecureService highSecureService) {
		this.highSecureService = highSecureService;
		this.lowSecureService = lowSecureService;
	}

	@GetMapping(path = "/low")
	public String foo() {
		lowSecureService.lowSecureSeviceFoo();
		return "OK low";
	}

	@GetMapping(path = "/high")
	public String bar() {
		highSecureService.secureServicesMethodFoo();
		return "OK High";
	}
	
	
	
	@GetMapping("/safe")
	public String safe() {
		return "i am save";
	}



	}


