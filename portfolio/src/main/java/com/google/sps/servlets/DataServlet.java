// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
  static final String COMMENT_TABLE_NAME = "Comment";
  static final String COMMENT_COLUMN_NAME = "comment";
  static final String TIMESTAMP_COLUMN_NAME = "submit_time";
  private final DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Query query =
        new Query(COMMENT_TABLE_NAME).addSort(TIMESTAMP_COLUMN_NAME, SortDirection.DESCENDING);
    PreparedQuery results = datastore.prepare(query);
    List<String> commentsList = new ArrayList<String>();
    int hardCodedNumOfCommentsToDisplay = 2;
    List<Entity> limitedResults =
        results.asList(FetchOptions.Builder.withLimit(hardCodedNumOfCommentsToDisplay));

    List commentsList =
        limitedResults.stream()
            .map(entity -> entity.getProperty(COMMENT_COLUMN_NAME))
            .map(String.class::cast)
            .collect(toList());

    response.setContentType("application/json");
    String json = convertToJsonUsingGson(commentsList);
    response.getWriter().println(json);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Gets comment input from <form> by id selector
    String comment = request.getParameter("comment-input");
    long submit_time = System.currentTimeMillis();

    Entity commentEntity = new Entity(COMMENT_TABLE_NAME);
    commentEntity.setProperty(COMMENT_COLUMN_NAME, comment);
    commentEntity.setProperty(TIMESTAMP_COLUMN_NAME, submit_time);

    datastore.put(commentEntity);

    response.sendRedirect("/index.html");
  }

  private static String convertToJsonUsingGson(List<String> commentsToConvert) {
    Gson gson = new Gson();
    String json = gson.toJson(commentsToConvert);
    return json;
  }
}
