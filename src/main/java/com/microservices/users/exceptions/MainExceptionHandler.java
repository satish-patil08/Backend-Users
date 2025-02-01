package com.microservices.users.exceptions;


import com.microservices.shared_utils.statusResponces.StatusResponse;
import com.microservices.users.proxy.NotificationProxy;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.microservices.shared_utils.constants.Constants.ERROR_MESSAGE;

@ControllerAdvice
public class MainExceptionHandler {

    @Autowired
    private NotificationProxy notificationProxy;


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<StatusResponse> exception(Exception ex, HttpServletRequest request) {
        ex.printStackTrace();

        // Get the URL from the request object
        String requestURL = request.getRequestURL().toString();

        // Capture the stack trace to get file name and line number
        StackTraceElement[] stackTrace = ex.getStackTrace();
        String fileName = "";
        int lineNumber = 0;
        String yourPackagePrefix = "com.microservices"; // replace with your package's prefix
        for (StackTraceElement element : stackTrace) {
            if (element.getClassName().startsWith(yourPackagePrefix)) {
                fileName = element.getFileName();
                lineNumber = element.getLineNumber();
                break;  // Stop once you find the first element that matches
            }
        }

        notificationProxy.reportError(new ErrorHandlingRequest(
                "Backend-Users (File: " + fileName + "; Line Number: " + lineNumber + "; URL: " + requestURL + ")",
                ex.getMessage(),
                ex.toString()
        ));

        return new ResponseEntity<>(
                new StatusResponse(
                        false,
                        ERROR_MESSAGE
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
