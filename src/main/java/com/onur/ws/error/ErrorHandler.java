package com.onur.ws.error;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import ch.qos.logback.core.joran.action.IncludeAction;

@RestController
public class ErrorHandler implements ErrorController  {
	
	
	
	@Autowired
	private ErrorAttributes errorAttributes;
	
	@RequestMapping("/error")
	ApiError handelError(WebRequest webRequest) {
		Map<String,Object> attributes = this.errorAttributes.getErrorAttributes(webRequest
				,ErrorAttributeOptions.of(Include.MESSAGE, Include.BINDING_ERRORS));
		String message = (String) attributes.get("message");
		String path = (String) attributes.get("path");
		int status = (Integer) attributes.get("status");
		 return new ApiError(status, message, path);
		
	}
 
	@Override
	public String getErrorPath() {
		
		return "/error";
	}

}
