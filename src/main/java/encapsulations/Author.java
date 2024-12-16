package encapsulations;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter @NoArgsConstructor
public class Author {
    private UUID id;
    private String firstName;
    private String lastName;
    private List<Article> articleList;

    public Author(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
