package rpc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	try {
		JSONObject input = RpcHelper.readJsonObject(request);
		if (input.has("user_id") && input.has("visited")) {
			String userId = (String) input.get("user_id");
			JSONArray array = (JSONArray) input.get("visited");
			List<String> visitedEvents = new ArrayList<>();
			for (int i = 0; i < array.length(); i++) {
				String eventId = (String) array.get(i);
				visitedEvents.add(eventId);
			}

			RpcHelper.writeJsonObject(response,
					new JSONObject().put("status", "OK"));
		} else {
			RpcHelper.writeJsonObject(response,
					new JSONObject().put("status", "InvalidParameter"));
		}
	} catch (JSONException e) {
		e.printStackTrace();
	}
}

