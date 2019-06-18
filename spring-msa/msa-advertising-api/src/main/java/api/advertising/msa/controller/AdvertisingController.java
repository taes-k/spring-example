package api.advertising.msa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdvertisingController {

	@RequestMapping("/")
	public String getAdvertising() {

		return "advertising Information";
	}
}
