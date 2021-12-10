package musifan.musifan.controller.rest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import musifan.musifan.entity.Compte;
import musifan.musifan.entity.JsonViews;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthRestController {
	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public Compte login(@AuthenticationPrincipal Compte cUD) {
		return cUD.getCompte();
	}
}
