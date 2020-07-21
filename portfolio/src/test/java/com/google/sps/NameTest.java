package com.google.sps.servlets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletOutputStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public final class NameTest extends Mockito {
  private final DataServlet servlet = new DataServlet();

  @Mock
  private final HttpServletRequest request;
  @Mock
  private final HttpServletResponse response;
  @Mock
  private final ServletConfig servletConfig;
  @Mock
  private final ServletOutputStream outputStream;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getMyName() throws IOException {
   when(servlet.getServletConfig()).thenReturn(servletConfig);
   when(response.getOutputStream()).thenReturn(outputStream);
   servlet.doGet(request, response);

   verify(outputStream).println("Hello Bianca!");
  }
}