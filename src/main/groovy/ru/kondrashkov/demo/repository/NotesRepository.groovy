package ru.kondrashkov.demo.repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.kondrashkov.demo.entity.Notes

@Repository
interface NotesRepository extends JpaRepository<Notes, Long> {
}