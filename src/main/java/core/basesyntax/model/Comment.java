package core.basesyntax.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text", nullable = false)
    private String content;

    @ManyToMany
    @JoinTable(
            name = "comment_smiles",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "smile_id")
    )
    private List<Smile> smiles;

    public Comment(String content) {
        this.content = content;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Smile> getSmiles() {
        return smiles;
    }

    public void setSmiles(List<Smile> smiles) {
        this.smiles = smiles;
    }
}
