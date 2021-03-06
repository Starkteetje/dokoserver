package doko.rest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;

public class DokoController {
	
	@ModelAttribute
	public void setHeaders(HttpServletResponse response) {
		response.setHeader("strict-transport-security", "max-age=31536000; includeSubDomains; preload"); // HTST header with 1 year validity, include all subdomains, request HSTS-preloading
		response.setHeader("referrer-policy", "no-referrer"); // Do not send information on which this site to other linked sites
		response.setHeader("content-security-policy", "default-src 'none'; script-src 'self' https://www.gstatic.com; style-src 'self' 'unsafe-inline' https://www.gstatic.com; img-src 'self'; report-uri https://teetje-doko.de/reportcsp; base-uri 'self'; form-action 'self'; frame-ancestors 'none'"); // Load assets only from this site and additionally scripts/css from gstatic//TODO remove unsafe inline
		// require-sri-for style script cannot be set, because integrity check requires CORS and charts is not implementing it (except for requests with Origin header missing the scheme [WTF], which the browser won't sent)
		response.setHeader("x-frame-options", "DENY"); // Do not allow page to be loaded as an iframe
		response.setHeader("x-xss-protection", "1;mode=block"); // Enable XSS protection, block load if attack detected
		response.setHeader("x-content-type-options", "nosniff"); // Tell browser to stick with declared content type
		response.setHeader("feature-policy", "geolocation 'none'; midi 'none'; notifications 'none'; push 'none'; sync-xhr 'none'; microphone 'none'; camera 'none'; magnetometer 'none'; gyroscope 'none'; speaker 'none'; vibrate 'none'; fullscreen 'none'; payment 'none'"); // Tell browser not to allow access to any feature
	}
}
