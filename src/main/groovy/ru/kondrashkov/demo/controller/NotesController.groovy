package ru.kondrashkov.demo.controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.kondrashkov.demo.ResourceNotFoundException
import ru.kondrashkov.demo.entity.Notes
import ru.kondrashkov.demo.repository.NotesRepository
import javax.validation.Valid
import java.text.ParseException

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
class NotesController {
    @Autowired
    NotesRepository notesRepository

    @GetMapping('/notes')
    List<Notes> getNotes() {notesRepository.findAll()}

    @GetMapping('/notes/{id}')
    Notes getNotesById(@PathVariable Long id) {
        Optional<Notes> notes = notesRepository.findById(id)
        notes.orElseThrow({new ResourceNotFoundException('Notes not found.Id = ' + id)})
    }

    @PostMapping('/notes')
    Notes createNotes(@Valid @RequestBody Notes notes) {notesRepository.save(notes)}

    @PutMapping('notes{notesId}')
    Notes updateNotes(@PathVariable Long notesId, @Valid @RequestBody Notes notesRequest) throws ParseException {
        notesRepository.findById(notesId).map { notes ->
            notes.setHeader(notesRequest.getHeader())
            notes.setNote(notesRequest.getNote())
            notesRepository.save(notes)
        }.orElseThrow({new ResourceNotFoundException('Notes not found with id ' + notesId)})
    }

    @DeleteMapping('/notes/{notesId}')
    ResponseEntity<?> deleteNotes(@PathVariable Long notesId) {
        notesRepository.findById(notesId).map {notes ->
            notesRepository.delete(notes)
            ResponseEntity.ok().build()
        }.orElseThrow({new ResourceNotFoundException('Notes not found with id ' + notesId)})
    }
}
