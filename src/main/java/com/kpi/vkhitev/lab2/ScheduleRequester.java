package com.kpi.vkhitev.lab2;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.kpi.vkhitev.lab2.Models.Group;
import com.kpi.vkhitev.lab2.Models.Timetable;
import com.mashape.unirest.http.Unirest;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleRequester {
  private static final Gson gson = new Gson();

  private static String fetchJSON(String url) throws Exception {
    String res = Unirest.get(url).asJson().getBody().toString();
    Integer statusCode = new JsonParser()
      .parse(res)
      .getAsJsonObject()
      .get("statusCode")
      .getAsInt();
    if (statusCode == 404) {
      throw new Exception("Bad status code");
    } else {
      return res;
    }
  }

  private static List<String> fetchPartialGroupNames (int offset) {
    String res = null;
    try {
      String query = URLEncoder.encode("{\"limit\":100,\"offset\":" + offset + "}", "UTF-8");
      res = fetchJSON("http://api.rozklad.org.ua/v2/groups/?filter=" + query);
    } catch (Exception e) {
      System.out.println("Can not fetch groups");
      System.out.println(e.toString());
      return null;
    }
    Type type = new TypeToken<List<Group>>() {}.getType();
    String data = new JsonParser()
      .parse(res)
      .getAsJsonObject()
      .get("data")
      .getAsJsonArray()
      .toString();
    ArrayList<Group> groupNames = gson.fromJson(data, type);
    return groupNames
      .stream()
      .map(Group::getGroupFullName)
      .collect(Collectors.toList());
  }

  private static Integer fetchCountGroups() {
    String res;
    try {
      res = fetchJSON("http://api.rozklad.org.ua/v2/groups/");
    } catch (Exception e) {
      System.out.println("Can not fetch group size");
      return 0;
    }
    return new JsonParser()
      .parse(res)
      .getAsJsonObject()
      .get("meta")
      .getAsJsonObject()
      .get("total_count")
      .getAsInt();
  }

  public static List<String> fetchGroupNames() {
    List<String> groupNames = new ArrayList<>();
    int groups = fetchCountGroups();
    for (int i = 0; i < groups; i += 100) {
      groupNames.addAll(fetchPartialGroupNames(i));
    }
    return groupNames;
  }

  public static Timetable fetchTimetable(String groupName) {
    String url = "http://api.rozklad.org.ua/v2/groups/" + groupName + "/timetable";
    String res = "";
    try {
      res = fetchJSON(url);
    } catch (Exception e) {
//      System.out.println("Timetable for " + groupName + " does not exist");
      return null;
    }
    JsonObject data = new JsonParser()
      .parse(res)
      .getAsJsonObject()
      .get("data")
      .getAsJsonObject();

    JsonElement groupFullName = data
      .get("group")
      .getAsJsonObject()
      .get("group_full_name");

    data
      .add("group_full_name", groupFullName);

    return gson.fromJson(data.toString(), Timetable.class);
  }
}
