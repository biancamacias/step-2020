package com.google.sps.servlets;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.FetchOptions.Builder;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
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

@WebServlet("/delete-data")
public class DeleteServlet extends HttpServlet {
  private final DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Query query = new Query(DataServlet.COMMENT_TABLE_NAME).addSort(DataServlet.TIMESTAMP_COLUMN_NAME, SortDirection.DESCENDING);
    PreparedQuery results = datastore.prepare(query);
    int deleteComments = 2;

    for (Entity entity : results.asList(FetchOptions.Builder.withLimit(deleteComments))) {
      datastore.delete(entity.getKey());
    }
        
    response.sendRedirect("/index.html");
  }
}