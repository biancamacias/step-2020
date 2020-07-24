package com.google.sps.servlets;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.*;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.Mock;

@RunWith(JUnit4.class)
public class NameTest {

  private final DataServlet servlet = new DataServlet();

  @Rule public MockitoRule mockito = MockitoJUnit.rule();

  @Mock private HttpServletRequest request;
  @Mock private HttpServletResponse response;
  @Mock private ServletOutputStream outputStream;

  @Test
  public void getMyName() throws IOException {
    when(response.getOutputStream()).thenReturn(outputStream);
    servlet.doGet(request, response);

    verify(response).setContentType("plain/text");
    verify(outputStream).println("Hello Bianca!");
  }
}
