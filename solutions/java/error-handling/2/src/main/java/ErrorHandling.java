import java.util.Optional;

class ErrorHandling {

    void handleErrorByThrowingIllegalArgumentException() throws Exception {
        throw new Exception();
    }

    void handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage() {
        throw new IllegalArgumentException("This is the detail message.");
    }

    void handleErrorByThrowingAnyCheckedException() throws Exception {
        throw new Exception();
    }

    void handleErrorByThrowingAnyCheckedExceptionWithDetailMessage() throws Exception {
        throw new Exception("This is the detail message.");
    }

    void handleErrorByThrowingAnyUncheckedException() {
        throw new RuntimeException();
    }

    void handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage() {
        throw new RuntimeException("This is the detail message.");
    }

    void handleErrorByThrowingCustomCheckedException() throws Exception {
        throw new CustomCheckedException();
    }

    void handleErrorByThrowingCustomCheckedExceptionWithDetailMessage() throws CustomCheckedException {
        throw new CustomCheckedException("This is the detail message.");
    }

    void handleErrorByThrowingCustomUncheckedException() {
        throw new CustomUncheckedException();
    }

    void handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage() {
        throw new CustomUncheckedException("This is the detail message.");
    }

    Optional<Integer> handleErrorByReturningOptionalInstance(String integer) {
        try {
            return Optional.of(Integer.parseInt(integer));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
