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
    private static final String COMMENT_TABLE_NAME = "Comment";
    private static final String COMMENT_COLUMN_NAME = "comment";
    private static final String TIMESTAMP_COLUMN_NAME = "submit_time";
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TO DO(biancamacias): add data structure of keys and add while loop that deletes keys from that data structure
        Query query = new Query(COMMENT_TABLE_NAME).addSort(TIMESTAMP_COLUMN_NAME, SortDirection.DESCENDING);
        PreparedQuery results = datastore.prepare(query);

        response.sendRedirect("/index.html");
    }
}