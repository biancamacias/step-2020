package com.google.sps.servlets;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.*;
import org.mockito.junit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.Mock;

@RunWith(JUnit4.class)
public final class NameTest {

  private final DataServlet servlet = new DataServlet();

  public MockitoRule mockito = MockitoJUnit.rule();

  @Mock private final HttpServletRequest request;
  @Mock private final HttpServletResponse response;
  @Mock private final ServletOutputStream outputStream;

  @Test
  public void getMyName() throws IOException {
    when(response.getOutputStream()).thenReturn(outputStream);
    servlet.doGet(request, response);

    verify(response).setContentType("plain/text");
    verify(outputStream).println("Hello Bianca!");
  }
}
