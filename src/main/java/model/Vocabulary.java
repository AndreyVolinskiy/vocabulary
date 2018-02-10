package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Andrey Volinskiy on 07.02.2018.
 */
@Getter
@Setter
@ToString
public class Vocabulary {

    private long id;
    private String ukr;
    private String eng;
}
