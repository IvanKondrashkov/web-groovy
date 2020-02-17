package ru.kondrashkov.demo.entity
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = 'notes')
class Notes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = 'id')
    Long id
    @Column(columnDefinition = 'header')
    @NotBlank
    @Size(min = 3, max = 100)
    String header
    @Column(columnDefinition = 'note')
    @NotBlank
    String note

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getHeader() {
        return header
    }

    void setHeader(String header) {
        this.header = header
    }

    String getNote() {
        return note
    }

    void setNote(String note) {
        this.note = note
    }

    @Override
    String toString() {
        return "Notes{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
