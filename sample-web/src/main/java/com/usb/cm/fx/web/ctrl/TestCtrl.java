package com.usb.cm.fx.web.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("test")
public class TestCtrl {

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public @ResponseBody Map<Integer, String> getList() {
		Map<Integer, String> map = new HashMap<Integer, String>(1);

		for (int i = 1; i <= 10; i++) {
			map.put(i, "value " + i);
		} // for

		return map;
	}

	/**
     * Welcome.
     * 
     * @return the string
     */
    @RequestMapping("/home")
    public String welcome() {
        return "home";
    }
	
}
