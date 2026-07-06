import java.util.Optional;

class ErrorHandling {

    void handleErrorByThrowingIllegalArgumentException() throws Exception {
        throw new Exception();
    }

    void handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(String s) {
        throw new IllegalArgumentException("This is the detail message.");
    }

    void handleErrorByThrowingAnyCheckedException() throws Exception {
        throw new Exception();
    }

    void handleErrorByThrowingAnyCheckedExceptionWithDetailMessage(String s) throws Exception {
        throw new Exception("This is the detail message.");
    }

    void handleErrorByThrowingAnyUncheckedException() {
        throw new RuntimeException();
    }

    void handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage(String s) {
        throw new RuntimeException("This is the detail message.");
    }

    void handleErrorByThrowingCustomCheckedException() throws Exception {
        throw new CustomCheckedException();
    }

    void handleErrorByThrowingCustomCheckedExceptionWithDetailMessage(String s) throws CustomCheckedException {
        throw new CustomCheckedException("This is the detail message.");
    }

    void handleErrorByThrowingCustomUncheckedException() {
        throw new CustomUncheckedException();
    }

    void handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage(String s) {
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
