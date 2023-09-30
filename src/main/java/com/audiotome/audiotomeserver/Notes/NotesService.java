package com.audiotome.audiotomeserver.Notes;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotesService {
    @Autowired
    private NoteRepository noteRepo;

    public NoteResponseDto savedNotes(NotesCreateDto request) {
        Notes notes = new Notes();
        notes.setTitle(request.getTitle());
        notes.setNoteDesc(request.getNoteDesc());
        notes.setNoteDate(GetToDayDate());
        notes.setUserId(request.getUserId());
        Notes savedNotes = noteRepo.save(notes);
        return getNotesResponseDto(savedNotes);
    }

    private NoteResponseDto getNotesResponseDto(Notes savedNotes) {
        NoteResponseDto response = new NoteResponseDto();
        response.setN_id(savedNotes.getN_id());
        response.setTitle(savedNotes.getTitle());
        response.setNoteDesc(savedNotes.getNoteDesc());
        response.setNoteDate(savedNotes.getNoteDate());
<<<<<<< HEAD
        response.setUserId( savedNotes.getUserId());
=======
        response.setUserId(savedNotes.getUserId());
>>>>>>> 17faaac ( new server hosting)

        return response;
    }

    public NotesListResponseDto getNotes() {
        List<NoteResponseDto> res = new ArrayList<>();
        List<Notes> note = (List<Notes>) noteRepo.findAll();
<<<<<<< HEAD
        for (Notes notes : note){
=======
        for (Notes notes : note) {
>>>>>>> 17faaac ( new server hosting)
            res.add(getNotesResponseDto(notes));
        }
        NotesListResponseDto responseDto = new NotesListResponseDto();
        responseDto.setResponse(res);
        responseDto.setTotal(res.size());
        return responseDto;
    }

    public NoteResponseDto getNotesById(Long id) {
        Optional<Notes> notes = noteRepo.findById(id);
<<<<<<< HEAD
        if(notes.isPresent()){
=======
        if (notes.isPresent()) {
>>>>>>> 17faaac ( new server hosting)
            return getNotesResponseDto(notes.get());
        }
        return null;
    }

    public NotesListResponseDto getNotesByUserId(Long user_id) {
        List<NoteResponseDto> resp = new ArrayList<>();
        List<Notes> notes = noteRepo.findByUserId(user_id);
<<<<<<< HEAD
        for(Notes note : notes){
=======
        for (Notes note : notes) {
>>>>>>> 17faaac ( new server hosting)
            resp.add(getNotesResponseDto(note));
        }
        NotesListResponseDto notesResponse = new NotesListResponseDto();
        notesResponse.setResponse(resp);
        notesResponse.setTotal(resp.size());
        return notesResponse;
    }

    public NoteResponseDto updateNotes(Long id, NoteUpdateDto request) {
        Optional<Notes> notes = noteRepo.findById(id);
<<<<<<< HEAD
        if (notes.isPresent()){
=======
        if (notes.isPresent()) {
>>>>>>> 17faaac ( new server hosting)
            Notes note = notes.get();
            note.setTitle(request.getTitle());
            note.setNoteDate(GetToDayDate());
            note.setNoteDesc(request.getNoteDesc());
            Notes notesData = noteRepo.save(note);
            return getNotesResponseDto(notesData);
        }
        return null;
    }
<<<<<<< HEAD
=======

>>>>>>> 17faaac ( new server hosting)
    @Transactional
    public void deleteNote(Long aid) {
        noteRepo.deleteById(aid);
    }

<<<<<<< HEAD
    public String GetToDayDate(){
=======
    public String GetToDayDate() {
>>>>>>> 17faaac ( new server hosting)
        LocalDate myObj = LocalDate.now(); // Create a date object
        return myObj.toString();
    }
}
