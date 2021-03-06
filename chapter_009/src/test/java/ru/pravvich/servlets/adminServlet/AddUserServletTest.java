package ru.pravvich.servlets.adminServlet;

import org.junit.Test;
import ru.pravvich.jdbc.DBJoint;
import ru.pravvich.jdbc.DBJointHandler;
import ru.pravvich.jdbc.ScriptExecutor;
import ru.pravvich.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.Mockito.*;
import static ru.pravvich.servlets.Messages.EDIT_SUCCESS;
import static ru.pravvich.servlets.Messages.ERR_UNIQUE_L_P;
import static ru.pravvich.servlets.Paths.ANSWER;

public class AddUserServletTest {

    @Test
    public void whenUserAddThenDatabaseSuccessfully()
            throws ServletException, IOException, SQLException {

        final AddUserServlet servlet = new AddUserServlet();
        User user = new User("name", "login", "password", "email", "admin");

        //mock http.
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("name")).thenReturn("name");
        when(request.getParameter("login")).thenReturn("login");
        when(request.getParameter("password")).thenReturn("password");
        when(request.getParameter("email")).thenReturn("email");
        when(request.getParameter("role")).thenReturn("admin");

        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher(ANSWER.get()))
                .thenReturn(dispatcher);

        //mock database.
        ScriptExecutor executor = mock(ScriptExecutor.class);

        when(executor.addUserAndGetSuccess(user)).thenReturn(true);

        DBJoint joint = mock(DBJointHandler.class);
        when(joint.getDBScriptExecutor()).thenReturn(executor);

        ServletContext context = mock(ServletContext.class);
        when(request.getServletContext()).thenReturn(context);
        when(context.getAttribute("db")).thenReturn(joint);

        servlet.doPost(request, response);

        verify(request).getRequestDispatcher(ANSWER.get());
        verify(request).setAttribute("serverAnswer", EDIT_SUCCESS.get());
    }


    @Test
    public void whenAddInDatabaseOsFail()
            throws SQLException, ServletException, IOException {

        final AddUserServlet servlet = new AddUserServlet();
        User user = new User("name", "login", "password", "email", "admin");

        //mock http.
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);

        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher(ANSWER.get()))
                .thenReturn(dispatcher);

        //mock database.
        ScriptExecutor executor = mock(ScriptExecutor.class);



        DBJoint joint = mock(DBJointHandler.class);
        when(joint.getDBScriptExecutor()).thenReturn(executor);

        ServletContext context = mock(ServletContext.class);
        when(request.getServletContext()).thenReturn(context);
        when(context.getAttribute("db")).thenReturn(joint);

        servlet.doPost(request, response);

        verify(request).getRequestDispatcher(ANSWER.get());
        verify(request).setAttribute("serverAnswer", ERR_UNIQUE_L_P.get());
    }
}