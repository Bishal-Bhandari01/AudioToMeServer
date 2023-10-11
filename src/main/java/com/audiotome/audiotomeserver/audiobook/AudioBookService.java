package com.audiotome.audiotomeserver.audiobook;

import com.audiotome.audiotomeserver.constant.DateTime;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import java.time.DayOfWeek;
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


    public LocalDate GetToDayDate() {
        LocalDate myObj = LocalDate.now(); // Create a date object
        return myObj;
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

    public DateTime getAudiobookBasedOnTime() {
        LocalDate today = LocalDate.now();
        List<AudioBook> user = audioBookRepo.findByaUploadDate(today);

        LocalDate currentMonthDate = LocalDate.now();
        LocalDate startOfMonth = currentMonthDate.withDayOfMonth(1);
        LocalDate endOfMonth = currentMonthDate.withDayOfMonth(currentMonthDate.lengthOfMonth());
        List<AudioBook> monthlyuser = audioBookRepo.findByaUploadDateBetween(startOfMonth,endOfMonth);

        LocalDate currentYearDate = LocalDate.now();
        LocalDate startOfYear = currentYearDate.withDayOfYear(1);
        LocalDate endOfYear = currentYearDate.withDayOfYear(currentYearDate.lengthOfYear());
        List<AudioBook> yearlyuser = audioBookRepo.findByaUploadDateBetween(startOfYear, endOfYear);

        LocalDate weekly = LocalDate.now();
        LocalDate startDate = weekly;
        LocalDate endDate = weekly;

        // Find the start date (Monday) of the week
        while (startDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
            startDate = startDate.minusDays(1);
        }

        // Find the end date (Sunday) of the week
        while (endDate.getDayOfWeek() != DayOfWeek.SATURDAY) {
            endDate = endDate.plusDays(1);

        }
        List<AudioBook> weeklyUsers = audioBookRepo.findByaUploadDateBetween(startDate, endDate);

        List<AudioBook> users = (List<AudioBook>) audioBookRepo.findAll();

        var dateTime = DateTime.builder()
                .daily(user.size())
                .monthly(monthlyuser.size())
                .weekly(weeklyUsers.size())
                .yearly(yearlyuser.size())
                .totally(users.size())
                .build();

        return dateTime;
    }

    public AudioBookListResponseDto getAudioBookBasedOnListen() {
        Pageable page = (Pageable) PageRequest.of(0,5);
        List<AudioBook> book = audioBookRepo.findTop5ByOrderByListenDesc();

        List<AudioBookResponseDto> responseDtos = new ArrayList<>();

        for (AudioBook audioBook : book) {
            responseDtos.add(getAudioBookResponseDto(audioBook));
        }

        AudioBookListResponseDto response = new AudioBookListResponseDto();
        response.setResponse(responseDtos);
        response.setTotal(responseDtos.size());
        return response;
    }
}
