package com.nhnghia.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MessageUtil {

	public Map<String, String> showMessage(String message) {
		Map<String, String> result = new HashMap<>();
		if (message.equals("update_success")) {
			result.put("message", "Update success!");
			result.put("alert", "success");
		} else if (message.equals("insert_success")) {
			result.put("message", "Insert success!");
			result.put("alert", "success");
		} else if (message.equals("delete_success")) {
			result.put("message", "Delete success!");
			result.put("alert", "success");
		} else if (message.equals("error_success")) {
			result.put("message", "Error system!");
			result.put("alert", "danger");
		}
		
		return result;
	}

}
