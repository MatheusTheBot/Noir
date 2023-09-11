package Controllers.Contract;

public interface ControllerContract<t, r> {

    r processValidation(t command);
}
