package com.audiotome.audiotomeserver.Notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class NoteController {

    @Autowired
    private NotesService notesService;

<<<<<<< HEAD
    @RequestMapping(path="/api/v1/notes",method = RequestMethod.POST)
    public NoteResponseDto SavedNotes(@RequestBody NotesCreateDto request){
        return notesService.savedNotes(request);
    }
    @RequestMapping(path = "/api/v1/getNotes",method = RequestMethod.GET)
    public NotesListResponseDto GetNotes(){
        return notesService.getNotes();
    }
    @RequestMapping(path = "/api/v1/getNotesById",method = RequestMethod.GET)
    public NoteResponseDto GetNotesById(@RequestParam("id") Long id){
        return notesService.getNotesById(id);
    }
    @RequestMapping(path = "/api/v1/getNotesByUserId",method = RequestMethod.GET)
    public NotesListResponseDto GetNotesByUserId(@RequestParam("user_id") Long user_id){
        return notesService.getNotesByUserId(user_id);
    }
    @RequestMapping(path = "/api/v1/delNotesByid",method = RequestMethod.DELETE)
    public void DeleteNote(@RequestParam("aid") Long aid){
        notesService.deleteNote(aid);
    }
    @RequestMapping(path = "/api/v1/updateNotesById",method = RequestMethod.PUT)
    public NoteResponseDto UpdateNotes(@RequestParam("id") Long id, @RequestBody NoteUpdateDto request){
        return notesService.updateNotes(id,request);
=======
    @RequestMapping(path = "/api/v1/notes", method = RequestMethod.POST)
    public NoteResponseDto SavedNotes(@RequestBody NotesCreateDto request) {
        return notesService.savedNotes(request);
    }

    @RequestMapping(path = "/api/v1/getNotes", method = RequestMethod.GET)
    public NotesListResponseDto GetNotes() {
        return notesService.getNotes();
    }

    @RequestMapping(path = "/api/v1/getNotesById", method = RequestMethod.GET)
    public NoteResponseDto GetNotesById(@RequestParam("id") Long id) {
        return notesService.getNotesById(id);
    }

    @RequestMapping(path = "/api/v1/getNotesByUserId", method = RequestMethod.GET)
    public NotesListResponseDto GetNotesByUserId(@RequestParam("user_id") Long user_id) {
        return notesService.getNotesByUserId(user_id);
    }

    @RequestMapping(path = "/api/v1/delNotesByid", method = RequestMethod.DELETE)
    public void DeleteNote(@RequestParam("aid") Long aid) {
        notesService.deleteNote(aid);
    }

    @RequestMapping(path = "/api/v1/updateNotesById", method = RequestMethod.PUT)
    public NoteResponseDto UpdateNotes(@RequestParam("id") Long id, @RequestBody NoteUpdateDto request) {
        return notesService.updateNotes(id, request);
>>>>>>> 17faaac ( new server hosting)
    }
}
