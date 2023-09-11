package Models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseModel<T> {
    String commandTitle;
    boolean isSuccess;
    String[] observations;
    T response;
}
