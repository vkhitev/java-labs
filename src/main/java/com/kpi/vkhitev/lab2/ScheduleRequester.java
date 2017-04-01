package com.kpi.vkhitev.lab2;

import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.http.client.utils.URIBuilder;

public class ScheduleRequester {
  private class Groups {
    Groups () {
      data = new ArrayList<>();
    }

    private List<Group> data;

    private class Group {
      private String group_full_name;
    }

    private List<String> stringify () {
      return data.stream()
        .map(g -> g.group_full_name)
        .collect(Collectors.toList());
    }
  }

  public static List<String> fetchGroups () throws Exception {
    String url = new URIBuilder()
      .setPath("http://api.rozklad.org.ua/v2/groups/")
      .toString();
    String res = Request.get(url);
    return new Gson().fromJson(res, ScheduleRequester.Groups.class).stringify();
  }
}
