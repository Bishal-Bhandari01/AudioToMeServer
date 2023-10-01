package com.audiotome.audiotomeserver.audiobook;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AudioBookService {

    @Autowired
    private AudioBookRepository audioBookRepo;
    public AudioBookResponseDto getAudioBookResponseDto(AudioBook savedAudioBook) {
        AudioBookResponseDto response = new AudioBookResponseDto();
        response.setAId(savedAudioBook.getAId());
        response.setABookName(savedAudioBook.getABookName());
        response.setABookAuthor(savedAudioBook.getABookAuthor());
        response.setABookAudio(savedAudioBook.getABookAudio());
        response.setStatus(savedAudioBook.getStatus());
        response.setAUploadDate(GetToDayDate());
        response.setADescription(savedAudioBook.getADescription());
        response.setABookImage(savedAudioBook.getABookImage());
        return response;
    }

    public AudioBookListResponseDto getAllAudioBook() {
        List<AudioBookResponseDto> audioBookResponse = new ArrayList<>();
        List<AudioBook> audioBook = (List<AudioBook>) audioBookRepo.findAll();

        for (AudioBook audioBooks : audioBook) {
            audioBookResponse.add(getAudioBookResponseDto(audioBooks));
        }
        AudioBookListResponseDto response = new AudioBookListResponseDto();
        response.setResponse(audioBookResponse);
        response.setTotal(audioBookResponse.size());

        return response;
    }


    public String GetToDayDate() {
        LocalDate myObj = LocalDate.now(); // Create a date object
        return myObj.toString();
    }

    public AudioBookResponseDto saveAudioBook(AudioBookCreateDto request) {
        AudioBook audioBook = new AudioBook();
        audioBook.setABookName(request.getABookName());
        audioBook.setABookAuthor(request.getABookAuthor());
        audioBook.setABookAudio(request.getABookAudio());
        audioBook.setStatus(request.getStatus());
        audioBook.setAUploadDate(request.getAUploadDate());
        audioBook.setADescription(request.getADescription());
        audioBook.setABookImage(request.getABookImage());

        AudioBook savedAudioBook = audioBookRepo.save(audioBook);
        return getAudioBookResponseDto(savedAudioBook);
    }

    public AudioBookResponseDto updateAudioBook(Long aId, AudioBookUpdateDto request) {
        Optional<AudioBook> optAudioBook = audioBookRepo.findById(aId);
        if (optAudioBook.isPresent()) {
            AudioBook newAudioBook = new AudioBook();
            newAudioBook.setABookName(request.getABookName());
            newAudioBook.setABookAuthor(request.getABookAuthor());
            newAudioBook.setABookAudio(request.getABookAudio());
            newAudioBook.setABookImage(request.getABookImage());
            newAudioBook.setStatus(request.getStatus());
            newAudioBook.setADescription(request.getADescription());
            AudioBook savedAudiobook = audioBookRepo.save(newAudioBook);
            return getAudioBookResponseDto(savedAudiobook);
        }
        return null;
    }

    public AudioBookResponseDto getAudioBookById(Long aId) {
        Optional<AudioBook> audioBook = audioBookRepo.findById(aId);
        return audioBook.map(this::getAudioBookResponseDto).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        audioBookRepo.deleteById(id);
    }

    public AudioBookListResponseDto getaudioBookByTitle(String title) {
        List<AudioBookResponseDto> responseDtos = new ArrayList<>();
        List<AudioBook> audioBook = audioBookRepo.findByaBookNameContaining(title);
        for (AudioBook audioBooks : audioBook) {
            responseDtos.add(getAudioBookResponseDto(audioBooks));
        }
        AudioBookListResponseDto responseDto = new AudioBookListResponseDto();
        responseDto.setResponse(responseDtos);
        responseDto.setTotal(responseDtos.size());
        return responseDto;
    }

    public AudioBookListResponseDto getAudioBooksByStatus(Status status) {
        List<AudioBookResponseDto> responseDtos = new ArrayList<>();
        List<AudioBook> aBook = audioBookRepo.findByStatus(status);
        for (AudioBook audioBook : aBook) {
            responseDtos.add(getAudioBookResponseDto(audioBook));
        }
        AudioBookListResponseDto response = new AudioBookListResponseDto();
        response.setResponse(responseDtos);
        response.setTotal(responseDtos.size());
        return response;
    }
}
