package cat.tecnocampus.notes.apiRest.exceptionHandlers;

import cat.tecnocampus.notes.application.exception.UserNotFoundException;
import cat.tecnocampus.notes.domain.exception.NotEditableNote;
import cat.tecnocampus.notes.domain.exception.NoteNotOwnedException;
import cat.tecnocampus.notes.persistence.exception.NoteDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(NoteDoesNotExistException.class)
    public ResponseEntity<String> handleNoteDoesNotExistException(NoteDoesNotExistException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(NotEditableNote.class)
    public ResponseEntity<String> handleNotEditableNoteException(NotEditableNote ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(NoteNotOwnedException.class)
    public ResponseEntity<String> handleNoteNotOwnedException(NoteDoesNotExistException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

}
