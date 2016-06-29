/**
 * 
 */
package br.com.felipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Felipe Zanardo Affonso
 *
 */
@Controller
@RequestMapping(value = "/")
public class ViewsController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index";
	}

}
